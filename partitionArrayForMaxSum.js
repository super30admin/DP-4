/**
 * @param {number[]} A
 * @param {number} K
 * @return {number}
 */
var maxSumAfterPartitioning = function(A, K) {
    if(A == null || A.length == 0) return 0;
    
    let dp = new Array(A.length).fill(0);
    let max;
    
    for(let i = 0; i< A.length; i++){
        max =A[i];
        for(let j = 1; i-j+1>= 0 && j<=K; j++){
            max = Math.max(max,A[i-j+1]);
            if(i-j>=0){
                dp[i] = Math.max(dp[i] ,dp[i-j]+max*j);
            } else{
                dp[i] = Math.max(dp[i] ,max*j);

            }
        }
    }
    return dp.pop();
    
};