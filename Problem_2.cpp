//Time:O(N)
//Space: O(N)
class Solution {
public:
    int maxSumAfterPartitioning(vector<int>& A, int K) {
        int n=A.size();
        if(n==0) return 0;
        int dp[n+1];
        dp[0]=0;
        for(int i=1;i<=n;i++){
            dp[i]=dp[i-1]+A[i-1];
            int x=A[i-1];
            int j=i-1;
            int k=K-1;
            while(k-- && j--){
                x=max(x,A[j]);
                dp[i]=max(dp[i],dp[j]+(i-j)*x);
            }
        }
        return dp[n];
    }
};