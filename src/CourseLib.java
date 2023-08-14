import java.util.ArrayList;

import java.util.HashSet;


public class CourseLib {
	private ArrayList<Course> CourseList;
	private static CourseLib Instance;

	private CourseLib() {
		// TODO Auto-generated constructor stub
		CourseList = new ArrayList<Course>();
		//English Courses
		Course english101 = new Course("ENG-UA001", "English 101", "Josh P", "English", 4);
		Course advEngCourse = new Course("ENG-UA301", "Advanced English", "Josh B", "English", 4);
		//French Courses
		Course french101 = new Course("FR-UA001", "French 101", "Ann M", "French", 4);
		Course advFRCourse = new Course("FR-UA301", "Advanced French", "Ann W", "French", 4);
		//Fashion Courses
		Course introFashion = new Course("FASH-UA001", "Intro to Fashion", "Zan Shen", "Fashion", 4);
		Course mensWear = new Course("FASH-UA202", "Men's Wear", "Zan Shen", "Fashion", 2);
		Course luxuryDesign = new Course("FASH-UA470", "Luxury Design", "Zan Shen", "Fashion", 4);
		Course garmentPattern = new Course("FASH-UA301", "Garment Pattern", "Zan Shen", "Fashion", 4);
		//CS Courses
		Course introCS = new Course("CS-UA101", "Intro to CS", "Hilbert L", "Comp Science", 4);
		Course dataStructure = new Course("CS-UA120", "Data Structure", "Evan K", "Comp Science", 4);
		Course cso = new Course("CS-UA201", "Comp System Org", "Hasan A", "Comp Science", 4);
		Course operatingSystem = new Course("CS-UA202", "Operating Systems", "Tang", "Comp Science", 4);
		Course basicAlgo = new Course("CS-UA301", "Basic Algorithm", "Matt B", "Comp Science", 4);
		Course oop = new Course("CS-UA470", "OOP", "Hasan A", "Comp Science", 4);
		//
		
		populateCourseList(english101);
		populateCourseList(french101);
		populateCourseList(advEngCourse);
		populateCourseList(advFRCourse);
		populateCourseList(introFashion);
		populateCourseList(mensWear);
		populateCourseList(luxuryDesign);
		populateCourseList(garmentPattern);
		populateCourseList(introCS);
		populateCourseList(dataStructure);
		populateCourseList(cso);
		populateCourseList(operatingSystem);
		populateCourseList(basicAlgo);
		populateCourseList(oop);
		
		
	}

	
	public  boolean validateCourseID(String courseid) {	
		for(Course i:CourseList){
			if (courseid.equals(i.getCourseID())) {
				return true;
			}
		}
		return false;
	}
	
	public Course getCourseByID(String courseid) {
		for(Course i:CourseList){
			if (courseid.equals(i.getCourseID())) {
				return i;
			}
		}
		return null;
	}
	
	public ArrayList<Course> getCourseBySubject(String subject) {
		ArrayList<Course> resultArrayList = new ArrayList<Course>();
		for(Course i:CourseList){
			if (subject.equals(i.getSubject())) {
				resultArrayList.add(i);
			}
		}
		return resultArrayList;
	}
	
	public  ArrayList<Course> getCourseByName(String coursename) {
		ArrayList<Course> resultArrayList = new ArrayList<Course>();
		String normalizedString = coursename.toLowerCase();
		for(Course i:CourseList){
			if (i.getCourseName().toLowerCase().indexOf(normalizedString)!= -1) {
				resultArrayList.add(i);
			}
		}
		return resultArrayList;
	}
	
	public ArrayList<String> getAllSubjects(){
		HashSet<String> subjectSet = new HashSet<String>();
		for(Course i:CourseList) {
			subjectSet.add(i.getSubject());
		}
		ArrayList<String> resultArrayList = new ArrayList<String>(subjectSet);
		return resultArrayList;
	}
	
	
	
	private void populateCourseList(Course course) {
		getCourseList().add(course);
	}
	private boolean deleteFromCourseList(Course course) {
		return getCourseList().remove(course);
	}
	
	public  ArrayList<Course> getCourseList() {
		return CourseList;
	}

	public void setCourseList(ArrayList<Course> courseList) {
		CourseList = courseList;
	}
	
	public static CourseLib getInstance() {
		if (Instance == null) {
			Instance = new CourseLib();
		}
		return Instance;
	}
	
	
}
