class Solution
{
    bool Row[9][9];
    bool Col[9][9];
    bool Block[9][9];
    vector<pair<int, int>> uncertain;
public:
    void set3Cond(int i, int j, int x, bool val = 1)
    {
        Row[i][x] = val;
        Col[j][x] = val;
        int bidx = (i / 3) * 3 + j / 3;
        Block[bidx][x] = val;
    }

    void setup(vector<vector<char>>& board)
    {
        uncertain.reserve(81);
        for (int i = 0; i < 9; i++)
        {
            for (int j = 0; j < 9; j++)
            {
                char c = board[i][j];
                if (c == '.')
                {
                    uncertain.push_back({i, j});
                }
                else
                {
                    int x = (c - '0') % 9;
                    set3Cond(i, j, x);
                }
            }
        }
    }

    bool solve(vector<vector<char>>& board)
    {
        if (uncertain.empty())
        {
            return 1;
        }
        auto [i, j] = uncertain.back();
        for (char c = '1'; c <= '9'; c++)
        {
            if (isValid(i, j, c))
            {
                board[i][j] = c;
                uncertain.pop_back();

                int x = (c - '0') % 9;
                set3Cond(i, j, x);

                if (solve(board))
                {
                    return 1;
                }

                board[i][j] = '.';
                uncertain.push_back({i, j});
                set3Cond(i, j, x, 0);
            }
        }
        return 0;
    }

    bool isValid(int row, int col, char c)
    {
        int x = (c - '0') % 9;
        return !Row[row][x] && !Col[col][x] && !Block[(row / 3) * 3 + col / 3][x];
    }

    void solveSudoku(vector<vector<char>>& board)
    {
        setup(board);
        solve(board);
    }
};