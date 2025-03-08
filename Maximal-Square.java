## Problem1:(https://leetcode.com/problems/maximal-square/)

Given a 2D binary matrix filled with 0's and 1's, find the largest square containing only 1's ' and return its area.

Example:

Input: 


1 0 1 0 0

1 0 1 1 1

1 1 1 1 1

1 0 0 1 0

Output: 4

//Approach : Brute force
In this what we will do is we will iterate through an matrix and find one. If we find one then we will go diagonally by incrementing 
i+1 and j+1 and check if it is 1 if so then we will go above 1 element and check if it is 1 and then we will go left and check if it is 1
if so then we will repeat this process for i+2 and j+2 and so on. We are maintaining a max variable to keep track of how many diagonal elements are 
there in our square matrix and then at the end we are returning max*max as we have to return the area

Time Complexity : O(m*n)2
Space Complexity : O(1)

class Solution {
    public int maximalSquare(char[][] matrix) {
        //base Condition
        if(matrix==null || matrix[0].length==0){
            return 0;
        }
        int m=matrix.length;
        int n=matrix[0].length;
        int max=0;
        //iterating through a matrix
        for(int i=0;i<m;i++){
            for(int j=0;j<n;j++){
                if(matrix[i][j]=='1'){
                    int count=1;
                    boolean flag=true;
                    //loop to go through the elememnts diagonally while keeping in mind that they don't give out of bound error
                    while(i+count<m && j+count<n && flag==true){
                            for(int k=i+count;k>=i;k--){
                                if(matrix[k][j+count]!='1'){
                                    flag=false;
                                    break;
                                }
                            }
                            for(int k=j+count;k>=j;k--){
                                if(matrix[i+count][k]!='1'){
                                    flag=false;
                                    break;
                                }
                            }
                            //chaecking flag and incrementing count
                            if(flag==true){
                                count++;
                            }
                    }
                     max=Math.max(max,count);
                }     
            }
        }
        return max*max;
    }
}

Problem with the above approach was as we are iterating through a matrix and we are checking for every diagonal element and then further again when we 
go to that element again we are checking so it results in Time Limit Exceed error and there is a repeated sub-problem so we can go 
with Dynamic Problem Approach

In this we are maintaining an 2-d matrix of size m+1 and n+1 to keep our calculations similar for every row and 
column (first row we cant go above, left and diagonal) so we have kept it of size+1. at every point we will be checking left, above and 
diagonal element and we will get the minimum and add 1 to it if the value in matrix was 1. This will help us in giving the size of the square without recomputing

Time Complexity: O(m*n)
space Complexity:O(m*n)

class Solution {
    public int maximalSquare(char[][] matrix) {
        //base case
        if(matrix==null || matrix.length==0){
            return 0;
        }
        int m = matrix.length;
        int n =matrix[0].length;
        int max=0;
        int[][] dp=new int[m+1][n+1];
        //iterating through an array
        for(int i=0;i<m;i++){
            for(int j=0;j<n;j++){
                if(matrix[i][j]=='1'){
                    dp[i+1][j+1] = Math.min(dp[i][j+1],Math.min(dp[i+1][j],dp[i][j]))+1;
                    max=Math.max(dp[i+1][j+1],max);
                }
            }
        }
        return max*max;
    }
}

//In the above solution we are having m+1*n+1 dp matrix but if we see we are just seeing the above row, left column and diagonal.
So we can reduce it to one single row  and store diagonal elememt in temp variable


Time Complexity: O(m*n)
space Complexity:O(n)

class Solution {
    public int maximalSquare(char[][] matrix) {
        if(matrix==null || matrix.length==0){
            return 0;
        }
        int m = matrix.length;
        int n =matrix[0].length;
        int max=0;
        int[] dp=new int[n+1];
        for(int i=0;i<m;i++){
            int temp=dp[0];
            for(int j=1;j<n+1;j++){
                int prev=dp[j];
                if(matrix[i][j-1]=='1'){
                    dp[j] = Math.min(dp[j-1],Math.min(dp[j],temp))+1;
                    max=Math.max(dp[j],max);
                }
                else{
                    dp[j]=0;
                }
                temp=prev;
            }
        }
        return max*max;
    }
}