//Time complexity-O(mn)
//Space complexity-O(mn)
//Ran on leetcode-Yes
//Solution with comments-
class Solution {
    public int maximalSquare(char[][] matrix) {
        int row=matrix.length;
        int col= matrix[0].length;
        int max=0;
        int dp[][]= new int[row][col];//dp array to store the sqaure that can be foemed at the index
        for(int i=0;i<row;i++){
            for(int j=0;j<col;j++){
                if(matrix[i][j]=='0'||i==0 ||j==0){
                   dp[i][j]= Character.getNumericValue(matrix[i][j]);
                }
                else{
                    dp[i][j]= Math.min(dp[i-1][j-1],Math.min(dp[i-1][j],dp[i][j-1]))+1;//check the minimum value of all adjacents above the matrix value
                }                
                max=Math.max(max,dp[i][j]);
            }
        }
        return max*max;
    }
}