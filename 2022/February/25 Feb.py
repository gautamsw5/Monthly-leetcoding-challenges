class Solution:
    def compareVersion(self, v1: str, v2: str) -> int:
        v1 = v1.split(".")
        v2 = v2.split(".")
        i = 0
        while i < len(v1) and i < len(v2):
            if int(v1[i]) > int(v2[i]):
                return 1
            elif int(v1[i]) < int(v2[i]):
                return -1
            i += 1
        while i < len(v1):
            if int(v1[i]) > 0:
                return 1
            i += 1
        while i < len(v2):
            if int(v2[i]) > 0:
                return -1
            i += 1
        return 0
