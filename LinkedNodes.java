/**
 * This class implements the interface BagInterface to 
 * demonstrate how to use linked nodes to store book's
 * name to data.
 * @author Alan Huang
 * @param <T>
 */
public final class LinkedNodes<T> implements BagInterface<T>
{
   private Node firstNode;       // Reference to first node
   private int numberOfEntries;  //Number of book input so far

	/**  Adds a new entry to this linked node pile.
	 *   @param newEntry  The object to be added as a new entry
	 *   @return  True if the addition is successful, or false if not. 
     */
   public boolean add(T newEntry)  	      
   {
		Node newNode = new Node(newEntry); 
		newNode.next = firstNode; 
                                        
        firstNode = newNode;      
		numberOfEntries++;   //increase number of entry  
      
		return true; 
	} 
   
   /**
    * This method will remove one book from the 
    * top of pile
    */
   public T remove()
   {
      T result = null; // create a variable to return the name of book been remove
      
      if (firstNode != null)
      {
         result = firstNode.getData();
         firstNode = firstNode.getNextNode(); 
         numberOfEntries--;
      } // end if
  
      return result;   
   } // end remove
   
   
   /**
    * This method remove a specified book from the pile. also
    * remove all the books that is on top of the specified book
    */
   public boolean remove(T anEntry)
   {
	   boolean found = false;
	   Node nodeN = getReferenceTo(anEntry);
	      	
			while (!found && (nodeN != null))
			{
				
				if (firstNode == nodeN )
				{
					System.out.println("We are removing " +"(" 
				+firstNode.getData() +") "+"\n");
					
					found = true;
					firstNode = firstNode.getNextNode();
				    numberOfEntries--;
	            }
				else
				{
					System.out.println("We are removing " +"(" 
				+firstNode.getData() +")" +"\n");
					
					firstNode = firstNode.getNextNode();
	                numberOfEntries--;
				}
			} // end while
	   
			return true;
   } // end remove
   
   /**
    * This method will return the total number of books on the pile so far.
    */
   public int getCurrentSize()
   {
      return numberOfEntries;
   } // end getCurrentSize
   
   /**
    * This method return true is the pile is empty, and false
    * when the pile is not empty
    */
   public boolean isEmpty()
   {
      return numberOfEntries == 0;
   } // end isEmpty
   
   /**
    * This method will remove all the books from the pile
    */
   public void clear()
   {
      while (!isEmpty())
         remove();
   } // end clear
   
   /**
    *  This method return the name of the book at the top of pile
    */
   public T topOfBook()
   {
	   return firstNode.data;
   }
  
   /**
    * This private method help locating the book we want to delete
    * and help remove method remove the right book
    */
	private Node getReferenceTo(T anEntry)
	{
		boolean found = false;
		Node currentNode = firstNode;
		
		while (!found && (currentNode != null))
		{
			if (anEntry.equals(currentNode.getData()))
				found = true;
			else
				currentNode = currentNode.getNextNode();
		} // end while
     
		return currentNode;
	} // end getReferenceTo
	
	/**
	 * This method copy every node's data to an array 
	 * and return the array for display method in main  
	 */
	public T[] toArray()
	{
      // The cast is safe because the new array contains null entries
      @SuppressWarnings("unchecked")
      T[] result = (T[])new Object[numberOfEntries]; // Unchecked cast

      int index = 0;
      Node currentNode = firstNode;
      while ((index < numberOfEntries) && (currentNode != null))
      {
         result[index] = currentNode.getData();
         index++;
         currentNode = currentNode.getNextNode();
      } // end while
      	
		return result;
	} // end toArray
 
	
	/** 
	 *  a private inner class to created linked node
	 */
	private class Node
	{
	  private T    data; // Entry in bag
	  private Node next; // Link to next node

		private Node(T dataPortion)
		{
			this(dataPortion, null);	
		} // end constructor
		
		private Node(T dataPortion, Node nextNode)
		{
			data = dataPortion;
			next = nextNode;	
		} // end constructor
      
      private T getData()
      {
         return data;
      } // end getData
      
      private void setData(T newData)
      {
         data = newData;
      } // end setData
      
      private Node getNextNode()
      {
         return next;
      } // end getNextNode
      
      private void setNextNode(Node nextNode)
      {
         next = nextNode;
      } // end setNextNode
	} // end Node
} // end LinkedBag


