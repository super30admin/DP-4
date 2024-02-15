class Solution {
    public int maxSumAfterPartitioning(int[] arr, int k) {

        int[] res = new int[arr.length];

        for(int i = 0; i < arr.length; i++){
            int max = Integer.MIN_VALUE;
            int total = Integer.MIN_VALUE;
            for(int j = i; j >= 0 && i-j < k; j--){
                max = Math.max(arr[j], max);
                int me = ((1+i)- j)*max + (j > 0 ? res[j-1] : 0);
                total = Math.max(total, me);
            }
            res[i] = total;
        }

        //for(int num : res) System.out.print(num + "\t");

        return res[res.length-1];
        
    }
}
