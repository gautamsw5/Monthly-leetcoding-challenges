class Solution {
    public String orderlyQueue(String s, int k) {
        if(k == 1) {
            StringBuilder sb = new StringBuilder(s), ans = new StringBuilder(sb);
            for(int i = 0; i < s.length(); i++) {
                char ch = sb.charAt(0);
                sb = sb.deleteCharAt(0);
                sb.append(ch);
                if(ans.compareTo(sb) > 1)
                    ans = new StringBuilder(sb);
            }
            return new String(ans);
        }
        else {
            char[] arr = s.toCharArray();
            Arrays.sort(arr);
            return new String(arr);
        }
    }
}
