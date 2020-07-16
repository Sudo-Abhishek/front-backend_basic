package studentManagementProject;

import testHibernate.dao.CourseDao;
import testHibernate.dao.StudentDao;
import testHibernate.daoImpl.CourseDaoImpl;
import testHibernate.daoImpl.StudentDaoImpl;
import testHibernate.dto.Course;
import testHibernate.dto.Student;

public class Operations {
	CourseDao courseDao;

	public Operations() {
		courseDao = new CourseDaoImpl();
	}

	public boolean addStudent(Integer studentId, String studentName, Integer studentAge, Integer courseId) {
		Student student = new Student();
		student.setCourseId(courseId);
		student.setStudentAge(studentAge);
		student.setStudentName(studentName);
		student.setStudentId(studentId);
		StudentDao studentdao = new StudentDaoImpl();
		return studentdao.addStudent(student);
	}

	public boolean addCourse(Integer courseId, String courseName, Double courseFee) {
		Course course = new Course();
		course.setCourseId(courseId);
		course.setCourseName(courseName);
		course.setCourseFee(courseFee);
		CourseDao coursedao = new CourseDaoImpl();
		return coursedao.addCourse(course);

	}

	public boolean updateCourse(Integer courseId, String courseName, Double courseFee) {
		Course course = courseDao.getCourse(courseId);
		course.setCourseName(courseName);
		course.setCourseFee(courseFee);
		return courseDao.updateCourse(course);

	}

	public boolean deleteCourse(Integer courseId) {
		return courseDao.deleteCourse(courseId);
	}

}
