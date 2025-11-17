use std::cell::RefCell;
use std::collections::{HashMap, VecDeque};
use std::hash::{BuildHasherDefault, Hasher};

type Int3 = (i32, i32, i32);

#[derive(Clone)]
struct FnvHasher
{
    hash: u64,
}

impl Default for FnvHasher
{
    fn default() -> Self
    {
        Self
        {
            hash: 1469598103934665603,
        }
    }
}

impl Hasher for FnvHasher
{
    fn write(&mut self, bytes: &[u8])
    {
        for b in bytes
        {
            self.hash ^= *b as u64;
            self.hash = self.hash.wrapping_mul(1099511628211);
        }
    }

    fn finish(&self) -> u64
    {
        self.hash
    }

    fn write_u32(&mut self, i: u32)
    {
        self.write(&i.to_le_bytes());
    }

    fn write_i32(&mut self, i: i32)
    {
        self.write_u32(i as u32);
    }

    fn write_u64(&mut self, i: u64)
    {
        self.write(&i.to_le_bytes());
    }

    fn write_i64(&mut self, i: i64)
    {
        self.write_u64(i as u64);
    }
}

type FastBuildHasher = BuildHasherDefault<FnvHasher>;

struct DestList
{
    ts: Vec<i32>,
    head: usize,
}

impl DestList
{
    fn new() -> Self
    {
        Self
        {
            ts: Vec::new(),
            head: 0,
        }
    }

    fn push(&mut self, t: i32)
    {
        self.ts.push(t);
    }

    fn pop_front_one(&mut self)
    {
        self.head += 1;
        if self.head >= 1024 && self.head * 2 > self.ts.len()
        {
            self.ts.drain(0..self.head);
            self.head = 0;
        }
    }

    fn count_in_range(&self, lo: i32, hi: i32) -> i32
    {
        if self.head >= self.ts.len()
        {
            return 0;
        }
        let slice = &self.ts[self.head..];
        let l = lower_bound(slice, lo);
        let r = upper_bound(slice, hi);
        let c = if r >= l { r - l } else { 0 };
        c as i32
    }
}

fn lower_bound(a: &[i32], x: i32) -> usize
{
    let mut l = 0usize;
    let mut r = a.len();
    while l < r
    {
        let m = (l + r) >> 1;
        if a[m] < x
        {
            l = m + 1;
        }
        else
        {
            r = m;
        }
    }
    l
}

fn upper_bound(a: &[i32], x: i32) -> usize
{
    let mut l = 0usize;
    let mut r = a.len();
    while l < r
    {
        let m = (l + r) >> 1;
        if a[m] <= x
        {
            l = m + 1;
        }
        else
        {
            r = m;
        }
    }
    l
}

pub struct Router
{
    queue: RefCell<VecDeque<Int3>>,
    by_dest: RefCell<HashMap<i32, DestList, FastBuildHasher>>,
    seen: RefCell<HashMap<Int3, (), FastBuildHasher>>,
    memory_limit: usize,
}

impl Router
{
    fn new(memory_limit: i32) -> Self
    {
        Router
        {
            queue: RefCell::new(VecDeque::new()),
            by_dest: RefCell::new(HashMap::with_hasher(FastBuildHasher::default())),
            seen: RefCell::new(HashMap::with_hasher(FastBuildHasher::default())),
            memory_limit: if memory_limit > 0 { memory_limit as usize } else { 0 },
        }
    }

    fn add_packet(&self, source: i32, destination: i32, timestamp: i32) -> bool
    {
        let packet = (timestamp, source, destination);

        if self.seen.borrow().contains_key(&packet)
        {
            return false;
        }

        if self.memory_limit == 0
        {
            return true;
        }

        {
            let mut q = self.queue.borrow_mut();
            if q.len() == self.memory_limit
            {
                if let Some(old) = q.pop_front()
                {
                    self.seen.borrow_mut().remove(&old);
                    let od = old.2;
                    let mut bd = self.by_dest.borrow_mut();
                    if let Some(list) = bd.get_mut(&od)
                    {
                        list.pop_front_one();
                        if list.head >= list.ts.len()
                        {
                            bd.remove(&od);
                        }
                    }
                }
            }
            q.push_back(packet);
        }

        {
            let mut bd = self.by_dest.borrow_mut();
            bd.entry(destination).or_insert_with(DestList::new).push(timestamp);
        }

        self.seen.borrow_mut().insert(packet, ());
        true
    }

    fn forward_packet(&self) -> Vec<i32>
    {
        let packet =
        {
            let mut q = self.queue.borrow_mut();
            if let Some(p) = q.pop_front()
            {
                p
            }
            else
            {
                return Vec::new();
            }
        };

        self.seen.borrow_mut().remove(&packet);

        let (timestamp, source, destination) = packet;

        {
            let mut bd = self.by_dest.borrow_mut();
            if let Some(list) = bd.get_mut(&destination)
            {
                list.pop_front_one();
                if list.head >= list.ts.len()
                {
                    bd.remove(&destination);
                }
            }
        }

        vec![source, destination, timestamp]
    }

    fn get_count(&self, destination: i32, start_time: i32, end_time: i32) -> i32
    {
        if start_time > end_time
        {
            return 0;
        }
        let bd = self.by_dest.borrow();
        if let Some(list) = bd.get(&destination)
        {
            list.count_in_range(start_time, end_time)
        }
        else
        {
            0
        }
    }
}