n = 0
def remove(legal, x):
    leg = set(legal)
    for y in legal:
        if x[0]==y[0] or x[1]==y[1] or x[0]+x[1]==y[0]+y[1] or x[0]-x[1]==y[0]-y[1]:
            leg.remove(y)
    return leg
def solve(i, legal):
    if i==n:
        return 1
    ans = 0
    for x in legal:
        if x[0]==i:
            ans += solve(i+1, remove(legal, x))
    return ans
class Solution:
    def totalNQueens(self, N: int) -> int:
        global n
        n = N
        legal = set()
        for i in range(n):
            for j in range(n):
                legal.add((i, j))
        return solve(0, legal)
