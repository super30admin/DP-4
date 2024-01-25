
// TC : O(mn)
// SC : O(n)

package S30_Codes.DP_4;

class MaximalSquare {
    public int maximalSquare(char[][] matrix) {
        int m = matrix.length;
        int n = matrix[0].length;
        int max = 0;
        int[] cache = new int[n+1];

        for(int i=1; i<=m; i++){
            int diagUp = 0; //cache[0]
            for(int j=1; j<=n; j++){
                int temp = cache[j];
                if(matrix[i-1][j-1] == '1'){
                    cache[j] = 1 + Math.min( diagUp, Math.min(cache[j], cache[j-1]) );
                    max = Math.max(max, cache[j]);
                }
                else{
                    cache[j] = 0;
                }
                diagUp = temp;
            }
        }
        return max*max;
    }
}