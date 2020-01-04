/*


https://leetcode.com/problems/partition-array-for-maximum-sum/

Time Complexity: 0(N2)
Space Complexity: 0(N2)


Algorithm:

Problem asks for to partition array in some parts (each partition of length at most K) such that replace each element in partition by max element in that partition then total sum should be maximised.

For K = 1, trivial solution to consider each element as one partition then max sum = Sum of all elements
For K = 2, check for previous k - 1 elements i.e. previous 1 element.
Then decide between whether or not increase size of partition
e.g. For each two elements, Max of (2 * max element, sum of each element with k - 1)
For K = 3, check for previous k - 1 elements i.e. previous 2 elements.
e.g. For each three elements, Max of (3 * max element, earlier result of partition of size 2 of first two or last two elements + remaining element)

From pattern we have overlapping subproblem of computation of parition of size of k - 1 and optimal substructure (finding max sum), this calls for dyanamic programming.


*/




class Solution {
    public int maxSumAfterPartitioning(int[] A, int K) {
       
        
        int[] d = new int[A.length];

            for (int i = 0; i < A.length; i++)
            {
                int partitionMax = 0;
                for (int k = 1; k <= K && (k - 1) <= i; k++)
                {
                    partitionMax = Math.max(partitionMax, A[i - (k - 1)]);
                    d[i] = Math.max(d[i], (i >= k ? d[i - k] : 0) + k * partitionMax);
                }
            }

            return d[A.length - 1];
        
        
    }
}