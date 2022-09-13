// time complexity: O(mn)
// space complexity: O(1)

//we're making dp and checking upper, left and upper_diagonal element
//using bottom-up approch

class maximalSq {
    public int maximalSquare(char[][] matrix) {
        if(matrix==null||matrix.length==0) return 0;
        int m = matrix.length;
        int n = matrix[0].length;
        int max = 0;

        for(int i=0; i<m; i++){
            if(matrix[i][0] == '1') max = 1;
        }

        for(int j=0; j<n; j++){
            if(matrix[0][j] == '1') max = 1;
        }

        // going over element and if we found 1 then, we'll get the minimum of three postion and add 1
        // which helps to determine maximum size of square, we can create at that point.
        for(int i=1; i<m; i++){
            for(int j = 1; j<n; j++){
                if(matrix[i][j]=='1'){
                    int min = 1+ Math.min(matrix[i-1][j], Math.min(matrix[i][j-1], matrix[i-1][j-1]));
                    matrix[i][j] = (char)min;
                    max = Math.max(max,matrix[i][j]-'0');
                }
            }
        }
        return max*max;
    }
}