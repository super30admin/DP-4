class Solution {
//Time Complexity:O(n.m)
//Space Complexity:O(n)
public int maximalSquare(char[][] matrix) {
    if (matrix == null){
    return 0;
    } 
    int n = matrix.length;
    int m = matrix[0].length;

    int[] dp = new int [m+1];
    int max = 0;
    for (int i =0; i <n;i++){
        int temp = dp [0];
    for (int j =1; j <m+1;j++){
        int prev = dp[j];
        if (matrix[i][j-1] == '1'){
            dp [j] = Math.min (dp[j-1],Math.min(dp[j],temp))+1;
            max = Math.max (max, dp[j]);
        } else {

        dp [j] = 0;
        }
        temp = prev;
        }
    }
    return max * max;
}
}
