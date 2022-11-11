// ## Problem1:(https://leetcode.com/problems/maximal-square/)

// 2d array
// Time Complexity : O(mn)
// Space Complexity : O(mn)

// 1d array
// Time Complexity : O(mn)
// Space Complexity : O(m)

// Did this code successfully run on Leetcode : Yes
// Any problem you faced while coding this : No


// Your code here along with comments explaining your approach
/**
 * @param {character[][]} matrix
 * @return {number}
 */
var maximalSquare = function (matrix) {
    if (matrix === null || matrix.length === 0)
        return 0;

    // // 2d DP
    // let rows = matrix.length;
    // let cols = matrix[0].length;
    // let dp = new Array(rows+1);
    // // Set the 1st row and column of dp same as matrix, others are 0
    // for(let i=0; i<dp.length; i++){
    //     dp[i] = new Array(cols+1);
    //     dp[i].fill(0);
    // }

    // // Strat from row 1 and col 1, value will be (min of top and left)+1, last cell will have the result
    // let max = 0;
    // for(let i=1; i<dp.length; i++){
    //     for(let j=1; j<dp[0].length; j++){
    //         if(matrix[i-1][j-1] === '1'){
    //             let min = dp[i-1][j-1];
    //             min = Math.min(min, dp[i-1][j])
    //             min = Math.min(min, dp[i][j-1])
    //             dp[i][j] = min+1;
    //             max = Math.max(max, dp[i][j]);
    //         }
    //     }   
    // }

    // 1d DP
    let rows = matrix.length;
    let cols = matrix[0].length;
    let dp = new Array(cols + 1);

    dp.fill(0);

    let max = 0;
    let diagonalUp = 0;
    for (let i = 1; i <= rows; i++) {
        for (let j = 1; j <= cols; j++) {
            // Before updating the cell value, we store the value as it will be required later
            let temp = dp[j];
            if (matrix[i - 1][j - 1] === '1') {
                let min = Math.min(dp[j - 1], diagonalUp)
                min = Math.min(min, dp[j])
                dp[j] = min + 1;
                max = Math.max(max, dp[j]);
            } else {
                dp[j] = 0;
            }
            diagonalUp = temp;
        }
    }
    return max * max;
};