class Solution:
    def canAttack(self, i: int, j: int):
        for q in self.queens:
            if i + j == q[0] + q[1] or i - j == q[0] - q[1] or i == q[0] or j == q[1]:
                return True
        return False
    def findSolutions(self, i: int):
        if i == self.n:
            self.ans.append([''.join(c for c in self.board[i]) for i in range(self.n)])
            return
        for j in list(self.remCols):
            if not self.canAttack(i, j):
                self.queens.append([i, j])
                self.board[i][j] = 'Q'
                self.remCols.remove(j)
                self.findSolutions(i+1)
                self.board[i][j] = '.'
                self.queens.pop(-1)
                self.remCols.add(j)
    def solveNQueens(self, n: int) -> List[List[str]]:
        self.board = [['.' for j in range(n)] for i in range(n)]
        self.ans = []
        self.queens = []
        self.n = n
        self.remCols = set(range(n))
        self.findSolutions(0)
        return self.ans
