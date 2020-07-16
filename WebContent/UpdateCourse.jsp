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
<Style>
body {
	background-color: #525252;
}

.centered-form {
	margin-top: 60px;
}

.centered-form .panel {
	background: rgba(255, 255, 255, 0.8);
	box-shadow: rgba(0, 0, 0, 0.3) 20px 20px 20px;
}
</Style>
</head>
<body>
	<link
		href="//netdna.bootstrapcdn.com/bootstrap/3.1.0/css/bootstrap.min.css"
		rel="stylesheet" id="bootstrap-css">
	<script
		src="//netdna.bootstrapcdn.com/bootstrap/3.1.0/js/bootstrap.min.js"></script>
	<script src="//code.jquery.com/jquery-1.11.1.min.js"></script>
	<!------ Include the above in your HEAD tag ---------->

	<div class="container">
		<jsp:include page="navbar.jsp" />
		<div class="row centered-form">
			<div
				class="col-xs-12 col-sm-8 col-md-4 col-sm-offset-2 col-md-offset-4">
				<div class="panel panel-default">
					<div class="panel-heading">
						<h3 class="panel-title">Please add the details for Course</h3>
					</div>
					<div class="panel-body">
					
					<%Integer courseId=Integer.valueOf(request.getParameter("courseId"));	
								out.print(courseId);
					CourseDaoImpl coursedao=new CourseDaoImpl();
						coursedao.getCourse(courseId);
						Course course=coursedao.getCourse(courseId);
						%>
						<form role="form" action="Controller1?action=updateCourse"
							method="post">
							<div class="row">
								<div class="col-xs-6 col-sm-6 col-md-6">
									<div class="form-group">
										<input type="text" name="courseId" id="courseId"
											class="form-control input-sm" value=<%=course.getCourseId() %>>
									</div>
								</div>
								<div class="col-xs-6 col-sm-6 col-md-6">
									<div class="form-group">
										<input type="text" name="courseName" id="courseName"
											class="form-control input-sm" value=<%=course.getCourseName() %>>
									</div>
								</div>
							</div>

							<div class="row">

								<div class="col-xs-6 col-sm-6 col-md-6">
									<div class="form-group">
										<input type="text" name="courseFee" id="courseFee"
											class="form-control input-sm" value=<%=course.getCourseFee() %>>
									</div>
								</div>
							</div>


							
							<input type="submit" value="Update" class="btn btn-info btn-block">

						</form>
					</div>
				</div>
			</div>
		</div>
	</div>
</body>
</html>