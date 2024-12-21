function solve(board: string[][]): string[][] {
  let direction: number[][] = [
    [-1, 0], // Top
    [0, 1], // Right
    [1, 0], // Bottom
    [0, -1], // Left
  ];

  function dfs(row: number, col: number): boolean {
    let flag = true;
    for (let i = 0; i < direction.length; i++) {
      let newRow = row + direction[i][0];
      let newCol = col + direction[i][1];
      if (
        flag &&
        newRow >= 0 &&
        newRow < board.length &&
        newCol >= 0 &&
        newCol < board[newRow].length
      ) {
        if (board[newRow][newCol] == "X" || board[newRow][newCol] == "-O") {
          continue;
        } else if (board[newRow][newCol] == "+O") {
          flag = false;
          break;
        } else {
          board[row][col] = "-O";
          flag = dfs(newRow, newCol);
          if (flag == false) {
            break;
          }
        }
      } else {
        flag = false;
        break;
      }
    }
    board[row][col] = flag ? "X" : "+O";

    return flag;
  }

  for (let i = 0; i < board.length; i++) {
    for (let j = 0; j < board[i].length; j++) {
      if (board[i][j] == "O") {
        dfs(i, j);
      }
    }
  }

  for (let i = 0; i < board.length; i++) {
    for (let j = 0; j < board[i].length; j++) {
      if (board[i][j] == "+O") {
        board[i][j] = "O";
      }
    }
  }
  console.log(board);
  return board;
}

describe("130. Surrounded Regions", () => {
  it("Happy Path", () => {
    expect(
      solve([
        ["X", "X", "X", "X"],
        ["X", "O", "O", "X"],
        ["X", "X", "O", "X"],
        ["X", "O", "X", "X"],
      ])
    ).toStrictEqual([
      ["X", "X", "X", "X"],
      ["X", "X", "X", "X"],
      ["X", "X", "X", "X"],
      ["X", "O", "X", "X"],
    ]);
  });

  it("Failing TestCase 01", () => {
    expect(
      solve([
        ["O", "X", "X", "O", "X"],
        ["X", "O", "O", "X", "O"],
        ["X", "O", "X", "O", "X"],
        ["O", "X", "O", "O", "O"],
        ["X", "X", "O", "X", "O"],
      ])
    ).toStrictEqual([
      ["O", "X", "X", "O", "X"],
      ["X", "X", "X", "X", "O"],
      ["X", "X", "X", "O", "X"],
      ["O", "X", "O", "O", "O"],
      ["X", "X", "O", "X", "O"],
    ]);
  });

  it("Failing TestCase 02", () => {
    expect(
      solve([
        ["O", "X", "O", "O", "O", "X"],
        ["O", "O", "X", "X", "X", "O"],
        ["X", "X", "X", "X", "X", "O"],
        ["O", "O", "O", "O", "X", "X"],
        ["X", "X", "O", "O", "X", "O"],
        ["O", "O", "X", "X", "X", "X"],
      ])
    ).toStrictEqual([
      ["O", "X", "O", "O", "O", "X"],
      ["O", "O", "X", "X", "X", "O"],
      ["X", "X", "X", "X", "X", "O"],
      ["O", "O", "O", "O", "X", "X"],
      ["X", "X", "O", "O", "X", "O"],
      ["O", "O", "X", "X", "X", "X"],
    ]);
  });
});
