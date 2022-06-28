TC - O(n*2k)
SC - O(n)

var maxSumAfterPartitioning = function(A, K) {
    const n = A.length;
    const dp = new Array(n + 1).fill(0);
    dp[0] = 0;
    dp[1] = A[0];
    
    for (let i = 2; i <= n; i++) {
        let maxVal = A[i - 1];
        dp[i] = maxVal + dp[i - 1];
        
        for (let j = i - 1; j > 0 && i - j + 1 <= K; j--) {
            maxVal = Math.max(A[j - 1], maxVal);
            
            const len = i - j + 1;
            
            dp[i] = Math.max((len * maxVal) + dp[j - 1], dp[i]);
        }
    }

    return dp[n];
};