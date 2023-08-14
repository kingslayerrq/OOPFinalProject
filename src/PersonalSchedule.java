import java.util.ArrayList;

public class PersonalSchedule {
	private ArrayList<Course> schedule;
	
	private static PersonalSchedule Instance;
	
	private PersonalSchedule() {
		// TODO Auto-generated constructor stub
		schedule = new ArrayList<Course>();
	}
	
	// return true if we successfully added, false if already exists?
	public boolean addCoursetoSchedule(Course course) {
		if (!schedule.contains(course)) {
			schedule.add(course);
			return true;
		}
		return false;
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
