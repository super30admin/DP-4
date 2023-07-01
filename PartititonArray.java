// tc: O(n*k)
// sc : O(n)

class Solution {
    int[] arr;
    int[] memo;
    int k ;
    int size;
    public int maxSumAfterPartitioning(int[] arr, int k) {
        this.arr= arr;
        this.size = arr.length;
        this.memo = new int[size+1];
        Arrays.fill(memo,-1);
        this.k = k ;
        return helper(0);
    }

    public int helper(int ind){
        //base case 
        if(ind == size) return 0;
        //logic
        int curr = arr[ind];
        for(int i = ind ; i < Math.min(size, ind + k) ; i++){
            curr = Math.max(curr, arr[i]);
            if(memo[i+1]==-1) memo[i+1]=helper(i+1);
            memo[ind] = Math.max(memo[ind], memo[i+1]+curr*(i-ind+1));
        }
        return memo[ind]; 
    }
}
