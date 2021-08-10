import java.util.*;
class Solution
{
    int solve(int l, int r, int[] arr, Integer[][] cache)
    {
        if(l==r)
            return arr[l];
        if(l > r)
            return 0;
        if(cache[l][r] != null)
            return cache[l][r];
        // Case 1 Alex Left
        int alex_left = Math.min(arr[l] + solve(l+2, r, arr, cache),
        arr[l] + solve(l+1, r-1, arr, cache));
        // Case 2 Alex Right
        int alex_right = Math.min(arr[r] + solve(l+1, r-1, arr, cache),
        arr[r] + solve(l, r-2, arr, cache));
        cache[l][r] = Math.max(alex_left, alex_right);
        return cache[l][r];
    }
    public boolean stoneGame(int[] piles)
    {
        int alex_score = solve(0, piles.length-1, piles, new Integer[piles.length][piles.length]), sum = 0;
        for(int i = 0; i < piles.length; i++)
            sum += piles[i];
        int lee_score = sum - alex_score;
        return alex_score > lee_score;
    }
}