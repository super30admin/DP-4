/*Time Complexity : O(mn)^2
Space Complexity : 
Did it run on LeetCode : yes
Any Problems: No
*/
class Solution {
    public int maximalSquare(char[][] matrix) {
     int rows = matrix.length;
        int max=0;   // Create a max variable to compare curr and max. Then return Max*max;
        if(rows==0) return 0;
        int cols = matrix[0].length;
        boolean flag=false; // keep a track of something becoming 0 in the matrix.
        
        for(int i=0;i<rows;i++)
        {
            for(int j=0;j<cols;j++)
            {
                if(matrix[i][j]=='1')
                {
                    flag = true;    // Flag= true because we encountered 1.
                    int curr = 1;
                    // check with bottom right
                    while(i+curr < rows && j+curr < cols && flag)
                    {
                       for(int k=i+curr; k>=i;k--) // Check for rows.
                       {
                           if(matrix[k][j+curr]=='0'){
                               flag= false;break;
                           }
                       }   
                           for(int k=j+curr; k>=j;k--) // Check for columns.
                       {
                           if(matrix[i+curr][k]=='0'){
                               flag= false;break;
                           }
                               
                       }
                    
                if(flag) 
                    curr++; // if flag is still true, increase the current.
                    
                }//end of while.
                    max= Math.max(curr,max);    // -> get the max value for max square area.
            } // end of if i,j ==1
        } // end of for j
 }// end of for i.
       return max*max; 
    }
}
