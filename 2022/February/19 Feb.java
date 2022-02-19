class Solution {
    public int minimumDeviation(int[] arr) {
        TreeSet<Integer> set = new TreeSet<>();
        for (int i : arr) {
            set.add(i);
        }
        int ans = set.last() - set.first();
        while(set.first() % 2 == 1) {
            int x = set.pollFirst();
            set.add(2*x);
            ans = Math.min(ans, set.last() - set.first());
        }
        while(set.last() % 2 == 0) {
            int x = set.pollLast();
            set.add(x/2);
            ans = Math.min(ans, set.last() - set.first());
        }
        return ans;
    }
}
