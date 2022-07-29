class Solution
{
    private String PatGen(char[] pattern)
    {
        Map<Character,Character> map = new HashMap<>();
        char s = 'a';
        for(char c : pattern)
        {
            if(!map.containsKey(c))
            {
                map.put(c, s++);
            }
        }
        for(int i=0; i<pattern.length;i++)
        {
            pattern[i] = map.get(pattern[i]);
        }
        return new String(pattern);
    }
    public List<String> findAndReplacePattern(String[] words, String pattern)
    {
        List<String> ans = new ArrayList<>();
        String pat = PatGen(pattern.toCharArray());
        for(String s : words)
        {
            if(PatGen(s.toCharArray()).equals(pat))
            {
                ans.add(s);
            }
        }
        return ans;
    }
}
