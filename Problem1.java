/*
Maximal Square
approach: we can do it iteratively with intuition that for a 2x2 matrix all columns and rows should have 1's,
doing this will result in checking some rows and cols again which can be optimized using dynamic programming.
time: exhaustive: O(mn)^2 dp: O(mxn)
space: exhaustive: O(mxn) dp: O(1)
 */
public class Problem1 {
    public int maximalSquare(char[][] matrix) {
        int m = matrix.length;
        int n = matrix[0].length;
        int max = 0;
        for(int i=0;i<m;i++) {
            System.out.println("row val "+matrix[i][0]);
            if(matrix[i][0]=='1'){
                max = 1; break;
            }
        }
        for(int i=0;i<n;i++) {
            System.out.println("col val "+matrix[0][i]);
            if(matrix[0][i]=='1'){
                max = 1; break;
            }
        }
        for(int i=1;i<m;i++) {
            for(int j=1;j<n;j++) {
                if(matrix[i][j]!='1') continue;
                int topleft = matrix[i-1][j-1]-'0';
                int top = matrix[i-1][j]-'0';
                int left = matrix[i][j-1]-'0';
                char val = (char)((Math.min(Math.min(topleft, left), top)+1)+'0');
                matrix[i][j] = val;
                max = Math.max(max, (int)val-'0');
            }
        }

        return max*max;
    }
}
