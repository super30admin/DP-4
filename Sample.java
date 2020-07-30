// Time Complexity : O(m^2 n^2) as 2 choices each time for each cell
// Space Complexity : O(1)
// Did this code successfully run on Leetcode : Yes
// Any problem you faced while coding this : None

class Solution {
    public int maximalSquare(char[][] matrix) {
        //edge case
      if(matrix== null || matrix.length == 0)
          return 0;
        int m = matrix.length;
        int n = matrix[0].length;
        boolean flag;
        int max = 0;
        for(int i=0;i<m;i++) // iterate over the matrix
        {
            for(int j=0;j<n;j++)
            {
               if(matrix[i][j] == '1') // when we find 1
               {
                  int curr = 1; // set curr to 1
                   flag = true; // flag to true as we have a possibility of square
                    while(i+curr<m && j+curr<n && flag) // boundary check and flag should be true
                    {
                        for(int k=i+curr; k>=i;k--) // check all values above the point till i
                        {
                            if(matrix[k][j+curr] == '0') // if any zero
                                flag = false; // set falg to false
                        }
                        
                        for(int k=j+curr; k>=j;k--) // check all values before the point till j
                        {
                            if(matrix[i+curr][k] == '0') // if any zero
                                flag = false; // set falg to false
                        }
                        
                        if(flag) // flag true
                            curr++; // incraese curr as it will give size of square and update curr for  next square size check
                    }
                 max = Math.max(max, curr);   // find max 
               }
            }
        }
        
        return max*max; // return max square
    }
}


// Time Complexity : O(m*n)
// Space Complexity : O(m*n)
// Did this code successfully run on Leetcode : Yes
// Any problem you faced while coding this : None

class Solution {
    public int maximalSquare(char[][] matrix) {
        //edge case
        if(matrix == null || matrix.length == 0)
            return 0;
        int m = matrix.length;
        int n = matrix[0].length;
        int dp[][] = new int[m+1][n+1]; // extra row and column
        int max = Integer.MIN_VALUE;
        
        for(int i=1;i<=m;i++) // iterate over dp array
        {
            for(int j=1;j<=n;j++)
            {
                if(matrix[i-1][j-1] == '1') // if in the original array we have a 1
                {
                    //the value will be min of all three neighbours(square possible) + 1
                    dp[i][j] = Math.min(dp[i-1][j], Math.min(dp[i][j-1], dp[i-1][j-1]) ) + 1;
                    //update max
                    max = Math.max(max, dp[i][j]);
                }
                
            }
        }
        return max*max; // return max square
    }
}

// Time Complexity : O(nK)
// Space Complexity : O(n)
// Did this code successfully run on Leetcode : Yes
// Any problem you faced while coding this : None


class Solution {
    public int maxSumAfterPartitioning(int[] A, int K) {
        //edge case
        if(A == null || A.length == 0)
            return 0;
        int n = A.length;
        int dp[] = new int[n];
        
        for(int i=0;i<n;i++) // iterate over dp
        {
          int max = A[i]; // store the element as max
            for(int j = 1; i-j+1>=0 && j<=K; j++) // iterate till max split possible
            {
                max = Math.max(max, A[i-j+1]); // update the max with each incoming value
                if(i>=j) 
                {
                   dp[i] = Math.max(dp[i], dp[i-j] + max * j);  //find value by taking value k splits previous to i and adding k times the max value from the values in split
                }
                else
                    dp[i] = Math.max(dp[i], max * j); // else  k times the max value from the values in split
               
            }
        }
        
        return dp[dp.length-1]; // return last value
        
    }
}