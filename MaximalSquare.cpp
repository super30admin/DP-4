// Brute Force Solution
// Time Complexity - O(m^2*n^2)
// Space Complexity - O(1)
// Problems Faced - No!
// It runs on Leetcode!
class Solution {
public:
    int maximalSquare(vector<vector<char>>& matrix) {
        int m = matrix.size();
        int n = matrix[0].size();
        int answer = 0;
        
        for(int i = 0; i < m; i++){
            for(int j = 0; j < n; j++){
                if(matrix[i][j] == '1'){
                    int l = 1;
                    bool flag = true;
                    while(i+l < m && j+l < n && flag){
                        for(int k = i+l; k >= i; k--){
                            if(matrix[k][j+l] == '0'){
                                flag = false;
                                break;
                            }
                        }
                        
                        for(int k = j+l; k >= j; k--){
                            if(matrix[i+l][k] == '0'){
                                flag = false;
                                break;
                            }
                        }
                        if(flag)
                            l++;
                    }
                    answer = max(answer, l);
                }
            }
        }
        return answer*answer;
    }
};

// Approach - DP(using a dp matrix)
// Time Complexity - O(m*n)
// Space Complexity - O(m*n)
// Problems Faced - No!
// It runs on Leetcode!
class Solution {
public:
    int maximalSquare(vector<vector<char>>& matrix) {
        int m = matrix.size();
        int n = matrix[0].size();
        int answer = 0;
        vector<vector<int>> dp(m, vector<int>(n, 0));
        
        for(int i = 0; i < m; i++){
            if(matrix[i][0] == '1')
                answer = 1;
            dp[i][0] = matrix[i][0] - '0';
        }

        for(int i = 0; i < n; i++){
            if(matrix[0][i] == '1')
                answer = 1;
            dp[0][i] = matrix[0][i] - '0';
        }
        
        for(int i = 1; i < m; i++){
            for(int j = 1; j < n; j++){
                if(matrix[i][j] == '1'){
                    int diag = dp[i-1][j-1];
                    int top = dp[i-1][j] ;
                    int left = dp[i][j-1];
                    int val = 1 + min(top, min(diag, left));
                    answer = max(answer, val);
                    dp[i][j] = val;
                }
            }
        }
        return answer*answer;
    }
};


// DP - In-Place
// Time Complexity - O(m*n)
// Space Complexity - O(1)
// Problems Faced - It fails for 1 testcase. It is a very large testcase. The expected answer is 90,000 but the output is 6400. All testcases except this one pass.
// It runs on Leetcode - No!
class Solution {
public:
    int maximalSquare(vector<vector<char>>& matrix) {
        int m = matrix.size();
        int n = matrix[0].size();
        int answer = 0;
        for(int i = 0; i < m; i++){
            if(matrix[i][0] == '1')
                answer = 1;
        }
        for(int i = 0; i < n; i++){
            if(matrix[0][i] == '1')
                answer = 1;
        }
        
        for(int i = 1; i < m; i++){
            for(int j = 1; j < n; j++){
                if(matrix[i][j] == '1'){
                    int diag = matrix[i-1][j-1] - '0';
                    int top = matrix[i-1][j] - '0';
                    int left = matrix[i][j-1] - '0';
                    int val = 1 + min(top, min(diag, left));
                    answer = max(answer, val);
                    matrix[i][j] = val + '0';
                }
            }
        }
        return answer*answer;
    }
};