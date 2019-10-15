//Time Complexity:O(MN)
//Space Complexity:O(MN)
//Approach- Whenever a one is encountered, I'll be finding the min value from the top, topleft diagonal and its left element and add one to it. This would give me an indication of the size of the square matrix formed until that instant. I'll also update the max value whenever there is a change in the matrix size I'm forming. AT the end I'll return max^2 which will be the maximal square area.
//This code was executed successfully and got accepted in leetcode.

class Solution {
    public int maximalSquare(char[][] matrix) {
        int rows=matrix.length;
        int cols=rows>0?matrix[0].length:0;
        int [][] res=new int[rows+1][cols+1];
        int max=0;
        
        for(int i=1;i<=rows;i++){
            for(int j=1;j<=cols;j++){
                if(matrix[i-1][j-1]=='1'){
                    res[i][j]=Math.min(Math.min(res[i-1][j],res[i][j-1]),res[i-1][j-1])+1;
                    max=Math.max(max,res[i][j]);
                }
            }
        }
        return max*max;
        
    }
}