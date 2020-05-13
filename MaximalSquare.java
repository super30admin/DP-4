// 221.
class Solution {
    public int maximalSquare(char[][] matrix) {
        //edge
        if(matrix == null || matrix.length == 0 || matrix[0].length == 0)
        {
            return 0;
        }
        return maxSquare(matrix);
    }
    
    //time - O(n^2 * m^2)
    //space - constant
    private int bruteForce(char[][] matrix) {
        int m = matrix.length; 
        int n = matrix[0].length;
        boolean flag = false;
        int maxSide = 0;
        for(int i = 0; i < m; i++)
        {
            for(int j = 0; j < n; j++)
            {
                if(matrix[i][j] == '1')
                {
                    flag = true; //found a valid square of side 1 at i,j
                    int current = 1; //side of current square is 1 and its at i,j cell
                    //start exploring from i,j
                    while(i + current < m && j + current < n && flag)
                    {
                        //as long as the next layer is within bounds and a valid square is seen continue exploring
                        //check for 1s in all rows from i to i + current and column is j + current
                        for(int k = i; k <= i + current; k++)
                        {
                            if(matrix[k][j + current] == '0')
                            {
                                flag = false; //square becomes invalid so set flag as false and break
                                break;
                            }
                        }
                        
                        //check for all 1s in all columns from j to j + current and row is i + current
                        for(int k = j; k <= j + current; k++)
                        {
                            if(matrix[i + current][k] == '0')
                            {
                                flag = false; //square becomes invalid so set flag as false and break
                                break;
                            }
                        }
                        
                        if(flag) //square remains valid
                        {
                            current++; //increase sidelength and check again
                        }
                    }
                    
                    maxSide = Math.max(maxSide, current); //update side length for square at this location i,j
                }
            }
        }
        return maxSide * maxSide; //area
    }
    
    //time - O(n*m)
    //space - O(n*m)
    private int maxSquare(char[][] matrix) {
        int m = matrix.length; 
        int n = matrix[0].length;
        int[][] result = new int[m][n];
        int maxSide = 0;
        //base
        //for all cells in 1st row and 1st col, result square is 1 if value in cell is 1
        for(int i = 0; i < n; i++)
        {
            if(matrix[0][i] == '1')
            {
                result[0][i] = 1;
                maxSide = 1; //updating as 1 valid square of side 1 is found
            }
        }
        for(int i = 0; i < m; i++)
        {
            if(matrix[i][0] == '1')
            {
                result[i][0] = 1;
                maxSide = 1; //updating as 1 valid square of side 1 is found
            }
        }
        
        for(int i = 1; i < m; i++)
        {
            for(int j = 1; j < n; j++)
            {
                if(matrix[i][j] == '1')
                {
                    //the possiblity of extending this cell is based on its minimum of 3 neighbours
                    result[i][j] = 1 + Math.min(result[i - 1][j - 1], Math.min(result[i - 1][j], result[i][j - 1]));
                    maxSide = Math.max(maxSide, result[i][j]); //update max side so far
                }
            }
        }
        return maxSide * maxSide; //return area
    }
}
