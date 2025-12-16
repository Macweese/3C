class Solution
{
public:
    int maxProfit(int n, vector<int>& present, vector<int>& future, vector<vector<int>>& hierarchy, int budget)
    {
        vector<vector<int>> children(n + 1);
        for (auto& edge : hierarchy)
        {
            children[edge[0]].push_back(edge[1]);
        }
        
        function<map<int, int>(int, bool)> dfs = [&](int node, bool parentBought) -> map<int, int>
        {
            map<int, int> result;
            result[0] = 0;
            
            int cost = parentBought ? present[node - 1] / 2 : present[node - 1];
            int profit = future[node - 1] - cost;
            
            if (children[node].empty())
            {
                if (cost <= budget)
                {
                    result[cost] = profit;
                }
                return result;
            }
            
            vector<map<int, int>> childrenNotBought;
            for (int child : children[node])
            {
                childrenNotBought.push_back(dfs(child, false));
            }
            
            vector<map<int, int>> childrenBought;
            for (int child : children[node])
            {
                childrenBought.push_back(dfs(child, true));
            }
            
            map<int, int> notBuyingCurrent;
            notBuyingCurrent[0] = 0;
            for (auto& childDp : childrenNotBought)
            {
                map<int, int> next;
                for (auto& [b1, p1] : notBuyingCurrent)
                {
                    for (auto& [b2, p2] : childDp)
                    {
                        int totalBudget = b1 + b2;
                        if (totalBudget <= budget)
                        {
                            next[totalBudget] = max(next[totalBudget], p1 + p2);
                        }
                    }
                }
                notBuyingCurrent = move(next);
            }
            
            for (auto& [b, p] : notBuyingCurrent)
            {
                result[b] = max(result[b], p);
            }
            
            if (cost <= budget)
            {
                map<int, int> buyingCurrent;
                buyingCurrent[0] = 0;
                for (auto& childDp : childrenBought)
                {
                    map<int, int> next;
                    for (auto& [b1, p1] : buyingCurrent)
                    {
                        for (auto& [b2, p2] : childDp)
                        {
                            int totalBudget = b1 + b2;
                            if (totalBudget + cost <= budget)
                            {
                                next[totalBudget] = max(next[totalBudget], p1 + p2);
                            }
                        }
                    }
                    buyingCurrent = move(next);
                }
                
                for (auto& [b, p] : buyingCurrent)
                {
                    int totalBudget = b + cost;
                    if (totalBudget <= budget)
                    {
                        result[totalBudget] = max(result[totalBudget], p + profit);
                    }
                }
            }
            
            return result;
        };
        
        auto dp = dfs(1, false);
        
        int maxProfit = 0;
        for (auto& [b, p] : dp)
        {
            maxProfit = max(maxProfit, p);
        }
        
        return maxProfit;
    }
};
