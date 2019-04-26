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
 * Servlet implementation class RecursiveAdd
 */
@WebServlet("/RecursiveAdd")
public class RecursiveAdd extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public RecursiveAdd() {
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
	//recursively add the first sum of the first n numbers 
	public static int addRecursive(int number1) {
		if(number1==0) {//base case, if the number is 0, return 0
			return 0;
		}
		else {
			return addRecursive(number1-1)+number1;//add the sum of the number and recursively call the next number(number1-1)
		}
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
		response.setContentType("text/html");
		PrintWriter out=response.getWriter();//initialize variable out so that I can print to the web app 
	
		int n1=Integer.parseInt(request.getParameter("number1"));//capture the user's input from the jsp form and convert that string value to an int
				
		out.println("<h1>"+"The sum of the first "+n1+" numbers is "+addRecursive(n1)+"</h1>");//print out the sum of the first n numbers to the web app

	}

}
