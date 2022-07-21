class Solution {
    public int maximalSquare(char[][] matrix) {
      // null
        int m = matrix.length; int n = matrix[0].length;
        int max = 0;
        int [] dp = new int[n+1];
        for(int i = 1; i <= m; i++){
            int diagUp = 0;
            for(int j = 1; j <= n; j++){
                 int temp = dp[j];
                if(matrix[i-1][j-1] == '1'){
                    dp[j] = 1 + Math.min(dp[j], Math.min(dp[j-1], diagUp));
                    max = Math.max(dp[j], max);
                } else {
                    dp[j] = 0;
                }
                diagUp = temp;
            }
        }
        
        return max*max;
    }
}

/*
//dp by munipulating the same matrix
class Solution {
    public int maximalSquare(char[][] matrix) {
        if(matrix == null || matrix.length == 0) return 0;
        int max = 0; int m = matrix.length; int n = matrix[0].length;
        for(int j = 0; j < n;j++){
            if(matrix[0][j] == '1'){
                max = 1;
            }
        }
        for(int i = 0; i < m;i++){
            if(matrix[i][0] == '1'){
                max = 1;
            }
        }
        for(int i = 1; i < m; i++){
            for(int j = 1; j < n; j++){
                if(matrix[i][j] == '1'){
                    int top = matrix[i-1][j] - '0';
                    int topLeft = matrix[i-1][j-1] - '0';
                    int left = matrix[i][j-1] - '0';
                    int temp = 1 + Math.min(top, Math.min(topLeft, left));
                    max = Math.max(max, temp);
                    matrix[i][j] = (char)(temp +'0');
                }
            }
        }                         
        return max*max;
    }
}
*/
/*
class Solution {
    public int maximalSquare(char[][] matrix) {
        if(matrix == null || matrix.length == 0) return 0;
        int max = 0; int m = matrix.length; int n = matrix[0].length;
        for(int i = 0; i < m; i++){
            for(int j = 0; j < n; j++){
                if(matrix[i][j] == '1'){
                    int l = 1;
                    boolean flag = true;
                    while(i+l < m && j + l < n && flag){
                        //check in colomn if all 1;
                        for(int k = i+l; k >= i; k--){
                            if(matrix[k][j+l] == '0'){
                                flag = false;
                                break;
                            }
                        }
                        //row
                        for(int k = j+l; k >= j; k--){
                            if(matrix[i+l][k] == '0'){
                                flag = false;
                                break;
                            }
                        } 
                      if(flag) l++;                
                    }
                    max = Math.max(max,l);
                }        
            }
        }                         
        return max*max;
    }
}
*/