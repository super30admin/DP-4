/*Algorithm:
    - For each element we make combination of 1, 2, 3. Take the largest value and then add it with previous largest value.
    - At the end we will have the largest value at the last element of the dp array.
    
    Time Complexity: O(Kn)
    Space Complexity: O(n)
    
    Did the code run on leetcode? Yes
*/

class Solution {
    public int maxSumAfterPartitioning(int[] A, int K) {
        int row = A.length;
        if(row==0)
            return 0;
        int dp[] = new int[row];
        
        for(int i=0 ; i<row ; i++){
            int max=0;
            for(int j=1; j<=K && (i-j+1)>=0; j++){
                max = Math.max(max, A[i-j+1]);
                dp[i] = Math.max(dp[i], max*j +((i>=j)?dp[i-j]:0));
            }
        }
        
        return dp[row-1];
    }
}