package examples.pubhub.dao;

import java.util.List;

import examples.pubhub.model.Book;
import examples.pubhub.model.BookTag;

/**
 * Interface for our Data Access Object to handle database queries related to Books.
 */
public interface BookTagDAO {

	public List<BookTag> getAllBookDetails();
	public List<BookTag> getAllBooks();
	public List<BookTag> getAllTagsByBook(String isbn13);
	public List<Book> getBooksByTag1(String tag_name);
	public BookTag getBookByISBN(String isbn);
	
	public boolean Tag(BookTag bookTag);
	public boolean removeTag(BookTag bookTag);
	public boolean updateTag(BookTag bookTag);

	boolean addTag(BookTag bookTag);
	boolean updateTag1(BookTag bookTag);
	boolean removeTag1(BookTag bookTag);

}
