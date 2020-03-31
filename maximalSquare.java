
// Time Complexity : O(M*N) traverse all elements withing input 2D array
// Space Complexity : O(M*N) : dp array
// Did this code successfully run on Leetcode : Yes
// Any problem you faced while coding this : After class solution


// Your code here along with comments explaining your approach


class Solution {
    public int maximalSquare(char[][] matrix) {
        
        if(matrix == null || matrix.length == 0) return 0; //ask
        
        int m = matrix.length;
        int n = matrix[0].length;
        
        //initialize the result area matrix
        int[][] area = new int[m][n];
        
        int maxArea = 0;
        
        //fill first col of "area" with 1 or 0 depending on the value
        for(int i=0; i<m; i++){
           area[i][0] = matrix[i][0] == '0' ? 0 : 1; 
            maxArea = Math.max(maxArea, area[i][0]);
        }
        
        //fill first row with 1 or 0 depending on the value
        for(int i=0; i<n; i++){
           area[0][i] = matrix[0][i] == '0' ? 0 : 1; 
            maxArea = Math.max(maxArea, area[0][i]);
        }
        
        //fill other values in area matrix
        for(int i=1; i<m; i++){
            for(int j=1; j<n; j++){
                System.out.println(area[i][j]);
                if(matrix[i][j] == '1'){
                  area[i][j] = Math.min(area[i-1][j], Math.min(area[i][j-1], area[i-1][j-1])) + 1;  
                maxArea = Math.max(maxArea, area[i][j]);
                }
            }
        }
        
        return maxArea*maxArea;
    }
}
