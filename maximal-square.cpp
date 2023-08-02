// Time Complexity : O(mn)
// Space Complexity : O(1)
// Did this code successfully run on Leetcode : Yes

#include <vector>
#include <algorithm>

using namespace std;

class Solution {
public:
    int maximalSquare(std::vector<std::vector<char>>& matrix) {
        int rows = matrix.size();
        if (rows == 0) return 0;

        int curlen = 0;
        int cols = matrix[0].size();
        bool flag = false;
        int maxLen = 0;

        for (int i = 0; i < rows; i++) {
            for (int j = 0; j < cols; j++) {
                if (matrix[i][j] == '1') {
                    curlen = 1;
                    flag = true;

                    while (i + curlen < rows && j + curlen < cols && flag) {
                        for (int k = i; k <= i + curlen; k++) {
                            if (matrix[k][j + curlen] == '0') {
                                flag = false;
                                break;
                            }
                        }

                        for (int k = j; k <= j + curlen; k++) {
                            if (matrix[i + curlen][k] == '0') {
                                flag = false;
                                break;
                            }
                        }

                        if (flag) curlen++;
                    }

                    maxLen = std::max(maxLen, curlen);
                }
            }
        }

        return maxLen * maxLen;
    }
};
