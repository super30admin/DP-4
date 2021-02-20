

// Time Complexity :  in Brute Force method O(mn*mn)=O((mn)^2)
                    //  in DP matrix it is O(m*n)
                    //In DP array it is O(m*n)
// Space Complexity : in Brute Force method O(1)
            //         in DP matrix its o(m*n) m and n being rows and columns
            // in DP array it is O(n) where n is number of columns
// Did this code successfully run on Leetcode :yes
// Did this code successfully run on Local Computer :yes
// Any problem you faced while coding this : no


// Your code here along with comments explaining your approach

//Brute Force Method

// class Solution {
// public:
//     int maximalSquare(vector<vector<char>>& matrix) {
//         //edge
//         if(matrix.empty()) return 0;
//         //logic
//         int gmax=0; //to know th emax size of the square
//         int m=matrix.size();//row
//         int n=matrix[0].size();//column
//         bool flag=false;//if flag is true we found a 1
        
        
//         for(int i=0;i<m;i++){
//             for(int j=0;j<n;j++){//traversing through each element
//                 //check for each 1 how much will be the size by going to next diagonal element and then checking till top and then checking till left
                
//                 if(matrix[i][j]=='1'){
//                     int curr=1;
//                     flag=true;
                    
//                     while(i+curr<m && j+curr<n && flag){
//                         //next diagonal element is matrix[i+curr][j+curr]
//                         // so we check the boundary conditions and go ahead
//                         //traverse through up and left side to check the max square
                        
//                         //checking in the column if there is 1
//                         for(int k=i+curr;k>=i;k--){
//                             if(matrix[k][j+curr]=='0'){
//                                 flag=false;
//                                 break;
//                             }
//                         }
                        
//                         //checking in the row if there is 1
//                         for(int k=j+curr;k>=j;k--){
//                             if(matrix[i+curr][k]=='0'){
//                                 flag=false;
//                                 break;
//                             }
//                         }
//                         if(flag) curr++;
//                     } 
//                     gmax=max(gmax,curr);
//                 }  
//             }
//         }
//         return gmax*gmax;
//     }
// };


// //Using DP

// //using DP matrix 

// class Solution {
// public:
//     int maximalSquare(vector<vector<char>>& matrix) {
//          //edge
//         if(matrix.empty()) return 0;
        
//         int m=matrix.size();//row
//         int n=matrix[0].size();//column
//         int gmax=0;
        
//         vector<vector<int>> dp(m+1,vector<int> (n+1,0));
        
// //         vector<int> a(2,3); //a=[3,3]
        
// //         for(int i = 0; i < a.size(); i++)
// //     {
// //         cout << a[i]<< " ";
// //         cout<< endl;
// //     }
        
        
//     //     for(int i = 0; i < n; i++)
//     // {
//     //     for(int j = 0; j < m; j++)
//     //     {
//     //         cout << dp[i][j] << " ";
//     //     }
//     //     cout<< endl;
//     // }
        
//         // int dp[m+1][n+1]={};
        
//         for(int i=1;i<=m;i++){
//             for(int j=1;j<=n;j++){
//                 if(matrix[i-1][j-1]=='1'){
//                     dp[i][j]=1+min(dp[i-1][j],min(dp[i-1][j-1],dp[i][j-1]));
//                     gmax=max(gmax,dp[i][j]);
//                 }
//             }
//         }
//         return gmax*gmax;
//     }
// };



// //DP
// //Using DP Array

class Solution {
public:
    int maximalSquare(vector<vector<char>>& matrix) {
         //edge
        if(matrix.empty()) return 0;
        
        int m=matrix.size();//row
        int n=matrix[0].size();//column
        int gmax=0;
        
        // vector<vector<int>> dp(m+1,vector<int> (n+1,0));
        vector<int> dp(n+1);
        int prev=0;
        
        for(int i=1;i<=m;i++){
            for(int j=1;j<=n;j++){
                if(matrix[i-1][j-1]=='1'){
                    int temp=dp[j];
                    dp[j]=1+min(dp[j],min(prev,dp[j-1]));
                    gmax=max(gmax,dp[j]);
                    prev=temp;
                }else{
                    dp[j]=0;
                }
            }
        }
        return gmax*gmax;
    }
};





