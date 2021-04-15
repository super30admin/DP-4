//TC: O(n*m)
//SC: O(arr.length)
class Solution {
    public int maxSumAfterPartitioning(int[] arr, int k) {
        if(arr.length==0)
            return 0;
        int n = arr.length;
        int[] dp = new int[n];
        
        for(int i=0;i<n;i++)
        {
            int max = Integer.MIN_VALUE;    //Based on the k range traversing, the elements maximum value is taken gets the sum with the length of elements traversed back.
            for(int j=0;j<k;j++)        //Keeping the maximum value at each index in a dynamic array.
            {                           //Repeating the same process untill you reach the last element.
                int x = i-j;            //And last element will be the maximum of the atmost k-range partition array for maximum sum. 
                if(x<0)
                    break;
                else
                {
                    max= Math.max(arr[x],max);                    
                    if(x-1<0)
                        dp[i] = Math.max(dp[i],max*(j+1));
                    else
                        dp[i] = Math.max(dp[i],dp[x-1]+max*(j+1));
                }
            }
        }
        
        return dp[n-1];
    }
}