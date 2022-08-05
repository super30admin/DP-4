class MaximalSquare {
    //TC is O(m*n)
    //SC is constant
    public int maximalSquare(char[][] matrix) {
        int m =matrix.length;
        int n = matrix[0].length;
        int l = 0;
        int max = 0;
        if(matrix == null || matrix.length == 0) return 0;
        for(int i=0;i<m;i++){
            if(matrix[i][n-1] == '1'){
                max = 1;
            }
        }
        for(int j=0;j<n;j++){
            if(matrix[m-1][j] == '1'){
                max = 1;
            }
        }
        for(int i=m-2;i>=0;i--){
            for(int j=n-2;j>=0;j--){
                if(matrix[i][j] == '1'){
                int right = matrix[i][j+1]-'0';
                int bottom = matrix[i+1][j]-'0';
                int bottomR = matrix[i+1][j+1]-'0';
                
                int temp = Math.min(right,Math.min(bottom,bottomR))+1;
                max = Math.max(max,temp);
                matrix[i][j] = (char)(temp+'0');
            }
            }
        }
        return max*max;
    }
}