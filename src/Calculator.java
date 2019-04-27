import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * Servlet implementation class Calculator
 */
@WebServlet("/Calculator")
public class Calculator extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public Calculator() {
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
	public static double  factorial(double n){
        if (n == 0)
            return 1;
        else
            return (n * factorial(n-1));
    }

    public static double math(double num1, double num2, String operation) {

        if (operation.equals("Factorial")) {
            return factorial(num1);
        }

        if (operation.equals("Add")) {
            return num1 + num2;
        }

        if (operation.equals("Subtract")) {
            return num1 - num2;

        }

        if (operation.equals("Multiply")) {
            return num1 * num2;

        }
        else {
            return num1 / num2;

        }
    }
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
		response.setContentType("text/html");
		PrintWriter out=response.getWriter();//initialize variable out so that I can print to the web app 
		
		int n1=Integer.parseInt(request.getParameter("number1"));//capture the user's input from the jsp form and convert that string value to an int
				
		int n2=Integer.parseInt(request.getParameter("number2"));//capture the user's input from the jsp form and convert that string value to an int
		
		String n3 =request.getParameter("number3");//capture the user's string input from jsp form and save it as a string
		if(n3.contentEquals("Factorial")) {
			out.println("<h1>The factorial of "+n1+" equals "+math(n1,n2,n3)+"</h1>");//Print out factorial of first number and second number, if the string, number3 equals factorial
			out.println("<h1>The factorial of "+n2+" equals "+math(n2,n1,n3)+"</h1>");
		}
		else {
		out.println("<h1>The "+n3+" of "+n1+" and "+n2+" equals "+math(n1,n2,n3)+"</h1>");//print out the addition, subtraction, multiplication, or division of the first two numbers
		}
	}
	

}
