/**
 * This class will demonstrates all the required implementation
 * for Task 3.
 * @author Alan Huang
 */
public class NodeTest {

	public static void main(String[] args) {
		
		BagInterface<String> bookPiles = new LinkedNodes<String>();
		
		System.out.println("*************************************************************************************************************\n");
		
		System.out.println("We will add 6 books to the pile.\n\n");
		
		System.out.println("let's check if the pile is empty right now:  " +"(" +bookPiles.isEmpty() +")" +"\n\n" );
		
		String [] contentsOfBook ={"Rich Dad Poor Dad", "10% Happier", "The Path to Love",
				"Data Structures", "Fuel Injection System", "Peaceful Warrior"  };
		
		testAdd(bookPiles, contentsOfBook);
		
		
		System.out.println("Which book is on the top now? " +"(" +bookPiles.topOfBook() +")" +"\n\n");
		
		System.out.println("*************************************************************************************************************\n");
		
		System.out.println("We want to remove (Data Structures) from the pile now, "
				+ "but we need to remove all the books on top first. \n");
		
		System.out.println("Let's begin\n");
		
		
		bookPiles.remove("Data Structures");
		
		System.out.println("Which book is at the top now? " +"(" + bookPiles.topOfBook() +")" +"\n");
		
		System.out.println("*************************************************************************************************************\n");

		
		System.out.println("let's check if the pile is empty right now:  " +"(" +bookPiles.isEmpty() +")" +"\n" );
		
		System.out.println("Let's add a textbook (Starting Out with Java) to the pile\n");
		
		bookPiles.add("Starting Out with Java ");
		
		System.out.println("Which book is at the top now? " +"(" + bookPiles.topOfBook() +")" +"\n");
		
		System.out.println("*************************************************************************************************************\n");

		displayBag(bookPiles);
		
		System.out.println("Which book is at the top now? " +"(" + bookPiles.topOfBook() +")" +"\n");
		
		System.out.println("*************************************************************************************************************\n");
		
	}
	/**
	 * This private inner method will save each variable from contentsOfBook array
	 * @param bookPiles the pile I create to store all the books
	 * @param contentsOfBook array that store 6 different books title
	 */
	private static void testAdd(BagInterface<String> bookPiles, String[] contentsOfBook)
	{
    	System.out.print("Adding books to the bag: ");
    	
    	for (int index= 0; index < contentsOfBook.length; index++)
		{
			
    		bookPiles.add(contentsOfBook[index]);
            
        	System.out.print(" (" +contentsOfBook[index] +") ");
		}//end for
    	
    	System.out.println("\n\n");
    		
	}
	
	/**
	 * This private inner class will call toArray methods from LinkedNodes
	 * to copy each oh books that still remain on the pile
	 * @param piles is the pile where I need to check how many books still
	 * remain
	 */
	private static void displayBag(BagInterface<String> piles)
	{
		System.out.println("How many books we hava now ?" +"(" + piles.getCurrentSize() +")\n");	
		
		Object[] bagArray = piles.toArray();
		
		System.out.print("The pile have ");
		
		for (int index = 0; index < bagArray.length; index++)
		{
			System.out.print("(" +bagArray[index] + ") ");
		} // end for
		
		System.out.println("\n");
	} // end displayBag


}
