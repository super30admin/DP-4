class Solution {
    //tc = m2mn2
    public int maximalSquare(char[][] matrix) {
        if(matrix == null || matrix.length == 0) return 0;
        int m = matrix.length;
        int n = matrix[0].length;
        int l=0;
        int max = 0;
        
        for(int i=0;i<m;i++)
        {
            for(int j=0;j<n;j++)
            {
                if(matrix[i][j] == '1')
                {
                  l =1;
                  boolean flag = true;
                  while(i+l < m && j+l < n && flag)
                  {
                      //coulmn
                      for(int k=i+l;k>=i;k--)
                      {
                          if(matrix[k][j+l] == '0') 
                          {
                              flag = false;
                              break;
                          }
                      }
                      //row
                      for(int k= j+l;k>=j;k--)
                      {
                          if(matrix[i+l][k] == '0')
                          {
                              flag = false;
                              break;
                          }
                      }
       
                  
                 if(flag) l++;
                }
                max = Math.max(max,l);
            }
        }
        }
        return max * max;
    }
}