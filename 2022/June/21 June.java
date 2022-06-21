class Solution {
    public int furthestBuilding(int[] heights, int bricks, int ladders) {
        TreeMap<Integer, Integer> map = new TreeMap<>();
        int k = 0, ans = 0;
        long s = 0L, sm = 0L; // sum of all, sum of max k
        for(int i = 0; i < heights.length-1; i++) {
            if(heights[i] > heights[i+1]) {
                ans = i+1;
                continue;
            }
            else if(k < ladders) {
                map.put(heights[i+1]-heights[i], map.getOrDefault(heights[i+1]-heights[i], 0) + 1);
                s += heights[i+1]-heights[i];
                sm += heights[i+1]-heights[i];
                ans = i+1;
                k++;
            }
            else {
                map.put(heights[i+1]-heights[i], map.getOrDefault(heights[i+1]-heights[i], 0) + 1);
                s += heights[i+1]-heights[i];
                int key = map.firstKey();
                map.put(key, map.get(key) - 1);
                if(map.get(key) == 0) map.remove(key);
                sm += heights[i+1]-heights[i] - key;
                if(s - sm <= bricks) ans = i+1;
                else break;
            }
        }
        return ans;
    }
}
