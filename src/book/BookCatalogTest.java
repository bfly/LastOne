package book;	// 20220418
import static org.junit.jupiter.api.Assertions.*;

import java.util.*;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import book.file.BookFileReader;

class BookCatalogTest {

	// lists to store lines from different loaded book files
	List<String> catInTheHat;
	List<String> warAndPeace;
	List<String> siddhartha;

	// book objects to be created from lines 
	Book catInTheHatBook;
	Book warAndPeaceBook;
	Book siddharthaBook;
		
	@BeforeEach
	void setUp() throws Exception {
		
		////////////////////////////////////////////////
		///// DO NOT MODIFY THE TEST CODE BELOW! ///////

		//load and parse cat in the hat snippet book file
		this.catInTheHat = BookFileReader.parseFile("the_cat_in_the_hat_snippet.txt");
		
		//create book object from list of lines from cat in the hat snippet
		this.catInTheHatBook = new Book(this.catInTheHat);
		
		//load and parse war and peace book file
		this.warAndPeace = BookFileReader.parseFile("war_and_peace.txt");
		
		//create book object from list of lines from war and peace
		this.warAndPeaceBook = new Book(this.warAndPeace);
		
		//load and parse siddhartha book file
		this.siddhartha = BookFileReader.parseFile("siddhartha.txt");
		
		//create book object from list of lines from siddhartha
		this.siddharthaBook = new Book(this.siddhartha);
		
		///// DO NOT MODIFY THE TEST CODE ABOVE! ///////
		////////////////////////////////////////////////
				
	}

	@Test
	void testAddBook() {
		
		//////////////////////////////////////////////
		///// DO NOT MODIFY THE TEST CODE BELOW! /////
		
		BookCatalog bookCatalog = new BookCatalog();

		//create book with title, and add to catalog
		List<String> bookLines = new ArrayList<>();
		bookLines.add("Title: Test book.Book Title");
		Book book = new Book(bookLines);
		bookCatalog.addBook(book);
		
		//catalog should contain 1 book
		Assertions.assertEquals(1, bookCatalog.getBookMap().size(), "After adding 1 book to an empty book catalog, the book catalog should now have 1 book.");
		
		//create another book with title, and add to catalog
		bookLines = new ArrayList<>();
		bookLines.add("Title:    Another book.Book Title");
		book = new Book(bookLines);
		bookCatalog.addBook(book);
		
		//catalog should contain 2 books
		Assertions.assertEquals(2, bookCatalog.getBookMap().size(), "After adding 1 book to a book catalog that already had 1 book, the book catalog should now have 2 books.");
		
		
		//add cat in the hat
		bookCatalog.addBook(this.catInTheHatBook);

		//catalog should contain 3 books
		Assertions.assertEquals(3, bookCatalog.getBookMap().size(), "After adding 'The Cat in the Hat' to a book catalog that already had 2 books, the book catalog should now have 3 books.");
		
		///// DO NOT MODIFY THE TEST CODE ABOVE! /////
		//////////////////////////////////////////////
		
		
		// TODO insert 2 additional test cases
        // Hint(s): Add war and peace and siddhartha book objects and check bookmap 
	}

	@Test
	void testGetBookByTitle() {
		
		////////////////////////////////////////////////
		///// DO NOT MODIFY THE TEST CODE BELOW! ///////
		
		//create book catalog
		BookCatalog bookCatalog = new BookCatalog();
		
		//create book with title and add to catalog
		List<String> bookLines = new ArrayList<>();
		bookLines.add("Title: Test book.Book Title");
		Book book = new Book(bookLines);
		bookCatalog.addBook(book);
		
		//get book from catalog
		Book catalogBook = bookCatalog.getBookByTitle("Test book.Book Title");
		
		//test book
		Assertions.assertEquals("Test book.Book Title", catalogBook.getTitle(), "The expected title does not match the actual title from the book from the catalog.");
		
		//create another book and add to catalog
		bookLines = new ArrayList<>();
		bookLines.add("Title:     Another book.Book Title");
		book = new Book(bookLines);
		bookCatalog.addBook(book);
		
		//get book from catalog
		catalogBook = bookCatalog.getBookByTitle("Another book.Book Title");
		
		//test book
		Assertions.assertEquals("Another book.Book Title", catalogBook.getTitle(), "The expected title does not match the actual title from the book from the catalog.");
		
		//add cat in the hat
		bookCatalog.addBook(this.catInTheHatBook);

		//get book from catalog
		catalogBook = bookCatalog.getBookByTitle("The Cat in the Hat");
		
		//test book
		Assertions.assertEquals("The Cat in the Hat", catalogBook.getTitle(), "The expected title does not match the actual title from 'The Cat in the Hat' book from the catalog.");
		
		///// DO NOT MODIFY THE TEST CODE ABOVE! /////
		//////////////////////////////////////////////
		
		
		// TODO insert 2 additional test cases
        // Hint(s): Add war and peace and siddhartha book objects and get them by title
	}

	@Test
	void testGetBookByAuthor() {
		
		////////////////////////////////////////////////
		///// DO NOT MODIFY THE TEST CODE BELOW! ///////
		
		//create book catalog
		BookCatalog bookCatalog = new BookCatalog();
		
		//create book with title and author and add to catalog
		List<String> bookLines = new ArrayList<>();
		bookLines.add("Title: My book.Book Title");
		bookLines.add("Author: Joseph Berry");
		Book book = new Book(bookLines);
		bookCatalog.addBook(book);
		
		//get book from catalog
		Book catalogBook = bookCatalog.getBookByAuthor("Joseph Berry");
		
		//test book
		Assertions.assertEquals("Joseph Berry", catalogBook.getAuthor(), "The expected author does not match the actual author from the book from the catalog.");
		
		//create another book and add to catalog
		bookLines = new ArrayList<>();
		bookLines.add("Title:     My Other book.Book Title");
		bookLines.add("Author:    Rhonda Fierri");
		book = new Book(bookLines);
		bookCatalog.addBook(book);
		
		//get book from catalog
		catalogBook = bookCatalog.getBookByAuthor("Rhonda Fierri");
		
		//test book
		Assertions.assertEquals("Rhonda Fierri", catalogBook.getAuthor(), "The expected author does not match the actual author from the book from the catalog.");
		
		//add cat in the hat
		bookCatalog.addBook(this.catInTheHatBook);

		//get book from catalog
		catalogBook = bookCatalog.getBookByAuthor("Dr. Seuss");
		
		//test book
		Assertions.assertEquals("Dr. Seuss", catalogBook.getAuthor(), "The expected author does not match the actual author from 'The Cat in the Hat' book from the catalog.");

		///// DO NOT MODIFY THE TEST CODE ABOVE! ///////
		////////////////////////////////////////////////

		
		// TODO insert 2 additional test cases
        // Hint(s): Add war and peace and siddhartha book objects and get them by author
	}

}
