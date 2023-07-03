
// Any problem you faced while coding this :


// Your code here along with comments explaining your approach

// Approach 1:  recursion + memoization (dp)
// Time Complexity : O(nk) n= arr.size()
// Space Complexity : O(n)
// Did this code successfully run on Leetcode : yes

class Solution {
public:
    
    int dfs(vector<int>&arr,int k, int start, vector<int>&dp)
    {
        int n = arr.size();
        
        if(start>=n) return 0;
        if(dp[start]!=-1) return dp[start];
        
        int maxSum = 0,maxEle = 0;
        
        for(int i = start; i< min(n,start+k);i++){
            maxEle = max(maxEle,arr[i]);
            maxSum = max(maxSum, (i-start+1)*maxEle + dfs(arr,k,i+1,dp));
        }
        return dp[start]=maxSum;
    }
    
    int maxSumAfterPartitioning(vector<int>& arr, int k) {
        int n = arr.size();
        vector<int>dp(n,-1);
        return dfs(arr,k,0,dp);
    }
};


// Approach 2: bottom up dp
// Time Complexity : O(nk)
// Space Complexity : O(n)
// Did this code successfully run on Leetcode : yes

class Solution {
public:
    int maxSumAfterPartitioning(vector<int>& arr, int k) {
        int n = arr.size();
        int sum = 0;
        int dp[n];
        memset(dp,0,sizeof dp);
        int maxK = 0;
        
        for(int i = 0;i<k;i++){
            maxK = max(maxK,arr[i]);
            dp[i] = (i+1)* maxK;
        }
        for(int i = k;i<n;i++){
            maxK = arr[i];
            for(int j = i;j>(i-k);j--){
                maxK = max(maxK,arr[j]);
                dp[i] = max(dp[i], dp[j-1] + (i-j+1)*maxK);
            }
        }
        return dp[n-1];
        
    }
};