import java.util.ArrayList;

public class Course {
 String courseName;
 
 void setCourseName(String courseName) {
	 this.courseName=courseName;
 }
 
 String getCourseName() {
	 return courseName;
 }
	public Course() {
		// TODO Auto-generated constructor stub
	}
	
	ArrayList<Marks> marksList=new ArrayList<>();
	
	
	void setMarksList(ArrayList<Marks> marksList) {
		this.marksList=marksList;
	}
	
	public ArrayList<Marks> getMarksList() {
		return marksList;
		
	}

}