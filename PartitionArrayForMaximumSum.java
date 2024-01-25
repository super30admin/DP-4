
// TC : O(nk)
// SC : O(n)

package S30_Codes.DP_4;

class PartitionArrayForMaximumSum {
    public int maxSumAfterPartitioning(int[] arr, int k) {
        int n = arr.length;
        int[] cache = new int[n];

        for(int i=0; i<n; i++){
            int maxEle = 0;
            for(int j=1; j<=k && i+1-j>=0; j++){
                maxEle = Math.max(maxEle, arr[i+1-j]);
                if(i-j >= 0)
                    cache[i] = Math.max(cache[i], maxEle*j + cache[i-j]);
                else
                    cache[i] = Math.max(cache[i], maxEle*j);

            }
        }

        return cache[n-1];
    }
}