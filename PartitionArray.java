// Time complexity - O(n *k)
// Space complexity - O(n)
//Solved on leetcode - yes
// faced any isues - no
// using memorization to store the values of previous max
class Solution {
    public int maxSumAfterPartitioning(int[] arr, int k) {
        int p[] = new int[arr.length+1];
        int n = arr.length;
        for(int i=0;i<n;i++) {
            int max = 0, l=1, j=i,maxSum = 0;
            while(l<=k && j>=0) {
                max = Math.max(max, arr[j]);
                maxSum = Math.max(maxSum, max*l + p[i-l+1]);
                j--;
                l++;
            }
            p[i+1] = maxSum;
        }
        return p[n];
    }
}
