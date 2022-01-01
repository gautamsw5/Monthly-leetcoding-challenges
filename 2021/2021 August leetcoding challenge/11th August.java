import java.util.*;
class Solution
{
    void decrement(TreeMap<Integer, Integer> freq, int key)
    {
        if(freq.get(key) == 1)
            freq.remove(key);
        else
            freq.put(key, freq.get(key) - 1);
    }
    public boolean canReorderDoubled(int[] arr)
    {
        // System.out.println();
        TreeMap<Integer, Integer> freq = new TreeMap<>();
        for(int i : arr)
            freq.put(i, freq.getOrDefault(i, 0) + 1);
        if(freq.getOrDefault(0, 0) % 2 == 1)
            return false;
        while(freq.size() > 0 && freq.lastKey() > 0)
        {
            // System.out.println(freq);
            int greatest = freq.lastKey(), half = greatest / 2;
            if(greatest % 2 == 1 || !freq.containsKey(half))
                return false;
            decrement(freq, greatest);
            decrement(freq, half);
        }
        while(freq.size() > 0)
        {
            // System.out.println(freq);
            int lowest = freq.firstKey(), half = lowest / 2;
            // System.out.println(lowest % 2);
            if(Math.abs(lowest % 2) == 1 || !freq.containsKey(half))
                return false;
            // System.out.println(lowest+" "+mul2);
            if(!freq.containsKey(half))
                return false;
            decrement(freq, lowest);
            decrement(freq, half);
            
        }
        return true;
    }
}