function maximalRectangleBruteForce(matrix: string[][]): number {
  let max = 0;
  let rows = matrix.length;
  let cols = matrix[0].length;

  for (let i = 0; i < matrix.length; i++) {
    for (let j = 0; j < matrix[i].length; j++) {
      if (matrix[i][j] == "1") {
        let level = 1;
        let flag: boolean = true;
        while (flag && i + level < rows && j + level < cols) {
          let diagonalRow = i + level;
          let diagonalCol = j + level;
          if (matrix[diagonalRow][diagonalCol] == "1") {
            // check left
            for (let col = diagonalCol - 1; col >= j; col--) {
              if (matrix[diagonalRow][col] != "1") {
                flag = false;
                break;
              }
            }
            // check top
            if (flag) {
              for (let row = diagonalRow - 1; row >= i; row--) {
                if (matrix[row][diagonalCol] != "1") {
                  flag = false;
                  break;
                }
              }
            }
          } else {
            flag = false;
          }
          if (flag == true) {
            level++;
          } else {
            break;
          }
        }
        max = Math.max(max, level);
      }
    }
  }

  return max * max;
}

describe("85. Maximal Rectangle", () => {
  it("Happy Path", () => {
    expect(
      maximalRectangleBruteForce([
        ["1", "0", "1", "0", "0"],
        ["1", "0", "1", "1", "1"],
        ["1", "1", "1", "1", "1"],
        ["1", "0", "0", "1", "0"],
      ])
    ).toStrictEqual(16);
  });
});
