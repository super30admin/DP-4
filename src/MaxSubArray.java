// Time Complexity :O(mn)
// Space Complexity :O(n)
// Did this code successfully run on Leetcode :Yes
// Any problem you faced while coding this : No

class Solution {
    public int maxSumAfterPartitioning(int[] A, int K) {
     int N= A.length;
     int[] gain = new int[N];
        for(int i=0;i<N;i++){
            int maxElement = 0;
            for(int j=1;j<=K;j++){
                if(i-j+1>=0){
                    maxElement = Math.max(maxElement,A[i-j+1]);
                    gain[i] = Math.max(gain[i],j*maxElement+(i-j>=0 ? gain[i-j]:0));
                }
            }
        }
        return gain[N-1];
    }
}