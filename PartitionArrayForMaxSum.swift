//
//  PartitionArrayForMaxSum.swift
//  DSA-Practice
//
//  Created by Paridhi Malviya on 2/18/26.
//

/*
 Recursion - - K^n
 when using dp -> nk. For every wlement, considering k partitions for n elements. We optimized recursive pattern here.
 DP solution doesn't need to have recursive solution. If any problem have repeated subproblems, we can use DP to optimize it.
 */


class PartitionArrayForMaximumSum {
    
    //Recursion - - K^n
    func maxSumAfterPartitioningUsingRecursion(_ arr: [Int], _ k: Int) -> Int {
        return helperR(arr: arr, k: k, i: 0)
    }

    func helperR(arr: [Int], k: Int, i: Int) -> Int {
        //base case
        if (i >= arr.count) {
            return 0
        }

        //logic for loop based recursion. j - partition
        var maximumSum = 0
        var maxInCurrentPartition = arr[i]
        for j in 1...k {
            if (i+j-1 < arr.count) {
                maxInCurrentPartition = max(maxInCurrentPartition, arr[i + j - 1]) //this is the max no in the partition
                //maximum sum for the partition would be max number in the partition and the length of the partition.
                let maxValue = maxInCurrentPartition * j + helperR(arr: arr, k: k, i: i + j)
                maximumSum = max(maximumSum, maxValue)
            }
        }
        return maximumSum
    }

    //time complexity - O(nk), space complexity -> O(n)
    func maxSumAfterPartitioning(_ arr: [Int], _ k: Int) -> Int {
        //tabulation

        let n = arr.count
        var dp = Array(repeating: 0, count: n)
        dp[0] = arr[0]
        for i in 1..<n {
            var maxNumInMyCurrentPartition = arr[i]

            //to have different partitions
            for j in 1...k {
                if (i - j + 1 >= 0) {
                    maxNumInMyCurrentPartition = max(maxNumInMyCurrentPartition, arr[i - j + 1]) //i - j + 1 will be -1 for 1 index and 3rd partition
                    var maxSumInPartition = j * maxNumInMyCurrentPartition
                    if (i - j >= 0) {
                        maxSumInPartition = maxSumInPartition + dp[i - j]
                    } else {
                    //since it goes out of bounds at the start of the array, so add 0. No need to this statement at all.
                        maxSumInPartition += 0
                    }
                    dp[i] = max(dp[i], maxSumInPartition)
                }
            }
        }
        return dp[n - 1]

    }
}
