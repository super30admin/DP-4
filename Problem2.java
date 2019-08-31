// Time Complexity :O(n) 
// Space Complexity :O(n+1) 
// Did this code successfully run on Leetcode : Yes
// Any problem you faced while coding this : No
//
// Your code here along with comments explaining your approach
// 1. Have an array of size n+1.If we do a partition before first element then sum will be 0.So dp[0] = 0.If we do a partition after 
// 1st element then sum will be 1st element + sum of previous ,so dp[1] will be A[0].
// 2.Similarly for each element we do a partition from element to the left  each time incrementing size of partition by 1 K times. 
// Each time we check maximum in current partition and update curmax . Next we add partition size times curmax element and maximum sum
// we get from previous partition .We do this for all possible partition sizes for each element and update maximum sum possible in dp array.
// 3.The last element in dp array will have maximum sum possible.
public class maxSumAfterPartitioning {
    public static int maxSumAfterPartitioning(int[] A, int K) {
        int[] dp = new int[A.length+1];
        dp[1] = A[0];
        for(int i = 1;i<A.length;i++){
            int curmax = A[i];
            for(int j = 1;j<=K;j++){
                int k = i-j+1;
                if(k< 0)    break;
                curmax = Math.max(A[k],curmax);
                dp[i+1] = Math.max(dp[i+1],j*curmax+dp[k]);
            }
        }

        return dp[A.length];
    }

    public static void main(String[] args) {
        int[] arr = {1,15,7,9,2,5,10};
        System.out.println(maxSumAfterPartitioning(arr,3));
    }
}
