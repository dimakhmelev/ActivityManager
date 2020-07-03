package controller;



import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import model.ActivityRepository;
import model.ElementarySchoolActivity;
import model.HighSchoolActivity;
import model.LogInRepository;
import model.OtherActivity;
import model.RatingAndReview;
import model.RatingAndReviewRepository;
import model.User;

public class UserController  {

	RatingAndReviewRepository ratingAndReviewRepository;
	ActivityRepository activityRepository;
	LogInRepository logInRepository;
	
	public UserController()
	{
		this.ratingAndReviewRepository=new RatingAndReviewRepository();
		this.activityRepository=new ActivityRepository();
		this.logInRepository=new LogInRepository();
	}
	
	
	public User signIn(User user) {
		
		try {
			user=logInRepository.userlogIn(user.getEmail(),user.getPassword());
		} catch ( SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		
		return user;

}
	
	public Boolean signUpUser(User newUser) {

		try {
			logInRepository.SignUpUser(newUser);
			return true;
		} catch (Exception e) {
			return false;
			}
	}
	
	public List<OtherActivity> getOtherActivities() throws Exception {
		List<OtherActivity> list = new ArrayList<>();
		
			list=activityRepository.getOtherActivity();
			return list;
	
		
		
		
		
	}
	
	public List<HighSchoolActivity> getHighSchoolActivity() throws Exception {
		List<HighSchoolActivity> list = new ArrayList<>();
		
			list=activityRepository.getHighSchoolActivity();
			return list;
	
		
		
		
		
	}
	
	
	
	public List<ElementarySchoolActivity> getElementarySchoolActivity() throws Exception {
		List<ElementarySchoolActivity> list = new ArrayList<>();
		
			list=activityRepository.getElementarySchoolActivity();
			return list;
	
		
		
		
		
	}
	
	
	public Boolean RegisterUserToAvctivity(User user,int activityID) throws Exception
	{	
		

		 int capacityLeft;
		 capacityLeft=activityRepository.capicityByActivity(activityID);
		 
		 if (capacityLeft<=0)
				return false;
		
		activityRepository.RegisterUserToAvctivity(user, activityID);
		activityRepository.incrementCapicity(activityID);
		
		return true;
	}
	
	public void addRatingAndReview(RatingAndReview opinion) {
		
		try {
			ratingAndReviewRepository.insertRatingAndReview(opinion);
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

		
		
	}
	
	public List<RatingAndReview> getRatingAndReview(int activityID) throws Exception {
		List<RatingAndReview> list = new ArrayList<>();
		
			list=ratingAndReviewRepository.getRatingAndReview(activityID);
			return list;
	

	}
	
	
	
	
	
	
	
	
	
}//class end
