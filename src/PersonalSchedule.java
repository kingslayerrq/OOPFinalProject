import java.util.ArrayList;

public class PersonalSchedule {
	private ArrayList<Course> schedule;
	
	private static PersonalSchedule Instance;
	
	private PersonalSchedule() {
		// TODO Auto-generated constructor stub
		schedule = new ArrayList<Course>();
		schedule.add(CourseLib.titleCourse);     //for title formatting
	}
	
	// return true if we successfully added, false if already exists?
	public boolean addCoursetoSchedule(Course course) {
		if (!schedule.contains(course)) {
			schedule.add(course);
			return true;
		}
		return false;
	}
	
	public boolean deleteCourse(Course course) {
		if(!schedule.contains(course)) {
			return false;
		}
		else {
			schedule.remove(course);
			return true;
		}
	}
	
	public ArrayList<Course> getSchedule() {
		return schedule;
	}

	public void setSchedule(ArrayList<Course> schedule) {
		this.schedule = schedule;
	}
	
	public static PersonalSchedule getInstance() {
		if (Instance == null) {
			Instance = new PersonalSchedule();
		}
		return Instance;
	}
	
}
