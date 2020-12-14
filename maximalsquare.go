// Time Complexity : O(mn)
// Space Complexity : O(mn)
// Did this code successfully run on Leetcode : yes
// Any problem you faced while coding this :

// Your code here along with comments explaining your approach
/*
create result martix with int values
set max to 0
loop over each element
if value is 0 ignore
if its first row or column then set max to bigger of max, 1
else
get min element among above column, previous row and diagonally above and previous
set current value to min + 1
if max < curr value set max to current value
return max*max
*/

package main

import (
	"fmt"
	"strconv"
)

func maximalSquare(matrix [][]byte) int {
	m := len(matrix)
	n := len(matrix[0])

	intmat := make([][]int, m)
	for i:=0;i<m;i++ {
		intmat[i] = make([]int, n)
		for j:=0;j<n;j++ {
			intmat[i][j], _ = strconv.Atoi(string(matrix[i][j]))
		}
	}
	max := 0
	for i:=0;i<m;i++ {
		for j:=0;j<n;j++ {
			if intmat[i][j] == 0 {
				continue
			}
			if i == 0 || j == 0 {
				max = fmax(max, 1)
			} else {
				a:= intmat[i-1][j-1]
				b:= intmat[i-1][j]
				c:= intmat[i][j-1]
				d := fmin(a, fmin(b, c)) + 1
				intmat[i][j] = d
				if max < d {
					max = d
				}
			}
		}
	}
	return max * max
}

func fmax(a, b int) int {
	if a > b {
		return a
	}
	return b
}

func fmin(a, b int) int {
	if a < b {
		return a
	}
	return b
}

func MainMaxSquare() {
	fmt.Println(maximalSquare([][]byte{{'1','0','1','0','0'},{'1','0','1','1','1'},{'1','1','1','1','1'},{'1','0','0','1','0'}})) //expected 4
}
