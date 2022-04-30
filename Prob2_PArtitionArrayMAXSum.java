//TC : O(N*K)
//SC : O(N) // Optimal solution for space can be done if we maintain array of only 3 values 

class Solution {
    public int maxSumAfterPartitioning(int[] arr, int k) {
        int[] result = new int[arr.length];
        result[0] = arr[0];
        
        for(int i = 1; i< result.length; i++){
            int currMax = arr[i];
            
            for(int j = i; j >= i-k+1 && j >= 0; j--){ // Check for atmost K partitions 
                currMax = Math.max(arr[j], currMax);
                if(j-1 >= 0){ // Will compute the sum by multiplying currrMax wil partition length and Sum of rest of the partition (Elements) with size atmost K
                    result[i] = Math.max(result[i], currMax * (i - j + 1) + result[j-1]);
                }else{ // If we reach at index out of bound while partitioning, We will just multiply currrMax with partition length only 
                    result[i] = Math.max(result[i], currMax * (i - j + 1) );                    
                }
            }
        }
        return result[result.length - 1];
    }
}