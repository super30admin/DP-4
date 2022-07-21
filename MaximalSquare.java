// Time Complexity : O(m*n) Time to traverse the entire matrix(size of matrix)
// Space Complexity : O(1) No extra space because we're using the same matrix to store info.
// Did this code successfully run on Leetcode : Yes
// Any problem you faced while coding this : None

class MaximalSquare {
    public int maximalSquare(char[][] matrix) {
        if(matrix == null || matrix.length==0) return 0;
        int max = 0;
        int m = matrix.length;
        int n = matrix[0].length;
        //int[][] dp = new int
        for(int j=0;j<n;j++){
            if(matrix[0][j]=='1'){
                max = 1;
            }
        }
        for(int j=0;j<m;j++){
            if(matrix[j][0]=='1'){
                max = 1;
            }
        }
        for(int i=1;i<m;i++){
            for(int j=1;j<n;j++){
                if(matrix[i][j]=='1'){
                    int top = matrix[i-1][j] - '0';
                    int topleft = matrix[i-1][j-1] - '0';
                    int left = matrix[i][j-1] - '0';
                    int temp = 1+Math.min(top, Math.min(topleft, left));
                    max = Math.max(max, temp);
                    matrix[i][j] = (char)(temp+'0');

                }
            }
        }
        return max*max;
    }

    public static void main(String [] args){
        MaximalSquare ms = new MaximalSquare();
        char[][] matrix = new char[][]{{'1','0','1','0','0'},{'1','0','1','1','1'},{'1','1','1','1','1'},{'1','0','0','1','0'}};
        System.out.println(ms.maximalSquare(matrix));
    }
}