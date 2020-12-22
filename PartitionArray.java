package codes;

public class PartitionArray {
	private static int result;
	
	
	
	
	public int maxSumAfterPartitioning_dp(int[] arr, int k) {
        if (arr==null || arr.length==0) return 0;
        
        int n=arr.length;
        
        int [] dp= new int [n];
        
        
        for(int i=0;i<arr.length;i++){
            int max=arr[i];
            for(int j=1;j<=k&&i-j+1>=0;j++){
                max=Math.max(max,arr[i-j+1]);
                
                if(i-j>=0){
                    dp[i]=Math.max(dp[i],dp[i-j]+max*j);
                }else{
                    dp[i]=Math.max(dp[i],max*j);
                }
            }
        }
        
        
        return dp[n-1];
    }
	public static  int maxSumAfterPartitioning(int[] arr, int k) {
		
		if (arr.length==0  || arr == null) {
			return 0;
		}
		
		helper(arr,k,0,0,0);
		return result;
	}
	
	public static void helper(int [] arr, int k, int st, int et, int max_val) {
		//base
		
		//1 when st+k > arr.length
		
		if (st==arr.length) {
//			return;
			result =Math.max(result, max_val);
			for(int num:arr) {
				System.out.print(num+" ");
			}
			return;
		}
		
		// when we have complete length
		

		
		
		//logic
		int val=arr[st];
		for (int i=st, j=0;j<k && st+j<arr.length ;i++,j++) {
			
			val=Math.max(val,arr[st+j]);
			int max_val_new=max_val+((j+1)*val);
			helper( arr,  k,  st+j+1,  et,  max_val_new);
		
		}
		
		
	}
	
	
	
	public static void main(String[] args) {
		
		
		
		int [] arr = {1,15,7,9,2,5,10};
		int k = 3;
		
		int [] arr2 = {1,4,1,5,7,3,6,1,9,9,3};
		int k2 = 4;
		
		
		int [] arr3= {1};
		int k3 = 1;
		
		
		
		
		int [] arr4= {20779,436849,274670,543359,569973,280711,252931,424084,361618,430777,136519,749292,933277,477067,502755,695743,413274,168693,368216,677201,198089,927218,633399,427645,317246,403380,908594,854847,157024,719715,336407,933488,599856,948361,765131,335089,522119,403981,866323,519161,109154,349141,764950,558613,692211};
		int k4=26;
		
		int final_result=maxSumAfterPartitioning(arr4, k4);
		System.out.println("Solution :: "+final_result);
	}
	
}
