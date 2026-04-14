//
//  MaximalSquare.swift
//  DSA-Practice
//
//  Created by Paridhi Malviya on 2/18/26.
//

class MaximalSquare {
    
    init() {
        
    }
    
    //O(mn)^2,
       func maximalSquare(_ matrix: [[Character]]) -> Int {
           let m = matrix.count
           let n = matrix[0].count
           var maxSize = 0
           for i in 0..<m {
               for j in 0..<n {
                   if (matrix[i][j] == "1") {
                       //then start a small square and check, what is the maximum size of the square that can be made. check right and down
                       var size = 1
                       // maxSize = 1
                       var flag = true
                       //right
                       while(i + size < m && j + size < n && flag) {

                           //check the same column till the roof
                           for v in stride(from: (i + size), through: i, by: -1) {
                               if (matrix[v][j+size] == "0") {
                                   flag = false
                                   break
                               }
                           }
                           //check the same row till the left wall
                           for h in stride(from: (j + size), through: j, by: -1) {
                               if (matrix[i+size][h] == "0") {
                                   flag = false
                                   break
                               }
                           }
                           if (flag == true) {
                               size += 1

                           }
                       }
                       maxSize = max(maxSize, size)
                   }
               }
           }
           return maxSize * maxSize
       }
    
    /*
     Bottom up DP -> When we go bottom up, check right, diagonal down and bottom chekcbox value to check the maximum square thta can be made.
     for top down -> check up, left and diagonal left.
     Time complexity -> O(m * n)
     space comlexity -> O(m * n)
     */
        func maximalSquareUsingBottomUpDP(_ matrix: [[Character]]) -> Int {
           var m = matrix.count
           var n = matrix[0].count
           var dp = Array(repeating: Array(repeating: 0, count: n + 1), count: m + 1)
           var maxSize = 0
           for i in stride(from: m-1, through: 0, by: -1) {
               for j in stride(from: n-1, through: 0, by: -1) {
                   if (matrix[i][j] == "1") {
                       dp[i][j] = 1 + min(dp[i][j+1], dp[i+1][j], dp[i+1][j+1])
                       maxSize = max(maxSize, dp[i][j])
                   }
               }
           }
           return maxSize * maxSize
       }
    
    /*
     to reduce space compelxity from O(m*n) to O(n)
     Use 1D array as DP. Whatever element is being processed, takt it into a diagonalDown variable. Because it will act as diagonalDown variable for the next element in loops m-1, n-1.
     If the element which is being processed is 0 then dp[j] will also have 0. because no square can be generated otu of it.
     While calculating the minimum of right, bottom and diagonalDown, you just take d[j+1],dp[j] and diagonalDown variabl respectively.dp[j+1], dp[j] it contains the maximum sized square that can be generated when it is considered as pivot.
     
     */
    
    func maximalSquareUsingBottomUp1DDPArray(_ matrix: [[Character]]) -> Int {

           var m = matrix.count
           var n = matrix[0].count
           var dp = Array(repeating: 0, count: n + 1)
           var maxSize = 0

           for i in stride(from: m-1, through: 0, by: -1) {
               var diagonalDown = 0

               for j in stride(from: n-1, through: 0, by: -1) {
                   var temp = dp[j]
                   if (matrix[i][j] == "1") {
                       dp[j] = 1 + min(dp[j+1], dp[j], diagonalDown)
                       maxSize = max(maxSize, dp[j])
                   } else {
                       dp[j] = 0
                   }
                   diagonalDown = temp
               }
           }
           return maxSize * maxSize
       }
}
