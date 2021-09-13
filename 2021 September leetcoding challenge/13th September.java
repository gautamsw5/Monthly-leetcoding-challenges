class Solution {
    public int maxNumberOfBalloons(String text) {
        int[] freq = new int[5];
        for(char c : text.toCharArray()) {
            if(c=='b') freq[0]++;
            else if(c=='a') freq[1]++;
            else if(c=='l') freq[2]++;
            else if(c=='o') freq[3]++;
            else if(c=='n') freq[4]++;
        }
        return Math.min(freq[0], Math.min(freq[1], Math.min(freq[2]/2, Math.min(freq[3]/2, freq[4]))));
    }
}
