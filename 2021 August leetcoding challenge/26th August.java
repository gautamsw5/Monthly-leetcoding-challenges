class Pair
{
    Integer left, right;
    Pair()
    {
        left = null;
        right = null;
    }
}
class Solution
{
    public boolean isValidSerialization(String preorder)
    {
        if(preorder.equals("#"))
            return true;
        String[] arr = preorder.split(",");
        int i = 0;
        Stack<Pair> stack = new Stack<>();
        try
        {
            if(arr[i].equals("#"))
                return false;
            stack.push(new Pair());
            i++;
            while(i < arr.length)
            {
                Pair root = stack.peek();
                if(root.left == null)
                {
                    if(!arr[i].equals("#"))
                    {
                        root.left = Integer.parseInt(arr[i]);
                        stack.push(new Pair());
                    }
                    else
                        root.left = -1;
                }
                else if(root.right == null)
                {
                    if(arr[i].equals("#"))
                        stack.pop();
                    else
                    {
                        root.right = Integer.parseInt(arr[i]);
                        stack.pop();
                        stack.push(new Pair());
                    }
                }
                else
                {
                    stack.pop();
                }
                i++;
            }
            return stack.isEmpty();
        }
        catch(Exception e)
        {
            return false;
        }
    }
}
