# DP-4
## Problem1:(https://leetcode.com/problems/maximal-square/)

Given a 2D binary matrix filled with 0's and 1's, find the largest square containing only 1's and return its area.

Example:

Input: 


1 0 1 0 0

1 0 1 1 1

1 1 1 1 1

1 0 0 1 0

Output: 4

//Optimized SOLUTION - DP 1d array
class Solution {
    //Time Complexity: O(m*n)
    //Space Complexity: O(n) -- 1d array
    public int maximalSquare(char[][] matrix) {
        if(matrix == null || matrix.length ==0)
        {
            return 0;
        }
        int max =0;
        int []dp = new int[matrix[0].length +1];
        int diagonal = 0;
        int temp =0;
        for(int i=1; i<= matrix.length; i++)
        {
            
            for(int j=1; j<= matrix[0].length; j++)
            {
                 temp = dp[j];
                if(matrix[i-1][j-1] == '1')
                {
                     dp[j] = Math.min(diagonal, Math.min(dp[j],dp[j-1])) +1;
                     max = Math.max(max, dp[j]);
                }
                else
                {
                        dp[j] = 0;
                }
                
                 diagonal = temp;  
            }
        }
        
        
        return max * max;
    }
}

//DP - 2D Array
class Solution {
    //Time Complexity: O(m*n)
    //Space Complexity: ((m*n)) -- 2d array
    public int maximalSquare(char[][] matrix) {
        if(matrix == null || matrix.length ==0)
        {
            return 0;
        }
        int max =0;
        int [][]dp = new int[matrix.length +1 ][matrix[0].length + 1];
        for(int i=1; i<dp.length ; i++)
        {
            for(int j=1; j<dp[0].length; j++)
            {
                if(matrix[i-1][j-1]=='0')
                {
                    dp[i][j] =0;
                }
                else
                {
                    
                    int top = j>0?dp[i][j-1]:0;
                    int left = i>0?dp[i-1][j]:0;
                    int diag = i>0 && j>0 ? dp[i-1][j-1]:0;
                    dp[i][j] = 1 + Math.min(top, Math.min(left ,diag));
                    max = Math.max(max, dp[i][j]);
                }
            }
        }
        
        
        return max * max;
    }
}

//Brute Force 
//Time Complexity: O(m^2 * n^2)
//Space Complexity: O(1)
class Solution {
    public int maximalSquare(char[][] matrix) {
        if(matrix == null || matrix.length ==0)
        {
            return 0;
        }
        int n = matrix.length;
        int m= matrix[0].length;
        int max =0;
        boolean flag = false;
        for(int i=0; i<n; i++)
        {
            for(int j=0; j<m; j++)
            {
                if(matrix[i][j] == '1')
                {
                    flag = true;
                    int curr = 1;
                    while(i+curr < n && j+curr < m && flag)
                    {
                        for(int k= i+ curr; k>=i; k--)
                        {
                            if(matrix[k][j+curr] == '0')
                            {
                                flag = false;
                                break;
                            }
                        }
                        
                        for(int k= j+ curr; k>=j; k--)
                        {
                            if(matrix[i+curr][k] == '0')
                            {
                                flag = false;
                                break;
                            }
                        }
                        
                        if(flag) curr++;
                    }
                    
                    max = Math.max(max, curr);
                    
                }
            }
        }
        
        return max * max;
    }
}

## Problem2:(https://leetcode.com/problems/partition-array-for-maximum-sum/)

Given an integer array A, you partition the array into (contiguous) subarrays of length at most K.  After partitioning, each subarray has their values changed to become the maximum value of that subarray.

Return the largest sum of the given array after partitioning.

Example 1:

Input: A = [1,15,7,9,2,5,10], K = 3

Output: 84

    Explanation: A becomes [15,15,15,9,10,10,10]

Note:

1 <= K <= A.length <= 500
0 <= A[i] <= 10^6

//O(m*k) time and O(m) space , m= arr.length

class Solution {
    public int maxSumAfterPartitioning(int[] arr, int k) {
        //null
        int dp[] = new int[arr.length];
        dp[0] = arr[0];
        for(int i=1; i< dp.length; i++)
        {
            int max = dp[i];
            for(int j=1; j<=k && (i-j+1)>=0; j++)
            {
                //process incoming elements from l->r 
                max = Math.max(max, arr[i-j+1]);
                if(i-j>=0)
                    dp[i] = Math.max(dp[i], dp[i-j] + j*max);
                else
                    dp[i] = Math.max(dp[i], j*max);
            }
        }
        
        return dp[arr.length-1];
    }
}