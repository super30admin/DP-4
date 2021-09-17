/*
Time Complexity = O(n*k)
Spcae Complexity = O(n)
where n is the size of the arr and k is the partition size.
*/
class Solution {
public:
    int maxSumAfterPartitioning(vector<int>& arr, int k) {
        int m,i,j;
        int n = arr.size();
        vector<int> dp(n+1,0);
        for(i=1;i<=n;i++)
        {
            m = INT_MIN;
            for(j=1;j<=k && i-j>=0;j++)
            {
                m=max(m, arr[i-j]);
                dp[i] = max(dp[i], dp[i-j] + m*j);
            }
        }
        return dp[n];
    }
};
