
import java.io.FileOutputStream;
import java.io.*;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.HashSet;
import java.util.List;
import java.util.Map;
import java.util.Scanner;
import java.util.Set;
import java.util.Stack;

public class Main {

	public static void subMenu() {
		System.out.println("Please Choose Number From Menu: \n");
		System.out.println("================================");
		System.out.println("|  [1] Calculate Factorial     |");
		System.out.println("|  [2] Print Fibonacci         |");
		System.out.println("|  [3] Go Back To Menu         |");
		System.out.println("================================");
		System.out.println("Please Enter your Choice: \n");
	}

	public static void menu() {

		System.out.println("\t\t+++++++++++++++++++++++++++++");
		System.out.println("\t\t+ WELCOME TO THE SYSTEM     +");
		System.out.println("\t\t+++++++++++++++++++++++++++++\n");
		System.out.println("Please Choose Number From Menu: \n");
		System.out.println("================================");
		System.out.println("|  [1] Enter Student Details    |");
		System.out.println("|  [2] Print Report             |");
		System.out.println("|  [3] Show History             |");
		System.out.println("|  [4] Print duplicated Emails  |");
		System.out.println("|  [5] Student Fees             |");
		System.out.println("|  [6] Sub Menu                 |");
		System.out.println("|  [7] Serialization for Student|");
		System.out.println("|  [8] Exit from program        |");
		System.out.println("================================");
	}

	public static void welcomMenu() {
		System.out.println("\t\t+++++++++++++++++++++++++++++");
		System.out.println("\t\t+ WELCOME TO THE SYSTEM     +");
		System.out.println("\t\t+++++++++++++++++++++++++++++\n");
	}

	public static void thankMenu() {
		System.out.println("+++++++++++++++++++++++++++++");
		System.out.println("+        THANK YOU          +");
		System.out.println("+++++++++++++++++++++++++++++");
	}

	public static void main(String[] args) throws Throwable {

		List<School> schoolList = new ArrayList<>();
		Set<String> emialSet = new HashSet<>();
		List<String> emailList = new ArrayList<>();
		List<Student> stdList = new ArrayList<>();
		List<Marks> marksList = new ArrayList<>();
		List<Course> courseList = new ArrayList<>();

		Stack<String> historyStack = new Stack<>();
		Scanner sc = new Scanner(System.in);
		Scanner scn = new Scanner(System.in);

		HashMap<String, Double> studentFees = new HashMap<>();
		HashMap<String, HashMap<String, Double>> studentAmount = new HashMap<>();

		boolean isExit = true;
		boolean isCurrencyExit = true;
		boolean courseExit = true;
		boolean schoolExit = true;
		boolean exitMenu = true;
		boolean checkSwitch = true;
		boolean isUserExit = true;
		boolean checkMark = true;

		File file = new File("C:\\Users\\user015\\eclipse-workspace\\RHNewCode\\School\\history.txt");
		ObjectOutputStream oos = null;
		ObjectInputStream ois = null;

		while (isUserExit) {
			welcomMenu();
			try {
				Validation validation = new Validation();
				System.out.println("\n PLEASE ENTER USERNAME TO LOGIN : \t");
				String username = scn.next();
				validation.validateUsername(username);
				System.out.println("\n PLEASE ENTER PASSWORD: \t");
				String password = sc.next();
				validation.validatePassword(password);

				System.out.println("your login is seccessful");
				do {
					menu();
					String option = null;
					do {
						try {
							System.out.println("Please Enter your Choice: \n");
							option = sc.next();
							Integer.parseInt(option);
							checkSwitch = false;

						} catch (Exception e) {

							System.out.println("Please Enter Integer only ");
						}
					} while (checkSwitch);
					switch (option) {
					case "1":
						System.out.println("*  ENTER STUDENT DETAILS    *");
						while (schoolExit) {

							School schools = new School();
							System.out.println("Enter School Name");
							String enterSchool = scn.next();
							schools.setSchoolName(enterSchool);

							historyStack.push(enterSchool);
							try {
								if (!enterSchool.matches("^[a-zA-Z]*$")) {

									throw new Exception("Please Enter valid name");

								}
							} catch (Exception e) {

								System.out.println(e.getMessage());

							}

							courseExit = Boolean.TRUE;

							while (isExit) {

								Student students = new Student();
								System.out.println("Enter Student Age");
								int stdAge = scn.nextInt();
								students.setStdAge(stdAge);
								String age = Integer.toString(stdAge);
								historyStack.push(age);
								students.stdAge(stdAge);

								if (stdAge > 5 && stdAge <= 18) {
									System.out.println("Enter Student Name \n");
									String stdName = scn.next();
									students.setStudentName(stdName);
									students.stdName("Student name is : " + stdName + "\n");
									historyStack.push(stdName);
									try {
										if (!stdName.matches("^[a-zA-Z]*$")) {

											throw new Exception("Please Enter valid name");

										}
									} catch (Exception e) {

										System.out.println(e.getMessage());
										continue;

									}

									System.out.println("Enter" + " " + stdName + " " + "Email");
									String stdEmail = scn.next();
									students.setStdEmail(stdEmail);
									historyStack.push(stdEmail);
									emailList.add(stdEmail);
									try {
										if (!stdEmail.matches("^[A-Za-z0-9+_.-]+@(.+)$")) {

											throw new Exception("Please Enter valid Email");

										}
									} catch (Exception e) {

										System.out.println(e.getMessage());
										continue;
									}

									isCurrencyExit = Boolean.TRUE;

									while (isCurrencyExit) {

										CalculateFeesAmount fees = new CalculateFeesAmount();

										fees.CalculateCurrency();
										studentFees.put(fees.currencyName, fees.amountCal);
										studentAmount.put(students.getStudentName(), studentFees);
										System.out.println(
												"Do You want To Add Currency press 1 if  you want exit press 0");
										int exitcurrency = sc.nextInt();
										if (exitcurrency == 0)

											isCurrencyExit = false;

									}
									courseExit = Boolean.TRUE;

									while (courseExit) {
										Course studentCourse = new Course();
										Marks courseMarks = new Marks();

										System.out.println("Enter Course Name \n");
										String addCourseName = scn.next();
										historyStack.push(addCourseName);
										studentCourse.setCourseName(addCourseName);
										studentCourse.finalize();
										while (checkMark) {
											System.out.println("Enter Mark for Course :");
											int addCourseMark = sc.nextInt();
											try {
												if (!(addCourseMark >= 0 && addCourseMark <= 100)) {
													throw new Exception("Enter mark between 0 and 100");
												}

											} catch (Exception e) {

												System.out.println(e.getMessage());
												continue;

											}
											String addMark = Integer.toString(addCourseMark);
											historyStack.push(addMark);
											courseMarks.setCousrseMark(addCourseMark);
											courseMarks.stdMark(addCourseMark);
											courseMarks.finalize();
											checkMark = false;
										}
										marksList.add(courseMarks);
										studentCourse.setMarksList(marksList);
										courseList.add(studentCourse);
										students.setCourseList(courseList);

										System.out
												.println("Do You want To Add course press 1 if  you want exit press 0");
										int exitoutput = sc.nextInt();
										if (exitoutput == 0)

											courseExit = false;
									}

									schoolList.add(schools);
									stdList.add(students);
									schools.setStdList(stdList);
									System.out.println("If You want To Add Student press 1 ");
									int exitStudentOutput = sc.nextInt();
									if (exitStudentOutput == 0) {
										isExit = false;
									}
								} else {
									System.out.println("Student cant be registerd");
								}
							}

							System.out.println("If you want To Add School press 1 ");
							int exitoutterloop = sc.nextInt();
							if (exitoutterloop == 1) {
								schoolExit = true;
								isExit = true;
								courseExit = true;

							} else {
								schoolExit = false;
								isExit = false;
								courseExit = false;
							}

							try {
								oos = new ObjectOutputStream(new FileOutputStream(file));
								StringBuilder st = new StringBuilder();
								while (!historyStack.isEmpty()) {
									String s = historyStack.pop();
									st.append(s);
								}
								oos.writeObject(st);
								
								oos.close();
							} catch (IOException exception) {
								System.out.println("An unexpected error is occurred");
								exception.printStackTrace();
							}
						}

						break;
					case "2":

						System.out.println("*  YOUR REPORT  *");

						for (School h : schoolList) {
							System.out.println("\tSchool Name: " + h.getSchoolName());
							for (Student s : h.getStdList()) {
								System.out.println("\t Student Age: " + s.getstdAge());
								System.out.println("\t Student Name: " + s.getStudentName());
								System.out.println("\t Student Email: " + s.getStdEmail());
								for (Course c : s.getCourseList()) {
									for (Marks m : c.getMarksList()) {
										System.out.println("\nCourse Name: " + c.getCourseName() + " \tCourse Marks"
												+ m.getCousrseMark());
									}
								}
							}
						}
						break;

					case "3":
						try {
							if (file.isFile()) {
								ois = new ObjectInputStream(new FileInputStream(file));
								StringBuilder sb = (StringBuilder) new StringBuilder(ois.readObject().toString());
								ois.close();

								System.out.println(sb.toString() + "\n");

							}
						} catch (IOException exception) {
							System.out.println("An unexpected error is occurred.");
							exception.printStackTrace();
						}

						break;

					case "4":

						for (String emails : emailList) {
							if (emialSet.add(emails) == false) {
								System.out.println("The duplicated emails are : " + emails);

							}

						}
						break;
					case "5":

						for (String stdName : studentAmount.keySet()) {
							Map<String, Double> map2 = studentAmount.get(stdName);
							for (String currenyKey : map2.keySet()) {
								System.out.println("Name of Student: " + stdName + " Currency: " + currenyKey
										+ " Amount: " + map2.get(currenyKey));
							}
						}
						break;
					case "6":
						boolean isExitMenu = true;
						do {
							subMenu();
							int op = sc.nextInt();

							switch (op) {
							case 1:
								CalculateFactorialNumbers.calculateFactorial();
								break;
							case 2:
								FibonacciNumbers.fibonacciNumbers();
								break;
							case 3:
								isExitMenu = false;
							}
						} while (isExitMenu);

						break;
					case "7":
						Serialization.serilizationfunction();

						break;

					case "8":
						thankMenu();
						exitMenu = false;
						break;
					default:
						System.out.println("please Enter number between 1-8");
					}
				} while (exitMenu);

			} catch (Exception e) {

				System.out.println("Please login again " + e.getMessage());

			}
		}

		isUserExit = false;
	}

}
