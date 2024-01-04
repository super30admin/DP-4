//  Time Complexity: O(m^2 * n^2)
//  Space Complexity: O(1)
//  Bruteforce approach (not working)
class Solution {
    public int maximalSquare(char[][] matrix) {
        if(matrix == null) return 0;
        int m = matrix.length;
        int n = matrix[0].length;
        int max = 0;

        for(int i=0; i<m; i++){
            for(int j=0; j<n; j++){
                if(matrix[i][j] == '1'){
                    int le = 1;
                    boolean flag = true;
                    while(flag && i+le < m && j+le<n && matrix[i+le][j+le] == '1'){
                        for(int k = i+le; k>= i; k--){
                            if(matrix[k][j+le] == '0'){
                                flag = false;
                                break;
                            }
                        }

                        for(int k = j+le; k>= j; k--){
                            if(matrix[i+le][k] == '0'){
                                flag = false;
                                break;
                            }
                        }

                        if(flag) le++;

                    }
                    max = Math.max(max, le);

                }
            }
        }
        return max * max;
    }
}

//  Time Complexity: O(mn)
//  Space Complexity: O(mn)
//  Dynamic Programming (2d Array)
class Solution {
    public int maximalSquare(char[][] matrix) {
        if(matrix == null) return 0;
        int m = matrix.length;
        int n = matrix[0].length;
        int dp[][] = new int[m+1][n+1];
        int max = 0;

        for(int i=1; i<=m; i++){
            for(int j=1; j<=n; j++){
                if(matrix[i-1][j-1] == '1'){
                    dp[i][j] = Math.min(dp[i][j-1], Math.min(dp[i-1][j], dp[i-1][j-1])) + 1;
                    max = Math.max(dp[i][j], max);
                }
            }
        }

        return max * max;
    }
}


//  Time Complexity: O(mn)
//  Space Complexity: O(n)
//  Dynamic Programming (1d Array)
class Solution {
    public int maximalSquare(char[][] matrix) {
        if(matrix == null) return 0;
        int m = matrix.length;
        int n = matrix[0].length;
        int dp[] = new int[n+1];
        int max = 0;

        for(int i=1; i<=m; i++){
            int diaUp = 0;

            for(int j=1; j<=n; j++){
                int temp = dp[j];

                if(matrix[i-1][j-1] == '1'){
                    dp[j] = Math.min(dp[j], Math.min(dp[j-1], diaUp)) + 1;
                    max = Math.max(dp[j], max);
                }else{
                    dp[j] = 0;
                }

                diaUp = temp;
            }
        }

        return max * max;
    }
}
