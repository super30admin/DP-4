// Time Complexity : O(n*k) traversing through each value of element for k times for checking again
// Space Complexity : O(n) for the vector we created
// Did this code successfully run on Leetcode : Yes
// Any problem you faced while coding this : no issues as of now.. Learning


class Solution {
public:
    int maxSumAfterPartitioning(vector<int>& arr, int k) {
        
        if( arr.size() == 0){
            return 0;
        }
        
        vector<int> dp(arr.size(),0);
        
        
        for( int i = 0; i < arr.size(); i++){
            
            int max_val = INT_MIN;
            
            for( int j = 1; (j <= k && ( i-j+1)>=0) ; j++){
                
                max_val = max(max_val,arr[i-j+1]);
               
                if(i >= j){
                    
                    dp[i] = max(dp[i], dp[i-j] + max_val*j);
                    
                }else{
                    dp[i] = max(dp[i], max_val*j);
                }
            }
        }
        return dp[arr.size()-1];
    }
};