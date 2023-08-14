
public class Course {
	private String courseID;           //always unique
	private String courseName;
	private String profName;
	private String subject;
	private String credit;
	
	
	public Course(String courseID, String courseName, String profName, String subject, String credit) {

		this.courseID = courseID;
		this.courseName = courseName;
		this.profName = profName;
		this.subject = subject;
		this.credit = credit;
	}
	
	public String getCourseID() {
		return courseID;
	}
	public void setCourseID(String courseID) {
		this.courseID = courseID;
	}
	public String getCourseName() {
		return courseName;
	}
	public void setCourseName(String courseName) {
		this.courseName = courseName;
	}
	public String getProfName() {
		return profName;
	}
	public void setProfName(String profName) {
		this.profName = profName;
	}
	public String getSubject() {
		return subject;
	}
	public void setSubject(String subject) {
		this.subject = subject;
	}
	public String getCredit() {
		return credit;
	}
	public void setCredit(String credit) {
		this.credit = credit;
	}
	
	
	
}
