package UserLoginPackage;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

/**
 * Servlet implementation class LoginServlet
 */
@WebServlet("/LoginServlet")
public class LoginServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public LoginServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

		String name = request.getParameter("name");
		String password = request.getParameter("password");
		response.setContentType("text/html; charset=UTF-8");
		PrintWriter out = response.getWriter();
		AccountManager accounts = (AccountManager) request.getServletContext().getAttribute("accounts");
		if (accounts.correctPassword(name, password)){
			out.println("<!DOCTYPE html>");
			out.println("<html>");
			out.println("<head>");
			out.println("<meta charset=\"UTF-8\" />");
			out.println("<title>Welcome " + name + "</title>");
			out.println("</head>");
			out.println("<body>");
			out.println("<h1>Welcome " + name + "</h1>");
			out.println("</body>");
			out.println("</html>");
		} else {
			RequestDispatcher dispatch = request.getRequestDispatcher("incorrect.html");
			dispatch.forward(request, response);
		}
		
		
	}

}
