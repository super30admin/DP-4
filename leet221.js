TC - O(i*j)

SC - O(i*j)
var maximalSquare = function(matrix) {
    let maxSize = 0;
    for (let i = 0; i < matrix.length; i++) {
        for (let j = 0; j < matrix[0].length; j++) {
			
            matrix[i][j] = matrix[i][j] - 0
			if (!maxSize && matrix[i][j]) maxSize = 1;
			
			
            if (i - 1 >= 0 && j - 1 >= 0 && matrix[i][j] === 1) {
                matrix[i][j] = Math.min(matrix[i - 1][j], matrix[i][j-1], matrix[i-1][j-1]) + 1;
				maxSize = Math.max(maxSize, matrix[i][j])
            }
        }
    }
	
    return (maxSize) ** 2;
}