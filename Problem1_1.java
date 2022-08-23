//Time Complexity: O(m+n)^2; where m is the no. of rows & n is the no. of columns.
//Space Complexity: O(1)
//Code run successfully on LeetCode.

public class Problem1_1 {

    public int maximalSquare(char[][] matrix) {
        
        if(matrix == null || matrix.length == 0)
            return -1;
        
        int m = matrix.length;
        int n = matrix[0].length;
        int max =0;
        
        for(int i =0; i<m; i++)
        {
            for(int j =0; j <n; j++)
            {
                if(matrix[i][j] == '1')
                {
                    boolean flag = true;
                    
                    int curr = 1;
                    
                    while(i + curr <m && j + curr <n && flag)
                    {
                        for(int k = i+curr; k >=i; k--)
                        {
                            if(matrix[k][j + curr] == '0')
                            {
                                flag = false;
                                break;
                            }
                        }
                        
                        for(int k = j+ curr; k>=j; k--)
                        {
                            if(matrix[i+curr][k] == '0')
                            {
                                flag = false;
                                break;
                            }
                        }
                        
                        if(flag)
                        {
                            curr++;
                        }
                    }
                    
                    max = Math.max(max,curr);
                }
            }
        }
        return max*max;
    }
}
