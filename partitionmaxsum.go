// Time Complexity : O(nk)
// Space Complexity : O(n)
// Did this code successfully run on Leetcode : yes
// Any problem you faced while coding this :

// Your code here along with comments explaining your approach
/*
create dp array of n size
loop over each element
set max to curr value
loop over k times if i - j + 1 >=0 (previous k elements exist)
set max to bigger of max, arr[i-j+1]
if i-j >=0 then dp[i]= max of dp[i], dp[i-j]+max*j
else dp[i]=max of dp[i], max*j

return dp[n-1]
*/
package main

import "fmt"

func maxSumAfterPartitioning(arr []int, k int) int {
	n := len(arr)
	dp := make([]int, n)
	for i:=0;i<n;i++ {
		max := arr[i]
		for j:=1;j<=k && i-j+1 >= 0;j++ {
			max = fmax1(max, arr[i-j+1])
			if i - j >= 0 {
				dp[i] = fmax1(dp[i], dp[i-j] + max*j)
			} else {
				dp[i] = fmax1(dp[i], max*j)
			}
		}
	}
	return dp[n-1]
}

func fmax1(a, b int) int {
	if a>b {
		return a
	}
	return b
}

func MainPartitionMaxSum() {
	fmt.Println(maxSumAfterPartitioning([]int{1,15,7,9,2,5,10}, 3)) //expected 84
}
