class Point {
    
    int x, y;
    Point(int x, int y) {
        this.x = x;
        this.y = y;
    }
}
class Solution {
    
    public int[][] outerTrees(int[][] trees) {
        
        int n = trees.length;
        
        if(n <= 3)
            return trees;
        
        Point[] points = new Point[n];
        
        for(int i = 0; i < n; i++)
            points[i] = new Point(trees[i][0], trees[i][1]);
        
        int p = 0, q = 0, start;
        for(int i = 1; i < n; i++)
            if(points[i].x < points[p].x || (points[i].x == points[p].x && points[i].y > points[p].y))
                p = i;
        
        start = p;
        Set<Integer> hull = new HashSet<>();
        do {
            hull.add(p);
            q = (p + 1) % n;
            for(int i = 0; i < n; i++)
                if(check(points[p], points[i], points[q]) == 1)
                    q = i;
            
            for(int i = 0; i < n; i++)
                if(i != p && i != q && check(points[p], points[i], points[q]) == 0)
                    hull.add(i);
            
            p = q;
        } while(p != start);
        
        int[][] ans = new int[hull.size()][];
        int k = 0;
        for(int i : hull)
            ans[k++] = trees[i];
            
        return ans;
        
    }
    
    private int check(Point p, Point q, Point r) {
        if((q.y-p.y)*(r.x-q.x) < (q.x-p.x)*(r.y-q.y))
            return 1;
        if((q.y-p.y)*(r.x-q.x) == (q.x-p.x)*(r.y-q.y))
            return 0;
        return -1;
    }
    
}
