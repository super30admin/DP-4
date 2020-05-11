//time complexity : O(n)
//space complexity : O(k)
//leet code : executed
//steps : implemented using DP.
class PartitionArrayforMaximumSum1043 {
    public int maxSumAfterPartitioning(int[] A, int K) {
        int[] f = new int[A.length + 1];
        f[0] = 0;
        for(int i = 1; i <= A.length; ++i) {
            int max = A[i - 1];
            for(int j = 1; j <= Math.min(i, K); ++j) {
                f[i] = Math.max(f[i], f[i - j] +  max * j);
                if (i - j - 1 >= 0) {
                    max = Math.max(max, A[i - j - 1]);
                }
            }
        }
        return f[A.length];
    }

    public static void main(String[] args) {
        
    }
}