// Time Complexity :O(MN)
// Space Complexity :O(1)
// Did this code successfully run on Leetcode :Yes
// Any problem you faced while coding this :


// Your code here along with comments explaining your approach

class Solution {
    public int maximalSquare(char[][] matrix) {
        int m=matrix.length;
        int n= matrix[0].length;
        int maxSquare=0;
        if(m==0) return 0;

        for(int i=m-1; i>=0; i--){
            for(int j=0; j<n; j++){
                if(matrix[i][j]=='1'){
                    if(i!=m-1 && j!=0){
                        int neighbors=Math.min(matrix[i][j-1], Math.min(matrix[i+1][j-1], matrix[i+1][j]))-'0';
                        matrix[i][j] = (char)(neighbors + 1 + '0');
                    } 
                }
                maxSquare=Math.max(maxSquare, matrix[i][j]-'0');
            }
        }
        return  maxSquare*maxSquare;
    }
}