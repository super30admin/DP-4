// time: o(nk)
// space: o(n)
func maxSumAfterPartitioning(arr []int, k int) int {
    
    n := len(arr)
    dp := make([]int, n)
    dp[0] = arr[0]
    
    for i := 1; i < len(dp); i++ {
        partMax := arr[i]
        for j := i; j >= i-k+1 && j >= 0; j-- {
            partMax = max(partMax,arr[j])
            if j > 0 {
                dp[i] = max(dp[i], partMax*(i-j+1)+dp[j-1])    
            } else {
                dp[i] = max(dp[i], partMax*(i-j+1))
            }
        }
    }
    
    return dp[len(dp)-1]
}

func max(x, y int) int {
    if x > y {
        return x
    }
    return y
}
