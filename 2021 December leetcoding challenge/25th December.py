class Solution:
    def calculate(self, s: str) -> int:
        s = s.replace(" ", "")
        i = 0
        n = len(s)
        op = [] # Store operators
        nums = [] # Store Numbers
        while i < n:
            start = i
            while i < n and s[i] >= '0' and s[i] <= '9':
                i += 1
            nums.append(int(s[start:i]))
            if i != n:
                op.append(s[i])
            i += 1
        ans = nums[0]
        i = 0
        n = len(op)
        while i < n:
            if op[i] == '*' or op[i] == '/':
                r = nums[i]
                while i < n and (op[i] == '*' or op[i] == '/'):
                    if op[i] == '*':
                        r = r * nums[i+1]
                    else:
                        sign = 1
                        if r * nums[i+1] < 0:
                            sign = -1
                        r = sign * (abs(r) // abs(nums[i+1]))
                    i += 1
                ans = r
            elif i+1 == n or op[i+1] == '+' or op[i+1] == '-':
                while i < n and (i+1 == n or op[i+1] == '+' or op[i+1] == '-'):
                    if op[i] == '+':
                        ans += nums[i+1]
                    else:
                        ans -= nums[i+1]
                    i += 1
            else:
                plusminus = op[i]
                i += 1
                r = nums[i]
                while i < n and (op[i] == '*' or op[i] == '/'):
                    if op[i] == '*':
                        r = r * nums[i+1]
                    else:
                        sign = 1
                        if r * nums[i+1] < 0:
                            sign = -1
                        r = sign * (abs(r) // abs(nums[i+1]))
                    i += 1
                if plusminus == '+':
                    ans += r
                else:
                    ans -= r
        return ans
