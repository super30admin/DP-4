// Time Complexity :
// Space Complexity :
// Did this code successfully run on Leetcode :
// Any problem you faced while coding this :

//create a 2d array now check for min(element(i-1,j)(i-1,j-1)(i,j-1))
//result = max(this element,result) 
//if it is 1(arr[i-1][j-1])
// Your code here along with comments explaining your approach
//TC: O(m*n)
//SC: O(m*n)
//check for
class Solution {
    public int maximalSquare(char[][] arr) {
    if(arr.length == 0) return 0;
    int m = arr.length, n = arr[0].length, result = 0;
    int[][] dp = new int[m+1][n+1];
    for (int i = 1 ; i <= m; i++) {
        for (int j = 1; j <= n; j++) {
            if(arr[i-1][j-1] == '1') {
                dp[i][j] = Math.min(Math.min(dp[i][j-1] , dp[i-1][j-1]), dp[i-1][j]) + 1;
                result = Math.max(dp[i][j], result); // update result
            }
        }
    }
    return result*result;
    }
}