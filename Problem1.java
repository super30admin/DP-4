// Time Complexity :O(m+1 * n+1)
// Space Complexity :O(m+1 * n+1)
// Did this code successfully run on Leetcode : Yes
// Any problem you faced while coding this : No

// Your code here along with comments explaining your approach
// 1.Have a 2d array and initialise top row and left column with zeroes.
// 2. Now start from first row, first column in matrix and check if its one , else move on to next element.
// 3. If its one then check if its top,left,top left diagonal are >0 then update current value in new array to one plus min of those values.
// 4. Have a max variable and update it whwnever we find a max value . After all elements covered return max*max since we need area.
public class maximalSquare {
    public static int maximalSquare(char[][] matrix){
        if(matrix.length == 0)  return 0;
        int[][] dp = new int[matrix.length+1][matrix[0].length+1];
        for(int i = 0;i<dp.length;i++)
            dp[i][0] = 0;
        for(int i = 0;i<dp[0].length;i++)
            dp[0][i] = 0;
        int max = 0;
        for(int i = 1;i<dp.length;i++){
            for(int j =1;j<dp[0].length;j++){
                if(matrix[i-1][j-1] == '1'){
                    dp[i][j] = 1+Math.min(dp[i-1][j-1],Math.min(dp[i-1][j],dp[i][j-1]));
                    max = Math.max(max,dp[i][j]);
                }

            }
        }
        return max*max;
    }
// Brute Force Approach
    // Time Complexity : O(mn)^2
    // Space Complexity : O(1)
    // Did this code successfully run on Leetcode : Yes
    // 1. Start from first element . If its one check if next row's and next col's elements inculding next diagonal are 1. If true then 
    //    update curlenthen check this till last row and last col or till a 0 is found.
    // 2. Updat max value if curlen is greater then max . Do this for all elements and finally return max*max since we need area. 
    public static int maximalSquare2(char[][] matrix){
        if(matrix.length == 0)  return 0;
        int rows = matrix.length;
        int cols = matrix[0].length;
        int max = 0;
        int curlen = 0;
        boolean flag = false;
        for(int i = 0;i<rows;i++){
            for(int j = 0;j<rows;j++){
                if(matrix[i][j] == '1'){
                    curlen = 1;
                    flag = true;
                    while(i+curlen < rows && j+curlen <cols && flag){
                        for(int k = i;k<=i+curlen;k++){
                            if(matrix[k][j+curlen] == '0'){
                                flag = false;
                                break;
                            }
                        }
                        for(int k = j;k<=j+curlen;k++){
                            if(matrix[i+curlen][k] == '0'){
                                flag = false;
                                break;
                            }
                        }
                        if(flag)    curlen++;
                    }
                    max = Math.max(curlen,max);
                }
            }
        }
        return max*max;
    }
    
    public static void main(String[] args) {
        char[][] matrix = {{'1','0','1','0','0'},{'1','0','1','1','1'},{'1','1','1','1','1'},{'1','0','0','1','0'}};
        System.out.println(maximalSquare(matrix));
    }
}
