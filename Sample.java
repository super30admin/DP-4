//Problem 1 - > Maximal Square
// Time Complexity : O(mn)
// Space Complexity : O(n)
// Did this code successfully run on Leetcode : yes
// Any problem you faced while coding this : no


// Your code here along with comments explaining your approach
//for any given cell, take minimum of up,diag,left cell values and add 1 to it. that will be maximum square that can be made
class Solution {
    public int maximalSquare(char[][] matrix) {
        
        int m=matrix.length;
        int n=matrix[0].length;
        int max=0;

        // for(int i=0;i<m;i++){
        //     for(int j=0;j<n;j++){
        //         if(matrix[i][j]=='1'){
        //             //find maximalSquare
        //             int squarelength=1;
        //             boolean flag =true;
        //             while(flag && i+squarelength<m && j+squarelength<n){ //until it doesnt go out of bounds

        //                 for(int k=i+squarelength;k>=i;k--){
        //                     if(matrix[k][j+squarelength]=='0'){
        //                         flag=false;
        //                         break;
        //                     } 
        //                 }

        //                 for(int k=j+squarelength;k>=j;k--){
        //                     if(matrix[i+squarelength][k]=='0'){
        //                         flag=false;
        //                         break;
        //                     }
        //                 }

        //                 if(flag) squarelength++;
        //             }
        //             max= Math.max(max,squarelength);
        //         }
        //     }
        // }
        // return max*max;

        //DP solution
        //m*n //m*n
        // int[][] dp=new int[m+1][n+1];
        //  for(int i=1;i<=m;i++){
        //     for(int j=1;j<=n;j++){
        //         if(matrix[i-1][j-1]=='1'){//start calculating squares
        //             int up=dp[i-1][j];
        //             int left= dp[i][j-1];
        //             int diag= dp[i-1][j-1];
        //             dp[i][j]=1+Math.min(up, Math.min(left, diag));
        //             max=Math.max(dp[i][j],max);
        //         }
        //     }
        //  }

        //mn n
        int[] dp=new int[n+1];
         for(int i=1;i<=m;i++){
             int diagUp=0;
            for(int j=1;j<=n;j++){
                int temp=dp[j];
                if(matrix[i-1][j-1]=='1'){//start calculating squares
                    dp[j]=1+Math.min(dp[j], Math.min(dp[j-1], diagUp));
                    max=Math.max(dp[j],max);
                }else{
                    dp[j]=0;
                }
                diagUp=temp;
            }
         }

         return max*max;
    }
}

//Problem 2 - > Partitioning Array for Maximum Sum
// Time Complexity : O(nk)
// Space Complexity : O(n)
// Did this code successfully run on Leetcode :yes
// Any problem you faced while coding this :no


// Your code here along with comments explaining your approach
//check for all possible partitions and take maximum between them. at the end, we will get maximum answer.
//O(nk)
class Solution {
    public int maxSumAfterPartitioning(int[] arr, int k) {
        int n= arr.length;
        int[] dp=new int[n];
        dp[0]=arr[0];
        for(int i=1;i<n;i++){
            int curmax=arr[i];
            for(int j=1;j<=k && i+1-j>=0;j++){ //number of partitions
                curmax=Math.max(curmax, arr[i+1-j]);
                if(i-j >= 0)
                    dp[i]=Math.max(dp[i],j*curmax + dp[i-j]);
                else
                    dp[i]=Math.max(dp[i],j*curmax);
            }
        }
        return dp[n-1];
    }
}