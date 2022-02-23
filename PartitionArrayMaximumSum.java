// Time Complexity : O(nk) where n is the size of the array
// Space Complexity : O(n) 
// Did this code successfully run on Leetcode : yes

class Solution {
    //time complexity : O((n-k)*k + k) ~= O(nk)
    public int maxSumAfterPartitioning(int[] arr, int k) {

        int[] dp = new int[arr.length];

        int count = 1;
        int c = arr.length - 1;
        int max = 0;

        //fill out the last k elements as those will always be max of those elements
        // times the number of elements covered between 1 - k, as for numbers less than k
        // the max can be the max number in that sub array repeated the length of subarray times
        while(count <= k){
            max = Math.max(arr[c],max);
            dp[c] = max * count;
            count++;
            c--;
        }


        //since we filled last k elements already, we start fillking dp from length - k
        // as last k elements of dp have already been filled in
        for(int i = dp.length - k - 1; i >= 0; i-- ){

            int temp = 1;
            // without considering it in partition and adding to next max
            int val = arr[i] + dp[i+ 1];
            int tempMax = arr[i];

            //trying all combinations starting from 1 element to k-1 together in the pair
            //till k-1 as we are including the element itself in all these partitions and if we take kth element as well for these sub partitions then the length might become k+1 for these.
            while(temp < k){
                //figuring out new max each time
                tempMax = Math.max(tempMax,arr[i+(temp++)]);
                //calculating new value by taking max to add * number of times and the next max
                int partMax = tempMax * temp + dp[i+temp];
                //compare if it is better than previous partition
                val = Math.max(val,partMax);
            }
            dp[i] = val;
        }

        return dp[0];

    }
}
