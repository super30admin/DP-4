import java.util.Scanner;

public class PartitionArrayMaxSumDP {

        //DYNAMIC PROGRAMMING - O(N*K) TIME AND O(N) SPACE

        public int maxSumAfterPartitioning(int[] arr, int k) {

            // null case
            if(arr == null)        return 0;

            int n = arr.length;

            // dp array
            int[] dp = new int[n];        // O(N) space

            // first element in dp array
            dp[0] = arr[0];

            // build dp array from second element
            for(int i = 1; i < n; i++) {     // O(N)

                // single partition at i value
                int partMax = arr[i];

                // check k partitions at iterator-i while incoming element in partition is valid
                for(int j = 1; j <= k && i-j+1 >= 0; j++) {  // O(K)

                    // update maximum element in partition
                    partMax = Math.max(partMax, arr[i-j+1]);

                    // if valid previous dp value exists
                    if(i-j >= 0) {

                        //Maximum of current dp and partition sum plus previous dp sum
                        dp[i] = Math.max(dp[i], j*partMax + dp[i-j]);
                    }

                    else{
                        // no previous dp sum to add
                        // at i = 2 and k =3 and j =3, i-j+1 = 0, but i-j = 2-3
                        // i.e., valid incoming element in partition, but no valid previous dp sum
                        dp[i] = Math.max(dp[i], j*partMax);
                    }
                }

            }
            // output last element in dp array
            return dp[n-1];
        }

        public static void main(String[] args) {

            PartitionArrayMaxSumDP object = new PartitionArrayMaxSumDP();

            Scanner scanner = new Scanner(System.in);

            System.out.println("n: ");
            int n = scanner.nextInt();

            int[] arr = new int[n];

            System.out.println("array: ");
            for(int i = 0; i < n; i++) {

                arr[i] = scanner.nextInt();
            }

            System.out.println("k : ");
            int k = scanner.nextInt();

            int answer = object.maxSumAfterPartitioning(arr, k);

            System.out.println("The largest sum of the given array after " +
                    "partitioning into (contiguous) sub arrays of length at most k is " + answer);
        }

}

/*
TIME COMPLEXITY = O(N*K)

O(N*K) time for checking k partitions at each element of array

SPACE COMPLEXITY = O(N)

O(N) = dp array space
*/
