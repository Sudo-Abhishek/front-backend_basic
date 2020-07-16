package studentManagementProject;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import testHibernate.dao.CourseDao;
import testHibernate.dao.StudentDao;
import testHibernate.daoImpl.CourseDaoImpl;
import testHibernate.daoImpl.StudentDaoImpl;
import testHibernate.dto.Course;
import testHibernate.dto.Student;

@WebServlet("/Controller1")
public class Ser1 extends HttpServlet {
	private static final long serialVersionUID = 1L;

	public Ser1() {
		super();

	}

	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		PrintWriter out = response.getWriter();
		Operations operation=new Operations();
		String ch=request.getParameter("action");
		
		
		switch(ch)
		{
		case "course":
		
		if(operation.addCourse(Integer.valueOf(request.getParameter("courseId")), request.getParameter("courseName"), Double.valueOf(request.getParameter("courseFee"))))	
		{out.print("course added sucessfully");}
		else {
			out.print("Course not added</Br>");
			out.println("<a href='ListCourse.jsp'>Click for List Course</a>");
		}
		
		/*Integer courseId = Integer.valueOf(request.getParameter("courseId"));
		String courseName = request.getParameter("courseName");
		Double courseFee = Double.valueOf(request.getParameter("courseFee"));
		Course course = new Course();
		course.setCourseId(courseId);
		course.setCourseFee(courseFee);
		course.setCourseName(courseName);
		out.print(courseDao.addCourse(course));*/
		break;
		
		
	
		case "student":
			
			if(operation.addStudent(Integer.valueOf(request.getParameter("studentId")),request.getParameter("studentName"),Integer.valueOf(request.getParameter("studentAge")),Integer.valueOf(request.getParameter("courseId"))))
			{
				out.print("student added successfully");
			}
			else
				out.print("student not added");
			/*Integer studentId = Integer.parseInt(request.getParameter("studentId"));

			String studentName = request.getParameter("studentName");

			Integer studentAge = Integer.parseInt(request.getParameter("studentAge"));

			Integer courseId1 = Integer.parseInt(request.getParameter("courseId"));

			Student student = new Student();
			student.setCourseId(courseId1);
			student.setStudentAge(studentAge);
			student.setStudentId(studentId);
			student.setStudentName(studentName);
			StudentDao studentDao = new StudentDaoImpl();
			out.print(studentDao.addStudent(student));
			out.print(student);*/
			break;
		
		case "deleteCourse":
			if(operation.deleteCourse(Integer.valueOf(request.getParameter("courseId"))))
				out.print("the course has been deleted");
			else
				out.print("course couldnot be deleted");
			/*out.print("hello delete course");
			out.print(Integer.valueOf(request.getParameter("courseId")));
			out.print(courseDao.deleteCourse(Integer.valueOf(request.getParameter("courseId"))));*/
			break;
		case "updateCourse":
			out.print(Integer.valueOf(request.getParameter("courseId")));
			if(operation.updateCourse(Integer.valueOf(request.getParameter("courseId")), request.getParameter("courseName"), Double.valueOf(request.getParameter("courseFee"))))
				out.print("course updated successfully");
			else
			{
				out.print("course couldnot be updated");
			}
			/*courseId=Integer.valueOf(request.getParameter("courseId"));
			courseName=request.getParameter("courseName");
			courseFee=Double.valueOf(request.getParameter("courseFee"));
			course=null;
			course=courseDao.getCourse(courseId);
			course.setCourseName(courseName);
			course.setCourseFee(courseFee);
			out.print(course);
			courseDao.updateCourse(course);*/
			
			break;
			
			
		
		default :
			out.print("enter valid attribute");
			}
		}

	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		doGet(request, response);
	}

}
