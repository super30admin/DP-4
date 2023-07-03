
// Any problem you faced while coding this :


// Your code here along with comments explaining your approach


// Approach 1: recurrsion with memoization

// Time Complexity : O(m*n)
// Space Complexity : O(m*n)
// Did this code successfully run on Leetcode : yes


class Solution {
public:
    int dp[301][301];
    int solve(int r,int c, int m,int n,vector<vector<char>>&matrix)
    {
        if(r>=m || c>=n || matrix[r][c]!='1') return dp[r][c]=0;
        if(dp[r][c]!=-1) return dp[r][c];
        
        int right = 1 + solve(r,c+1,m,n,matrix);
        int down = 1 + solve(r+1,c,m,n,matrix);
        int diagonal = 1 + solve(r+1,c+1,m,n,matrix);
        return dp[r][c] = min({right,down,diagonal});
    } 
    int maximalSquare(vector<vector<char>>& matrix) {
        int m = matrix.size();
        int n = matrix[0].size();
        memset(dp,-1,sizeof(dp));
        int ans = 0;
        for(int i = 0;i<m;i++)
        {
            for(int j = 0;j<n;j++)
            {
                if(matrix[i][j] == '1'){
                    ans = max(ans,solve(i,j,m,n,matrix));
                }
            }
        }
        return ans*ans;
    }
};

// Approach 2: dp 
// Time Complexity : O(m*n)
// Space Complexity : O(m*n)
// Did this code successfully run on Leetcode : yes
class Solution {
public:
    int maximalSquare(vector<vector<char>>& matrix) {
        int m = matrix.size();
        int n = matrix[0].size();
        int dp[m+1][n+1];
        memset(dp,0,sizeof(dp));
        int ans = 0;
        
        for(int i = 1;i<=m;i++){
            for(int j =1;j<=n;j++){
                if(matrix[i-1][j-1]=='1'){
                    dp[i][j] = min({dp[i-1][j],dp[i-1][j-1],dp[i][j-1]}) + 1;
                }                
                ans = max(ans,dp[i][j]);
            }
        }
        return ans*ans;
    }
};

// Approach: dp with space optimization
// Time Complexity : O(m*n)
// Space Complexity : O(n)
// Did this code successfully run on Leetcode : yes

class Solution {
public:
    int maximalSquare(vector<vector<char>>& matrix) {
        int m = matrix.size();
        int n = matrix[0].size();
        int dp[n+1];
        memset(dp,0,sizeof(dp));
        int ans = 0;
        int prev = 0;
        
        for(int i = 1;i<=m;i++){
            for(int j =1;j<=n;j++){
                int temp = dp[j];
                if(matrix[i-1][j-1]=='1'){
                    dp[j] = min({dp[j],dp[j-1],prev}) + 1;
                }
                else{
                    dp[j] = 0;
                }
                prev = temp;
                ans = max(ans,dp[j]);
            }
        }
        return ans*ans;
    }
};

Approach 4: bruteforce
// Time Complexity : O(m*n*m*n)
// Space Complexity : O(1)
// Did this code successfully run on Leetcode : yes

class Solution {
public:
    int maximalSquare(vector<vector<char>>& matrix) {
        int m = matrix.size();
        int n = matrix[0].size();
        
        int ans = 0;
        
        for(int i = 0;i<m;i++){
            for(int j = 0;j<n;j++){
                if(matrix[i][j]=='1'){
                    int curr = 1;
                    bool flag = true;
                    while(i+curr<m && j+curr<n && flag){
                        for(int k = i+curr;k>=i;k--){
                            if(matrix[k][j+curr]=='0'){
                                flag = false;
                                break;
                            }
                        }
                        for(int k = j+curr;k>=j;k--){
                            if(matrix[i+curr][k]=='0'){
                                flag = false;
                                break;
                            }
                        }
                        if(flag) curr++;
                    }
                    ans = max(ans,curr);
                }
            }
        }
        return ans*ans;
    }
};