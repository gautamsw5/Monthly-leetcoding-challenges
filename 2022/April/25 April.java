// Java Iterator interface reference:
// https://docs.oracle.com/javase/8/docs/api/java/util/Iterator.html

class PeekingIterator implements Iterator<Integer>
{
    private Iterator<Integer> it;
    private Integer pek;
	public PeekingIterator(Iterator<Integer> iterator)
    {
	    // initialize any member here.
	    it = iterator;
        if(it.hasNext())
        {
            pek = it.next();
        }
        else
        {
            pek = null;
        }
	}
	
    // Returns the next element in the iteration without advancing the iterator.
	public Integer peek()
    {
        return pek;
	}
	
	// hasNext() and next() should behave the same as in the Iterator interface.
	// Override them if needed.
	@Override
	public Integer next()
    {
	    Integer ret = pek!=null?(new Integer(pek)):null;
        if(it.hasNext())
        {
            pek = it.next();
        }
        else
        {
            pek = null;
        }
        return ret;
	}
	
	@Override
	public boolean hasNext()
    {
	    return pek!=null;
	}
}
