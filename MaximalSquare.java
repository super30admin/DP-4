// Time Complexity: O(mn) size of matrix
// Space Complexity: O(n) column length
// DP space optimized
public class MaximalSquare {
    int max = 0;        
    if(matrix == null || matrix.length == 0)
            return max;
        
        int m = matrix.length, n = matrix[0].length;
        int dp[] = new int[n+1];
        int diag = 0;
        // parse through the matrix
        for(int i = 1 ; i <= m ; i++)
        {
            for(int j = 1 ; j <= n; j++)
            {
                if(matrix[i-1][j-1] == '1')
                {
                    // saving top as this will become diagonal in next col
                   int top = dp[j];
                   // min of left = dp[j-1], top = dig[j], diag == prev top + 1
                   dp[j]= Math.min(dp[j-1], Math.min(dp[j],diag)) + 1;
                   // update diag 
                   diag = top;
                   // update max
                   max = Math.max(max, dp[j]);
                }
                else
                {
                    dp[j] = 0 ;
                }
            }
        }
              
        return max * max;
    }
}

// Time Complexity: O(mn) size of matrix
// Space Complexity: O(mn)
// DP
public class MaximalSquare {
    public int maximalSquare(char[][] matrix) {
        int max = 0;        
        if(matrix == null || matrix.length == 0)
                return max;
            
            int m = matrix.length, n = matrix[0].length;
            int dp[][] = new int[m+1][n+1];
            // parse through the matrix
            for(int i = 1 ; i <= m ; i++)
            {
                for(int j = 1 ; j <= n; j++)
                {
                    if(matrix[i-1][j-1] == '1')
                    {
                        // min of left, top, diag + 1
                        dp[i][j]= Math.min(dp[i][j-1], Math.min(dp[i-1][j], dp[i-1][j-1])) + 1;    
                        // update max
                        max = Math.max(max, dp[i][j]);
                    }
                }
            }
                  
            return max * max;
        }
}

// Time Complexity: O((mn)^2)
// Space Complexity: O(1)
// Brute Force
public class MaximalSquare {
    public int maximalSquare(char[][] matrix) {
        int max = 0;        
        if(matrix == null || matrix.length == 0)
                return max;
            
            int m = matrix.length, n = matrix[0].length;
            
            // parse through the matrix
            for(int i = 0 ; i < m ; i++)
            {
                for(int j = 0 ; j < n; j++)
                {
                    if(matrix[i][j] == '1')
                    {
                        boolean isValid = true;
                        int len = 1;
                        // keep increasing the size of sq if in range and find valid
                        while(i + len < m && j + len < n && isValid)
                        {
                            // check row + len all cols
                            for(int k = j ; k <= j+len ; k++)
                            {
                                if(matrix[i+len][k] == '0')
                                {
                                    isValid = false;
                                    break;
                                } 
                            }
                            
                            // check for col + len all rows
                            for(int k = i ; k <= i + len ; k++)
                            {
                                if(matrix[k][j+len] == '0')
                                {
                                    isValid = false;
                                    break;
                                } 
                            }
                        
                            if(isValid)
                            {
                                // check for a bigger size sq
                                len++;
                             }
                        }
                        // only if valid for all len update max
                        max = Math.max(max, len);
                    }
                }
            }
                  
            return max * max;
        }
}
