class MyHashSet {

    /** Initialize your data structure here. */
    List<Integer> list;
    public MyHashSet()
    {
        list=new ArrayList<Integer>();
    }
    public void add(int key)
    {
        if(list.size()==0)
        {
            list.add(key);
        }
        else if(list.size()==1)
        {
            if(list.get(0)<key)
            {
                list.add(key);
            }
            else if(list.get(0)>key)
            {
                list.add(0,key);
            }
        }
        else
        {
            int p=-1;
            int l=0,r=list.size()-1;
            while(l<=r)
            {
                int m=l+(r-l)/2;
                if(list.get(m)==key)
                {
                    return;
                }
                else if(list.get(m)<key && (m==list.size()-1 || list.get(m+1)>key))
                {
                    p=m+1;
                    break;
                }
                else if((m==0 || list.get(m-1)<=key) && list.get(m)>=key)
                {
                    p=m;
                    break;
                }
                else if(list.get(m)<key)
                {
                    l=m+1;
                }
                else
                {
                    r=m-1;
                }
            }
            if(p>-1)
            {
                list.add(p,key);
            }
        }
    }
    public void remove(int key)
    {
        int p=-1;
        int l=0,r=list.size()-1;
        while(l<=r)
        {
            int m=l+(r-l)/2;
            if(list.get(m)==key)
            {
                p=m;
                break;
            }
            else if(list.get(m)<key)
            {
                l=m+1;
            }
            else
            {
                r=m-1;
            }
        }
        if(p>-1)
        {
            while(p<list.size() && list.get(p)==key)
            {
                list.remove(p);
            }
            p--;
            while(p>0 && list.get(p)==key)
            {
                list.remove(p);
                p--;
            }
        }
    }
    /** Returns true if this set contains the specified element */
    public boolean contains(int key)
    {
        int p=-1;
        int l=0,r=list.size()-1;
        while(l<=r)
        {
            int m=l+(r-l)/2;
            if(list.get(m)==key)
            {
                p=m;
                break;
            }
            else if(list.get(m)<key)
            {
                l=m+1;
            }
            else
            {
                r=m-1;
            }
        }
        return p>-1;
    }
}

/**
 * Your MyHashSet object will be instantiated and called as such:
 * MyHashSet obj = new MyHashSet();
 * obj.add(key);
 * obj.remove(key);
 * boolean param_3 = obj.contains(key);
 */
