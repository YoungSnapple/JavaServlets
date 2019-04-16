import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import com.NOTICS.sorting.*;

@WebServlet(name = "MathServlet")
public class MathServlet extends HttpServlet {

    private static double  factorial(double n){
        if (n == 0)
            return 1;
        else
            return (n * factorial(n-1));
    }

    private double math(double num1, double num2, String operation) {

        if (operation.equals("Fact")) {
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

    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

        String operation = request.getParameter("operation");
        int i = Integer.parseInt(request.getParameter("num1"));
        int j = Integer.parseInt(request.getParameter("num2"));

        response.getWriter();
        response.getWriter().println("Result is " + math(i, j, operation));

    }
}
