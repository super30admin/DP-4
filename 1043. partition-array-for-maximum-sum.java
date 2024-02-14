package DP-4;

public class 1043. partition-array-for-maximum-sum (int[] arr, int k) {
    int n = arr.length;
    int[] dp = new int[n];

    for(int i = 0; i<n; i++){
        int max = arr[i];
        for(int j = 1; j<=k && i-j+1 >=0; j++){
            max = Math.max(max, arr[i-j+1]);
            int currVal = j*max;
            if(i-j >=0){
                currVal = dp[i-j] + j*max;
            }

            dp[i] = Math.max(dp[i], currVal);
        }
    }
return dp[n-1];

    }
}

//Time Complexity: n
//Space Complexity: n