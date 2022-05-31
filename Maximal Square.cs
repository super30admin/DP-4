// Time Complexity : O(m*n)
// Space Complexity : O(n)
// Did this code successfully run on Leetcode : Yes
// Any problem you faced while coding this : No


// Your code here along with comments explaining your approach

// 1) The below approach can be otimized by space by keeping only one row in 1D array
// 2) We need tree values ot get current value, up, left and upleft(diagonal)
// 	a. Up - dp[i]
// 	b. Left - dp[i-1], because after calculating current elemnt, we replace current value in dp array.
// 		i. We can store dp[i-1] in temp variable, so we can use in next step
//     c.Left up (diagonal) - temp variable

public int MaximalSquare(char[][] matrix) {
        
    if(matrix == null || matrix.Length == 0)
        return 0;
    
    int m = matrix.Length;
    int n = matrix[0].Length;
    int max = 0;
    int[] dp = new int[n+1];
    int[] dp = new int[n+1];
    int prev = 0, temp = 0;
    for(int i = 1; i < m+1; i++)
    {
        for(int j = 1; j < n+1; j++)
        {
            prev = dp[j];
            if(matrix[i-1][j-1] == '1')
            {
                dp[j] = Math.Min(temp, Math.Min(dp[j-1], dp[j])) + 1;
            }
            else
            {
                dp[j] = 0;
            }
            
            max = Math.Max(max, dp[j]);
            temp = prev;
        }
    }
    return max * max;
}

//TC: O(m*n)
//SC: O(n)
// 1) We can use DP also because we are looking for maximum squares at every point for whole matrix, so are repeating going to same element so many times.
//     a. At every element, we care about its neighbor, if they are 1, it means sqaure can be formed.
//     b. If element is 0, we can't form sqare there, just put 0.
// 2) So we use bottom up approach, Minimum(above, left, diagonal up) + 1
// 3) e keep iterating and take maximum in result.
public int MaximalSquare(char[][] matrix) {
        
    if(matrix == null || matrix.Length == 0)
        return 0;
    
    int m = matrix.Length;
    int n = matrix[0].Length;
    int max = 0;
    int[,] dp = new int[m+1,n+1];
    
    for(int i = 1; i < m+1; i++)
    {
        for(int j = 1; j < n+1; j++)
        {
            if(matrix[i-1][j-1] == '1')
            {
                dp[i,j] = Math.Min(dp[i-1,j-1], Math.Min(dp[i-1,j], dp[i,j-1])) + 1;
                max = Math.Max(max, dp[i,j]);
            }
        }
    }
    return max * max;
}

//Brute force
//TC: O(n^2)
//SC: O(1)
 public int MaximalSquare(char[][] matrix) {
    
    if(matrix == null || matrix.Length == 0)
        return 0;
    
    int m = matrix.Length;
    int n = matrix[0].Length;
    int max = 0;
    
    for(int i = 0; i < m; i++)
    {
        for(int j = 0; j < n; j++)
        {
            //if value is '1', traverse diagonally
            if(matrix[i][j] == '1')
            {
                int curr = 0;
                bool flag = true;
                
                while( i + curr < m && j + curr < n && flag)
                {   
                    //check within the same row
                    for(int k = j; k <= j + curr; k++)
                    {
                        if(matrix[i+curr][k] == '0')
                        {
                            flag = false;
                            break;
                        }
                    }
                    
                    if(!flag)
                        break;
                    //check with in smae column
                    for(int k  = i; k <= i + curr; k++)
                    {
                        if(matrix[k][j+curr] == '0')
                        {
                            flag = false;
                            break;
                        }
                    }
                    
                    if(!flag)
                        break;

                    curr++;
                }
                max = Math.Max(max, curr);
            }
        }
    }
    return max * max;
}