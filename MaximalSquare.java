// Time Complexity : O(row*col)
// Space Complexity : O(row*col)
// Did this code successfully run on Leetcode : Yes.
// Any problem you faced while coding this : Nope.


// Your code here along with comments explaining your approach
class MaximalSquare {
    public int maximalSquare(char[][] matrix) {
        if(null == matrix || 0 == matrix.length){return 0;}
        int[][] graph = new int[matrix.length][matrix[0].length];
        int length = 0;
        for(int i = 0; i < graph.length; i++){
            for(int j = 0; j < graph[0].length; j++){
                if(0 == i || 0 == j){
                    if(matrix[i][j] == '0'){
                        graph[i][j] = 0;
                    }else{
                        graph[i][j] = 1;    
                    }
                }else{
                    if(matrix[i][j] == '1'){
                        graph[i][j] = Math.min(graph[i-1][j],Math.min(graph[i][j-1],graph[i-1][j-1])) + 1;
                    }
                }
                length = Math.max(length,graph[i][j]);
            }
        }
    return length*length;
    }
}