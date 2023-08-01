package DP_4;

/**
 * Using bottom up dynamic programming where in the dp array each cell
 * represents the maximum square that can be formed looking upward.
 * 
 * Time Complexity : O(n*m)- where n is the of rows and m is the no of cols in
 * the given matrix
 * 
 * Space Complexity : O(m), as the dp array indicates the values of a
 * corresponding matrix row at every point.
 * 
 * Did this code successfully run on Leetcode : yes
 * 
 * Any problem you faced while coding this : No
 */
public class Problem1 {
    public int maximalSquare(char[][] matrix) {

        int dp[]= new int[matrix[0].length];
        int maxSize=0;

        for(int i=0;i<dp.length;i++){
            dp[i]=matrix[0][i]-'0';
            if(matrix[0][i]=='1')
                maxSize=1;
        }

        int diagUp;


        for(int i=1;i<matrix.length;i++){
            dp[0]=matrix[i][0]-'0';
            diagUp=matrix[i-1][0]-'0';
            if(matrix[i][0]=='1')
                maxSize=Math.max(maxSize, 1);;
            for(int j=1;j<matrix[0].length;j++){
                int temp=dp[j];
                if(matrix[i][j]-'0'==1){
                dp[j]=Math.min(dp[j],Math.min(dp[j-1],diagUp))+1;
                maxSize=Math.max(maxSize, dp[j]);
                }
                else
                    dp[j]=0;
                
                diagUp=temp;
            }
            
        }

        return maxSize*maxSize;
    }

}
