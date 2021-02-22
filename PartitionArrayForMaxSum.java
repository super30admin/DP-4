// Time Complexity : O(kn 2) (kn square)
// Space Complexity : O(n) DP array will take additional space.
// Did this code successfully run on Leetcode : Yes
// Any problem you faced while coding this : No


//Your code here along with comments explaining your approach
//We have k choices of split at each element in the array. 
//Calculate the total for each choice, and store the max of all choices in the DP array


class Solution {
    public int maxSumAfterPartitioning(int[] arr, int k) {
        if(arr == null || arr.length == 0) return 0;


        int[] dpArray = new int[arr.length];

        dpArray[0] = arr[0];

        for(int i = 1; i < dpArray.length; i++){

            int maxNum = arr[i];
            int maxVal = arr[i];
            int count = 1;

            for(int j = 1; i-j >= -1 && j <= k; j++) {
                maxNum = Math.max(arr[i-j+1], maxNum);
                int val = 0;
                if(i-j >= 0 )
                    val += dpArray[i-j];
                val += maxNum * j;
                maxVal = Math.max(maxVal, val);
            }
            dpArray[i] = maxVal;



        }
        return dpArray[dpArray.length-1];
    }
}
