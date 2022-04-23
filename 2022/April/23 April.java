/*public class Hashmap
{
    public List<Integer> keys;
    public List<String> values;
    public Multiset()
    {
        keys = new ArrayList<Integer>();
        values = new ArrayList<String>();
    }
    public void put(int x, String s)
    {
        if(keys.size()==0)
        {
            keys.add(x);
            values.add(s);
            return;
        }
        if(keys.size()==1)
        {
            if(keys.get(0)>x)
            {
                keys.add(0,x);
                values.add(0,s);
            }
            else
            {
                keys.add(x);
                values.add(s);
            }
            return;
        }
        if(x<keys.get(0))
        {
            keys.add(0,x);
            values.add(0,s);
            return;
        }
        if(x>keys.get(keys.size()-1))
        {
            keys.add(x);
            return;
        }
        int l=0,
        r=set.size()-1;
        while(l<=r)
        {
            int m=l+(r-l)/2;
            if(set.get(m)==x)
            {
                set.add(m,x);
                return;
            }
            if(set.get(m+1)>=x && set.get(m)<=x)
            {
                set.add(m+1,x);
                return;
            }
            if(set.get(m)>x)
            {
                r=m-1;
            }
            else
            {
                l=m+1;
            }
        }
    }
    public void remove(int x)
    {
        int l=0,
        r=set.size()-1;
        while(l<=r)
        {
            int m=l+(r-l)/2;
            if(set.get(m)==x)
            {
                set.remove(m);
                return;
            }
            else if(set.get(m)>x)
            {
                r=m-1;
            }
            else
            {
                l=m+1;
            }
        }
    }
}*/
public class Codec
{
    /*private int x;
    private List<String> list;
    // Encodes a URL to a shortened URL.
    public Codec()
    {
        x=0;
        list=new ArrayList<String>();
    }*/
    public String encode(String url)
    {
        /*list.add(url);
        x++;
        return x+"";*/
        return url;
    }
    // Decodes a shortened URL to its original URL.
    public String decode(String surl)
    {
        return surl;
    }
}

// Your Codec object will be instantiated and called as such:
// Codec codec = new Codec();
// codec.decode(codec.encode(url));
