//*****106.221.MAXIMAL SQUARE--BFS APPROACH****
//Time complexity:o(m square*n square);
//Space complexity:0(1);
//Leetcode runnable:Y;
//Any doubts:N;

class Solution {
    public int maximalSquare(char[][] matrix) {
        //Null case
        if(matrix.length==0 || matrix==null)
        {
            return 0;
        }
        int max=0;
        int m=matrix.length;
        int n=matrix[0].length;
        
        for(int i=0;i<m;i++)
        {
            for(int j=0;j<n;j++)
            {
                if(matrix[i][j]=='1')
                {
                    int l=1;
                    boolean flag=true;
                    while(i+l<m && j+l<n && flag)
                    {
                        //Check for the corresponding col
                        for(int k=i+l;k>=i;k--)
                        {
                            if(matrix[k][j+l]=='0')
                            {
                                flag=false;
                                break;
                            }
                        }
                        
                        //Check for the corresponding row
                        for(int k=j+l;k>=j;k--)
                        {
                            if(matrix[i+l][k]=='0')
                            {
                                flag=false;
                                break;
                            }
                        }
                        if(flag)l++;
                    }
                    max=Math.max(max, l);
                }
            }
        }
        return max*max;
    }
}

//*****106.221.MAXIMAL SQUARE--DP APPROACH****
//Time complexity:o;
//Space complexity:0(1);
//Leetcode runnable:Y;
//Any doubts:N;

class Solution {
    public int maximalSquare(char[][] matrix) {
        //Null case
        if(matrix.length==0 || matrix==null)
        {
            return 0;
        }
        int max=0;
        int m=matrix.length;
        int n=matrix[0].length;
        
        //Check for row 1
        for(int i=0;i<m;i++)
        {
            if(matrix[i][0]=='1')
            {
                max=1;
            }
        }
        
        //Check for col 1
        for(int i=0;i<n;i++)
        {
            if(matrix[0][i]=='1')
            {
                max=1;
            }
        }
        
        
        //We are using top down approach
        //We need to start from 1st row and col as the 0th row and col will by default be 1 for 1's and 0 for zeros
        for(int i=1;i<m;i++)
        {
            for(int j=1;j<n;j++)
            {
                if(matrix[i][j]=='1')
                {
                    //Now check for 3 neighbour corners
                //As it is in the char array we need to do -0 to convert to int
                int top=matrix[i-1][j]- '0';
                int topleft=matrix[i-1][j-1]- '0';
                int left=matrix[i][j-1]- '0';
                
                int temp= 1+ Math.min(top,Math.min(topleft, left));
                max=Math.max(max,temp);
                //Mutating and updating the current position
                matrix[i][j]=(char)(temp+'0');
                    
                }
                
            }
        }
        return max*max;
    }
}

//*****107.1043. PARTITION ARRAY FOR MAXIMUM SUM****
//Time complexity:o(n*k);
//Space complexity:o(1);
//Any doubts: N;
//Leetcode runnable: Y;

class Solution {
    public int maxSumAfterPartitioning(int[] nums, int k) {
        int n=nums.length;
        int[] dp=new int[n];
        
        //Initializing the element one of the array as that would be just the element it self
        dp[0]=nums[0];
        
        //Iterating through the given array
        for(int i=1;i<n;i++)
        {
            //Max currently would be the number it self
            int max=nums[i];
            //Now we can have k cases here to choose and not to choose
            for(int j=1;j<=k && i-j+1>=0 ;j++)
            {

                max=Math.max(max, nums[i-j+1]);
                
                int curr=0;
                if(i-j>=0)
                {
                    curr= j * max + dp[i-j];
                }
                else
                {
                    curr=j*max;
                }
                dp[i]=Math.max(dp[i], curr);
                
            }
            
        }
        return dp[n-1];
    }
}
