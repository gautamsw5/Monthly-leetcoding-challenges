class Solution {
    public int removeCoveredIntervals(int[][] intervals) {
        int n = intervals.length;
        Arrays.sort(intervals, (a, b) -> {
            if(a[0] != b[0]) return b[0] - a[0];
            else return a[1] - b[1];
        });
        // System.out.println(Arrays.deepToString(intervals));
        Set<Integer> set = new HashSet<>();
        // i is covered by j   i[0] >= j[0] && i[1] <= j[1]
        for(int i = 0; i < n; i++) {
            for(int j = i+1; j < n; j++) {
                if(intervals[i][1] <= intervals[j][1]) {
                    set.add(i);
                    // System.out.println(Arrays.toString(intervals[i]) + " < " + Arrays.toString(intervals[j]));
                }
            }
        }
        return n - set.size();
    }
}
