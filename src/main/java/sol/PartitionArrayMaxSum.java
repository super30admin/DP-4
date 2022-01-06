package sol;
import java.util.*;
public class PartitionArrayMaxSum {
	 public int maxSumAfterPartitioning(int[] arr, int k) {
	        int []dp=new int[arr.length];
	        Arrays.fill(dp,-1);
	        
	        return (helper(k,arr,0,dp));
	        
	    }


	public int helper(int k, int arr[], int index,int dp[]){
	   
	    if(index>=arr.length){return 0;}
	    if(dp[index]!=-1){return dp[index];}
	    
	    int max=0;
	    int ans=0;
	    
	    for(int i=index;i<index+k && i<arr.length;i++){
	        max=Math.max(max,arr[i]);
	        
	        ans= Math.max(ans,helper(k,arr,i+1,dp)+(i-index+1)*max);
	        
	        
	        
	        
	    }
	return    dp[index]=ans;
	    
	}

}
