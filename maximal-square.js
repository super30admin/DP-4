// Time Complexity : O(M*N)
// Space Complexity : O(1)
// Did this code successfully run on Leetcode : Yes
// Any problem you faced while coding this : DP IS HARD

/**
 * @param {character[][]} matrix
 * @return {number}
 */
var maximalSquare = function(matrix) {
    if (!matrix || !matrix.length || !matrix[0].length) return 0;
    
    let max = 0;
    for (let i = 0; i < matrix.length; i++) {
        for (let j = 0; j < matrix[i].length; j++) {
            if (matrix[i][j] == '0') continue;
            else if (i == 0 || j == 0) max = Math.max(max, 1);
            else {
                matrix[i][j] = Math.min(parseInt(matrix[i - 1][j]),
                                        parseInt(matrix[i - 1][j - 1]),
                                        parseInt(matrix[i][j - 1])) + 1;
                if (matrix[i][j] > max) max = matrix[i][j];
            }
        }
    }
    
    return max**2;
};
