import { number } from "yargs";

function orderOfLargestPlusSign(n: number, mines: number[][]): number {
  if (n == 1) {
    return 0;
  }

  let matrix: number[][] = Array.from({ length: n }, () => Array(n).fill(1));
  let leftDp: number[][] = Array.from({ length: n }, () => Array(n).fill(-1));
  let rightDp: number[][] = Array.from({ length: n }, () => Array(n).fill(-1));
  let topDp: number[][] = Array.from({ length: n }, () => Array(n).fill(-1));
  let downDp: number[][] = Array.from({ length: n }, () => Array(n).fill(-1));

  function getLeftCount(row: number, col: number) {
    if (leftDp[row][col] != -1) return leftDp[row][col];

    let left: number = 0;
    for (let i = col - 1; i >= 0; i--) {
      if (matrix[row][i] == 0) break;
      left++;
    }
    return left;
  }

  function getRightCount(row: number, col: number) {
    if (rightDp[row][col] != -1) return rightDp[row][col];

    let right: number = 0;
    for (let i = col + 1; i < n; i++) {
      if (matrix[row][i] == 0) break;
      right++;
    }
    return right;
  }

  function getTopCount(row: number, col: number) {
    if (topDp[row][col] != -1) return rightDp[row][col];

    let top: number = 0;
    for (let i = row - 1; i >= 0; i--) {
      if (matrix[i][col] == 0) break;
      top++;
    }
    return top;
  }

  function getBottomCount(row: number, col: number) {
    if (topDp[row][col] != -1) return rightDp[row][col];

    let bottom: number = 0;
    for (let i = row + 1; i < n; i++) {
      if (matrix[i][col] == 0) break;
      bottom++;
    }
    return bottom;
  }

  for (let i = 0; i < mines.length; i++) {
    let row = mines[i][0];
    let col = mines[i][1];
    matrix[row][col] = 0;
    leftDp[row][col] = 0;
    rightDp[row][col] = 0;
    topDp[row][col] = 0;
    downDp[row][col] = 0;
  }

  let max = 0;

  for (let row = 0; row < n; row++) {
    for (let col = 0; col < n; col++) {
      if (matrix[row][col] == 1) {
        // Check left
        let left: number = getLeftCount(row, col);
        let right: number = getRightCount(row, col);
        let top: number = getTopCount(row, col);
        let bottom: number = getBottomCount(row, col);
        let cellMax = Math.min(top, bottom, left, right);
        max = Math.max(cellMax + 1, max);
      }
    }
  }

  return max;
}

describe("85. Maximal Rectangle", () => {
  it("Happy Path", () => {
    expect(orderOfLargestPlusSign(5, [[4, 2]])).toStrictEqual(2);
  });

  it("Negative", () => {
    expect(
      orderOfLargestPlusSign(2, [
        [0, 0],
        [0, 1],
        [1, 0],
      ])
    ).toStrictEqual(1);
  });

  it("Negative Input", () => {
    expect(orderOfLargestPlusSign(1, [])).toStrictEqual(0);
  });
});
