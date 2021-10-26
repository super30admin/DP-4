/*
Time Complexity = O(m*n)^2
Space Complexity = O(1)
where m is the number of rows and n is the number of coloumns in the matrix. 
*/
class Solution {
public:
    long maximalSquare(vector<vector<char>>& matrix) {
        int m = matrix.size();
        int n = matrix[0].size();
        int i,j,k,maxi=INT_MIN,curr;
        for(i=0;i<m;i++)
        {
            for(j=0;j<n;j++)
            {
                if(matrix[i][j]=='1')
                {
                    bool valid = true;
                    curr = 1;
                    while(i+curr<m && j+curr<n){
                    //check upward directions
                    for(k = i+curr; k>=i;k--)
                    {
                        if(matrix[k][j+curr]=='0')
                        {
                            valid = false;
                            break;
                        }
                    }
                    if(!valid)  break;
                    //check downward directions
                    for(k = j+curr; k>=j;k--)
                    {
                        if(matrix[i+curr][k]=='0')
                        {
                            valid = false;
                            break;
                        }
                    }
                    if(!valid)  break;
                    curr++;
                }
                maxi = max(maxi,curr);
                }
            }
        }
        return (long)maxi*maxi;
    }
};


/*
Time Complexity = O(m*n)
Space Complexity = O(m*n)
where m is the number of rows and n is the number of coloumns in the matrix. 
*/
class Solution {
public:
    long maximalSquare(vector<vector<char>>& matrix) {
        int m = matrix.size();
        int n = matrix[0].size();
        int i,j,maxi = INT_MIN;
        int dp[m+1][n+1];
        //initializing the first coloumn to be 0.
        for(i=0;i<=m;i++)
            dp[i][0] = 0;
        //initializing the first row to be 0;
        for(i=0;i<=n;i++)
            dp[0][i] = 0;
        for(i=1;i<=m;i++)
        {
            for(j=1;j<=n;j++)
            {
                if(matrix[i-1][j-1]=='1')
                    dp[i][j] = min(dp[i-1][j-1], min(dp[i-1][j],dp[i][j-1]))+1;
                else
                    dp[i][j]=0;
                maxi=max(maxi,dp[i][j]);
            }
        }
        return maxi*maxi;
    }
};
/*
Time Complexity = O(m*n)
Space Complexity = O(n)
where m is the number of rows and n is the number of coloumns in the matrix. 
*/
class Solution {
public:
    long maximalSquare(vector<vector<char>>& matrix) {
        int m = matrix.size();
        int n = matrix[0].size();
        int i,j,maxi = INT_MIN,temp=0,prev=0;
        int dp[n+1];
        //initializing the first row to be 0;
        for(i=0;i<=n;i++)
            dp[i] = 0;
        for(i=1;i<=m;i++)
        {
            for(j=1;j<=n;j++)
            {
                temp = dp[j];
                if(matrix[i-1][j-1]=='1')
                    dp[j] = min(prev, min(dp[j],dp[j-1]))+1;
                else
                    dp[j]=0;
                maxi=max(maxi,dp[j]);
                prev = temp;
            }
        }
        return maxi*maxi;
    }
};
