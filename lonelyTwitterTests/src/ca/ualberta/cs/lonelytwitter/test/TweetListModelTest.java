package ca.ualberta.cs.lonelytwitter.test;

import ca.ualberta.cs.lonelytwitter.LonelyTwitterActivity;
import ca.ualberta.cs.lonelytwitter.NormalTweetModel;
import ca.ualberta.cs.lonelytwitter.TwitterListModel;
import android.test.ActivityInstrumentationTestCase2;

public class TweetListModelTest extends ActivityInstrumentationTestCase2<LonelyTwitterActivity> {

	
	private TwitterListModel tweets;

	protected void setUp() throws Exception {
		super.setUp();
		tweets = new TwitterListModel();
		
	}
	
	public TweetListModelTest() {
		super(LonelyTwitterActivity.class);
	}
	

	
	public void testTweetsListInitaialised(){
		
		assertNotNull("Is my arraylist not initialisted?",tweets);
		
	}
	
	public void testListCount(){

		NormalTweetModel tweet = new NormalTweetModel("hi");
		tweets.addTweet(tweet);
		assertEquals("Added a tweet, counter updated?", 1, tweets.getListLength());
	}
	
}
	

