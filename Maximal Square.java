// Time Complexity : O(MN)
// Space Complexity : O(MN) 
// Did this code successfully run on Leetcode : YES
// Any problem you faced while coding this :


// Your code here along with comments explaining your approach
class Solution {
    public int maximalSquare(char[][] matrix) {
        if(matrix == null || matrix.length==0) return 0;
        int m=matrix.length;
        int n=matrix[0].length;
        int max=0;
        int[][] sqmatrix=new int[m][n];
        for (int i=0;i<m;i++){
            if(matrix[i][0] =='0'){
                sqmatrix[i][0]=0;
            }else{
               sqmatrix[i][0]=1;  
            }
            
            max=Math.max(max,sqmatrix[i][0]);
        }
         for (int j=0;j<n;j++){
            if(matrix[0][j] =='0'){
                sqmatrix[0][j]=0;
            }
             else{
             sqmatrix[0][j]=1;}
               max=Math.max(max,sqmatrix[0][j]);
        }
        for(int i=1;i<m;i++){
            for(int j=1;j<n;j++){
                if(matrix[i][j]=='1'){
                  sqmatrix[i][j]= Math.min(Math.min(sqmatrix[i-1][j],sqmatrix[i][j-1]),sqmatrix[i-1][j-1])+1;
                      max=Math.max(max,sqmatrix[i][j]);
                }
            }
        }
        print(sqmatrix);
        return max*max;
    }
    
    public void print(int[][] arr){
        for(int i=0;i<arr.length;i++){
            for(int j=0;j<arr[0].length;j++){
                System.out.println(arr[i][j]);
            }
        }
    }
}