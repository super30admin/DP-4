/*time complexity O((mn)^2)
space complexity O(1) 
approach: when we encounter a first 1 we check all the elements from column+current value to column value and same with rows
if at any place we find 0 break from that and restart from next element*/

class Solution {
    public int maximalSquare(char[][] matrix) {
        if(matrix==null|| matrix.length==0) return 0;
        int m=matrix.length;
        int n=matrix[0].length;
        int max=0;
        boolean flag=false;
        for(int i=0;i<m;i++){
            for(int j=0;j<n;j++){
                if(matrix[i][j]=='1'){
                    flag=true;
                    int curr=1;
                while(i+curr<m && j+curr<n && flag){
                    for(int k=i+curr;k >= i;k--){
                        if(matrix[k][j+curr]=='0'){
                            flag=false;
                            break;
                        }
                    }
                    for(int k=j+curr;k >= j;k--){
                        if(matrix[i+curr][k]=='0'){
                            flag=false;
                            break;
                        }
                    }
                    if(flag)curr++;
                }
                max=Math.max(max,curr);
                System.out.println(curr);
                }
            }
        }
        return max*max;
        
    }
}