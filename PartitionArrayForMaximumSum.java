//Time complexity : O(n * n) where n is the length of the string
//Space complexity : O(n) where n is the length of the given array.

public class PartitionArrayForMaximumSum {
    public int maxSumAfterPartitioning(int[] arr, int k) {
        int[] d = new int[arr.length];

        for (int i = 0; i < arr.length; i++) {
            int partitionMax = 0;
            for (int j = 1; j <= k && (j - 1) <= i; j++) {
                partitionMax = Math.max(partitionMax, arr[i - (j - 1)]);
                d[i] = Math.max(d[i], (i >= j ? d[i - j] : 0) + j * partitionMax);
            }
        }

        return d[arr.length - 1];
    }   
}
