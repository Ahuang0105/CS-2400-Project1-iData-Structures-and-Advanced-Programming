import java.util.Arrays;

/**
 * This class implements the BagInterface using a resizable array.
 * @author Alan Huang
 * @param <T>
 */
public class PileOfBooks<T> implements BagInterface<T> {
	
	private T[] bag;  
	private  int numberOfEntries;
	private boolean integrityOK = false;
	private static final int DEFAULT_CAPACITY = 5;  // We create 5 capacity so we can increase size later
	private static final int MAX_CAPACITY = 10000;  //
	
	/**
	 * Constructor use to initial the size of my pile
	 */
	public PileOfBooks ()
	{
		this (DEFAULT_CAPACITY);
	}
	
	/**
	 * Constructor I use to create my pile to store books
	 * @param intialSize use to unchecked cast
	 */
	public PileOfBooks (int intialSize)
	{
		checkCapacity(intialSize);
		
		@SuppressWarnings("unchecked") //Unchecked cast
		T [] tempPile = (T[]) new Object [intialSize]; 
		bag = tempPile;
		numberOfEntries = 0;
		integrityOK = true;
	}
	
	/**
	 * This method will add books to the top of 
	 * pile and increase size if the plie is full
	 */
    public boolean add(T newEntry)
    {
    	checkintegrity();
    	
    	boolean result = true;
    	if ( isArrayFull() )
    	{
    		doubleCapacity();
    	}
    	// end if
    	bag[numberOfEntries ] = newEntry;
    	numberOfEntries++ ;
    	return result;
    }

	/**
	 * THIs remove method will remove one book
	 * form the top of pile
	 */
	public T remove()
	{
		checkintegrity();
		T result = removeEntry(numberOfEntries - 1);
	    return result;
	}
	
	/**
	 * This method remove a specified book from the pile. also
	 * remove all the books that is on top of the specified book
	 */
	public boolean remove(T anEntry)
	{
		checkintegrity();
      int index = getIndexOf(anEntry);
      T result = removeEntry(index);
      return anEntry.equals(result);
	}
	
	/**
	 * This method will return the total number of books on the pile so far.
	 */
    public int getCurrentSize()
    {
    	return numberOfEntries;
    }
	
    /**
     * This method return true is the pile is empty, and false
     * when the pile is not empty
     */
	public boolean isEmpty()
	{
		return numberOfEntries == 0;
	}
	
	/**
	    * This method will remove all the books from the pile
	    */
	public void clear()
	{
		while (!isEmpty())
		{
	         remove();
		}
	}
	
	/**
	 * This method will remove all the books from the pile
	 */
	public T[] toArray() 
	{
		checkintegrity();
      // The cast is safe because the new array contains null entries.
      @SuppressWarnings("unchecked")
      T[] result = (T[])new Object[numberOfEntries]; // Unchecked cast
      for (int index = 0; index < numberOfEntries; index++)
      {
         result[index] = bag[index];
      } // end for
      return result;
	} // end toArray
	
    /**
     * This private inner method will check if the array 
     * if full  
     * @return true is it's full or false if not
     */
	private boolean isArrayFull()
	{
		return numberOfEntries >= bag.length;
	}
	
	/**
	 * This private inner method will double the total
	 * capacity number if the pile is not big enough
	 * to store all the books
	 */
	private void doubleCapacity()
	{
      int newLength = 2 * bag.length;
      checkCapacity(newLength);
      bag = Arrays.copyOf(bag, newLength);
	}
	
	/**
	 * This private method will ensure the capacity will
	 * not pass MAC_CAPACITY
	 * @param capacity the current total entries
	 */
	private void checkCapacity(int capacity)
	{
	   if (capacity > MAX_CAPACITY)
	   throw new IllegalStateException("Attempt to create a bag whose capacity exceeds " +
	                                         "allowed maximum of " + MAX_CAPACITY);
	} // end checkCapacity
	
	/**
	 * This private method will help me remove all the 
	 * books that is on top the book I want to remove
	 * and display all the action
	 * @param givenIndex the location of the book on the pile
	 * @return the data of the book I wish to delete
	 */
	private T removeEntry(int givenIndex)
	{
       T result = null;
       
       int lastIndex = numberOfEntries - 1;
			
       for (int index = lastIndex; index >= givenIndex; index--)
	   {
	      System.out.println("We are removing " +"(" +bag[index] +")" +" right now.\n");
		
	      bag[index] = null;
		
	      numberOfEntries-- ;
	   }
       
       result = bag[givenIndex]; 
       
       return result;			
	}
	
	/**
	 * This method will the name of the book that 
	 * is on top of the pile
	 */
	public T topOfBook()
	{
		if (isEmpty())
		{
			System.out.println("The pile is now empty");
		}
		return bag[numberOfEntries-1];
		
	}
	/**
	 * This private methods will search the pile
	 * and locate the book I am looking for 
	 * @param anEntry the title of the book
	 * @return The index for the book
	 */
	private int getIndexOf(T anEntry)
	{	
		int where = -1;
		boolean found = false;
		int index = 0;
	      
		while (!found && (index < numberOfEntries))
		{
			if (anEntry.equals(bag[index]))
			{
				found = true;
				where = index;	
			} // end if
	         index++;	
		}
	     
		return where;	
	}
	
	/**
	 *  This method will check integrity and throw an 
	 *  exception if receiving object is not initialized.
	 */
	private void checkintegrity()
	   {
	      if (!integrityOK)
	         throw new SecurityException ("ArrayBag object is corrupt.");
	   }

}