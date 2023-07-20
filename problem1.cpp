/*
// Time Complexity : O(M*N)
// Space Complexity : O(N)
// Did this code successfully run on Leetcode : Yes
// Any problem you faced while coding this :


// Your code here along with comments explaining your approach
if the character is 1 ,check the minimum number of square that are present in the 2x2 neighbour for the element and add 1.
*/

#include<iostream>
#include<vector>

using namespace std;

class Solution {
public:
    int maximalSquare(vector<vector<char>>& matrix) {
        int m = matrix.size();
        int n = matrix.at(0).size();

        //cout<<"m is "<<m<<endl;
        //cout<<"n is "<<n<<endl;

        vector<int> sol(n+1,0);
        int max_val{},diag{},temp{};
        
        for(int i{};i<m;++i){
            diag = 0;
            for(int j{};j<n;++j){
                temp = sol.at(j+1);
                if(matrix.at(i).at(j) == '1'){
                    sol.at(j+1) = min(sol.at(j+1),min(sol.at(j),diag))+1;
                    max_val = max(max_val,sol.at(j+1));
                }
                else{
                    sol.at(j+1) = 0;
                }
                //cout<<sol.at(j+1)<<" ";
                diag = temp;
            }
            //cout<<endl;
        }
        return max_val*max_val;
    }
};