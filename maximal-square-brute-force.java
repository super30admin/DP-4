//Time complexity: O(MN)^2
//Space complexity: O(1)
class Solution {
    public int maximalSquare(char[][] matrix) {
        if(matrix == null || matrix.length == 0) {
            return 0;
        }
        int max = 0;
        int m = matrix.length;
        int n = matrix[0].length;
        boolean flag;
        for(int i = 0; i < m; i++) {
            for(int j = 0; j < n; j++) {
                int curr = 1;
                if(matrix[i][j] == '1') {
                    flag = true;
                    //traverse thru i + curr < m and j + curr < n
                    while(i + curr < m && j + curr < n && flag) {
                        //for traversing thru the rows
                        for(int k = j; k <= j + curr; k++) {
                            if(matrix[i + curr][k] == '0') {
                                flag = false;
                                break;
                            }
                        }
                        //for traversing thru the cols
                        for(int k = i; k <= i + curr; k++) {
                            if(matrix[k][j + curr] == '0') {
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