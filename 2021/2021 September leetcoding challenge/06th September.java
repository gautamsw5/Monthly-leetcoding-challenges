class Solution {
    public char slowestKey(int[] releaseTimes, String keysPressed) {
        char[] arr = keysPressed.toCharArray();
        
        int slowest = 0;
        int duration = releaseTimes[0];
        
        for(int i = 1; i < arr.length; i++) {
            if(duration < releaseTimes[i] - releaseTimes[i-1] || (arr[i] > arr[slowest] && duration == releaseTimes[i] - releaseTimes[i-1])) {
                slowest = i;
                duration = releaseTimes[i] - releaseTimes[i-1];
            }
        }
        
        return arr[slowest];
    }
}
