/** 
 * Forward declaration of guess API.
 * @param  num   your guess
 * @return 	     -1 if num is lower than the guess number
 *			      1 if num is higher than the guess number
 *               otherwise return 0
 * int guess(int num);
 */

public class Solution extends GuessGame {
    public int guessNumber(int n)
    {
        int i=1,j=n;
        while(i+1<j)
        {
            int m=(int)(((long)i+(long)j)/2);
            if(guess(m)==0)
            {
                return m;
            }
            else if(guess(m)==-1)
            {
                j=m;
            }
            else
            {
                i=m;
            }
        }
        if(guess(i)==0)
        {
            return i;
        }
        if(guess(j-1)==0)
        {
            return j-1;
        }
        return j;
    }
}
