

// Time Complexity :  O(n+k) where n in no of element and k is partition size
// Space Complexity : O(n) where n is number of elements in arr
// Did this code successfully run on Leetcode :yes
// Did this code successfully run on Local Computer :yes
// Any problem you faced while coding this : no


// Your code here along with comments explaining your approach

class Solution {
public:
    int maxSumAfterPartitioning(vector<int>& arr, int k) {
        
        if(arr.empty()) return 0;
        
        vector<int> dp(arr.size()); //making a dp array of size which is the length of the array
        
        
        for(int i=0;i<arr.size();i++){
            int gmax=dp[i];
            for(int j=1;j<=k && i-j+1>=0;j++){
                gmax=max(gmax,arr[i-j+1]);
                
                if(i-j >= 0){
                    dp[i]=max(dp[i],gmax*j+dp[i-j]);
                }else{
                    dp[i]=max(dp[i],gmax*j);
                }
            }
        }
        return dp[arr.size()-1];
        
    }
};