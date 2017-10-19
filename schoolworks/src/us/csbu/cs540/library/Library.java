package us.csbu.cs540.library;

import java.util.HashMap;
import java.util.Iterator;
import java.util.Map.Entry;

public class Library {
	String address;
	HashMap<String, Book> booksDatabase;
	
	public Library(String libraryAddress) {
		this.address = libraryAddress;
		this.booksDatabase = new HashMap<String, Book>();
	}

	// Add the missing implementation to this class
	public static void main(String[] args) { 
		// Create two libraries 
		Library firstLibrary = new Library("10 Main St.");
		Library secondLibrary = new Library("228 Liberty St."); 
		// Add four books to the first library
		firstLibrary.addBook(new Book("The Da Vinci Code"));
		firstLibrary.addBook(new Book("Le Petit Prince"));
		firstLibrary.addBook(new Book("A Tale of Two Cities"));
		firstLibrary.addBook(new Book("The Lord of the Rings"));
		// Print opening hours and the addresses
		System.out.println("Library hours:");
		printOpeningHours();
		System.out.println();
		
		System.out.println("Library addresses:");
		firstLibrary.printAddress();
		secondLibrary.printAddress();
		System.out.println();
		
		// Try to borrow The Lords of the Rings from both libraries
		System.out.println("Borrowing The Lord of the Rings:");
		firstLibrary.borrowBook("The Lord of the Rings");
		firstLibrary.borrowBook("The Lord of the Rings");
		secondLibrary.borrowBook("The Lord of the Rings");
		System.out.println();
		
		// Print the titles of all available books from both libraries
		System.out.println("Books available in the first library:");
		firstLibrary.printAvailableBooks();
		System.out.println();
		System.out.println("Books available in the second library:");
		secondLibrary.printAvailableBooks();
		System.out.println();
		
		// Return The Lords of the Rings to the first library
		System.out.println("Returning The Lord of the Rings:");
		firstLibrary.returnBook("The Lord of the Rings");
		System.out.println();
		
		// Print the titles of available from the first library
		System.out.println("Books available in the first library:");
		firstLibrary.printAvailableBooks(); 
	}

	/**
	 * to return a book
	 * @param string
	 * @return is return success or not
	 */
	public boolean returnBook(String bookTitle) {
		Book book = this.booksDatabase.get(bookTitle);
		if (book == null) {
			return false;
		}
		if (!book.borrowed) {
			return false;
		}
		book.returned();
		return true;
	}

	public void printAvailableBooks() {
		Iterator<Entry<String, Book>> it = this.booksDatabase.entrySet().iterator();
		if (this.booksDatabase.isEmpty()) {
			System.out.println("No book in catalog");
			return;
		}
		while (it.hasNext()) {
			HashMap.Entry<String, Book> pair = (HashMap.Entry<String, Book>) it.next();
			if (pair.getValue().isBorrowed()) {
				continue;
			}
			System.out.println(pair.getValue().getTitle());
		}
	}

	/**
	 * borrow a book
	 * @param bookTitle
	 * @return is borrow success or not
	 */
	public boolean borrowBook(String bookTitle) {
		Book book = this.booksDatabase.get(bookTitle);
		if (book == null) {
			return false;
		}
		if (book.borrowed) {
			return false;
		}
		book.rented();
		return true;
	}

	public void printAddress() {
		System.out.println(this.address);
	}

	public static void printOpeningHours() {
		System.out.println("Libraries are open daily from 9am to 5pm.");
	}

	public void addBook(Book book) {
		this.booksDatabase.put(book.getTitle(), book);
	}
}
