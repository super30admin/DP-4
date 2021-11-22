//Timecomplexity :- O(n*m).
//Spacecomplexity:- O(n*M);


class Solution {
    public int maximalSquare(char[][] matrix) {
        int m=matrix.length;
        int n=matrix[0].length;
        int max=0;
        int[][] cache=new int[m+1][n+1];
        
        
        for(int i=1;i<=m;i++){
            for(int j=1;j<=n;j++){
                
                if(matrix[i-1][j-1]=='1'){
                    cache[i][j]=1 + Math.min(cache[i-1][j],Math.min(cache[i][j-1],cache[i-1][j-1]));
                    max=Math.max(max,cache[i][j]);
                }
            }
        }
        return max*max;
    }
}