
// Brute force
public class MaximalSquare {
    public int maximalSquare(char[][] matrix) {
        if(matrix==null || matrix.length==0) return 0;
        int m = matrix.length;
        int n = matrix[0].length;
        int max = 0;
        for(int i=0;i<m;i++){
            for(int j=0;j<n;j++){
                if(matrix[i][j]=='1'){
                    int l = 1;
                    boolean flag = true;
                    while(i+l<m && j+l<n && flag){
                       for(int k=i+l;k>=i;k--){
                        if(matrix[k][j+l]=='0'){
                            flag = false;
                            break;
                        } 
                    }
                    for(int k=j+l;k>=j;k--){
                        if(matrix[i+l][k]=='0'){
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

// Time complexity - O(m2*n2)

// DP Solution
public class MaximalSquare {
    public int maximalSquare(char[][] matrix) {
        if(matrix==null || matrix.length==0) return 0;
        int m = matrix.length;
        int n = matrix[0].length;
        int max = 0;
        int[][] dp = new int[m+1][n+1];
        for(int i=1;i<=m;i++){
            for(int j=1;j<=n;j++){
                if(matrix[i-1][j-1]=='1'){ // top-down
                    dp[i][j] = 1+ Math.min(dp[i][j-1], Math.min(dp[i-1][j], dp[i-1][j-1]));
                    max = Math.max(max, dp[i][j]);
                }
            }
        }
        return max*max;
    }
}

// Time complexity - O(m*n)
// Space complexity - O(m*n)

// DP Solution - optimized space
public class MaximalSquare {
    public int maximalSquare(char[][] matrix) {
        if(matrix==null || matrix.length==0) return 0;
        int m = matrix.length;
        int n = matrix[0].length;
        int max = 0;
        int[][] dp = new int[m+1][n+1];
        for(int i=0;i<m;i++){
            if(matrix[i][0]=='1') max=1;
        }
         for(int j=0;j<n;j++){
            if(matrix[0][j]=='1') max=1;
        }
        
        for(int i=1;i<m;i++){
            for(int j=1;j<n;j++){
                if(matrix[i][j]=='1'){ // top-down
                    int up = matrix[i][j-1]-'0';
                    int left = matrix[i-1][j]-'0';
                    int diagUp = matrix[i-1][j-1]-'0';
                    int curr = 1+Math.min(up, Math.min(left, diagUp));
                    max = Math.max(max, curr);
                    matrix[i][j] = (char)(curr+'0');
                }
            }
        }
        return max*max;
    }
}

// Time complexity - O(m*n)
// Space complexity - O(1)