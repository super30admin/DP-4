/*
Time: O(n*k)
Space: O(n)
*/

class Solution {
public:
    vector<int> v, dp;
    int n,k;

    int call(int pos){
      if(pos==n)  return 0;
      if(dp[pos]!=-1)  return dp[pos];
      
      int maxi = 0;
      int ans = 0;

      //options: take this element in the subarray (check if it's the maximum for this subarray)
      //opt1 = continue till subarray size <=k
      //opt2 = end this subarray and recusive call to build next subarray from the next element
      for(int i=pos; i<min(n,pos+k); i++){
        maxi = max(maxi, v[i]);
        int subarr_sum = (i-pos+1) * maxi;
        ans = max(ans, subarr_sum + call(i+1));
      }

      return dp[pos] = ans;
    }


    int maxSumAfterPartitioning(vector<int>& arr, int k) {
        v = arr;
        n = arr.size();
        dp = vector(n,-1);
        this->k = k;

        return call(0);
    }
};
