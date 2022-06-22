//Time: O(MN) ^ 2 || Space: O(1)

//Brute Force
class Solution {
    public int maximalSquare(char[][] matrix) {
        int m = matrix.length;
        int n = matrix[0].length;
        int max = 0;
        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                // at every 1, we find in the matrix,
                // we keep going in the diagonal direction, finding 1,
                // if we find 1 in that path, we should exploring that mini matrix's cols and rows,
                // only if they are 1s we increase the boundary and perform same check,
                // it's O(MN)
                if (matrix[i][j] == '1') {
                    int level = 1;
                    boolean flag = true;
                    while (i + level < m && j + level < n && flag) {
                        for (int r = i + level; r >= i; r--) {
                            if (matrix[r][j + level] == '0') {
                                flag = false;
                                break;
                            }
                        }
                        for (int c = j + level; c >= j; c--) {
                            if (matrix[i + level][c] == '0') {
                                flag = false;
                                break;
                            }
                        }
                        if (flag) level++;
                    }
                    max = Math.max(max, level);
                }
            }
        }
        return max * max;
    }
}

// Time efficient soln - dp soln
// Space has been tradedoff for Time
// Time: O(MN) | Space: O(MN)
class Solution {
    public int maximalSquare(char[][] matrix) {
        int m = matrix.length;
        int n = matrix[0].length;
        int max = 0;
        int[][] numberMat = new int[m+1][n+1];
        for(int i=1;i<numberMat.length;i++){
            for(int j=1;j<numberMat[0].length;j++){
                if(matrix[i-1][j-1] == '1') {
                    numberMat[i][j] = 1+(Math.min(numberMat[i-1][j], Math.min(numberMat[i][j-1], numberMat[i-1][j-1])));
                }
                max = Math.max(max, numberMat[i][j]);
            }
        }
        return max*max;
    }
}

// Time and space efficent solution | Time: O(MN) | Space: O(N)
class Solution {
    public int maximalSquare(char[][] matrix) {
        int m = matrix.length;
        int n = matrix[0].length;
        int max = 0;
        int[] numberMat = new int[n+1];
        for(int i=1;i<=m;i++){
            // using 1D array, we are handling only diagonal up element copy before we mututate it
            int diagonalUp = 0;
            for(int j=1;j<=n;j++){
                int temp = numberMat[j];
                if(matrix[i-1][j-1] == '1') {
                    numberMat[j] = 1+(Math.min(numberMat[j], Math.min(numberMat[j-1], diagonalUp)));
                    max = Math.max(max, numberMat[j]);
                } else numberMat[j] = 0;
                diagonalUp = temp;
            }
        }
        return max*max;
    }
}