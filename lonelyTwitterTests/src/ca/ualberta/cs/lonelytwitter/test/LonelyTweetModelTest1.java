package ca.ualberta.cs.lonelytwitter.test;

import java.sql.Date;

import ca.ualberta.cs.lonelytwitter.LonelyTweetModel;
import ca.ualberta.cs.lonelytwitter.LonelyTwitterActivity;
import ca.ualberta.cs.lonelytwitter.NormalTweetModel;
import android.test.ActivityInstrumentationTestCase2;

public class LonelyTweetModelTest1 extends
		ActivityInstrumentationTestCase2<LonelyTwitterActivity> {

	public LonelyTweetModelTest1() {
		super(LonelyTwitterActivity.class);
	}

	protected void setUp() throws Exception {
		super.setUp();
	}

	public void testSample(){
		
		assertFalse("this statement is true",greaterThan(6,6));
		
		
	}
	public void testEqual(){
		Date date = new Date(12313);
		Date date2 = new Date(11111);
		NormalTweetModel normal = new NormalTweetModel("test tweet",date);
		
		NormalTweetModel secondTweet = new NormalTweetModel("Test tweet 2",date);
		
		
		NormalTweetModel third= new NormalTweetModel("test tweet",date);
		
		NormalTweetModel fourth = new NormalTweetModel("test tweet",date);
		assertFalse("Different Tweets are not equal", normal.equals(secondTweet));
		
		assertFalse("Different Tweets are not equal", normal.equals(secondTweet));
		
	}

	public boolean greaterThan(int i , int j){
		if (i>j)
			return true;
		else
			return false;
		
	}
}
