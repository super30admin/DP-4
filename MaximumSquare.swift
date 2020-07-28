// Time Complexity : O(n*m)
// Space Complexity : O(n*m)
// Did this code successfully run on Leetcode : yes
// Any problem you faced while coding this : no


// Your code here along with comments explaining your approach
//find first top, left and diagonal value and add 1 to create a DP array



class Solution {
    func maximalSquare(_ matrix: [[Character]]) -> Int {
        if matrix.count == 0 {
            return 0
        }
        var dp = [[Int]](repeating: [Int](repeating: 0, count: matrix[0].count + 1) , count: matrix.count + 1)
        var maximum = 0
        for i in 1..<dp.count {
            for j in 1..<dp[0].count {
                if matrix[i-1][j-1] == "1" {
                    dp[i][j] = 1 + min(dp[i-1][j], min(dp[i][j-1], dp[i-1][j-1]))
                    maximum = max(maximum, dp[i][j])
                } 
            }
        }
        return maximum * maximum
    }
}