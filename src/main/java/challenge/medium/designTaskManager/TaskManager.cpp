#pragma once
#include <vector>
#include <cstdint>
#include <cassert>

class TaskManager
{
public:
    explicit TaskManager(const std::vector<std::vector<int>>& tasks)
        : TaskManager(tasks, -1)
    {
    }

    TaskManager(const std::vector<std::vector<int>>& tasks, int expectedMaxConcurrentTasks)
    {
        const int initial = static_cast<int>(tasks.size());
        int cap = initialCapacity(initial, expectedMaxConcurrentTasks);
        key_.assign(cap, 0);
        payload_.assign(cap, 0);
        pos_.assign(MAX_TASK_ID + 1, 0);
        size_ = 0;

        if (initial == 0) return;

        if (initial >= HEAPIFY_THRESHOLD)
        {
            int i = 1;
            for (int k = 0; k < initial; ++k)
            {
                const auto& t = tasks[k];
                if (t.size() != 3) continue;
                const int u  = t[0];
                const int id = t[1];
                const int pr = t[2];
                ensureCapacity(i);
                key_[i]     = packKey(pr, id);
                payload_[i] = packPayload(u, id);
                if (id >= 0 && id <= MAX_TASK_ID) pos_[id] = i;
                ++i;
            }
            size_ = i - 1;
            for (int j = size_ >> 1; j >= 1; --j)
            {
                siftDown(j);
            }
        }
        else
        {
            for (const auto& t : tasks)
            {
                if (t.size() != 3) continue;
                add(t[0], t[1], t[2]);
            }
        }
    }

    inline void add(int userId, int taskId, int priority)
    {
        int i = ++size_;
        ensureCapacity(i);
        key_[i]     = packKey(priority, taskId);
        payload_[i] = packPayload(userId, taskId);
        if (taskId >= 0 && taskId <= MAX_TASK_ID) pos_[taskId] = i;
        siftUp(i);
    }

    inline void edit(int taskId, int newPriority)
    {
        if (taskId < 0 || taskId > MAX_TASK_ID) return;
        int i = pos_[taskId];
        if (i == 0) return;

        key_[i] = packKey(newPriority, taskId);

        int parent = i >> 1;
        if (i > 1 && key_[i] > key_[parent])
        {
            siftUp(i);
        }
        else
        {
            siftDown(i);
        }
    }

    inline void rmv(int taskId)
    {
        if (taskId < 0 || taskId > MAX_TASK_ID) return;
        int i = pos_[taskId];
        if (i == 0) return;

        pos_[taskId] = 0;

        if (i == size_)
        {
            --size_;
            return;
        }

        uint64_t lk = key_[size_];
        uint64_t lp = payload_[size_];
        const int movedTask = low32(lp);
        --size_;

        key_[i]     = lk;
        payload_[i] = lp;
        if (movedTask >= 0 && movedTask <= MAX_TASK_ID) pos_[movedTask] = i;

        int parent = i >> 1;
        if (i > 1 && key_[i] > key_[parent])
        {
            siftUp(i);
        }
        else
        {
            siftDown(i);
        }
    }

    inline int execTop()
    {
        if (size_ == 0) return -1;

        const uint64_t rootPL = payload_[1];
        const int topUser = high32(rootPL);
        const int topTask = low32(rootPL);
        if (topTask >= 0 && topTask <= MAX_TASK_ID) pos_[topTask] = 0;

        if (size_ == 1)
        {
            size_ = 0;
            return topUser;
        }

        uint64_t lk = key_[size_];
        uint64_t lp = payload_[size_];
        const int movedTask = low32(lp);
        --size_;

        key_[1]     = lk;
        payload_[1] = lp;
        if (movedTask >= 0 && movedTask <= MAX_TASK_ID) pos_[movedTask] = 1;

        siftDown(1);
        return topUser;
    }

private:
    static constexpr int MAX_TASK_ID        = 100'000;
    static constexpr int KEY_SHIFT          = 17;
    static constexpr uint32_t TASK_MASK     = (1u << KEY_SHIFT) - 1u;
    static constexpr int HEAPIFY_THRESHOLD  = 2048;

    std::vector<uint64_t> key_;
    std::vector<uint64_t> payload_;
    std::vector<int>      pos_;
    int size_ = 0;

    static inline uint64_t packKey(int priority, int taskId) noexcept
    {
        return (static_cast<uint64_t>(static_cast<uint32_t>(priority)) << KEY_SHIFT)
             | (static_cast<uint64_t>(static_cast<uint32_t>(taskId)) & TASK_MASK);
    }
    static inline uint64_t packPayload(int userId, int taskId) noexcept
    {
        return (static_cast<uint64_t>(static_cast<uint32_t>(userId)) << 32)
             | (static_cast<uint64_t>(static_cast<uint32_t>(taskId)));
    }
    static inline int low32(uint64_t v) noexcept  { return static_cast<int>(static_cast<uint32_t>(v)); }
    static inline int high32(uint64_t v) noexcept { return static_cast<int>(static_cast<uint32_t>(v >> 32)); }

    inline void siftUp(int i)
    {
        uint64_t k  = key_[i];
        uint64_t pl = payload_[i];
        const int t = low32(pl);

        while (i > 1)
        {
            int p = i >> 1;
            if (key_[p] >= k) break;

            key_[i]     = key_[p];
            payload_[i] = payload_[p];
            const int moved = low32(payload_[i]);
            if (moved >= 0 && moved <= MAX_TASK_ID) pos_[moved] = i;

            i = p;
        }

        key_[i]     = k;
        payload_[i] = pl;
        if (t >= 0 && t <= MAX_TASK_ID) pos_[t] = i;
    }

    inline void siftDown(int i)
    {
        uint64_t k  = key_[i];
        uint64_t pl = payload_[i];
        const int t = low32(pl);

        while (true)
        {
            int left = i << 1;
            if (left > size_) break;

            int right = left + 1;
            int best = left;
            if (right <= size_ && key_[right] > key_[left]) best = right;

            if (key_[best] <= k) break;

            key_[i]     = key_[best];
            payload_[i] = payload_[best];
            const int moved = low32(payload_[i]);
            if (moved >= 0 && moved <= MAX_TASK_ID) pos_[moved] = i;

            i = best;
        }

        key_[i]     = k;
        payload_[i] = pl;
        if (t >= 0 && t <= MAX_TASK_ID) pos_[t] = i;
    }

    inline void ensureCapacity(int requiredIndex)
    {
        if (requiredIndex < static_cast<int>(key_.size())) return;
        int newCap = static_cast<int>(key_.size()) << 1;
        if (newCap <= requiredIndex) newCap = requiredIndex + 1;

        key_.resize(newCap);
        payload_.resize(newCap);
    }

    static int initialCapacity(int initial, int expectedMaxConcurrentTasks)
    {
        if (expectedMaxConcurrentTasks > 0)
        {
            int cap = expectedMaxConcurrentTasks + 2;
            if (cap < 16) cap = 16;
            int p = 1;
            while (p < cap) p <<= 1;
            return p;
        }
        int want = initial + 8;
        if (want < 16) want = 16;
        int p = 1;
        while (p < want) p <<= 1;
        return p;
    }
};