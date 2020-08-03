//Brute Force

/**
 * @param {character[][]} matrix
 * @return {number}
 */
var maximalSquare = function(matrix) {
    if(matrix == null || matrix.length == 0) return 0;
    let max = 0;
    let m = matrix.length;
    let n = matrix[0].length;
    let flag = false;
    let curr = 0;
    for(let i = 0; i<m; i++){
        for (let j = 0; j<n; j++){
            if(matrix[i][j] == 1) {
                curr = 1; flag = true;
                while( i + curr < m && j+ curr < n && flag){
                    //navigate on col of diagonal element
                    for( let k = i+curr; k>=i; k--){
                        if(matrix[k][j+curr] == 0){
                            flag = false;
                            break;
                        }
                    }
                    //navigate on row of diagonal element
                    for( let k = j+curr; k>=j; k--){
                            if(matrix[i+curr][k] == 0){
                                flag = false;
                                break;
                            }
                    }
                    
                    if(flag) {
                        curr++;
                    }
                }
                max = Math.max(max,curr);
            }
        }
    }
     return max*max;   
};

//time complexity : O(m2n2);



//Dp Solution

/**
 * @param {character[][]} matrix
 * @return {number}
 */
var maximalSquare = function(matrix) {
    if(matrix == null || matrix.length == 0) return 0;
    var max = 0;
    
    
    //create a dp array
    let dp = new Array(matrix.length+1);
    var m = dp.length;
    
    for(let i = 0; i<m; i++){
        dp[i] = new Array(matrix[0].length+1);
        dp[i][0] = 0;
    }
    
    var n = dp[0].length;
    
    for(let j = 0; j<n; j++){
        dp[0][j] = 0;
    }

    
    for(let i = 1; i<m; i++){
        for (let j = 1; j<n; j++){
            //org col and org row in the 'matrix' is i-1, j-1
            if(matrix[i-1][j-1] == 1){
            dp[i][j] = 1 + Math.min(dp[i-1][j], Math.min(dp[i-1][j-1],dp[i][j-1]));
            max = Math.max(dp[i][j],max);
            } else dp[i][j] = 0;
        }
    }
     return max*max;   
};