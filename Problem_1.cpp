/**
 * Time complexity:
 * Brute force: O((mn)^2)
 * DP: O(mn)
 * Optimized DP:  O(mn)
 * 
 */

/**
 * Space Complexity:
 * * Brute force: O(1)
 * DP: O(mn)
 * Optimized DP:  O(n)
 */

/**
 * Approach:
 * First approach is Brute force:
 * we start from the top left corner and check if the value is 1 or not.
 * If it is 1 then we have length 1 of the square. Now we check till i + length <
 * size of the rows and j +length is less than size of the columns to get 1. If it
 * is not 1,we break out of the loop. Otherwise we increment if we get 1 for the 
 * above condition for both rows and columns. Finally we take square of the max value.
 * 
 * Second approach is DP:
 * Based on the above approach we observe that the length of the square is
 * minimum of the element on the left, top and left upper diagnoal + 1. Based
 * on this approach we built our solution. Here we are creating an extra matrix
 * to store the values.
 * 
 * Third approach is optimized DP:
 * We observed that we do not need to maintain an entire matrix, just one row 
 * would be enough that is the last row of the matrix which can be updated again
 * and again. It will save the space. So instead of the matrix we maintain an array.
 * 
 * 
 */

//The code ran perfectly on leetcode.

//Brute force solution
class Solution {
public:
    int maximalSquare(vector<vector<char>>& matrix) {
        if(matrix.size() == 0) return 0;
        int m = matrix.size();
        int n = matrix[0].size();
        bool flag = false;
        int maxSqr = 0;
        for(int i =0; i<m; i++){
            for(int j = 0; j<n; j++){
                if(matrix[i][j]=='1'){
                    flag = true;
                    int length = 1;
                    while(i + length < m && j + length < n && flag){
                        for(int k = i; k <= i + length; k++){
                            if(matrix[k][j+length] == '0'){
                                flag = false;
                                break;
                            }
                        }
                        
                        for(int k = j;  k<= j +length; k++){
                            if(matrix[i+length][k] == '0'){
                                flag = false;
                                break;
                            }
                        }
                        
                        if(flag) length++;
                    }
                    maxSqr = max(maxSqr, length);
                }
                
            }
        }
        return maxSqr*maxSqr;
    }
};



//DP Solution
class Solution {
public:
    int maximalSquare(vector<vector<char>>& matrix) {
        if(matrix.empty() || matrix.size() == 0) return 0;
        int m  = matrix.size();
        int  n = matrix[0].size();
        vector<vector<int>> dp(m + 1, vector<int> (n +1));
        int maxSqr = 0;
        
        for(int i =1; i<dp.size(); i++){
            for(int j = 1; j <dp[0].size(); j++){
                if(matrix[i-1][j-1] == '1'){
                    dp[i][j] = min(dp[i-1][j-1], min(dp[i-1][j], dp[i][j-1])) +1;
                    maxSqr = max(dp[i][j], maxSqr);
                }
            }
        }
        
        
        return maxSqr*maxSqr;
        
    }
};

//Optimized DP solution
class Solution {
public:
    int maximalSquare(vector<vector<char>>& matrix) {
        if(matrix.empty() || matrix.size() == 0) return 0;
        int m = matrix.size();
        int n = matrix[0].size();
        int maxSqr = 0;
        int diagUp = 0;
        int temp = 0;
        vector<int> dp(n+1);
        for(int i = 1; i<=m; i++){
            for(int j = 1; j<=n; j++){
                temp = dp[j];
                if(matrix[i-1][j-1] == '1'){
                    dp[j] = min(dp[j-1], min(dp[j], diagUp)) + 1;
                    maxSqr = max(maxSqr, dp[j]);  
                } else {
                    dp[j] = 0;
                }
                diagUp = temp;
            }
        }
        return maxSqr*maxSqr;
        
        
    }
};