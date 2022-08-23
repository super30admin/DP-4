//Time Complexity: O(2^n), where n is the no. of elements in the array.
//Space Complexity: O(n); Recursion Stack Space
//Code run successfully on LeetCode.

public class Problem2_1 {

    int sumTotal;
    
    public int maxSumAfterPartitioning(int[] arr, int k) {
        
        if(arr == null|| arr.length == 0)
            return -1;
        
        helper(arr,k,0,0);
        return sumTotal;
    }
    
    private void helper(int[] arr, int k, int sum, int index)
    {
        if(index > arr.length)
            return;
        
        else if(index == arr.length)
        {
            sumTotal = Math.max(sumTotal, sum);
            return;
        }
        
        int max = 0;
        for(int i =index; i < index + k; i++)
        {
            if(i < arr.length)
            {
              max = Math.max(max, arr[i]);
              int rsum = sum + max*((i-index)+1);
              helper(arr,k,rsum, i +1);
            }
        }
        
    }
}
