// Time Complexity :O(m*m*n*n) where m is the number of rows and n is the number of columns,
// Space Complexity : O(1)
// Did this code successfully run on Leetcode : Yes
// Any problem you faced while coding this : Yes, understanding the structure of the repeated sub problem.
// Your code here along with comments explaining your approach: //The approach is simple.We try to move around the diagonal from a one that we find in the matrix, we move to it's diagonal element if the row and column from that diagonal element has all ones then we move to the next diagonal element.
//2.We multiply the max*2 to give the area.Once the search breaks then, in the main array we search for the next one.At any point in this search we encounter a zero, we break the search.



class Solution {
    public int maximalSquare(char[][] matrix) {
        if(matrix==null || matrix.length==0) return 0;
        int m=matrix.length;int n=matrix[0].length;
        boolean flag=false; int max=0;
        for(int i=0;i<m;i++){
            for(int j=0;j<n;j++){
                if(matrix[i][j]=='1'){
                    flag=true;int curr=1;
                    while(i+curr<m && j+curr<n && flag==true){
                        //iterating on the column
                       for(int k=i+curr;k>=i;k--){
                           if(matrix[k][j+curr]=='0') flag=false;
                       } 
                        //iterate on the row
                         for(int k=j+curr;k>=j;k--){
                           if(matrix[i+curr][k]=='0') flag=false;
                       } 
                        if(flag)
                            curr++;
                    }
                    max=Math.max(max,curr);
                 }
            }
        }
        return max*max;
    }
}

// Time Complexity : O(m*n)
// Space Complexity : O(m*n)
// Did this code successfully run on Leetcode : Yes
// Any problem you faced while coding this : Yes
// Your code here along with comments explaining your approach: Dp Approach. At every point we check which of the neighbours is the constraining factor that is which is the minumum, is what we check and populate it. We view it diagonally. It is a dp solution.



class Solution {
    public int maximalSquare(char[][] matrix) {
        if(matrix==null || matrix.length==0) return 0;
        int m=matrix.length;int n=matrix[0].length;
        int max=0;
        int[][] dp=new int[m+1][n+1];
        for(int i=1;i<dp.length;i++){
            for(int j=1;j<dp[0].length;j++){
               if(matrix[i-1][j-1]=='1'){
                   dp[i][j]=1+Math.min(dp[i-1][j],Math.min(dp[i][j-1],dp[i-1][j-1]));
                   max=Math.max(max,dp[i][j]);
               }
            }
        }
        return max*max;
    }
}