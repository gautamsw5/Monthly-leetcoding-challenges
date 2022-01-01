class Solution:
    def movesToChessboard(self, board: List[List[int]]) -> int:
        n = len(board)
        for i in range(n):
            for j in range(n):
                if board[0][0] ^ board[i][0] ^ board[0][j] ^ board[i][j] == 1:
                    return -1
        rm, cm, rs, cs = 0, 0, 0, 0
        for i in range(n):
            rs += board[i][0]
            cs += board[0][i]
            rm += int(board[i][0] == (i%2))
            cm += int(board[0][i] == (i%2))
        if rs < n // 2 or rs > (n+1) // 2 or cs < n // 2 or cs > (n+1) // 2:
            return -1
        if n % 2 == 1:
            if rm % 2 == 1:
                rm = n - rm
            if cm % 2 == 1:
                cm = n - cm
            return (rm + cm) // 2
        else:
            return (min(rm, n-rm) + min(cm, n-cm)) // 2
