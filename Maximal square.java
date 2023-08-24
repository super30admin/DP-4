// Time Complexity : O(mxn)
// Space Complexity : O(n)
// Did this code successfully run on Leetcode : Yes
// Any problem you faced while coding this : No
// Your code here along with comments explaining your approach
// Dynamic Programming: We have repeated subproblems in the exhaustive approach. In a bigger square of length 
// eg: 4 we will have multiple small square for which we would have already calculated the length, so we don't need to calculate it everytime. 
// Starting from the first element , we need to check what is the length of the square that was formed in the diagonally upward, column upward and left row elements. 
// Then find the minimum amongst them and add 1 to it and update the length to the current element in the matrix. this way, the maximum length found amongst all the elements is the length of the square.
//Using 1D matrix
 

class Solution 
{
    public int maximalSquare(char[][] matrix) 
    {
        if(matrix==null || matrix.length==0) return 0;
        int m=matrix.length;    //row
        int n=matrix[0].length; //column
        int max=0;        //max length of the square
        int []dp= new int [n+1]; //the first row of the do would be 0s 

        for (int i=1;i<=m;i++)   //row
        {
            int diagUp=0;
            for(int j=1;j<=n;j++)    //column
            {
                int temp=dp[j];
                if (matrix[i-1][j-1]=='1')
                {
                    dp[j]=Math.min(dp[j-1],Math.min(dp[j],diagUp))+1;
                    max=Math.max(max,dp[j]);
                }
                else dp[j]=0;
                 diagUp=temp;   
            }
        }
        return max*max;
    }
}


// Dynamic Programming: We have repeated subproblems in the exhaustive approach. In a bigger square of length eg: 4 we will have multiple small square for which we would have already calculated the length, so we don't need to calculate it everytime. Starting from the first element , we need to check what is the length of the square that was formed in the diagonally upward, column upward and left row elements. Then find the minimum amongst them and add 1 to it and update the length to the current element in the matrix. this way, the maximum length found amongst all the elements is the length of the square.
//Using 2D matrix
 

class Solution 
{
    public int maximalSquare(char[][] matrix) 
    {
        if(matrix==null || matrix.length==0) return 0;
        int m=matrix.length;    //row
        int n=matrix[0].length; //column
        int max=0;        //max length of the square
        int [][]dp= new int [m+1][n+1]; //the first row of the do would be 0s 

        for (int i=1;i<=m;i++)   //row
        {
            for(int j=1;j<=n;j++)    //column
            {
                if (matrix[i-1][j-1]=='1')
                {
                    dp[i][j]=Math.min(dp[i-1][j-1],Math.min(dp[i][j-1],dp[i-1][j]))+1;
                    max=Math.max(max,dp[i][j]);
                }
                
            }
        }
        return max*max;
    }
}

// Exhaustive approach: For every element we need to find the 1s surrounding it. To do that we will take 
// all the elements which are one, then we will check the element diagonal to it. If it is one, then we 
// will check all the elements in the same column and row before it until the we reach the starting starting column and row. If all the elements in the process are 1, them we set the maximal square as the length. We will keep updating this value with the maximal value found so far and in the end return its square as we have to return the area. O(m^2 * n^2)
 

class Solution {
    public int maximalSquare(char[][] matrix) {
if(matrix==null || matrix.length==0) return 0;
        int m=matrix.length;    //row
        int n=matrix[0].length; //column
        int maxSquare=0;        //max length of the square


        for (int i=0;i<m;i++)   //row
        {
            for(int j=0;j<n;j++)    //column
            {
                
                if(matrix[i][j]=='1')
                {
                    int l=1; //length of the square
                    boolean flag=true;
                    //i+l and j+l are the diagonal elements
                    while(flag && i+l<m && j+l<n)
                    {
                        //move in the same column and row to check if all the elements before it are 1
                        //column
                        for(int k=i+l;k>=i;k--)
                        {
                            if(matrix[k][j+l]=='0')
                            {
                                flag=false;
                                break;
                            }
                            
                        }
                        //row
                        for(int k=j+l;k>=j;k--)
                        {
                            if(matrix[i+l][k]=='0')
                            {
                                flag=false;
                                break;
                            }
                        }
                       if (flag) l++; 
                    }

                    
                    maxSquare=Math.max(maxSquare,l);
                }
                
            }
        }

        return maxSquare*maxSquare;
    }
}