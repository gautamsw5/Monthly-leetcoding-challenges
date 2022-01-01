class Solution {
    public int[] intersect(int[] arr, int[] brr) {
        if(arr.length > brr.length)
            return intersect(brr, arr);
        Map<Integer, Integer> freq = new HashMap<>();
        for(int i : arr) freq.put(i, freq.getOrDefault(i, 0) + 1);
        List<Integer> ans = new ArrayList<>();
        for(int i : brr) {
            if(freq.getOrDefault(i, 0) > 0) {
                ans.add(i);
                freq.put(i, freq.get(i) - 1);
            }
        }
        int[] ret = new int[ans.size()];
        for(int i = 0; i < ans.size(); i++) ret[i] = ans.get(i);
        return ret;
    }
}
