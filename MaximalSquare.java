// Time Complexity : O(mn)
// Space Complexity : O(mn)
// Did this code successfully run on Leetcode : Yes

public class MaximalSquare {

    public int maximalSquare(char[][] matrix) {
        int m = matrix.length, n = matrix[0].length;
        int max = 0;
        boolean flag = false;

        for(int i =0 ; i < m ; i++){
            for(int j =0 ; j < n ; j++){
                if(matrix[i][j] == '1'){
                    flag = true;
                    int curr = 1;
                    while(i + curr < m &&
                            j + curr < n && flag){

                        //col check
                        for(int k = i+curr; k >=i; k--){
                            if(matrix[k][j+curr] == '0'){
                                flag = false;
                                break;
                            }
                        }

                        //row check
                        for(int k = j+curr; k >=j; k--){
                            if(matrix[i+curr][k] == '0'){
                                flag = false;
                                break;
                            }
                        }

                        if(flag) curr++;
                    }
                    max = Math.max(max, curr);
                }
            }
        }
        return max * max;
    }
}
