class Solution:
    def tictactoe(self, moves: List[List[int]]) -> str:
        self.mat = [['.' for j in range(3)] for i in range(3)]
        for (i, move) in enumerate(moves):
            if i % 2 == 0:
                self.mat[move[0]][move[1]] = 'A'
            else:
                self.mat[move[0]][move[1]] = 'B'
            w = self.findWinner()
            if w == 'A' or w == 'B':
                return w
        if len(moves) == 9:
            return "Draw"
        else:
            return "Pending"
    def findWinner(self):
        # Diagonal
        if self.mat[0][0] != '.' and self.mat[0][0] == self.mat[1][1] and self.mat[2][2] == self.mat[1][1]:
            return self.mat[0][0]
        # Anti diagonal
        if self.mat[0][2] != '.' and self.mat[0][2] == self.mat[1][1] and self.mat[2][0] == self.mat[1][1]:
            return self.mat[0][2]
        # Rows
        for r in range(3):
            if self.mat[r][0] != '.' and self.mat[r][0] == self.mat[r][1] and self.mat[r][1] == self.mat[r][2]:
                return self.mat[r][0]
        # Columns
        for c in range(3):
            if self.mat[0][c] != '.' and self.mat[0][c] == self.mat[1][c] and self.mat[1][c] == self.mat[2][c]:
                return self.mat[0][c]
        return '.'
