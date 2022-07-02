class Solution:
    def maxArea(self, h: int, w: int, hor: List[int], ver: List[int]) -> int:
        hor.sort()
        hor = [0] + hor + [h]
        ver.sort()
        ver = [0] + ver + [w]
        hd = 0
        vd = 0
        for i in range(1, len(hor)):
            hd = max(hd, hor[i] - hor[i-1])
        for i in range(1, len(ver)):
            vd = max(vd, ver[i] - ver[i-1])
        return (vd*hd)%(10**9+7)
