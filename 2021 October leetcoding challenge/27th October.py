class Solution:
    def sortColors(self, arr: List[int]) -> None:
        i = 0
        j = len(arr)-1
        while j > -1 and arr[j] == 2: # Ignore 2's at end
            j -= 1
        while i < j: # Move all 2's to end
            if arr[i] == 2:
                while j > i and arr[j] == 2: # Ignore 2's at end
                    j -= 1
                if j > i:
                    arr[i], arr[j] = arr[j], arr[i]
                i += 1
                j -= 1
            else:
                i += 1
        while j > -1 and arr[j] == 2: # Ignore 2's at end
            j -= 1
        while j > -1 and arr[j] == 1: # Ignore 1's at end
            j -= 1
        i = 0
        while i < j: # Move all 1's to end (before all 2's)
            if arr[i] == 1:
                while j > i and arr[j] == 1:
                    j -= 1
                if j > i:
                    arr[i], arr[j] = arr[j], arr[i]
                i += 1
                j -= 1
            else:
                i += 1
        # Sorted !
