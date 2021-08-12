import java.util.*;
class Solution
{
    public List<List<String>> groupAnagrams(String[] arr) {
        Map<String, List<String>> map = new HashMap<>();
        for(String s : arr)
        {
            char[] temp = s.toCharArray();
            Arrays.sort(temp);
            String sorted = new String(temp);
            if(map.containsKey(sorted))
                map.get(sorted).add(s);
            else
            {
                List<String> t = new ArrayList<>();
                t.add(s);
                map.put(sorted, t);
            }
            System.out.println(map);
        }
        return new ArrayList<>(map.values());
    }
}