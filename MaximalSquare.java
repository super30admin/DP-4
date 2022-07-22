//Time: O(m*n), as we iterate over each element
//Space: O(1), as no extra space is created

class Solution {
    public int maximalSquare(char[][] matrix) {
        //null case check
        if(matrix == null || matrix.length == 0) return 0;
        
        //row and column lengths and creating a max variable
        int m = matrix.length; int n = matrix[0].length;
        int max = 0;
        
        //for the first row, initializing max for each element that has a '1'
        for(int j = 0 ; j < n; j++) {
            if(matrix[0][j] == '1') {
                max = 1;
            }
        }
        
        //for the first column, initializing max for each element that has a '1'
        for(int i = 0 ; i < m; i++) {
            if(matrix[i][0] == '1') {
                max = 1;
            }
        }
        
        //interating over the elements of the matrix
        //we start from [1][1] because elements in first row and first column cannot form squares independently so we took care of it above
        for(int i = 1; i < m; i++) {
            for(int j = 1; j < n; j++) {
               
                //if the element is '1', we check if it's top, left and topLeft elements are also '1', as this will tell us if we're able to increse the size of our square
                if(matrix[i][j] == '1') {
                    
                    //here we do - '0' to convert characters to int
                    int top = matrix[i-1][j] - '0';
                    int left = matrix[i][j-1] - '0';
                    int topLeft = matrix[i-1][j-1] - '0';
                    
                    //we have a temp variable that will store the temporary max possible size for that element. This will be the minimum of max possible sizes of the three neighbours
                    int temp = 1 + Math.min(top, Math.min(left, topLeft));
                    
                    //comparing previous max with the temporary max and updatign it
                    max = Math.max(max, temp);
                    
                    //replacing the values in the matrix so we can keep using them for future squares that we will try to build as we iterate through the matrix
                    matrix[i][j] = (char) (temp + '0');
                }
            }
        }
        return max*max;
    }
}