//TC: O(nk) where n is the length of the array and k is the size of the window.
//SC: O(n)

class Solution {
public:
    int maxSumAfterPartitioning(vector<int>& arr, int k) {
        
        int n = arr.size();
        
        //make the dp vector
        int dp[n];
        
        for(int i=0; i<n; i++){
            dp[i] = 0;
        }
        
        for(int i=0; i<n; i++){
            int maxval = INT_MIN;
            
            //check if j is in the range of 1 to k(incl.) and if i-j+1 is within acceptable array bounds. 
            for(int j=1; j<=k && (i-j+1)>=0; j++){
                maxval = max(maxval, arr[i-j+1]); //this checks for the maximum value from index j backwards to index j-k (in backwards window of size k starting from j and ending at j-k)
                
                if(i<j){
                    dp[i] = max(dp[i], maxval*j);
                } else{
                    //if i > j, then we know that there might be some existing value in the dp matrix. We check for this existing value based on what is the value of j we are currently at. 
                    dp[i] = max(dp[i], maxval*j + dp[i-j]);
                }
                
            }
           
        }
        
        return dp[n-1];
        
    }
};