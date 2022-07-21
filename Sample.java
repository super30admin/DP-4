//*****106.221.MAXIMAL SQUARE****
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
