//Time - O(kn)
//Space - O(n)
class Solution {
public:
    int maxSumAfterPartitioning(vector<int>& arr, int k) {
        vector<int> dp (arr.size(),0);
        
        for(int i=0;i<arr.size();i++){
            int maxx = INT_MIN;
            for(int j=0;j<k && i-j>=0;j++){
                maxx = max(maxx, arr[i-j]);
                
                if(i-j-1>=0){
                    dp[i] = max(dp[i],dp[i-j-1]+maxx*(j+1));
                }else{
                    dp[i] = max(dp[i],maxx*(j+1));
                }
                
            }
        }
        return dp[arr.size()-1];
    }
};