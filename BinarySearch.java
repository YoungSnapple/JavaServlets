package web;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.PrintWriter;
import java.util.Random;
import java.util.Scanner;
/**
 * Servlet implementation class BinarySearch
 */
@WebServlet("/BinarySearch")
public class BinarySearch extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public BinarySearch() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
    public static boolean binarySearch(int arr[], int elementToSearch) {

        int firstIndex = 0;
        int lastIndex = arr.length - 1;

        // termination condition (element isn't present)
        while(firstIndex <= lastIndex) {
            int middleIndex = (firstIndex + lastIndex) / 2;
            // if the middle element is our goal element, return its index
            if (arr[middleIndex] == elementToSearch) {
                return true;
            }

            // if the middle element is smaller
            // point our index to the middle+1, taking the first half out of consideration
            else if (arr[middleIndex] < elementToSearch)
                firstIndex = middleIndex + 1;

            // if the middle element is bigger
            // point our index to the middle-1, taking the second half out of consideration
            else if (arr[middleIndex] > elementToSearch)
                lastIndex = middleIndex - 1;

        }
        return false;
    }
    public static void numberSwap(int numOne, int numTwo, int[] numArray) {
		
		int temp = numArray[numOne];
		
		numArray[numOne] = numArray[numTwo];
		
		numArray[numTwo] = temp;
		
	}
	
	public static void sorting(int[] numArray) {
		int l = numArray.length;
		
		int m;
		
		for (int n = l; n >= 0; n--) {
		
			for (int i = 0; i < l - 1; i++) {
				
				m = i + 1;
				
				if (numArray[i] > numArray[m]) {
					
					numberSwap(i, m, numArray);
					
					
				}
				
			}
			
		}
		
	}
	
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		//response.getWriter().append("Served at: ").append(request.getContextPath());
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
		response.setContentType("text/html");
		PrintWriter out=response.getWriter();
	
		String oneSequence=request.getParameter("arr1");
		String[]arr= oneSequence.split(",");
		int []numbers=new int[arr.length];
		for(int x=0;x<arr.length;x++) {
			numbers[x]=Integer.parseInt(arr[x]);
		}
		out.print("<h1>You entered these unsorted numbers: </h1>");
		for (int i = 0; i < numbers.length; i++) {
        	if(i==numbers.length-1) {
        		out.println(numbers[i]);
        	}
        	else {
            out.print(numbers[i] + ", ");
        	}
            
        }
		out.println("<h1>The sorting method has sorted your numbers: </h1>");
		sorting(numbers);
		for (int i = 0; i < numbers.length; i++) {
        	if(i==numbers.length-1) {
        		out.println(numbers[i]);
        	}
        	else {
            out.print(numbers[i] + ", ");
        	}
            
        }
		
		int searchNum=Integer.parseInt(request.getParameter("number"));
		out.println("<h1>The number was found: </h1>");
		out.println(binarySearch(numbers,searchNum));
		
		
		
	}

}
