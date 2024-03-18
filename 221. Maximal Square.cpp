/*
Time: O(m*n)
Space: O(m*n)

A cell's square forming is bounded by its own value and three adjacent (right, down and right-down cells)
If its value is 0, then no square formed with this cell
If it's value is 1, then (the minimum squared formed by its three cell + 1) is the square formed with this cell
*/

class Solution {
public:
    vector<vector<char>> mat;
    int m, n;
    int ans = 0;

    vector<vector<int>> dp;
    int call(int i, int j){
        if(i==m || j==n)  return 0;
        if(dp[i][j] != -1)  return dp[i][j];

        //check bound in 3 directions
        int r = call(i,j+1);
        int d = call(i+1,j);
        int rd = call(i+1,j+1);

        if(mat[i][j]=='0')  return dp[i][j] = 0; //0 means no square formed
        int adj = min(r, min(d, rd)); //check minimum bound

        ans = max(ans, 1+adj);

        return dp[i][j] = 1 + adj;
    }

    int maximalSquare(vector<vector<char>>& matrix) {
        mat = matrix;
        m = matrix.size(), n = matrix[0].size();

        dp = vector(m, vector(n, -1));

        call(0,0);
        return ans*ans;
    }
};
