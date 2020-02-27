//Brute Force
//TC - (mn)^2
//SC - O(1)

class Solution {
    int mxrow = 0;
    public int maximalSquare(char[][] matrix) {
        int m = matrix.length;
        if(matrix == null || m == 0) return 0;
        
        int n = matrix[0].length;
        
        for(int i = 0; i < m; ++i)
        {
            for(int j = 0; j < n; ++j)
            {
                if(matrix[i][j] == '1')
                {
                    helper(matrix, m, n, i, j);
                }
            }
        }
        
        return mxrow*mxrow;
    }
    
    private void helper(char[][] matrix, int m, int n, int i, int j)
    {
        int curr = 1;
        boolean flag = true;
        
        while(i + curr < m && j + curr < n && flag != false)
        {
            for(int k = i + curr; k >= i; --k)
            {
                if(matrix[k][j + curr] == '0')
                {
                    flag = false;
                    break;
                }
            }
            
            for(int l = j + curr; l >= j; --l)
            {
                if(matrix[i + curr][l] == '0')
                {
                    flag = false;
                    break;
                }
            }
            
            if(flag)
            {
                ++curr;
            }
        }
        
        mxrow = Math.max(mxrow, curr);
    }
}
