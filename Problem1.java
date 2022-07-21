// Time Complexity : O(mxn)
// Space Complexity : O(1)
// Did this code successfully run on Leetcode : Yes
// Any problem you faced while coding this : No


//221. Maximal Square
//https://leetcode.com/problems/maximal-square/


class Solution {
    // DYNAMIC PROGRAMMING MATRIX solution
    // time: O(mxn)
    // space: O(1)
    public int maximalSquare(char[][] matrix) {

        // iterate over each element
        // for each element check if it is 1, if it is 1, find its value(max square
        // area) by doing min of (its neighbouring values)
        // also have a max variable that will store the max square size yet found
        // how to handle edge cases?
        int m = matrix.length;
        int n = matrix[0].length;
        int max = 0;
        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                if (matrix[i][j] == '1') {

                    if (max == 0)
                        max = 1;

                    if (j > 0 && i > 0) { // System.out.print(i+" "); System.out.print(j+" ");
                                          // System.out.print("matrix[i-1][j-1] " + matrix[i-1][j-1]+ " ");
                                          // System.out.print("matrix[i][j-1] " + matrix[i][j-1] + " ");
                                          // System.out.print("matrix[i-1][j] " + matrix[i-1][j] + " ");
                        /*
                         * int top = matrix[i][j-1] -'0';
                         * int left = matrix[i-1][j] -'0';
                         * int topRight = matrix[i-1][j-1] -'0';
                         * int temp = 1+ Math.min(top, Math.min(left,topRight));
                         * //System.out.println(temp);
                         * max = Math.max(max,temp);
                         * matrix[i][j] = (char)(temp+'0');
                         */

                        int temp1 = Math.min((matrix[i][j - 1] - '0'), (matrix[i - 1][j - 1] - '0')); // System.out.print("temp1
                                                                                                      // " + temp1 + "
                                                                                                      // ");
                        int temp2 = 1 + Math.min((matrix[i - 1][j] - '0'), temp1); // System.out.print("temp2 " + temp2
                                                                                   // + " ");
                        matrix[i][j] = (char) ((temp2) + '0');
                        // max = Math.max(max,temp2);
                        if (temp2 > max) {
                            max = temp2;
                        }

                    }
                }
            }
        }
        return max * max;
    }
}


/*
class Solution {
    // Brute Force
    // time: O(mnxmn)
    // space: O(1)
    public int maximalSquare(char[][] matrix) {

        // Iterate over the matrix
        // At each element, traverse to the bottom right (l - length of the square that
        // starts from 1, (i+l, j+l))
        // keep a max variable to store the max length
        int m = matrix.length;
        int n = matrix[0].length;
        int l = 1;
        int max = 0;
        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                if (matrix[i][j] == '1') {

                    if (max == 0)
                        max = 1;

                    boolean flagI = true;
                    boolean flagJ = true;

                    while (i + l < m && j + l < n && matrix[i + l][j + l] == '1') {
                        // System.out.println(i+l); System.out.println(j+l);
                        // checking the column from i+l and j+l index
                        for (int k = i + l; k >= i; k--) {
                            if (matrix[k][j + l] == '1') { // System.out.print("k " + k + " "); System.out.println("j+l
                                                           // " + (j+l));
                                flagJ = true;
                            } else {
                                flagJ = false;
                                break;
                            }
                        }
                        // checking the row from i+l and j+l index
                        for (int t = j + l; t >= j; t--) { // System.out.print("t " + t + " "); System.out.println("i+l
                                                           // " + (i+l));
                            if (matrix[i + l][t] == '1') {
                                flagI = true;
                            } else {
                                flagI = false;
                                break;
                            }
                        }

                        if (flagJ == true && flagI == true) {
                            if (l + 1 > max)
                                max = l + 1; // System.out.print("max" + max + " "); System.out.println("l" + l);

                            l++;
                        } else {
                            break;
                        }
                    }
                    l = 1;
                }
            }
        }
        return max * max;
    }
}
*/