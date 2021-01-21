//Time - O(n^2)
//Space - O(1)
class Solution {
public:
    int maximalSquare(vector<vector<char>>& matrix) {
        
        if(matrix.size() == 0 && matrix[0].size() == 0) return 0;
        
        int size = 0;
        int maxSize = 0;
        for(int i=0;i<matrix.size();i++){
            for(int j=0;j<matrix[i].size();j++){
                if((i==0 || j==0) && matrix[i][j] == '1'){
                    maxSize = 1;
                }
            }
        }
        
        for(int i=1;i<matrix.size();i++){
            for(int j=1;j<matrix[i].size();j++){
                if(matrix[i][j] != '0'){
                    size = min(min(matrix[i-1][j-1]-'0',matrix[i-1][j]-'0'),matrix[i][j-1]-'0')+1;
                    matrix[i][j] = size+'0';
                    maxSize = max(size,maxSize);
                }
            }
        }
        
        return maxSize*maxSize;
        
        
    }
};