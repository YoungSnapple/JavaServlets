package web;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.*;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * Servlet implementation class Queue
 */
@WebServlet("/Queue")
public class Queue extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public Queue() {
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
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
		response.setContentType("text/html");
		String oneSequence=request.getParameter("numbers");//save the numbers input by user as a string
		PrintWriter out=response.getWriter();//initialize variable out so that I can print to the web app 
		String[]arr= oneSequence.split(",");//save the numbers entered into an array, they will be split on a comma
		int []numbers=new int[arr.length];//initialize new int array equal to the string array length
		for(int x=0;x<arr.length;x++) {
			numbers[x]=Integer.parseInt(arr[x]);//save the string numbers from the string arr into the int array numbers as ints
		
		}
		BinarySearch.sorting(numbers);//sort the array of integers using Kyle's binary search method
		PriorityQueue<Integer> queue = new PriorityQueue<>();// Initializes queue as a PriorityQueue that has Integer as its type and is set to create a new PriorityQueue
		for (int i=0; i<numbers.length;i++) {
			queue.offer(numbers[i]);//add each of the elements in the array of integers into the queue
		}
		out.println("<h1>The numbers have been added to the queue.</h1>");
		for (int i=0; i<numbers.length;i++) {
			out.println("\nThe "+(i+1)+" element in the queue is "+numbers[i]);
			out.println("<h1>\n</h1>");//print out to the web app the indexes and values that are in the queue, for this I just loop through the array
		}
		int firstElement = queue.peek();
		// Initializes firstElement as an int and sets it to the current highest priority
		// element in the queue
		
		queue.poll();
		// Deletes the current highest priority element in queue
		int secondElement = queue.peek();
		// Initializes secondElement as an int and sets it to the current highest priority
		// element in the queue
		out.println("<h1>\nThe product of the first and second integers in the queue is:</h1>");
		out.println(RecursiveMult.multRecursive(firstElement, secondElement));
		// Statement calls the method multRecursive and passes through
		// firsteElement and secondElement as its parameters and prints to the web app 
		// the product of the two numbers because the method returns an  int
		out.println("<h1>\nThe sum of the two numbers is:</h1>");
		out.println(Calculator.math(firstElement, secondElement, "Add"));//calculate sum of the two numbers using Shae's calculator method
	}

}
