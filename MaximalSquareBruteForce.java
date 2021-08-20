//T.C: O(MN)^2
//S.C: O(1)
class Solution {
    public int maximalSquare(char[][] matrix) {

        if(matrix == null || matrix.length==0){
            return 0;
        }
        int m=matrix.length;
        int n=matrix[0].length;
        int curr=0;
        int max = 0;
        for(int i=0;i<m;i++){
            for(int j=0;j<n;j++) {
                boolean flag=false;
                if(matrix[i][j] == '1'){
                    flag= true;
                    curr=1;
                    while(i+curr<m && j+curr<n && flag) {
                        //row check
                        for(int k = j+curr; k>=j ;k--) {
                            if(matrix[i+curr][k] == '0') {
                                flag = false;
                                break;
                            }
                        }

                        //col check
                        for(int k = i+curr; k>=i ;k--) {
                            if(matrix[k][j+curr] == '0') {
                                flag = false;
                                break;
                            }
                        }

                        if(flag)
                            curr++;
                    }
                }
                max= Math.max(max,curr);

            }
        }
        return max*max;
    }
}