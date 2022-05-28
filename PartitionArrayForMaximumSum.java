class Solution {

    //Time Complexity: 0(n*k) where n is the elements in the array and k is the no of partition
    //Space Complexity: 0(n)
    //Did it successfully run on leetcode: Yes
    //DId you face any problem while coding: No

    //In short explain your code

    public int maxSumAfterPartitioning(int[] arr, int k) {
        if(arr.length == 0 || arr == null){
            return 1;
        }
        int n = arr.length;
        int [] dp = new int [n];    //taking a 1-d array to store the max at each index inbetween 3 options. Option 1, takin 1 partition, 2-taking 2 partition, 3-taking 3 patition
        dp[0] = arr[0]; //initially, the 1st index cannot be partioned into more than 1 array
        for(int i = 1; i < n; i++){
            int max = arr[i];   //declaring max
            for(int j = 1; j <= k && i-j + 1 >= 0; j++){ //running another loop to create different partitions and also checking if the incoming element is in the bounds of the array
                max = Math.max(max, arr[i-j+1]);    //taking the max with partitioning only that element and the max of previous partitions
                if(i-j >= 0){   //checking the maximum with previous element
                    dp[i] = Math.max(dp[i], max * j + dp[i-j]);
                }
                else{
                    dp[i] = Math.max(dp[i], max * j);   //else checking max by considering the max partitions
                }
            }
        }
        return dp[n-1]; //returning the last element in the dp which will hold the result
    }
}