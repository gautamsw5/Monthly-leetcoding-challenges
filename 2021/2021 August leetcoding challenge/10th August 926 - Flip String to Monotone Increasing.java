import java.util.*;
class Solution
{
    public int minFlipsMonoIncr(String S)
    {
        int totalZeros = 0, totalOnes = 0, curOnes = 0, curZeros = 0, minFlips = S.length();
        char[] s = S.toCharArray();
        for(char c : s)
        {
            if(c == '0')
                totalZeros++;
            else
                totalOnes++;
        }
        for(int i = 0; i < s.length; i++)
        {
            if(s[i] == '0')
                curZeros++;
            else
                curOnes++;
            if(s[i] == '0')
                minFlips = Math.min(minFlips, curOnes + totalZeros - curZeros);
            else
                minFlips = Math.min(minFlips, curOnes - 1 + totalZeros - curZeros);
            
        }
        return minFlips;
    }
}