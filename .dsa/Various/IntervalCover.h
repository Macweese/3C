// 1. Create index array and sort intervals by start position
vi S(sz(I)), R;
iota(all(S), 0);  // S = [0, 1, 2, ..., n-1]
sort(all(S), [&](int a, int b) { return I[a] < I[b]; });

T cur = G.first;  // Current position that needs to be covered
int at = 0;       // Pointer to intervals we're considering

// 2. Greedy selection
while (cur < G.second) {
    pair<T, int> mx = make_pair(cur, -1);

    // Find the interval that starts at or before 'cur' and extends furthest
    while (at < sz(I) && I[S[at]].first <= cur) {
        mx = max(mx, make_pair(I[S[at]].second, S[at]));
        at++;
    }

    // If no valid interval found, coverage is impossible
    if (mx.second == -1) return {};

    // Move current position to end of chosen interval
    cur = mx.first;
    R.push_back(mx.second);  // Add interval index to result
}
```

## Example:
```
Target: [0, 10)
Intervals:
  0: [0, 5)
  1: [3, 7)
  2: [6, 12)
  3: [1, 4)

Execution:
- cur = 0
- Consider intervals starting ≤ 0: interval 0 [0,5)
- Choose interval 0 (extends to 5), cur = 5
- Consider intervals starting ≤ 5: intervals 1,3 already seen, add interval 2 [6,12)
- Wait, interval 2 starts at 6 > 5, so we need interval 1 [3,7)
- Choose interval 1, cur = 7
- Consider intervals starting ≤ 7: interval 2 [6,12)
- Choose interval 2, cur = 12
- 12 ≥ 10, done!

Result: [0, 1, 2]