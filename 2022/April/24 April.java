public class travel
{
    public String start;
    public String end;
    public int n;
    public double av;
    public travel(String s, String e)
    {
        start = s;
        end = e;
    }
    public double add(int t1, int t2) // t2>t1
    {
        av = (av*n + t2-t1)/(++n);
        return av;
    }
}
class UndergroundSystem
{
    private Map<String,travel> map; // "start end"->travel obj
    private Map<Integer,String> pos; // id->position
    private Map<Integer,Integer> time; // id->time
    public UndergroundSystem()
    {
        map = new HashMap<>();
        pos = new HashMap<>();
        time = new HashMap<>();
    }
    public void checkIn(int id, String stationName, int t)
    {
        pos.put(id,stationName);
        time.put(id,t);
    }
    public void checkOut(int id, String stationName, int t)
    {
        travel obj = null;
        if(!map.containsKey(pos.get(id)+" "+stationName))
        {
            obj = new travel(pos.get(id),stationName);
            map.put(pos.get(id)+" "+stationName, obj);
        }
        else
        {
            obj = map.get(pos.get(id)+" "+stationName);
        }
        obj.add(time.get(id),t);
        pos.put(id,stationName);
        time.put(id,t);
    }
    public double getAverageTime(String startStation, String endStation)
    {
        return map.get(startStation+" "+endStation).av;
    }
}

/**
 * Your UndergroundSystem object will be instantiated and called as such:
 * UndergroundSystem obj = new UndergroundSystem();
 * obj.checkIn(id,stationName,t);
 * obj.checkOut(id,stationName,t);
 * double param_3 = obj.getAverageTime(startStation,endStation);
 */
