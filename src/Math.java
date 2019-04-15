import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@WebServlet(name = "Math")
public class Math extends HttpServlet {

    private double math(double num1, double num2, String operation) {

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
