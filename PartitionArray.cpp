//TC = O(NK)
//SC = O(N)
class Solution {
public:
    int maxSumAfterPartitioning(vector<int>& arr, int k) {
        int n = arr.size();
        vector<int> dp(n);
        dp[0]=arr[0];
        for(int i=0;i<n;i++){
            int max = arr[i];
            for(int j=1;j<=k && i-j+1>=0;j++){ //make 3 partitions
                max = std::max(max, arr[i-j+1]); //record the incoming element 
                if(i-j>=0){
                    dp[i] = std::max(dp[i],(max*j) + dp[i-j]); //j= partitions size , dp[i-j] is previous stored result
                }else{
                    dp[i] = std::max(dp[i],(max*j)); 
                }
            }
        }
        return dp[n-1];
    }
};
