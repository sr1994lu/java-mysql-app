import java.io.IOException;

import java.sql.SQLException;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import my.beans.db.MyDBAccess11;

/**
 * Servlet implementation class Servlet0021
 */
@WebServlet("/BeansDBServlet13")
public class BeansDBServlet13 extends HttpServlet {
	private static final long serialVersionUID = 1L;

    /**
     * @see HttpServlet#HttpServlet()
     */
    public BeansDBServlet13() {
        super();
        // TODO Auto-generated constructor stub
    }

		/**
		 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
		 */
		protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
			// TODO Auto-generated method stub

			response.setContentType("text/html; charset=UTF-8");
		    request.setCharacterEncoding("UTF-8");

		    MyDBAccess11 myObject = new MyDBAccess11();

		    myObject.update("33333",MyDBAccess11.SHIMEI,"あああああ");
			try {
				myObject.select();
			} catch (SQLException e) {
				e.printStackTrace();
			}
			myObject.close();
	    	request.setAttribute("myVal", myObject);
	    	RequestDispatcher dispatcher = request.getRequestDispatcher("BeansDBJSP11.jsp");
	    	dispatcher.forward(request, response);
		}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
	}

}

