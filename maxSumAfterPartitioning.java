//TC - O(nxk);
//SC - O(n);
//LC - 1043

class Solution {
    public int maxSumAfterPartitioning(int[] arr, int k) {
        if(arr.length==0) return 0;
        
        int [] res = new int[arr.length];
        res[0]=arr[0];
        
        for(int i=1;i<arr.length;i++){
            int max=res[i];
            for(int j=1;j<=k && i-j+1 >=0 ;j++){
                max = Math.max(max,arr[i-j+1]);
                
                if(i-j>=0){
                    res[i] = Math.max(res[i],max*j+res[i-j]);
                }
                else{
                    res[i] = Math.max(res[i],max*j);
                }
            }
        }
        
        return res[res.length-1];
    }
}class maxSumAfterPartitioning {
    
}
