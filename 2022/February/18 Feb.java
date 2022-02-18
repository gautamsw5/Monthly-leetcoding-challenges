import java.util.*;

class Solution {
    public String removeKdigits(String s, int k) {
        int n = s.length();
        k = n - k;
        if(k == 0) return "0";
        TreeMap<Character, Queue<Integer>> indices = new TreeMap<>();
        for(int i = 0; i < n-k+1; i++) {
            char c = s.charAt(i);
            indices.computeIfAbsent(c, z -> new LinkedList<>()).add(i);
        }
        StringBuilder sb = new StringBuilder();
        int prev = -1, r = n-k+1;
        while(k > 0) {
            char c = indices.firstKey();
            Queue<Integer> q = indices.get(c);
            int i = q.remove();
            if(q.isEmpty()) indices.remove(c);
            if(!sb.isEmpty() || c != '0') sb.append(c);
            k--;
            for(int x = prev+1; x < i; x++) {
                q = indices.get(s.charAt(x));
                q.remove();
                if(q.isEmpty()) indices.remove(s.charAt(x));
            }
            prev = i;
            if(r < n)
            indices.computeIfAbsent(s.charAt(r), z -> new LinkedList<>()).add(r++);
        }
        if(sb.isEmpty()) return "0";
        return sb.toString();
    }
}
