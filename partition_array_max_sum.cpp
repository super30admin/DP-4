class Solution {
public:
    int maxSumAfterPartitioning(vector<int>& A, int K) {
        if(A.empty())
            return 0;
        int dp[A.size()];
        for(int i=0;i<A.size();i++)
            dp[i]=0;
        for(int i=0;i<A.size();i++)
        {
            int maximum=0;
            for(int j=1;i-j+1>=0&&j<=K;j++)
            {
                maximum=max(maximum,A[i-j+1]);
                if(i>=j)
                    dp[i]=max(dp[i],dp[i-j]+maximum*j);
                else
                    dp[i]=max(dp[i],maximum*j);
            }
        }
        return dp[A.size()-1];
    }
};