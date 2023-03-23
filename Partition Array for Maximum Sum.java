class Solution {
    public int maxSumAfterPartitioning(int[] arr, int k) {
        Integer[] memo = new Integer[arr.length];
        return dfs_helper(arr, k, 0, memo);
    }
    
    public int dfs_helper(int[] arr, int k, int start_index, Integer[] memo){
        
        //cover all the bases here.
        
        if(start_index == arr.length){
            return 0;
        }
        
        if(memo[start_index] != null){
            return memo[start_index];
        }
        
        //We need a for loop for putting the partitions
        
        int curr_max = 0;
        int sum_max = 0;
        
        for(int i = 0; i < k; i++){
            
            int to = start_index + i;
            //We need to check this because we will be accessing the array to calculate max. 
            if(to >= arr.length){
                break;
            }
            
            curr_max = Math.max(curr_max, arr[to]);
            
            //calculate the product of left side elements and the current max.
            
            sum_max = Math.max(sum_max, (curr_max * (i + 1)) + dfs_helper(arr, k, to + 1, memo));
        }
        
        return memo[start_index] = sum_max;
        
    }
}