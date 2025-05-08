// Time Complexity : O(m * n)
// Space Complexity : O(n)
// Did this code successfully run on Leetcode : Yes

// Approach:
// Using dp array to track the size of largest square ending at each cell in the current row.
// For each '1', compute the minimum of left, top, and top-left neighbors and add 1 to get the new square size.
// Keep updating the maximum size and return its area.

class Solution {
    public int maximalSquare(char[][] matrix) {
        int m=matrix.length;
        int n=matrix[0].length;
        int max=0;
        int[] dp=new int[n+1];
        int diagUp=0;
        for(int i=1;i<=m;i++){
            for(int j=1;j<=n;j++){
                int temp=dp[j];
                if(matrix[i-1][j-1]=='1'){
                    dp[j]=1+Math.min(dp[j],Math.min(dp[j-1],diagUp));
                    max=Math.max(max,dp[j]);
                }
                else{
                    dp[j]=0;
                }
                diagUp=temp;
            }
        }
        return max*max;
    }
}
