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


/*
time complexity: O(m*n)
space complexity: O(m*n)
// Did this code successfully run on Leetcode : Yes
// Any problem you faced while coding this :  No

 Code -

class Solution {
public:
    int maximalSquare(vector<vector<char>>& matrix) {
        int dp[matrix.size()][matrix[0].size()];
int size=INT_MIN;
 for(int i=0;i<matrix.size();i++){

           for(int j=0;j<matrix[0].size();j++){
dp[i][j]=0;

           }
 }
        for(int i=0;i<matrix.size();i++){
            if(matrix[i][0]=='1'){
dp[i][0]=1;
            }
            else{
     dp[i][0]=0;           
            }
          
            size=max(size,dp[i][0]);
        }

         for(int j=0;j<matrix[0].size();j++){
                   if(matrix[0][j]=='1'){
dp[0][j]=1;
            }
            else{
     dp[0][j]=0;           
            }
          
               size=max(size,dp[0][j]);
        }

        for(int i=1;i<matrix.size();i++){
              for(int j=1;j<matrix[0].size();j++){
if(matrix[i][j]=='1'){
    int minimum=min(dp[i-1][j-1],dp[i][j-1]);
   dp[i][j]=1+min(minimum,dp[i-1][j]);
}
else{
    dp[i][j]=0;
}
size=max(size,dp[i][j]);
              }
        }
        return pow(size,2);
    }
};
*/
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

/*
time complexity: O(n*k)
space complexity: O(n)
// Did this code successfully run on Leetcode : Yes
// Any problem you faced while coding this :  No
Code - 

class Solution {
public:
    int maxSumAfterPartitioning(vector<int>& arr, int k) {
        int dp[arr.size()];
        dp[0]=arr[0];
        for(int i=1;i<arr.size();i++){
            int maximum=INT_MIN;
int max_val=-1;
for(int j=i;j>i-k;j--){
    if(j<0){
        break;
    }
 max_val=max(max_val,arr[j]);
 if(j>0){
    maximum=max(maximum,dp[j-1]+(i-j+1)*max_val);
 }
 else{
     maximum=max(maximum,(i-j+1)*max_val);
 }
}

dp[i]=maximum;
        }
        return dp[arr.size()-1];
    }
};
*/