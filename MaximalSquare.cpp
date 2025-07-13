// TC : O(M*N) We iterate over the matrix once
// SC : O(N) We have a dp array of size of one row or tonal number of columns +1;

// Approach : 
// create an array of size columns+1;
// when ever the value of the matrix is 1 we do the max square that can be formed.
// we check the values left, diagonal and top;
// since we cant hold the value of diagonal in the 1d array we use a temporary variable to store it and compute the values depending on it.
// Since we iterate over the array of +1 length we always set the pre to zero for every iteration we do over a row.

class Solution {
public:
    int maximalSquare(vector<vector<char>>& matrix) {
        int m = matrix.size();
        int n = matrix[0].size();
        int maxValue=0;
        if(m == 0 || n == 0) return 0;
        vector<int> dp(n+1,0);
        for(int i=0;i < m;++i){
            int prev = 0;
            for(int j=0 ; j<n ; ++j){
                int temp = dp[j+1];
                if(matrix[i][j] =='1'){
                    dp[j+1] =  min(min(dp[j], dp[j+1]), prev)+1;
                    maxValue = max(maxValue,dp[j+1]);
                } else{
                    dp[j+1] = 0;
                }
                prev = temp;
            }
        }
        return maxValue * maxValue;
    }
};
