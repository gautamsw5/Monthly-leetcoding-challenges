class Solution:
    def findKthLargest(self, arr: List[int], k: int) -> int:
        return sorted(arr, reverse = 1)[k-1]
