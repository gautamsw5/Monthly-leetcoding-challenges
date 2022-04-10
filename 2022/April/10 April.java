class Solution {
    public int calPoints(String[] ops)
    {
        List<Integer>r=new ArrayList<Integer>();
        int index=-1,sum=0;
        for(String s:ops)
        {
            if(s.equals("+"))
            {
                sum+=r.get(index)+r.get(index-1);
                r.add(r.get(index)+r.get(index-1));
                index++;
            }
            else if(s.equals("C"))
            {
                sum-=r.get(index);
                r.remove(index);
                index--;
            }
            else if(s.equals("D"))
            {
                //sum+=r.get(index);
                r.add(2*r.get(index));
                sum+=r.get(index+1);
                index++;
            }
            else
            {
                sum+=Integer.parseInt(s);
                r.add(Integer.parseInt(s));
                index++;
            }
            //System.out.print(index+" ");
        }
        return sum;
    }
}
