//Lance Graham
//IT 214 Section 01 
//Group Project

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
	//method recursively finds the product of two numbers
	public static int multRecursive(int number1, int number2) {
		if(number1==0||number2==0) {//base case occurs if either of the numbers equals zero
			return 0;
		}
		else {//keeps adding number ones value and recursively calling the function again with number2 minus one
			return number1+multRecursive(number1,number2-1);//this will eventually sum the numbers up to the value equivalent to the product of the two numbers
		}
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
		response.setContentType("text/html");
		PrintWriter out=response.getWriter();//initialize variable out so that I can print to the web app 
		
		int n1=Integer.parseInt(request.getParameter("number1"));//capture the user's input from the jsp form and convert that string value to an int
				
		int n2=Integer.parseInt(request.getParameter("number2"));//capture the user's input from the jsp form and convert that string value to an int
		out.println("<h1>"+"The product of the two numbers is "+multRecursive(n1,n2)+"</h1>");//print out the product of the two numbers to the web app
	

	}

}
