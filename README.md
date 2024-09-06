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

class Solution {
    public int min(int a, int b){
        return a<b?a:b;
    }
    public int maximalSquare(char[][] matrix) {
        if(matrix==null || matrix.length == 0)
            return 0;
        int i, j, n = matrix.length, m = matrix[0].length, result = 0;
        int[][] ans = new int[n][m];
        for(i=0; i<matrix.length; i++){
            ans[i][0]=matrix[i][0]-'0';
            result=Math.max(result, ans[i][0]);
        }
 
        for(j=0; j<matrix[0].length; j++){
            ans[0][j]=matrix[0][j]-'0';
            result=Math.max(result, ans[0][j]);
        }
        
        for(i=1;i<n;i++){
            for(j=1;j<m;j++){
                
                if(matrix[i][j]=='1'){
                    ans[i][j] = min(ans[i-1][j], min(ans[i][j-1], ans[i-1][j-1])) + 1;
                    if (result < ans[i][j])
                        result = ans[i][j];
                }
                else
                    ans[i][j] = 0;
            }
        }
        for(i=0;i<n;i++){
            for(j=0;j<m;j++){
                System.out.print(ans[i][j]);
            }
        }
        return result*result;
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

