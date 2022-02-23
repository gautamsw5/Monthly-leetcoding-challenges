/*
// Definition for a Node.
class Node {
    public int val;
    public List<Node> neighbors;
    public Node() {
        val = 0;
        neighbors = new ArrayList<Node>();
    }
    public Node(int _val) {
        val = _val;
        neighbors = new ArrayList<Node>();
    }
    public Node(int _val, ArrayList<Node> _neighbors) {
        val = _val;
        neighbors = _neighbors;
    }
}
*/

class Solution
{
    private void dfs(Node node, Set<Integer> visited, Map<Integer,Set<Integer>> adjList)
    {
        visited.add(node.val);
        for(Node n : node.neighbors)
        {
            //System.out.println(node.val+" "+n.val);
            if(!adjList.containsKey(node.val))
            {
                adjList.put(node.val,new HashSet<Integer>());
            }
            adjList.get(node.val).add(n.val);
            if(!visited.contains(n.val))
            {
                dfs(n,visited,adjList);
            }
        }
    }
    public Node cloneGraph(Node node)
    {
        if(node==null)
        {
            return null;
        }
        if(node.neighbors==null || node.neighbors.size()==0)
        {
            return new Node(node.val);
        }
        Map<Integer,Set<Integer>> adjList = new HashMap<>();
        Set<Integer> visited = new HashSet<>();
        dfs(node,visited,adjList);
        Map<Integer,Node> map = new HashMap<>();
        for(int key : adjList.keySet())
        {
            Node x = new Node(key);
            map.put(key,x);
        }
        //System.out.println(adjList+"\n"+map);
        for(int key : adjList.keySet())
        {
            for(int i:adjList.get(key))
            {
                map.get(key).neighbors.add(map.get(i));
            }
        }
        return map.get(node.val);
    }
}
