class Solution {
public:
    int maximalSquare(vector<vector<char>>& matrix) {
        if(matrix.empty())
            return 0;
        int m=matrix.size(),n=matrix[0].size(),maximum=0;
        bool flag;
        for(int i=0;i<m;i++)
            for(int j=0;j<n;j++)
            {
                if(matrix[i][j]=='1')
                {
                    int curr=1;
                    flag=true;
                    while(i+curr<m && j+curr<n && flag==true)
                    {
                        for(int k=i+curr;k>=i;k--)
                        {
                            if(matrix[k][j+curr]=='0')
                            {
                                flag=false;
                                break;
                            }
                        }
                        for(int k=j+curr;k>=j;k--)
                        {
                            if(matrix[i+curr][k]=='0')
                            {
                                flag=false;
                                break;
                            }
                        }
                        if(flag==true)
                            curr++;                            
                    }
                    maximum=max(maximum,curr);
                }
            }
        return maximum*maximum;
    }
        /*if(matrix.empty())
            return 0;
        int maximum=0,m=matrix.size(),n=matrix[0].size();
        int dp[m+1][n+1];
        for(int i=0;i<m+1;i++)
            for(int j=0;j<n+1;j++)
                dp[i][j]=0;
        for(int i=1;i<m+1;i++)
            for(int j=1;j<n+1;j++)
            {
                if(matrix[i-1][j-1]=='1')
                {
                    dp[i][j]=1+min(dp[i-1][j-1],min(dp[i-1][j],dp[i][j-1]));
                    maximum=max(maximum,dp[i][j]);
                }
            }
        return maximum*maximum;
    }*/
};