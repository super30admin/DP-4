/*
//////////////////////////////////////////////////////////
Brute force: We consider each point as the top right point and then we find an approproate bottom right point for it to make it a square.
We then check the edges of that square to see if it is valid or not
Time Complexity: O((M*N)^2)
Space Complexity: O(1)
//////////////////////////////////////////////////////////
DP: We check the minimum between the neighbouring elements and then add 1 to it.
We use a 2D matrix to store all elements
Time Complexity: O((M*N))
Space Complexity: O(M*N)
//////////////////////////////////////////////////////////
We use a 1D array to store all elements
Time Complexity: O(M*N)
Space Complexity: O(M)
//////////////////////////////////////////////////////////
*/


class Solution {
public:
    int maximalSquare(vector<vector<char>>& matrix) {
        int rows = matrix.size();
        int cols = matrix[0].size();
        int maxArea = 0;
        int currArea = 1;
        bool flag = false;
        for ( int i = 0; i < rows; i ++){
            for ( int j = 0; j < cols; j ++){
                if ( matrix[i][j] == '1'){
                    currArea = 1;
                    flag = false;
                    while ( flag == false and  i+currArea < rows and j+currArea < cols ){
                        
                        int bottomRightI = i+currArea;
                        int bottomRightJ = j+currArea;
                        
                        for ( int k = bottomRightI; k >=i ; k-- )
                            if ( matrix[k][bottomRightJ] == '0'){
                                flag = true;
                                break;
                            }
                        for ( int l = bottomRightJ; l >=j ; l-- )
                            if ( matrix[bottomRightI][l] == '0'){
                                flag = true;
                                break;
                            }
                        if ( flag == false)
                        currArea += 1;
                        
   
                    }
                    maxArea = max(maxArea, currArea);
                    
                    
                }
            }
        }
        return maxArea* maxArea;
    }
};


class Solution {
public:
    int maximalSquare(vector<vector<char>>& matrix) {
        int rows = matrix.size();
        int cols = matrix[0].size();
        int maxArea = 0;
        int dp[rows + 1][cols + 1];
        for ( int i =0; i <= rows; i++){
            for (int j =0; j<= cols ; j++){
                dp[i][j] = 0;
            }
        }
        for ( int i =1; i <= rows; i++){
            for (int j =1; j<= cols ; j++){
                if ( matrix[i-1][j-1] == '1'){
                    dp[i][j] = min(dp[i-1][j-1], min(dp[i][j-1], dp[i-1][j]))+1;
                    maxArea = max(maxArea, dp[i][j]);
                }
            }
        }
        return maxArea* maxArea;
        
    }
};

class Solution {
public:
    int maximalSquare(vector<vector<char>>& matrix) {
        int rows = matrix.size();
        int cols = matrix[0].size();
        int maxArea = 0;
        int prev = 0;
        int dp[cols + 1];
        for (int j =0; j<= cols ; j++){
            dp[j] = 0;
        }

        for ( int i =1; i <= rows; i++){
            for (int j =1; j<= cols ; j++){
                if ( matrix[i-1][j-1] == '1'){
                    int temp = dp[j];
                    dp[j] = min(dp[j-1], min(dp[j] , prev))+1;
                    maxArea = max(maxArea, dp[j]);
                    prev = temp;
                    
                }
                else{
                    dp[j] = 0;
                }
            }
        }
        return maxArea* maxArea;
        
    }
};