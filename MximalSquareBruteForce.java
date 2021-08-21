// TC: O(m x n x m x n )
// SC: O(1)

class Solution {
    public int maximalSquare(char[][] mat) {
        if(mat == null || mat.length == 0) {
            return 0;
        }
        int m, n, max;
        m = mat.length;
        n = mat[0].length;
        max = 0;
        for(int i = 0; i < m; i++) {
            for(int j = 0; j < n; j++) {
                boolean flag = false;
                if(mat[i][j] == '1') {
                    int curr = 1;
                    flag = true;
                    while(i + curr < m && j + curr < n && flag) {
                        // col up
                        for(int k = i + curr; k >= i; k--) {
                            if(mat[k][j + curr] == '0') {
                                flag = false;
                                break;
                            }
                        }
                        // row left
                        for(int k = j + curr; k >= j; k--) {
                            if(mat[i + curr][k] == '0') {
                                flag = false;
                                break;
                            }
                        }
                        if(flag) {
                            curr++;
                        }

                    }
                    max = Math.max(max, curr);

                }
            }
        }
        return max * max;
    }
}