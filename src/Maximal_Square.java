import java.util.*;
/********************************** Using Dynamic Programing *********************************/
// Time Complexity : O(m * n), m and n are rows and col, single pass
// Space Complexity : O(m * n), dp matrix of same size used
// Did this code successfully run on Leetcode : Yes
// Any problem you faced while coding this : No

/**Initialize dp matrix with the same dimensions as the original one initialized with all 0’s
 * Starting from index (0,0), for every 1 found in the original matrix, we update the value of the current element as
 * dp[i][j] = 1 + Math.min(dp[i-1][j], Math.min(dp[i][j-1], dp[i-1][j-1]));
 * We store the max found so far. In this way, we traverse the original matrix once and find out the required maximum size. 
 * This gives the side length of the square, The required result is the area max * max **/

class Maximal_Square {
	public int maximalSquare(char[][] matrix) {
		if(matrix == null || matrix.length == 0)
			return 0;
		int[][] dp = new int[matrix.length + 1][matrix[0].length + 1];  // extra row and col, because dp matrix first row and col will be filled with zero
		int max = Integer.MIN_VALUE;
		//process all elements of matrix
		for(int i=1; i<=matrix.length; i++){
			for(int j=1; j<=matrix[0].length; j++){
				if(matrix[i-1][j-1] == '1'){    //if the original array value has 1
					dp[i][j] = 1 + Math.min(dp[i-1][j], Math.min(dp[i][j-1], dp[i-1][j-1]));
					if(max < dp[i][j])
						max = dp[i][j]; //updating the max value
				}
			}
		}
		return max * max;
	}
}


/**********************************Brute force *********************************/
//Time Complexity : O(m * n)^2, m and n are rows and col
//Space Complexity : O(1)
//Did this code successfully run on Leetcode : Yes
//Any problem you faced while coding this : No

class Solution {
	public int maximalSquare(char[][] matrix) {
		if(matrix == null || matrix.length == 0)
			return 0;
		boolean flag;
		int max = 0;
		for(int i=0; i<matrix.length; i++){
			for(int j=0;j<matrix[0].length; j++){
				if(matrix[i][j] == '1'){
					int curr = 1;
					flag = true;

					while(i+curr < matrix.length && j+curr < matrix[0].length && flag){ // boundary check and flag should be true
						for(int k=i+curr; k>=i; k--){    // check all values above the point till i
							if(matrix[k][j+curr] == '0')
								flag = false;
						}
						for(int k=j+curr; k>=j; k--){    // check all values above the point till j
							if(matrix[i+curr][k] == '0')
								flag = false;
						}
						if(flag)
							curr++; // increase curr as it will give size of square and update curr for  next square size check
					} 
					max = Math.max(max, curr);
				}
			}
		}
		return max * max;
	}
}


/**********************************Maximal Rectangle*********************************/
//Time Complexity : O(m * n), m and n are rows and col
//Space Complexity : O(n)
//Did this code successfully run on Leetcode : Yes
//Any problem you faced while coding this : No


class Maximal_Rectangle {
	public int maximalRectangle(char[][] matrix) {
		//edge case
		if(matrix == null || matrix.length == 0)
			return 0;

		int max = 0;        
		int[] height = new int[matrix[0].length];
		for(int i=0; i<matrix.length; i++){
			for(int j=0; j<matrix[0].length; j++){
				if(matrix[i][j] == '0'){    //if it's zero, then retain same
					height[j] = 0;
				}
				else{
					height[j] += 1; //else increment height by 1
				}
			}
			max = Math.max(max, findArea(height));
		}
		return max;        
	}

	private int findArea(int[] height){
		int max = 0;
		Stack<Integer> stack = new Stack<>();
		stack.add(0);   //add index of first element
		for(int i=1; i<height.length; i++){
			int curr = height[i];   //current element

			if(stack.isEmpty() || curr >= height[stack.peek()]){    //if stack is empty, or curr element is greater than element at top of stack
				stack.add(i);
			}
			else{   // keep popping till stack is not empty and current element is less than element at top of stack
				while(!stack.isEmpty() && curr < height[stack.peek()]){
					int temp = height[stack.pop()];
					if(stack.isEmpty()){
						max = Math.max(max, temp * i);
					}
					else{
						max = Math.max(max, temp * (i - stack.peek()-1));
					}
				}

				stack.add(i);

			}
		}
		if(!stack.isEmpty()){
			while(!stack.isEmpty()){
				int  i = height.length;
				int temp = height[stack.pop()];
				if(stack.isEmpty()){
					max = Math.max(max, temp * i);
				}
				else{
					max = Math.max(max, temp * (i - stack.peek()-1));
				}
			}
		}
		return max;
	}
}