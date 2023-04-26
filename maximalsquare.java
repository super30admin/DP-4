class Solution {
    public int maximalSquare(char[][] matrix) {
        //brute force solution willl be to loop through each element and for each element increase k by one and check if all are one's in that row and column, TC-O(m2n2)
        //optimal solution
        // find top,left and diagnol elements that represent max square that can be formed with that element as bottom right element of max matrix that can be formed and take min of all of them + 1
        //TC-O(mn), SC-O(mn)
        //WHENEVER WE LOOK FOR MAXIMAL THINGS IN A MATRIX, LOOK FOR SURROUNDING ELEMENTS
        int m = matrix.length;
        int n =matrix[0].length;
        int[][] dp = new int[m+1][n+1];
        int ans =0 ;
        for(int i =1;i<=m;i++){
            for(int j =1;j<=n;j++){
                if(matrix[i-1][j-1]=='1'){
                    // find min 
                    dp[i][j]=Math.min(dp[i-1][j],Math.min(dp[i-1][j-1],dp[i][j-1]))+1;
                    ans=Math.max(ans,dp[i][j]);
                }
            }
        }
        return ans*ans;

    }

        
}