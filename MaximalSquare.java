class Solution {

    //Time Complexity: 0(m*n) ^2 where m is the row and n is the columns
    //Space Complexity: 0(1)
    //Did it successfully run on leetcode: Yes
    //DId you face any problem while coding: No

    //In short explain your code

    public int maximalSquare(char[][] matrix) {
        int m = matrix.length;
        int n = matrix[0].length;
        int max = 0;    //taking a max variable to capture the max square
        for(int i = 0; i < m; i++){ //iterating through rows
            for(int j = 0; j < n; j++){ //iterating through column
                if(matrix[i][j] == '1'){    //our search starts once we encounter 1. we know that once we encounter 1, we see it's bottom right diagonal to check if 1 exists or not, if yes then we check for that column, whether all the elements are 1 or not and for that row wheteher all elements are 1 or not
                    int curr = 1;   //we assign 1 to current as we increase the diagonal by 1 after every check
                    boolean flag = true;    //setting flag to true, if we encounter a 0 in the checks, we will set flag as false and restart searching for 1
                    while(i + curr < m && j + curr < n && flag == true){    //checking for 1st diagnal and increasing current to head to next diagonal if all conditions are satisfied
                        //checking for column
                        for(int k = i; k <= i + curr; k++){ //if the entire column contains 1 or not for that square
                            if(matrix[k][j + curr] == '0'){ //same column, different rows
                                flag = false;
                                break;
                            }
                        }
                        if(!flag) break;    //if the elements are not 1 in column no need to do row check
                        //checking for row
                        for(int l = j; l <= j + curr; l++){ //if the entire row in the sware contains 1 or not
                            if(matrix[i + curr][l] == '0'){ //same row, changing column
                                flag = false;
                                break;
                            }
                        }
                        if(!flag) break;//if all element in row are not 1 then there is no point in expanding our search to a bigger sqare
                        curr++;
                    }
                    max = Math.max(max, curr);  //comparing previous max and current
                }
            }
        }
        return max * max;
    }
}

//DP with m*n space
class Solution {

    //Time Complexity: 0(m*n) where m is the row and n is the columns
    //Space Complexity: 0(m*n)
    //Did it successfully run on leetcode: Yes
    //DId you face any problem while coding: No

    //In short explain your code


    public int maximalSquare(char[][] matrix) {
        int m = matrix.length;
        int n = matrix[0].length;
        int[][] dp = new int [m+1][n+1];    //declaring a dp matrix to keep track of the min square that can be formed between top, left and left diagonal
        int max = 0;
        for(int i = 1; i <= m ; i++){
            for(int j = 1; j <= n; j++){
                if(matrix[i-1][j-1] == '1'){
                    dp[i][j] = 1 + Math.min(dp[i-1][j], Math.min(dp[i][j-1], dp[i-1][j-1]));    //adding 1 to min of the 3 checks
                    max = Math.max(max, dp[i][j]);  //comparing previous max and the max of the dp at that index to compute the largest square
                }
            }
        }
        return max * max;   //returning area
    }
}

//DP with n space
class Solution {

    //Time Complexity: 0(m*n) where m is the row and n is the columns
    //Space Complexity: 0(n)
    //Did it successfully run on leetcode: Yes
    //DId you face any problem while coding: No

    //In short explain your code

    public int maximalSquare(char[][] matrix) {
        int m = matrix.length;
        int n = matrix[0].length;
        int[] dp = new int [n+1];
        int max = 0;
        int temp = 0;   //keeping a temp and prev variable to keep track of the upper left diagonal as it will be overwritten at every step
        int prev = 0;
        for(int i = 1; i <= m ; i++){
            for(int j = 1; j <= n; j++){
                prev = dp[j];
                if(matrix[i-1][j-1] == '1'){
                    dp[j] = 1 + Math.min(dp[j-1], Math.min(dp[j], temp));
                }
                else{
                    dp[j] = 0;  //changing the values to 0 again as we are using a 1-d array and the the max square that can be formed at an index should be 0 in order to compute the upcoming steps correctly
                }
                max = Math.max(max, dp[j]);
                temp = prev;
            }
        }
        return max * max;
    }
}
