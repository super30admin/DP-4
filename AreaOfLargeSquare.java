//TC:O(m*n)
//SC: O(n)
class Solution {
    public int maximalSquare(char[][] matrix) {
        if(matrix.length==0 || matrix[0].length==0)
            return 0;
        int m = matrix.length+1;
        int n = matrix[0].length+1;
        int[] dp = new int[n];
        int max = Integer.MIN_VALUE;    //Taken intial row and column with all 0s
        for(int i=1;i<m;i++)            //Checking prvious top, left and top-left elements and getting the minimum value of these elements
        {                                  //If the present element is 1 adding 1 to previous check else place 0
            int[] temp = new int[n];        //Monitor the maximum element, returning the square of the element
            for(int j=1;j<n;j++)
            {
                if(matrix[i-1][j-1]=='1')
                {
                    temp[j] = Math.min(dp[j-1],Math.min(dp[j],temp[j-1]))+1;
                    if(temp[j]>max)
                        max = temp[j];
                }
            }
            dp = temp;
        }
        return max*max;
    }
}