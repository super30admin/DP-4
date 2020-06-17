// Time Complexity : O(n^2); n - number of elements in the matrix
// Space Complexity : O(1)
// Did this code successfully run on Leetcode : Yes
// Any problem you faced while coding this : Yes. Checking if the diagonal element is '1' throws 'Time Limit Exceeded' exception.


// Your code here along with comments explaining your approach
/*
	1. Find '1's in the matrix
	2. Determine the diagonal element (Don't check if the diagonal element is '1')
	3. Check both row and colums from the diagonal element, for '0's. If '0' not found, increase the counter,
		will be reset to 1 at once we find '1' in Step1.
	4. Repeat Step2 and Step3 untill a '0' is found. Keep track of Maximum (max) of counter at each Step1.
	5. Return max*max
*/



class MaximalSquare {
	//Brute force Approach
	public int maximalSquare(char[][] matrix) {
		//edge
		if(matrix == null || matrix.length == 0)
			return 0;
		
		int m = matrix.length;
		int n = matrix[0].length;
		boolean flag = false;
		int maxSquare = 0;
		int count = 1;
		
		for(int i = 0; i < m; i++) {
			for(int j = 0; j < n; j++) {
				if(matrix[i][j] == '1') {
					count = 1;
					flag = true;
					while(i+count < m && j+count < n && flag) {
							
						//row check
						for(int k=j+count; k >= j; k--) {
							if(matrix[i+count][k] != '1') {
								flag = false;
								break;
							}
						}

						//col check
						for(int k=i+count; k >= i; k--) {
							if(matrix[k][j+count] != '1') {
								flag = false;
								break;
							}
						}

						//increase count if all 1's
						if(flag)
							count++;
						
					}
					maxSquare = Math.max(maxSquare, count);
				}
			}
		}
		return maxSquare*maxSquare;
	}
}


