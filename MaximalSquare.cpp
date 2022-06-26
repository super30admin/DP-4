class Solution {
public:
    int maximalSquare(vector<vector<char>>& matrix) {
        int m = matrix.size();
        int n = matrix[0].size();
        vector<vector<int>> dp(m+1,vector<int>(n+1));
        int result=0;
        for(int i=1;i<dp.size();i++){
            for(int j=1;j<dp[0].size();j++){
                if(matrix[i-1][j-1]=='1'){
                    dp[i][j] = (std::min(std::min(dp[i-1][j],dp[i-1][j-1]),dp[i][j-1]) + 1);
                    result = std::max(result,dp[i][j]);
                }
            }
        }
        return result*result;
    }
};

class Solution {
public:
    int maximalSquare(vector<vector<char>>& matrix) {
        int m = matrix.size();
        int n = matrix[0].size();
        vector<int> dp(n+1);
        int result=0;
        int temp;
        for(int i=1;i<=m;i++){
            int diagUp = 0;
            for(int j=1;j<=n;j++){
                if(matrix[i-1][j-1]=='1'){
                    temp = dp[j];
                    dp[j] = std::min(std::min(dp[j],dp[j-1]),diagUp)+1;
                    diagUp = temp;
                    result = max(result,dp[j]);
                }else{
                    dp[j]=0;
                }
            }
        }
        return result*result;
    }
};
