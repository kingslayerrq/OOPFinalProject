
public class Feedback {
	
	private String profName;
	private String courseID; 
	private String rating;
	private String difficulty;
	
	
	public Feedback(String profName, String courseID, String rating, String difficulty) {

		this.profName = profName;
		this.courseID = courseID;
		this.rating = rating;
		this.difficulty = difficulty;
	}
	
	public String getProfName() {
		return profName;
	}
	public void setProfName(String profName) {
		this.profName = profName;
	}
	public String getCourseID() {
		return courseID;
	}
	public void setCourseID(String courseID) {
		this.courseID = courseID;
	}
	public String getRating() {
		return rating;
	}
	public void setRating(String rating) {
		this.rating = rating;
	}
	public String getDifficulty() {
		return difficulty;
	}
	public void setDifficulty(String difficulty) {
		this.difficulty = difficulty;
	}

}
