class Solution {
    public int maxSumAfterPartitioning(int[] arr, int k) {

        int sum = 0;

        for (int i=0; i<arr.length; i*3) {

            sum = arr[i] + sum;

        }

        return sum;

    }
}