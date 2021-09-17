// Time Complexity : O(M*N)
// Space Complexity :O(N)
// Did this code successfully run on Leetcode : yes
// Any problem you faced while coding this : no

class Solution {
public:
    int maximalSquare(vector<vector<char>>& matrix) {
        if(matrix.empty() || matrix.size() == 0)
            return 0;
        int m = matrix.size();
        int n = matrix[0].size();
        int Max = 0;
        int prev = 0;
        vector<int> dp (n+1, 0);
        for(int i=1; i<=m; i++){
            for(int j=1; j<=n; j++){
                if(matrix[i-1][j-1] == '1'){
                    int temp = dp[j];
                    dp[j] = min(dp[j-1], min(dp[j], prev))+1;
                    prev = temp;
                    Max = max(Max, dp[j]);
                }
                else{
                    dp[j]=0;
                }
            }
        }
        return Max*Max;
    }
};



// Time Complexity : O(M*N)
// Space Complexity :O(M*N)
// Did this code successfully run on Leetcode : yes
// Any problem you faced while coding this : no
class Solution {
public:
    int maximalSquare(vector<vector<char>>& matrix) {
        if(matrix.empty() || matrix.size() == 0)
            return 0;
        int m = matrix.size();
        int n = matrix[0].size();
        int Max = 0;
        vector<vector<int>> dp (m+1, vector<int>(n+1));
        for(int i=1; i<=m; i++){
            for(int j=1; j<=n; j++){
                if(matrix[i-1][j-1] == '1'){
                    dp[i][j] = min(dp[i-1][j], min(dp[i-1][j-1], dp[i][j-1]))+1;
                    Max = max(Max, dp[i][j]);
                }
            }
        }
        return Max*Max;
    }
};


// Time Complexity : O(M*N)^2
// Space Complexity :O(M*N)
// Did this code successfully run on Leetcode : yes
// Any problem you faced while coding this : no
class Solution{
public:
    int maximalSquare(vector<vector<char>>& matrix) {
        if(matrix.empty() || matrix.size() == 0)
            return 0;
        int m = matrix.size();
        int n = matrix[0].size();
        int Max=0;
        for(int i=0; i<m; i++){
            for(int j=0; j<n; j++){
                if(matrix[i][j] == '1'){
                    int curr = 1;
                    bool valid = true;
                    while(i+curr<m && j+curr<n){
                        //upward
                        for(int k=i+curr; k>=i; k--){
                            if(matrix[k][j+curr] == '0'){
                                valid = false;
                                break;
                            }
                        }
                        if(!valid)
                            break;
                        for(int k=j+curr; k>=j; k--){
                            if(matrix[i+curr][k] == '0'){
                                valid = false;
                                break;
                            }
                        }
                        if(!valid)
                            break;
                        curr++;
                    }
                    Max = max(Max, curr);
                }
            }
        }
        return (Max*Max);
    }
};
