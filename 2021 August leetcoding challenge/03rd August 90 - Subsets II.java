import java.util.*;
class Solution
{
    List<Integer> cur;
    void solve(int[] freq, int i, List<List<Integer>> ans)
    {
        if(i == freq.length)
        {
            ans.add(new ArrayList<Integer>(cur));
            return;
        }
        solve(freq, i+1, ans);
        for(int x = 0; x < freq[i]; x++)
        {
            cur.add(i-10);
            solve(freq, i+1, ans);
        }
        for(int x = 0; x < freq[i]; x++)
            cur.remove(cur.size()-1);
    }
    public List<List<Integer>> subsetsWithDup(int[] nums)
    {
        int[] freq = new int[21];
        // x -> x + 10
        for(int i : nums)
            freq[i+10]++;
        cur = new ArrayList<>();
        List<List<Integer>> ans = new ArrayList<List<Integer>>();
        solve(freq, 0, ans);
        return ans;
    }
}