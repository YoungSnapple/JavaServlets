// Code By Shae Feltz
// IT 214
// Group Project

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;

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

    public static double multRecursive(double number1, double number2) {
        if (number1 == 0 || number2 == 0) {//base case occurs if either of the numbers equals zero
            return 0;
        } else {//keeps adding number ones value and recursively calling the function again with number2 minus one
            return number1 + multRecursive(number1, number2 - 1);//this will eventually sum the numbers up to the value equivalent to the product of the two numbers
        }
    }

    /**
     * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
     */

    public static double math(double num1, double num2, String operation) {


        if (operation.equals("Addition")) {
            return num1 + num2;
        }

        if (operation.equals("Subtraction")) {
            return num1 - num2;

        }

        if (operation.equals("Multiplication")) {
            return multRecursive(num1, num2);

        } else {
            return num1 / num2;

        }
    }

    /**
     * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
     */
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        // TODO Auto-generated method stub
        //response.getWriter().append("Served at: ").append(request.getContextPath());
    }

    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        PrintWriter out = response.getWriter();//initialize variable out so that I can print to the web app

        double n1 = Double.parseDouble(request.getParameter("number1"));//capture the user's input from the jsp form and convert that string value to an int
        double n2 = Double.parseDouble(request.getParameter("number2"));//capture the user's input from the jsp form and convert that string value to an int
        String operation = request.getParameter("operation");//capture the user's string input from jsp form and save it as a string
        double result = math(n1, n2, operation);
        out.println("<h1>The " + operation + " of " + n1 + " and " + n2 + " equals " + result + "</h1>");//print out the addition, subtraction, multiplication, or division of the first two numbers
    }
}

