class Solution
{
    private boolean onedif(char[] c1, char[] c2)
    {
        int d=0;
        for(int i=0;i<c1.length;i++)
        {
            if(c1[i]!=c2[i])
            {
                d++;
                if(d==2)
                {
                    return false;
                }
            }
        }
        return true;
    }
    public int ladderLength(String beginWord, String endWord, List<String> list1)
    {
        if(beginWord.equals(endWord))
        {
            return 1;
        }
        list1.add(beginWord);
        Map<char[],Set<char[]>> adjList = new HashMap<>();
        char[][] vertices = new char[list1.size()][];
        Map<char[],Boolean> visited = new HashMap<>();
        int start=0;
        int end=0;
        int xyz=0;
        int f=0;
        for(String s : list1)
        {
            vertices[xyz] = s.toCharArray();
            if(s.equals(beginWord))
            {
                start = xyz;
            }
            else if(s.equals(endWord))
            {
                f=1;
                end = xyz;
            }
            adjList.put(vertices[xyz],new HashSet<char[]>());
            visited.put(vertices[xyz],false);
            xyz++;
        }
        if(f==0)
        {
            return 0;
        }
        for(int i=0;i<vertices.length;i++)
        {
            for(int j=i+1;j<vertices.length;j++)
            {
                if(onedif(vertices[i],vertices[j]))
                {
                    adjList.get(vertices[i]).add(vertices[j]);
                    adjList.get(vertices[j]).add(vertices[i]);
                }
            }
        }
        Queue<char[]> q = new LinkedList<>();
        Queue<char[]> next = new LinkedList<>();
        q.add(vertices[start]);
        int d=2;
        int m=Integer.MAX_VALUE;
        while(q.size()>0)
        {
            while(q.size()>0)
            {
                char[] cur = q.remove();
                for(char[] adj : adjList.get(cur))
                {
                    if(!visited.get(adj))
                    {
                        next.add(adj);
                        visited.put(adj,true);
                        if(adj==vertices[end])
                        {
                            return d;
                        }
                    }
                }
                visited.put(cur,true);
            }
            q = next;
            next = new LinkedList<>();
            d++;
        }
        return 0;
    }
}
