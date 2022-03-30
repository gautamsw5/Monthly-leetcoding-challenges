class Solution:
    def searchMatrix(self, mat: List[List[int]], x: int) -> bool:
        n, m = len(mat), len(mat[0])
        l, r = 0, n*m-1
        while l <= r:
            mid = (l+r) // 2
            if mat[mid // m][mid % m] == x:
                return True
            elif mat[mid // m][mid % m] < x:
                l = mid + 1
            else:
                r = mid - 1
        return False
