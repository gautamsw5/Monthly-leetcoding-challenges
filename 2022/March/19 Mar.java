class FreqStack {
    Map<Integer,Stack<Integer>> map;
    Map<Integer,Integer> freq;
    int m;
    public FreqStack() {
        m=0;
        map = new HashMap<>();
        freq = new HashMap<>();
    }
    public void push(int x) {
        freq.put(x,freq.getOrDefault(x,0)+1);
        if(!map.containsKey(freq.get(x)))
        {
            map.put(freq.get(x),new Stack<>());
        }
        m = Math.max(m,freq.get(x));
        map.get(freq.get(x)).push(x);
    }
    public int pop() {
        while(map.get(m).isEmpty())
        {
            m--;
        }
        int ret = map.get(m).pop();
        freq.put(ret,freq.get(ret)-1);
        return ret;
    }
}
