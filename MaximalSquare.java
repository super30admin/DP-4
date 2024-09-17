class MaximalSquare {
    //BruteForce:
    //SOLUTION 1:
    //Everytime we find a 1 check its right side, bottom and diagonal
    //check the same condition for all 1's in the uniform square.
    //exponential solution, 3 checks, 9 checks,...so on
    //even if we maintain visited array there would be 2 checks instead of 3, but still exponential

    //SOLUTION 2:
    //1. moment we find 1, drop to it's diagonal and check if it's 1 or not
    //2. if one check corresponding column and row to see if everything is 1.
    //3. if everything is 1 drop to diagonal....
    //4. we maintain a global variable 'side', everytime we drop to a diagonal we increment side
    //Time Complexity: O(mn)^2
    //If the whole matrix is of 1's
    //Going through each 1 would be mn
    //then when dropping to each diagonal element, checking column and row would be mn.
    public int maximalSquare(char[][] matrix) {
        if (matrix == null || matrix.length == 0)
            return 0;
        int m = matrix.length;
        int n = matrix[0].length;
        // records we have hit a square
        boolean flag = false;
        int max = Integer.MIN_VALUE;
        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {

                if (matrix[i][j] == '1') {
                    flag = true;
                    // Side
                    int k = 1;

                    // till the time we are inbounds and square is still there
                    while (i + k < m && j + k < n && flag) {
                        // when we are dropping to a diagonal element

                        // we check all columns are 1's
                        for (int row = i + k; row >= i; row--) {
                            if (matrix[row][j + k] == '0') {
                                flag = false;
                                break;
                            }

                        }
                        for (int col = j + k; col >= j; col--) {
                            if (matrix[i + k][col] == '0') {
                                flag = false;
                                break;
                            }

                        }
                        if (flag) {
                            k++;
                        }
                    }

                    max = Math.max(k, max);
                }

            }
        }

        return max * max;

    }


    //DP Solution
    //Bottom up DP: We start from smaller subproblem to solve larger problem
    //Brute force we always looks for top down
    //start with base condition row and column as 0's (side = 0)
    //check at each element what is the maximum square that can be formed up,left and diagonal
    //total square that can be formed at that position is minimum of up , left and diagonal
      //Time Complexity: O(mn)
    //Space: O(mn)

    public int maximalSquare2(char[][] matrix) {
        if (matrix == null || matrix.length == 0)
            return 0;
        int m = matrix.length;
        int n = matrix[0].length;
        //top row 0,0,...
        //first col 0,0...
        int[][] dp = new int[m+1][n+1];
        int max = Integer.MIN_VALUE;
        for (int i = 1; i <= m; i++) {
            for (int j = 1; j <= n; j++) {
                if(matrix[i-1][j-1]=='1')
                {
                    dp[i][j] = Math.min(dp[i-1][j],Math.min(dp[i][j-1],dp[i-1][j-1]));
                    max = Math.max(max,dp[i][j]);
                }
            }
        }

        return max*max;
    }

      //Time Complexity: O(mn)
    //Space: O(1)
    public int maximalSquare3(char[][] matrix) {
        if (matrix == null || matrix.length == 0)
            return 0;
        int m = matrix.length;
        int n = matrix[0].length;
        int max = Integer.MIN_VALUE;
        for(int i=0;i<m;i++)
        {
            if(matrix[i][0]=='1')max=1;
        }
        for(int j=0;j<n;j++)
        {
            if(matrix[0][j]=='1')max=1;
        }
       
        for (int i = 1; i < m; i++) {
            for (int j = 1; j < n; j++) {
                if(matrix[i][j]=='1')
                {
                    int up = matrix[i-1][j] - '0';
                    int left = matrix[i][j-1] - '0';
                    int diagonalUp = matrix[i-1][j-1] - '0';
                    int curr = 1 + Math.min(up, Math.min(left,diagonalUp));
                    max = Math.max(max,curr);
                    matrix[i][j] = (char) (curr+'0');
                }
            }
        }

        return max*max;
    }

}