//Kyle Peterson and Lance Graham 
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
    public static boolean binarySearch(int array1[], int searchElement) {

        int indexOne = 0;//first index
        int indexLast = array1.length - 1;//last index in array

        
        while(indexOne <= indexLast) {
            int midNum = (indexOne + indexLast) / 2;//divides array into two and finds middle number
           
            if (array1[midNum] == searchElement) {//middle number is the element we are searching for so we return true
                return true;
            }

            
            // number is not in the first half of the array, but could be in upper half
            else if (array1[midNum] < searchElement)
                indexOne = midNum + 1;

            
            // number is not in upper half of array, but could be in lower half yet
            else if (array1[midNum] > searchElement)
                indexLast = midNum - 1;

        }
        return false;//element was not found so false is returned 
    }
    public static void numberSwap(int numOne, int numTwo, int[] numArray) {
		// A public static void method that takes in two ints and an int array into the parameters
		
		int temp = numArray[numOne];
		// temp initialized as an int and set to the number at the index of numArray[numOne]
		
		numArray[numOne] = numArray[numTwo];
		// Sets the number at numArray[numOne] to the number at numArray[numTwo]
		
		numArray[numTwo] = temp;
		// Sets numArray[numTwo] to what was stored in temp effectively swapping numbers from 
		// numArray[numOne] to numArray[numTwo] and vice versa
		
	}
	
	public static void sorting(int[] numArray) {
		// A public static void method that takes in an int array
		
		int l = numArray.length;
		// Initializes l as an int and sets it to the length of numArray 
		
		int m;
		// Initializes m as an int but doesn't set it to anything
		
		for (int n = l; n >= 0; n--) {
		// For loop that initializes n as an int and sets it to l, argument is set to n >= 0, and
		// counts n down one for each time it loops through
		
			for (int i = 0; i < l - 1; i++) {
			// A nested for loop that initializes i as an int and sets it to 0, sets argument to i < l -1,
			// and counts i up one each time it loops through
				
				m = i + 1;
				// Sets m equal to i + 1
				
				if (numArray[i] > numArray[m]) {
				// If statement that determines if numArray[i] is greater than numArray[m] if it returns
				// true it runs through the statement
					
					numberSwap(i, m, numArray);
					// Calls numerSwap to switch the numbers at i and m in the array
					
		
					
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
	
		String oneSequence=request.getParameter("arr1");//save the numbers input by user as a string
		String[]arr= oneSequence.split(",");//save the numbers entered into an array, they will be split on a comma
		int []numbers=new int[arr.length];//initialize new int array equal to the string array length
		for(int x=0;x<arr.length;x++) {
			numbers[x]=Integer.parseInt(arr[x]);//save the string numbers from the string arr into the int array numbers as ints
		}
		out.print("<h1>You entered these unsorted numbers: </h1>");//print out the unsorted numbers to the web app
		for (int i = 0; i < numbers.length; i++) {
        	if(i==numbers.length-1) {
        		out.println(numbers[i]);
        	}
        	else {
            out.print(numbers[i] + ", ");
        	}
            
        }
		out.println("<h1>The sorting method has sorted your numbers: </h1>");//print out the sorted numbers to the web app
		sorting(numbers);
		for (int i = 0; i < numbers.length; i++) {
        	if(i==numbers.length-1) {
        		out.println(numbers[i]);
        	}
        	else {
            out.print(numbers[i] + ", ");
        	}
            
        }
		
		int searchNum=Integer.parseInt(request.getParameter("number"));//get the search number inputed by the user
		out.println("<h1>The number was found: </h1>");
		out.println(binarySearch(numbers,searchNum));//call binarSearch method that returns true or false depending whether the element was in the array
		
		
	}

}
