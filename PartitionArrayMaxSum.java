//Problem 107: Partition Array for Maximum Sum
//TC: O(nk)
//SC: O(n)

 //[1,15, 7, 9,  2, 5, 10], k = 3
 // 1 30 45  54  63 72 84 

class Solution107 {
    public int maxSumAfterPartitioning(int[] arr, int k) {
        
        if(arr==null || arr.length==0) return 0;
        //TC:O(nk)
        //[1,15, 7, 9,  2, 5, 10], k = 3
        // 1 30 45  54  63 72 84 
        int[] dp = new int[arr.length];
        int max = Integer.MIN_VALUE;
        for(int i=0;i<dp.length;i++){
            max = arr[i];
            //put the partition upto k
            for(int j=1;j<=k && i-j+1>=0;j++){
                //here for taking incoming index into consideration use i-j+1, because for k=3, first u will take 1 element then 2 and then 3 element which is right to left
                max = Math.max(max,arr[i-j+1]);
                
                if(i-j>=0){//if all elements not taken
                    ////previous index already calculated sum adding it with the max
                    dp[i] = Math.max(dp[i],dp[i-j]+max*j);
                }else{//if all elements ok k length are taken into consideration
                    dp[i] = Math.max(dp[i],max*j);
                }
                
            }
            
        }
        
        return dp[dp.length-1];
    }
}