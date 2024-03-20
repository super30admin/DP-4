package week9.day1;
//TC - O(m*n)
//SC - O(m*n)
class Solution24 {
  public int maximalSquare(char[][] matrix) {
      int row = matrix.length;
      int col = matrix[0].length;
      int max_square = matrix[0][0] -'0';

      int[][] dp = new int[row][col];
      for(int i=0;i<row;i++){
         for(int j=0;j<col;j++){
          if(i==0||j==0){ //copy first row and first col
              dp[i][j] = matrix[i][j] -'0';
              max_square = Math.max(max_square,dp[i][j]);
          }
          else{
              if(matrix[i][j] !='0'){ // skip 0
                  int a= dp[i-1][j-1];  //use dp matrix, not original matrix[][]
                  int b = dp[i-1][j];
                  int c = dp[i][j-1];

                  dp[i][j] = Math.min(a, Math.min(b,c))+1;
                  max_square = Math.max(max_square,dp[i][j]);
              }
          }
          } 
      }
      return max_square*max_square;
  }
}
public class MaximalSquare {

	public static void main(String[] args) {
		char[][] matrix = {{'1','1','1','1','0'},{'1','1','1','1','0'},{'1','1','1','1','1'},{'1','1','1','1','1'},{'0','0','1','1','1'}};
		Solution24 s = new Solution24();
		System.out.println(s.maximalSquare(matrix));
		

	}

}
