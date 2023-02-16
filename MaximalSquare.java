// Approach 1: Brute force
// Time Complexity : O(m^2*n^2)
// Space Complexity : O(1)
// Did this code successfully run on Leetcode : TLE
// Any problem you faced while coding this : No

// Your code here along with comments explaining your approach
// We can find max square length at every '1' and then return max of all of them
// To find if square of len is possible, firs't check diagonal element. If it is '1', check all elements on left and top of diagonal
class Solution {
    public int maximalSquare(char[][] matrix) {
        int m = matrix[0].length;
        int n = matrix.length;
        int max = 0;
        for(int i=0;i<n;i++)
            for(int j=0;j<m;j++)
            {
                if(matrix[i][j]=='1')
                {
                    boolean flag = true;
                    int len =1;
                    while(i+len<n && j+len<m && matrix[i+len][j+len]=='1' && flag){
                        for(int k=i+len;k>=i;k--){
                            if(matrix[k][j+len]=='0'){
                                flag = false;
                                break;
                            }
                        }
                        for(int k=j+len;k>=j;k--){
                            if(matrix[i+len][k]=='0'){
                                flag = false;
                                break;
                            }
                        }
                    if(flag) len++;
                    }
                    max = Math.max(len, max);
                }
            }
            return max*max;
    }
}

// Approach 2: DP
// Time Complexity : O(mn)
// Space Complexity : O(mn)
// Did this code successfully run on Leetcode : Yes
// Any problem you faced while coding this : No

// Your code here along with comments explaining your approach
// in DP approach, once we find max length with matrix[i][j] as its corner, we can use it in further calculations
// dp[i-1][j-1] gives us info about diagonal, dp[i][j-1] - left elements, dp[i-1][j] - top elements
// by storing these values we get rid of O(mn) complexity term
class Solution {
    public int maximalSquare(char[][] matrix) {
        int m = matrix[0].length;
        int n = matrix.length;
        int max = 0;
        int dp[][] = new int[n+1][m+1];
        for(int i=1;i<=n;i++)
            for(int j=1;j<=m;j++){
                if(matrix[i-1][j-1]=='1'){
                    dp[i][j] = 1+ Math.min(dp[i-1][j], 
                        Math.min(dp[i][j-1], dp[i-1][j-1]));
                    max = Math.max(max, dp[i][j]);
                }
            }
            return max*max;
    }
}

// Approach 3: DP optimized space
// Time Complexity : O(mn)
// Space Complexity : O(n)
// Did this code successfully run on Leetcode : Yes
// Any problem you faced while coding this : No

// Your code here along with comments explaining your approach
// Similar to Approach 2 but optimizing space by using 1D dp matrix
class Solution {
    public int maximalSquare(char[][] matrix) {
        int m = matrix[0].length;
        int n = matrix.length;
        int max = 0;
        int dp[] = new int[m+1];
        for(int i=1;i<=n;i++){
        int diag = dp[0];
            for(int j=1;j<=m;j++){
                int temp = dp[j];
                if(matrix[i-1][j-1]=='1'){
                    dp[j] = 1+ Math.min(dp[j-1], 
                        Math.min(dp[j], diag));
                    max = Math.max(max, dp[j]);
                }
                else dp[j] = 0;
                diag = temp;
            }
        }
            return max*max;
    }
}