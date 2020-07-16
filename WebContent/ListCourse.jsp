<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
    <%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@page import="testHibernate.daoImpl.CourseDaoImpl"%>
<%@page import="java.util.ArrayList"%>
<%@page import="testHibernate.dto.Course"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">

<title>Insert title here</title>
<link rel="stylesheet"
	href="https://maxcdn.bootstrapcdn.com/bootstrap/3.4.1/css/bootstrap.min.css">
<script
	src="https://ajax.googleapis.com/ajax/libs/jquery/3.5.1/jquery.min.js"></script>
<script
	src="https://maxcdn.bootstrapcdn.com/bootstrap/3.4.1/js/bootstrap.min.js"></script>
<script>function myFunction() {
	  var txt;
	  var r = confirm("Press a button!");
	  if (r) {
	  window.location="Controller1?action=deleteCourse";
	  } else {
	   window.location="ListCourse.jsp";
	  }
	  
	 }
</script>
</head>
<body>
<table class="table">
  <thead>
    <tr>
      <th scope="col">#</th>
      <th scope="col">Course Id</th>
      <th scope="col">Course Name</th>
      <th scope="col">Course Fee</th>
      <th scope="col">Edit</th>
      <th scope="col">Delete</th>
    </tr>
  </thead>
  <tbody>
									<%
										CourseDaoImpl cdi = new CourseDaoImpl();
									ArrayList<Course> courses = (ArrayList) cdi.getCourseList();
									int count=0;
									for (Course course : courses) {
										count++;
									%>
									
									
    <tr>
      <th scope="row"><%=count %>></th>
      <td><%=course.getCourseId()%></td>
      <td><%=course.getCourseName()%></td>
      <td><%=course.getCourseFee()%></td>
      <td><a href="UpdateCourse.jsp?courseId=<%=course.getCourseId()%>">Edit</a></td>
       <td><a href="Controller1?action=deleteCourse&courseId=<%=course.getCourseId() %>">deleteCourse</a></td>
     
      
     
    </tr>
    <% } %>
    

  </tbody>
</table>

</body>
</html>