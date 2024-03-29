package src;

import java.util.List;
import java.util.Scanner;
import java.util.Stack;

public class Course {
	private String courseId;
	public String getCourseId() {
		return courseId;
	}

	public void setCourseId(String courseId) {
		this.courseId = courseId;
	}

	private String courseName;
	private List<Marks> marksList;

	void setCourseName(String courseName) {
		this.courseName = courseName;
	}

	String getCourseName() {
		return courseName;
	}

	public void setMarksList(List<Marks> marksList) {
		this.marksList = marksList;
	}

	public List<Marks> getMarksList() {
		return marksList;

	}

	protected void finalize() throws Throwable {
		try {

			System.out.println("Course Finalize");
		} catch (Throwable e) {

			throw e;
		} finally {

			super.finalize();
		}
	}

	public void courseEntry(Stack<String> historyStack) {
		Scanner scn = new Scanner(System.in);
		System.out.println("Enter Course ID \n");
		String addCourseId = scn.next();
		historyStack.push(addCourseId);
		setCourseId(addCourseId);
		System.out.println("Enter Course Name \n");
		String addCourseName = scn.next();
		historyStack.push(addCourseName);
		setCourseName(addCourseName);
	}

}
