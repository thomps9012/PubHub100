package examples.pubhub.servlets;

import java.io.ByteArrayOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.time.LocalDate;

import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.annotation.MultipartConfig;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.Part;

import com.sun.tools.javac.util.List;

import examples.pubhub.dao.BookDAO;
import examples.pubhub.dao.BookTagDAOImpl;
import examples.pubhub.model.Book;
import examples.pubhub.model.BookTag;
import examples.pubhub.utilities.DAOUtilities;

@MultipartConfig // This annotation tells the server that this servlet has
					// complex data other than forms
// Notice the lack of the @WebServlet annotation? This servlet is mapped the old
// fashioned way - Check the web.xml!
public class AddTagServlet extends HttpServlet {

	private static final long serialVersionUID = 1L;

	protected void doGet1(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		request.getRequestDispatcher("publishBook.jsp").forward(request, response);
	}

	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

		String isbn13 = req.getParameter("isbn13");
		String tag_name = req.getParameter("tag_name");

				BookTag bookTag=new BookTag();
				Book books=new Book();
				books.setIsbn13(isbn13);
				bookTag.setIsbn13(books);
				bookTag.setTagName(tag_name);
				try
				{
					BookTagDAOImpl bookTagDAOImpl=new BookTagDAOImpl();
					bookTagDAOImpl.addTag(bookTag);
					List <BookTag> bookTagObj=(List<BookTag>) bookTagDAOImpl.getAllBookDetails();
					ServletRequest request = null;
					request.setAttribute("AddTag",bookTagObj);
					request.getRequestDispatcher("BookListTag.jsp");
				}
				catch(Exception e)
				{
					e.printStackTrace();
				}

			}

		}