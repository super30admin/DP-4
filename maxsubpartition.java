//Time Complexity:O(NK) where N is the size of the given array.
//SPace Complexity:O(N)
//Approach: find all the elements up to k from i, find the max value until then and update it. repeat it for all the elements in the array and for all the values upto k.
//This code was executed successfully and got accepted in leetcode. 
class Solution {
    public int maxSumAfterPartitioning(int[] A, int K) {
        int n=A.length;
        int []dp=new int[n];
        for(int i=0;i<n;i++){
            int max=0;
            for(int j=1;(j<=K) && (i-j+1>=0);j++){
                max=Math.max(max,A[i-j+1]);
                dp[i]=Math.max(dp[i],((i>=j)?dp[i-j]:0)+max*j);
            }
        }
        return dp[n-1];
    }
}