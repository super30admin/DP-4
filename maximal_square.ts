function maximalSquare_brute_force(matrix: string[][]): number {
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

function maximalSquare(matrix: string[][]): number {
  let rows = matrix.length;
  let cols = matrix[0].length;
  let max = 0;
  let dp: number[][] = Array.from({ length: rows + 1 }, () =>
    Array(cols + 1).fill(0)
  );

  for (let i = 1; i <= rows; i++) {
    for (let j = 1; j <= cols; j++) {
      if (matrix[i - 1][j - 1] == "1") {
        let left: number = dp[i][j - 1];
        let top: number = dp[i - 1][j];
        let diagonalTop: number = dp[i - 1][j - 1];
        let min = 1 + Math.min(left, top, diagonalTop);
        dp[i][j] = min;
        max = Math.max(max, min);
      } else {
        dp[i][j] = 0;
      }
    }
  }

  console.log(dp);

  return max * max;
}

describe("221. Maximal Square", () => {
  it("Happy Path", () => {
    expect(
      maximalSquare([
        ["0", "1", "1", "1", "1", "1"],
        ["0", "1", "1", "1", "1", "1"],
        ["1", "0", "1", "1", "1", "1"],
        ["1", "0", "1", "1", "1", "1"],
      ])
    ).toStrictEqual(16);
  });
});
