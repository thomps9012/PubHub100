package examples.pubhub.dao;

import java.sql.Blob;

import java.sql.Connection;
import java.sql.Date;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import examples.pubhub.model.Book;
import examples.pubhub.model.BookTag;
import examples.pubhub.utilities.DAOUtilities;

/**
 * Implementation for the BookTagDAO
 */
public class BookTagDAOImpl implements BookTagDAO {

	Connection connection = null;	// Our connection to the database
	PreparedStatement stmt = null;	// We use prepared statements to help protect against SQL injection
	
	/*------------------------------------------------------------------------------------------------*/
	
	
	@Override
	public List<BookTag> getAllBookDetails() {
		
		List<BookTag> bookTagObj = new ArrayList<>();

		try
		{
			connection=ConnectionUtility.getConnection();
			String sql="SELECT BOOKS.`ISBN_13`,BOOKS.`TITLE`,BOOKS.`AUTHOR`,BOOKS.`PUBLISH_DATE`,BOOKS.`CONTENT`,BOOKS.`PRICE`,BOOKS.`STATUS`,BOOK_TAGS.`TAG_NAME` FROM BOOKS JOIN BOOK_TAGS ON BOOKS.`ISBN_13`=BOOK_TAGS.`ISBN_13`;";
			stmt=connection.prepareStatement(sql);
			ResultSet rs=stmt.executeQuery();
			
			while(rs.next())
			{
				Book books=new Book();
				books.setIsbn13(rs.getString("isbn_13"));
				books.setTitle(rs.getString("title"));
				books.setAuthor(rs.getString("author"));
				books.setPublishDate(rs.getDate("publish_Date").toLocalDate());
				books.setContent(rs.getBytes("content"));
				books.setPrice(rs.getDouble("price"));
								
				BookTag bookTag=new BookTag();
				books.setIsbn13(rs.getString("isbn13"));
				bookTag.setIsbn13(rs.getString("isbn13"));
				bookTag.setTagName(rs.getString("tag_Name"));
				bookTagObj.add(bookTag);
				
			}
			rs.close();
		}
		catch (Exception e) {
			e.printStackTrace();
		} finally {
			closeResources();
		}
		return bookTagObj;
	}
	

	/*------------------------------------------------------------------------------------------------*/

	
	@Override
	public boolean addTag(BookTag bookTag) {
		
		try {
			connection = DAOUtilities.getConnection();
			String sql = "INSERT INTO BOOK_TAGS (ISBN13, TAG_NAME)VALUES(?,?)";
			stmt = connection.prepareStatement(sql);
			
			// But that's okay, we can set them all before we execute
			stmt.setString(1, bookTag.getIsbn13());
			stmt.setString(2, bookTag.getTagName());
			
			int rows=stmt.executeUpdate();
			System.out.println("Number of rows:" + rows);
						
		} catch (SQLException e) {
			e.printStackTrace();
			return true;
		} finally {
			closeResources();
		}
		return false;
	}

	
	/*------------------------------------------------------------------------------------------------*/

	
	@Override
	public boolean removeTag1(BookTag bookTag) {
		
		try {
			connection = DAOUtilities.getConnection();
			String sql = "DELETE FROM BOOK_TAGS WHERE ISBN13=?";
			stmt = connection.prepareStatement(sql);
			
			// But that's okay, we can set them all before we execute
			stmt.setString(1, bookTag.getIsbn13());
			
			
			int rows=stmt.executeUpdate();
			System.out.println("Number of rows:" + rows);
						
		} catch (SQLException e) {
			e.printStackTrace();
			return true;
		} finally {
			closeResources();
		}
		return false;
	}

	
	/*------------------------------------------------------------------------------------------------*/

	
	@Override
	public boolean updateTag1(BookTag bookTag) {
		
		try {
			connection = DAOUtilities.getConnection();
			String sql = "UPDATE BOOK_TAGS SET TAG_NAME=? WHERE ISBN13=?";
			stmt = connection.prepareStatement(sql);
			
			// But that's okay, we can set them all before we execute
			stmt.setString(1, bookTag.getTagName());
			stmt.setString(2, bookTag.getIsbn13());
			
			int rows=stmt.executeUpdate();
			System.out.println("Number of rows:" + rows);
						
		} catch (SQLException e) {
			e.printStackTrace();
			return true;
		} finally {
			closeResources();
		}
		return false;
	}

	
	/*------------------------------------------------------------------------------------------------*/

	// Closing all resources is important, to prevent memory leaks. 
	// Ideally, you really want to close them in the reverse-order you open them
	private void closeResources() {
		try {
			if (stmt != null)
				stmt.close();
		} catch (SQLException e) {
			System.out.println("Could not close statement!");
			e.printStackTrace();
		}
		
		try {
			if (connection != null)
				connection.close();
		} catch (SQLException e) {
			System.out.println("Could not close connection!");
			e.printStackTrace();
		}
	}


	@Override
	public boolean Tag(BookTag bookTag) {
		// TODO Auto-generated method stub
		return false;
	}


	@Override
	public boolean removeTag(BookTag bookTag) {
		// TODO Auto-generated method stub
		return false;
	}


	@Override
	public boolean updateTag(BookTag bookTag) {
		// TODO Auto-generated method stub
		return false;
	}


	@Override
	public List<BookTag> getAllBooks() {
		// TODO Auto-generated method stub
		return null;
	}


	@Override
	public List<BookTag> getAllTagsByBook(String isbn13) {
		// TODO Auto-generated method stub
		return null;
	}


	@Override
	public List<Book> getBooksByTag1(String tag_name) {
		// TODO Auto-generated method stub
		return null;
	}


	@Override
	public BookTag getBookByISBN(String isbn) {
		// TODO Auto-generated method stub
		return null;
	}
	
}


