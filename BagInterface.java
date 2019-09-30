/** I use this interface to transfer all method from pileOfBooks 
 *  and LinkedNodes to implemented the the action for add and 
 *  remove book from the pile. (Task 1)
 *  @author Alan Huang
 *  @param <T>
 */
public interface BagInterface<T>
{
	/** Get the total numbers of books on the pile.
	 *  @return Also return integer number of books
	 *   are on the pile by.
	 */
	public int getCurrentSize();
	
	/** Check if the pile is empty
	 *  @return  True if the pile is empty,
	 *   or false if not. */
	public boolean isEmpty();
	
	/** Adds a new book to the pile.
	  * @param newEntry  the name of the books going to be store on the pile
	  * @return  True if the book is successful place on the pile, 
	  * or false if not. 
	  */
	public boolean add(T newEntry);

	/** Removes one unspecified book from this pile, if possible.
	 * @return  Either the removed entry, if the removal.
     * was successful, or null. */
	public T remove();
   
    /** Removes one specified book from the pile, also remove  all
     * the books on top of the specified book.
     * @param anEntry  The entry to be removed.
     * @return  True if the removal was successful, or false if not. */
	public boolean remove(T anEntry);
	
	/** 
	 * Removes all the books from the pile
	 */
	public void clear();
	
	/**
	 * @return the data stored in the first node
	 */
	public T topOfBook();
	
	/**
	 * This method will copy all the data from pile and 
	 * transfer to an array file for display
	 * @return result array file to display all data from pile 
	 */
	public T[] toArray();
	
} // end BagInterface