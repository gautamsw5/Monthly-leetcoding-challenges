class Solution:
    def isRobotBounded(self, instructions: str) -> bool:
        x, y = 0, 0
        dx, dy = 0, 1
        L = {(0, 1):(-1, 0), (-1, 0):(0, -1), (0, -1):(1, 0), (1, 0):(0, 1)}
        R = {(0, 1):(1, 0), (1, 0):(0, -1), (0, -1):(-1, 0), (-1, 0):(0, 1)}
        for z in range(5):
            for c in instructions:
                if c == 'G':
                    x += dx
                    y += dy
                elif c == 'L':
                    dx, dy = L[(dx, dy)]
                elif c == 'R':
                    dx, dy = R[(dx, dy)]
            if (x, y) == (0, 0):
                return True
        return False
