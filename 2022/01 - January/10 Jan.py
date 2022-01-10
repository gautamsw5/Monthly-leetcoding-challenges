class Solution:
    def addBinary(self, a: str, b: str) -> str:
        c = ""
        i = len(a) - 1
        j = len(b) - 1
        carry = 0
        while i >= 0 and j >= 0:
            c = str(carry^int(a[i])^int(b[j])) + c
            if carry + int(a[i]) + int(b[j]) > 1:
                carry = 1
            else:
                carry = 0
            i -= 1
            j -= 1
        while i >= 0:
            c = str(carry^int(a[i])) + c
            if carry + int(a[i]) > 1:
                carry = 1
            else:
                carry = 0
            i -= 1
        while j >= 0:
            c = str(carry^int(b[j])) + c
            if carry + int(b[j]) > 1:
                carry = 1
            else:
                carry = 0
            j -= 1
        if carry == 1:
            c = "1" + c
        return c
