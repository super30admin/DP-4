/*
The time comlexity is O(n*k) and the space complexity is O(n) where n is the length of array A.

The intuition here is to use previous values and see the optimal cut for the present element by going back to presentindex-K elements.

Yes, the solution passed all the test cases in leetcode.
 */
class Solution {
    public int maxSumAfterPartitioning(int[] A, int K) {
        int length = A.length;
        if(length==0){return 0;}

        //Creating an array to store the max sum.
        int[] array = new int[length];

        for(int i=0;i<length;i++){
            int max = 0; int maxseen = A[i];

            //For every i in A we will be iterating from i to i-K to see what all numbers should we include in our subarray
            // that will produce max output. Store the value of max in index i of array.
            for(int j=i;j>i-K && j>=0;j--){

                //This is to get the max value till our present iteration.
                if(A[j]>maxseen){
                    maxseen = A[j];
                }
                //Multiply the max will the length of the subarray.
                int temp = maxseen*(i-j+1);

                //If j-1 is >=0 we should add the previous max.
                if(j-1>=0){
                    temp = temp+array[j-1];
                }
                if(temp>max){
                    max = temp;
                }
            }
            array[i] = max;
        }

        //The answer will be the last value of our array.
        return array[length-1];
    }
}