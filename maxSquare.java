class Solution {
    public int maximalSquare(char[][] matrix) {
        if(matrix == null || matrix.length == 0){
            return 0;
        }
        int m = matrix.length;
        int n = matrix[0].length;
        int max = 0;
        for(int i=0;i<m;i++){
            for(int j=0;j<n;j++){
                if(matrix[i][j]=='1'){
                    int curr = 1;
                    boolean flag=true;
                    while(i + curr < m && j + curr < n && flag == true){
                        //we check the column
                        for(int k=i+curr; k>=i; k--){
                            if(matrix[k][j+curr]!='1'){
                                flag=false;
                                break;
                            }
                        }
                        if(flag == true){
                            curr++;
                        }
                    }
                    max = Math.max(max,curr);
                }
            }
        }
        return max*max;
    }
}