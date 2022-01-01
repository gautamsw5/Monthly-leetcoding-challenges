def canPlace(board, i, j, x):
    for k in range(9):
        if board[i][k]==x:
            return False
        elif board[k][j]==x:
            return False
        elif board[i-i%3+k//3][j-j%3+k%3]==x:
            return False
    return True
def solve(board, arr, i):
    if i==len(arr):
        return True
    for n in range(1,10):
        if canPlace(board, arr[i][0], arr[i][1], str(n)):
            board[arr[i][0]][arr[i][1]] = str(n)
            if solve(board, arr, i+1):
                return True
            board[arr[i][0]][arr[i][1]] = "."
    return False
class Solution:
    def solveSudoku(self, board: List[List[str]]) -> None:
        arr = []
        for i in range(9):
            for j in range(9):
                if board[i][j] == ".":
                    arr.append((i,j))
        solve(board, arr, 0)
