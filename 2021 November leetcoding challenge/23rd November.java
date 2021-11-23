class Temp {
    static int[] SPF;
    static void init() {
        if(SPF != null) return;
        SPF = new int[100001];
        for(int i = 2; i < 100001; i++) SPF[i] = i;
        for(int i = 4; i < 100001; i += 2) {
            SPF[i] = 2;
        }
        for(int i = 3; i < 100001; i += 2) {
            if(SPF[i] == i) {
                for(long j = (long)i*i; j < 100001; j += i) {
                    if(SPF[(int)j] == j)
                        SPF[(int)j] = i;
                }
            }
        }
    }
}
class Solution {
    public int largestComponentSize(int[] arr) {
        DisjointUnionSets uf = new DisjointUnionSets(100001);
        Temp.init();
        TreeMap<Integer, TreeSet<Integer>> primeMultiples = new TreeMap<>();
        for(int i : arr) {
            if(i < 2) continue;
            int n = i;
            while(Temp.SPF[n] != n) {
                TreeSet<Integer> set = primeMultiples.get(Temp.SPF[n]);
                if(set == null) {
                    set = new TreeSet<>();
                    primeMultiples.put(Temp.SPF[n], set);
                }
                set.add(i);
                n = n / Temp.SPF[n];
            }
            TreeSet<Integer> set = primeMultiples.get(Temp.SPF[n]);
            if(set == null) {
                set = new TreeSet<>();
                primeMultiples.put(Temp.SPF[n], set);
            }
            set.add(i);
        }
        for(int i : primeMultiples.keySet()) {
            int x = primeMultiples.get(i).first();
            for(int y : primeMultiples.get(i)) {
                uf.union(x, y);
            }
        }
        int ans = 1;
        Node[] nodes = new Node[uf.n];
        for(int i = 0; i < uf.n; i++) {
            nodes[i] = new Node(i);
        }
        for(int i = 0; i < uf.n; i++) {
            if(uf.parent[i] != i)
                nodes[uf.parent[i]].child.add(nodes[i]);
        }
        for(int i = 0; i < uf.n; i++) {
            if(uf.parent[i] == i) ans = Math.max(ans, dfs(nodes[i]));
        }
        return ans;
    }
    private int dfs(Node u) {
        int ans = 1;
        for(Node v : u.child) {
            ans += dfs(v);
        }
        return ans;
    }
}
class DisjointUnionSets {
    int[] rank, parent;
    int n;
    public DisjointUnionSets(int n) {
        rank = new int[n];
        parent = new int[n];
        this.n = n;
        makeSet();
    }
    void makeSet() {
        for (int i = 0; i < n; i++) {
            parent[i] = i;
        }
    }
    int find(int x) {
        if (parent[x] != x) {
            parent[x] = find(parent[x]);
        }
        return parent[x];
    }
    void union(int x, int y) {
        int xRoot = find(x), yRoot = find(y);
        if (xRoot == yRoot) return;
        if (rank[xRoot] < rank[yRoot]) parent[xRoot] = yRoot;
        else if (rank[yRoot] < rank[xRoot]) parent[yRoot] = xRoot;
        else {
            parent[yRoot] = xRoot;
            rank[xRoot] = rank[xRoot] + 1;
        }
    }
}
class Node {
    int val;
    boolean vis;
    List<Node> child;
    Node(int val) {
        this.val = val;
        vis = false;
        child = new ArrayList<>();
    }
}
