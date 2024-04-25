// Time Complexity : O(m*n)
// Space Complexity : O(1)
// Did this code successfully run on Leetcode : Yes, https://leetcode.com/problems/maximal-square/description/
// Any problem you faced while coding this : No


class Solution {
    public int maximalSquare(char[][] matrix) {
        if(matrix==null || matrix.length==0) return 0;
        int m = matrix.length;
        int n = matrix[0].length;
        int max = 0;
        for(int i=0;i<m;i++){
            for(int j=0;j<n;j++){
                if(matrix[i][j]=='1'){
                    boolean flag = true;
                    int le = 1;
                    while(i+le<m && j+le<n && flag){
                        for(int k=i+le;k>=i;k--){
                            if(matrix[k][j+le]=='0'){
                                flag = false;
                                break;
                            }
                        }
                        for(int k=j+le;k>=j;k--){
                            if(matrix[i+le][k]=='0'){
                                flag = false;
                                break;
                            }
                        }
                        if(flag) le++;
                    }
                    max = Math.max(max,le);
                }
              
            }
        }
        return max*max;
    }
}
