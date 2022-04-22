public class Node
{
    int val;
    int key;
    Node() {}
    Node(int key,int value) { this.val = value; this.key = key; }
}
class MyHashMap
{
    /** Initialize your data structure here. */
    List<Node> list;
    public MyHashMap()
    {
        list=new ArrayList<Node>();
    }
    /** value will always be non-negative. */
    public void put(int key, int value)
    {
        if(list.size()==0)
        {
            list.add(new Node(key,value));
        }
        else if(list.size()==1)
        {
            if(list.get(0).key<key)
            {
                list.add(new Node(key,value));
            }
            else if(list.get(0).key>key)
            {
                list.add(0,new Node(key,value));
            }
            else
            {
                list.get(0).val=value;
            }
        }
        else
        {
            int p=-1;
            int l=0,r=list.size()-1;
            while(l<=r)
            {
                int m=l+(r-l)/2;
                if(list.get(m).key==key)
                {
                    list.get(m).val=value;
                    
                    
                    
                    return;
                }
                else if(list.get(m).key<key && (m==list.size()-1 || list.get(m+1).key>key))
                {
                    p=m+1;
                    break;
                }
                else if((m==0 || list.get(m-1).key<key) && list.get(m).key>key)
                {
                    p=m;
                    break;
                }
                else if(list.get(m).key<key)
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
                list.add(p,new Node(key,value));
            }
        }
        
    }
    /** Returns the value to which the specified key is mapped, or -1 if this map contains no mapping for the key */
    public int get(int key)
    {
        int p=-1;
        int l=0,r=list.size()-1;
        while(l<=r)
        {
            int m=l+(r-l)/2;
            if(list.get(m).key==key)
            {
                p=m;
                break;
            }
            else if(list.get(m).key<key)
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
            return list.get(p).val;
        }
        return -1;
    }
    /** Removes the mapping of the specified value key if this map contains a mapping for the key */
    public void remove(int key)
    {
        int p=-1;
        int l=0,r=list.size()-1;
        while(l<=r)
        {
            int m=l+(r-l)/2;
            if(list.get(m).key==key)
            {
                p=m;
                break;
            }
            else if(list.get(m).key<key)
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
            list.remove(p);
        }
        
        
        
    }
}

/**
 * Your MyHashMap object will be instantiated and called as such:
 * MyHashMap obj = new MyHashMap();
 * obj.put(key,value);
 * int param_2 = obj.get(key);
 * obj.remove(key);
 */
