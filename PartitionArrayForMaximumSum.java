//Time: O(n*k)
//Space: O(n)

//dynamic programming solution
class Solution {
    public int maxSumAfterPartitioning(int[] arr, int k) {
        int n = arr.length;
        //creating a dp array where we will store the max sum possible from all the partitions at that point
        int [] dp = new int [n];
        //setting the max partition sum for first element as itself because that is the only partition its able to create
        dp[0] = arr[0];
        
        //iterating through each element in the array
        //starting at the second elem cuz the sum for the 
        for(int i = 1; i < n; i++) {
            //so far the max value will be the second elem itself
            int maxElem = arr[i];
            
            //iterating through each length of partition possible from 1 to k
            //here i-j+1 represents the index of the incoming element into our partiton and we make sure that our iteration do not go beyond 0th index, i.e. to index -1 or beyong
            for(int j = 1; j <= k && i-j+1 >= 0; j++) {
                
                //here again i-j+1 represents the index of the incoming element into our partiton
                //we compare it with the previous max element and update it
                maxElem = Math.max(maxElem, arr[i-j+1]);
                //initializing the current sum to 0
                int currSum = 0;
                
                //calculating the partiton sum by multipying the max element with the length of the partition
                int partitionSum = maxElem*j;
                
                //our core logic involves adding the maximum sum from a partition from a previous partiton to our current partition's sum
                //but we add he max sum from previous partiton only if we are not tryna attemp to add partitions goind out of bounds i.e. -1 index
                if(i-j >= 0) {
                    currSum = partitionSum + dp[i-j];
                } else {
                    currSum = partitionSum;
                }
                //updating the dp array at the i'th index with max values out of all the k partitons
                dp[i] = Math.max(currSum, dp[i]);
            }
        }
        //returning the last elem of dp array which will store the max sum
        return dp[n-1];
    }
}