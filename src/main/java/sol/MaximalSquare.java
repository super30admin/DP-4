package sol;

public class MaximalSquare {

	 public int maximalSquare(char[][] matrix) {
	        int [][]dp= new int[matrix.length][matrix[0].length]; 
	        int max=Integer.MIN_VALUE;
	               
	         for( int i=0;i<matrix.length;i++){
	            for(int j=0;j<matrix[0].length;j++){
	                dp[i][j]=(int) matrix[i][j]-48;
	                if(dp[i][j]==1){max=1;}
	          // System.out.print(dp[i][j]+" ");
	            }
	      //   System.out.println();
	         }
	        
	        
	        for( int i=1;i<dp.length;i++){
	            for(int j=1;j<dp[0].length;j++){
	                
	                int a=dp[i-1][j-1];
	                int b= dp[i][j-1];
	                int c= dp[i-1][j];
	          if(dp[i][j]==1) {dp[i][j]=1+Math.min(a,Math.min(b,c));}
	           // System.out.println(dp[i][j]);
	             if(dp[i][j]>max){max=dp[i][j];}   
	            
	           
	            }
	            
	            
	        }
	       
	        
	       return max*max; 
	    }
	
}
