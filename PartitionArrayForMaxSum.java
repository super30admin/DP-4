public class PartitionArrayForMaxSum {
    //we have to make partitions at perfect position
    /*Greedy:
    //we take the maximum at each sub array and multiply with the partiton size
    arr = [1,15,7,9,2,5,10] k=3
    15*3=45
    9*1=9
    10*3=30
    Greedy fails for:
    [15,14,14,1]
    we replace first three elements with 15, 15*3+1 = 46
    but better case could have been 
    15*1+14*3 = 15+42 = 57
    15*2+14*2 = 30+28 = 58
    
    [1,15,10,7,4,9,2]
    15*3 + 9*3 + 2= 74
    max is 15*2+10*3+9*2
    */
    
    /*
    Exaustive approach:
     arr = [1,15,7,9,2,5,10] k=3
     check single partition at 1, sum = 1*1
        single partition at 15, 1 + 15*1, trying to maximize for [15, 7,9,2,5,10]
        double partition at 15, 1 + 15*2, trying to maximize for [7,9,2,5,10]
        ......
     check double partition at 1, sum = 15*2=30:
        single partition at 7, 30 + 7*1, trying to maximize for [9,2,5,10]
        double partition at 7, 30 + 9*2, trying to maximize for [2,5,10]
        ......
     check triple(k=3) partition at 1, sum = 15*3 = 45:
         single partition at 9, 45 + 9*1, trying to maximize for [2,5,10] (repeated subproblem)
        double partition at 9, 45 + 9*2, trying to maximize for [5,10]
        ......
    we are trying to maximize the sum by putting any number of partitions with max number as k
    
    at each level we have k options so time complexity would O(k^n)
    */
    
    
    /*
    DP Solution:
     arr = [1,15,7,9,2,5,10] k=3
    In brute force we were doing top down single partiton at 1, double partition at 1
    In DP , we will do bottom up, if we are at 7, single partition at 7
    double partition will be 15,7
    triple partiton will be 1,15,7
    
    Somewhere down we will be left with smallest subproblem as [1] what is the max we can earn from it
    At 1:
    [1], max sum = 1
    
    At 15, Bottom up: [1,15]
    single partition [15] would return 15*1, remaining element [1]:
     already calculated above for [1] = 1 so 15+1=16
    double partition [1,15] would return 15*2 = 30
    
    so double parttion would be better
    
    
    At 7:
    single partition [7], remianing elements [1,15] we calculated 30 was max sum for [1,15]
    so 7+30 = 37
    double partition, [15,7], remaining element would be [1] (already calculated) so
    15*2+1 = 31
    triple partition, [1,15,7], 15*3 = 45
    */
    //Time Complexity: O(n)
    //Space: O(n)
    public int maxSumAfterPartitioning(int[] arr, int k) {
        if (arr == null || arr.length == 0)
            return 0;
        int n = arr.length;
        int[] dp = new int[n];
        dp[0] = arr[0];
        for (int i = 1; i < n; i++) {
            int max = arr[i];
            for (int j = 1; j <= k && i - j + 1 >= 0; j++) {
                max = Math.max(max, arr[i - j + 1]);
                int currPart = max * j;
                if (i - j >= 0) {
                    currPart = max * j + dp[i - j];
                }

                dp[i] = Math.max(dp[i], currPart);
            }
        }
        return dp[n - 1];
    }
}
