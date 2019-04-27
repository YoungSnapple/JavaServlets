<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Calculator Methods</title>
</head>
<body>
<form action="CALCULATOR" method="post"><!-- This is a form to capture the user's two integers and one string value that are input,they are all saved as strings  -->
<h1>Enter two numbers that will be used with the calculator.</h1>
First number: <input type="text" name="number1"/><br/>
Second number: <input type="text" name="number2"/><br/>
    <br/>


    <input type="radio" name="operation" value="Addition"> Addition<br>
    <input type="radio" name="operation" value="Subtraction"> Subtraction<br>
    <input type="radio" name="operation" value="Multiplication"> Multiplication (Using a Recursive Function!)<br>
    <input type="radio" name="operation" value="Division"> Division<br>
    <br/>
    <input type="submit" value="Submit" name="operation">

</form>
<img src="https://us.123rf.com/450wm/seamartini/seamartini1508/seamartini150800325/43735139-stock-vector-cartoon-smiling-electronic-calculator-character-with-pen-and-note-paper-with-calculations-in-hands-f.jpg?ver=6" style="width: 400px;"/>
</body>
</html>