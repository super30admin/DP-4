// https://leetcode.com/problems/partition-array-for-maximum-sum/

// Time Complexity: O(N * k)
// Space Complexity: O(N + k)

class Solution {
    private int maxSum;
    private List<List<Integer>> maxPartition;

    public int maxSumAfterPartitioning(int[] arr, int k) {
        maxSum = 0;
        maxPartition = new ArrayList<>();
        List<Integer> partition = new ArrayList<>();
        helper(arr, 0, k, partition, 0);
        return maxSum;
    }

    private void helper(int[] arr, int idx, int k, List<Integer> partition, int currentSum) {
        if (idx == arr.length) {
            if (currentSum > maxSum) {
                maxSum = currentSum;
                maxPartition.clear();
                maxPartition.add(new ArrayList<>(partition));
            }
            return;
        }

        int length = 0, maxi = Integer.MIN_VALUE;
        for (int i = idx; i < Math.min(idx + k, arr.length); i++) {
            length++;
            maxi = Math.max(maxi, arr[i]);
            partition.add(maxi * length);
            helper(arr, i + 1, k, partition, currentSum + (maxi * length));
            partition.remove(partition.size() - 1);
        }
    }

    public int getMaxSum() {
        return maxSum;
    }

    public List<List<Integer>> getMaxPartition() {
        return maxPartition;
    }
}
