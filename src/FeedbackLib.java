import java.util.ArrayList;

import java.util.HashSet;

public class FeedbackLib {
	
	private ArrayList<Feedback> FeedbackList;
	private static FeedbackLib Instance;
	public static Feedback rateMyProfessor = new Feedback("Professor Name", "Course ID", "Rating", "Level of Difficulties");  
	private FeedbackLib() {
		FeedbackList = new ArrayList<Feedback>();
		
		//English Feedbacks
		Feedback e1 = new Feedback("Josh P", "ENG-UA001" , "4", "1.5");
		Feedback e2 = new Feedback("Josh B", "ENG-UA301", "5", "2.1");
		Feedback e3 = new Feedback("Josh B", "ENG-UA301", "5", "2.1");
		Feedback e4 = new Feedback("Josh P", "ENG-UA001", "3", "1.2");
		Feedback e5 = new Feedback("Josh B", "ENG-UA301", "4", "2.2");
		Feedback e6 = new Feedback("Josh P", "ENG-UA001", "3", "1.0");
		//French Feedbacks
		Feedback f1 = new Feedback("Ann M", "FR-UA001", "2", "1.2");
		Feedback f2 = new Feedback("Ann W", "FR-UA301", "5", "3.8");
		Feedback f3 = new Feedback("Ann M", "FR-UA001", "1", "1.1");
		//Fashion Feedbacks
		Feedback fa1 = new Feedback("Zan Shen", "FASH-UA001", "4", "1.4");
		Feedback fa2 = new Feedback("Zan Shen", "FASH-UA202", "5", "2.0");
		Feedback fa3 = new Feedback("Zan Shen", "FASH-UA470", "5", "4.0");
		Feedback fa4 = new Feedback("Zan Shen", "FASH-UA301", "5", "4.1");
		Feedback fa5 = new Feedback("Zan Shen", "FASH-UA001", "4", "1.1");
		Feedback fa6 = new Feedback("Zan Shen", "FASH-UA001", "5", "1.1");
		Feedback fa7 = new Feedback("Zan Shen", "FASH-UA001", "5", "1.1");
		Feedback fa8 = new Feedback("Zan Shen", "FASH-UA001", "5", "1.0");
		Feedback fa9 = new Feedback("Zan Shen", "FASH-UA202", "4", "2.5");
		Feedback fa10 = new Feedback("Zan Shen", "FASH-UA202", "3", "3.0");
		Feedback fa11 = new Feedback("Zan Shen", "FASH-UA470", "4", "4.4");
		
		
		//CS Feedbacks
		Feedback cs1 = new Feedback("Hilbert L", "CS-UA101", "3", "1.0");
		Feedback cs2 = new Feedback("Evan K", "CS-UA120", "3", "1.5");
		Feedback cs3 = new Feedback("Hasan A", "CS-UA201", "5", "1.8");
		Feedback cs4 = new Feedback("Tang", "CS-UA202", "4", "5.0");
		Feedback cs5 = new Feedback("Matt B", "CS-UA301", "4", "4.8");
		Feedback cs6 = new Feedback("Hasan A", "CS-UA470", "5", "3.1");
		Feedback cs7 = new Feedback("Hilbert L", "CS-UA101", "3", "1.7");
		Feedback cs8 = new Feedback("Evan K", "CS-UA120", "4", "1.2");
		Feedback cs9 = new Feedback("Evan K", "CS-UA120", "3", "1.9");
		Feedback cs10 = new Feedback("Hasan A", "CS-UA201", "5", "1.8");
		Feedback cs11 = new Feedback("Hasan A", "CS-UA201", "5", "2.0");
		Feedback cs12 = new Feedback("Hasan A", "CS-UA201", "5", "2.1");
		Feedback cs13 = new Feedback("Tang", "CS-UA202", "4", "4.7");
		Feedback cs14 = new Feedback("Matt B", "CS-UA301", "3", "4.7");
		Feedback cs15 = new Feedback("Matt B", "CS-UA301", "4", "4.2");
		Feedback cs16 = new Feedback("Hasan A", "CS-UA470", "5", "3.4");
		Feedback cs17 = new Feedback("Hilbert L", "CS-UA101", "4", "1.2");		
		
		//
		
		populateFeedbackList(e1);
		populateFeedbackList(e2);
		populateFeedbackList(e3);
		populateFeedbackList(e4);
		populateFeedbackList(e5);
		populateFeedbackList(e6);
		populateFeedbackList(f1);
		populateFeedbackList(f2);
		populateFeedbackList(f3);
		populateFeedbackList(fa1);
		populateFeedbackList(fa2);
		populateFeedbackList(fa3);
		populateFeedbackList(fa4);
		populateFeedbackList(fa5);
		populateFeedbackList(fa6);
		populateFeedbackList(fa7);
		populateFeedbackList(fa8);
		populateFeedbackList(fa9);
		populateFeedbackList(fa10);
		populateFeedbackList(fa11);
		populateFeedbackList(cs1);
		populateFeedbackList(cs2);
		populateFeedbackList(cs3);
		populateFeedbackList(cs4);
		populateFeedbackList(cs5);
		populateFeedbackList(cs6);
		populateFeedbackList(cs7);
		populateFeedbackList(cs8);
		populateFeedbackList(cs9);
		populateFeedbackList(cs10);
		populateFeedbackList(cs11);
		populateFeedbackList(cs12);
		populateFeedbackList(cs13);
		populateFeedbackList(cs14);
		populateFeedbackList(cs15);
		populateFeedbackList(cs16);
		populateFeedbackList(cs17);

	}
	private void populateFeedbackList(Feedback feedback) {
		getFeedbackList().add(feedback);
	}
	public  ArrayList<Feedback> getFeedbackList() {
		return FeedbackList;
	}

	public void setFeedbackList(ArrayList<Feedback> feedbackList) {
		FeedbackList = feedbackList;
	}
	public  ArrayList<Feedback> getFeedbackByName(String profname) {
		ArrayList<Feedback> resultArrayList = new ArrayList<Feedback>();
		String normalizedString = profname.toLowerCase();
		for(Feedback i:FeedbackList){
			if (i.getProfName().toLowerCase().indexOf(normalizedString)!= -1) {
				resultArrayList.add(i);
			}
		}
		return resultArrayList;
	}
	public static FeedbackLib getInstance() {
		if (Instance == null) {
			Instance = new FeedbackLib();
		}
		return Instance;
	}
}
