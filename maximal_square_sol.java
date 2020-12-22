package codes;

public class maximal_square_sol {
	
//	o((mn)^2) tc and o(1)spc
	   public int maximalSquare(char[][] matrix) {
	        if(matrix==null|| matrix.length==0) return 0;
	        
	        int m=matrix.length; int n= matrix[0].length;
	        
	        
	        boolean flag=false; int max=0;
	        
	        
	        
	        
	        for(int i=0;i<m;i++){
	            
	            for(int j=0;j<n;j++){
	                
	                
	                
	                if(matrix[i][j]=='1'){
	                    
	                    
	                    flag=true;
	                    int curr=1;  // dimension of diagonal
	                    
	                    
	                    while(i+curr<m&&j+curr<n&& flag){
	                        
	                        
	                        for(int k=i+curr;k>=i;k--){ // go through column 
	                            
	                            if(matrix[k][j+curr]=='0'){
	                                //when we find a 0 i.e cant be a square
	                                flag=false;
	                                break;
	                            }
	                        }
	                        
	                        if(!flag) break;
	                        
	                        
	                        for(int k=j+curr;k>=j;k--){ // go through row
	                            if(matrix[i+curr][k]=='0'){
	                                flag=false;
	                                break;
	                            }
	                        }
	                        
	                           if(flag) curr++;
	                        
	                        
	                    }
	                    
	                    max=Math.max(max, curr);
	                    
	                    
	                    
	                    
	                }
	                
	            }
	            
	            
	        }
	        return max*max;
	        
	    }
	   
	   
	   // approach 2
	   
//	   O(m*n) tc and spc
	   public int maximalSquare(char[][] matrix) {
	        if(matrix==null|| matrix.length==0) return 0;
	        
	        int m=matrix.length; int n= matrix[0].length;
	        
	        
	        boolean flag=false; int max=0;
	        
	    
	        int [][]dp= new int[m+1][n+1];
	        
	        for(int i=1;i<dp.length;i++){
	            for(int j=1;j<dp[0].length;j++){
	                if(matrix[i-1][j-1]=='1'){
	                    dp[i][j]=Math.min(Math.min(dp[i-1][j-1],dp[i-1][j] ),
	                                     dp[i][j-1])+1;
	                    max=Math.max(max, dp[i][j]);
	                }
	            }
	        }
	        
	        return max*max;
	        
	    }
}
