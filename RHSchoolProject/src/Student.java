package src;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;
import java.util.Stack;

public class Student implements Serializable, StudentInterface {
	int studAge;
	private String studentName;
	public int getStudAge() {
		return studAge;
	}

	public void setStudAge(int studAge) {
		this.studAge = studAge;
	}

	public String getStudentId() {
		return studentId;
	}

	public void setStudentId(String studentId) {
		this.studentId = studentId;
	}

	public int getStdAge() {
		return stdAge;
	}

	private String studentId;
	private String stdEmail;
	private int stdAge;
	private List<Course> courseList;

	@Override
	public void stdAge(int age) {
		if (age > 18) {
			System.out.println("Student Over age ");
		} else if (age < 6) {
			System.out.println("Student Under Age");
		} else {
			System.out.println("Student age allegeable complete  registration. ");
		}

	}

	@Override
	public void stdName(String name) {
		System.out.println(name);
	}

	public void setStudentName(String studentName) {
		this.studentName = studentName;
	}

	String getStudentName() {
		return studentName;
	}

	public void setStdEmail(String stdEmail) {
		this.stdEmail = stdEmail;
	}

	String getStdEmail() {
		return stdEmail;
	}

	public void setStdAge(int stdAge) {
		this.stdAge = stdAge;
	}

	int getstdAge() {
		return stdAge;
	}

	public void setCourseList(List<Course> courseList) {
		this.courseList = courseList;
	}

	public List<Course> getCourseList() {
		return courseList;
	}

	public Student() {
		this.studentName = studentName;
		this.stdEmail = stdEmail;
	}

	public Student(String studentName, String stdEmail) {
		this.studentName = studentName;
		this.stdEmail = stdEmail;
	}

	protected void finalize() throws Throwable {
		try {

			System.out.println("School Finalize");
		} catch (Throwable e) {

			throw e;
		} finally {

			super.finalize();
		}
	}

	public void studentEntry(Stack<String> historyStack, List<String> emailList) {
		Scanner scn = new Scanner(System.in);
		System.out.println("Enter Student ID \n");
		String stdID = scn.next();
		setStudentName(stdID);
		System.out.println("Enter Student Name \n");
		String stdName = scn.next();
		setStudentName(stdName);
		stdName("Student name is : " + stdName + "\n");
		historyStack.push(stdName);
		historyStack.push(stdID);
		try {
			if (!stdName.matches("^[a-zA-Z]*$")) {

				throw new Exception("Please Enter valid name");

			}
		} catch (Exception e) {

			System.out.println(e.getMessage());

		}

		System.out.println("Enter" + " " + stdName + " " + "Email");
		String stdEmail = scn.next();
		setStdEmail(stdEmail);
		historyStack.push(stdEmail);
		emailList.add(stdEmail);
		try {
			if (!stdEmail.matches("^[A-Za-z0-9+_.-]+@(.+)$")) {

				throw new Exception("Please Enter valid Email");

			}
		} catch (Exception e) {

			System.out.println(e.getMessage());

		}

	}

	public void checkage(Stack<String> historyStack) {
		Scanner scn = new Scanner(System.in);
		System.out.println("Enter Student Age");
		studAge = scn.nextInt();
		setStdAge(studAge);
		String age = Integer.toString(studAge);
		historyStack.push(age);
		stdAge(studAge);
	}
}
