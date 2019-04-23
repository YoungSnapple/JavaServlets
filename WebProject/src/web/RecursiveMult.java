//Lance Graham
//IT 214 Section 01 
//Group Project
package web;

import java.io.IOException;
import java.io.PrintWriter;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * Servlet implementation class RecursiveMult
 */
@WebServlet("/RecursiveMult")
public class RecursiveMult extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public RecursiveMult() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		//response.getWriter().append("Served at: ").append(request.getContextPath());
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	public static int multRecursive(int number1, int number2) {
		if(number1==0||number2==0) {
			return 0;
		}
		else {
			return number1+multRecursive(number1,number2-1);
		}
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
		response.setContentType("text/html");
		PrintWriter out=response.getWriter();
		
		int n1=Integer.parseInt(request.getParameter("number1"));
				
		int n2=Integer.parseInt(request.getParameter("number2"));
		out.println("<h1>"+"The product of the two numbers is "+multRecursive(n1,n2)+"</h1>");

	}

}
