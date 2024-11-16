//brute force approach tc- O(m*n * m*n)

// class Solution {
//     public int maximalSquare(char[][] matrix) {
//         int max = 0;
//         int m = matrix.length;
//         int n = matrix[0].length;

//         for(int i = 0; i < m; i++){//m*n
//             for(int j = 0; j < n; j++){
//                 if(matrix[i][j] == '1'){
//                     boolean flag = true;
//                     int l = 1;
//                     while(i+l < m && j+l <n){//checking base cond, if from ith position plus level becomes more then m same for colmn
//                     //for worst case it will go for whole matrix so per iteration m*n traversal worst case
//                        for(int k= i+l; k >= i; k--){//from that level through diognal going up till i
//                           if(matrix[k][j+l] == '0'){//if find 0 in the way that is breach break the loop
//                             flag = false;
//                             break;
//                           }
//                        }
//                        for(int k = j+l; k >= j; k--){//from that level through diognal going left till j
//                           if(matrix[i+l][k] == '0'){//if find 0 in the way that is breach break the loop
//                             flag = false;
//                             break;
//                           }
//                        }
//                        if(flag){//if we did not find flag as false means no breach was found increase l
//                         l++;
//                        }else{
//                         break;//else 0 was found for that i, j location square come out, and start from next location to look for square
//                        }
//                     }

//                     max = Math.max(max, l);
//                 }
//             }
//         }

//         return max*max;
        
//     }
// }

//dp tc- O(m*n) sc - O(m*n)

class Solution {
    public int maximalSquare(char[][] matrix) {
        int max = 0;
        int m = matrix.length;
        int n = matrix[0].length;
        
        int[][] dp = new int[m+1][n+1];//initializing first row and column as 0 taking extra space

        for(int i = 1; i <= m; i++){//m*n
            for(int j = 1; j <= n; j++){
                if(matrix[i - 1][j - 1] == '1'){//beause we started from i =1, j=1
                  dp[i][j] = 1 + Math.min((dp[i-1][j-1]), Math.min(dp[i][j-1], dp[i-1][j]));//per square we are checking 
                  //in three dir the min value than adding 1 to it that is its square size and updaing in dp, we go like this
                  //from small to big square
                  max = Math.max(max, dp[i][j]);
                }
            }
        }

        return max*max;
        
    }
}
