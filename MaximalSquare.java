/*
The time complexity is O(m*n) and the space complexity is O(m*n) where m and n are no of rows and columns in the matrix.

Here the intuition is to use the knowledge of top, left, topleft where we can find if the above rows contain squares or not.

Yes, the solution passed all the test cases in leetcode.
 */
class Solution {
    public int maximalSquare(char[][] matrix) {
        if(matrix.length==0){return 0;}

        //Creating a matrix where we are going to store the knowledge of above rows.
        int[][] array = new int[matrix.length][matrix[0].length];

        //This variable is used to store the max length of sqaure seen so far.
        int maxseen = 0;

        //Iterating through the matrix
        for(int i=0;i<matrix.length;i++){
            for(int j=0;j<matrix[0].length;j++){

                //If we find '1' which means this can be used to for a square. So, check its top, left and topleft values of array matrix
                if(matrix[i][j]=='1'){

                    //First initialize the values to zero. If we are not going out of bound then get the value present.
                    int top = 0; int topleft = 0; int left = 0;
                    if(i-1>=0){top = array[i-1][j];}
                    if(i-1>=0 && j-1>=0){topleft = array[i-1][j-1];}
                    if(j-1>=0){left = array[i][j-1];}

                    //The minimum of the values is calculated.
                    int min = Math.min(top,topleft);
                    min = Math.min(min,left);

                    //Make the current value of array matrix to be min+1 since we can make a sqaure of higher length with min and current '1'
                    array[i][j] = min+1;
                    if(min+1>maxseen){maxseen = min+1;}
                }
                else{
                    array[i][j]=0;
                }
            }
        }

        //We get the highest length of a square. To get Area length*length.
        return maxseen*maxseen;
    }
}