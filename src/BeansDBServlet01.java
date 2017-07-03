

import java.io.IOException;

import java.sql.SQLException;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import my.beans.db.MyDBAccess01;

/**
 * Servlet implementation class BeansDBServlet01
 */
@WebServlet("/BeansDBServlet01")
public class BeansDBServlet01 extends HttpServlet {
	private static final long serialVersionUID = 1L;

    /**
     * @see HttpServlet#HttpServlet()
     */
    public BeansDBServlet01() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		//response.getWriter().append("Served at: ").append(request.getContextPath());

		MyDBAccess01 myObject = new MyDBAccess01();
		try {
			myObject.select();
		} catch (SQLException e) {
			e.printStackTrace();
		}
		myObject.close();
		request.setAttribute( "myVal", myObject );
		RequestDispatcher dispatcher = request.getRequestDispatcher("/BeansDBJSP01.jsp");
		dispatcher.forward(request, response);


	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
