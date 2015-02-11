package ca.ualberta.cs.lonelytwitter.test;

import android.app.Activity;
import android.app.Instrumentation;
import android.test.ActivityInstrumentationTestCase2;
import android.test.ViewAsserts;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ListView;
import android.widget.TextView;
import ca.ualberta.cs.lonelytwitter.LonelyTwitterActivity;
import ca.ualberta.cs.lonelytwitter.NormalTweetModel;
import ca.ualberta.cs.lonelytwitter.TweetSetModel;

/*
 * generate this class with new.. JUnit Test Case
 * set superclass to ActivityInstrumentationTestCase2
 */
public class LonelyTwitterActivityUITest extends
		ActivityInstrumentationTestCase2<LonelyTwitterActivity> {

	Instrumentation instrumentation;
	Activity activity;
	EditText textInput;
	private ListView oldTweetList;
	
	public LonelyTwitterActivityUITest() {
		super(LonelyTwitterActivity.class);
	}

	protected void setUp() throws Exception {
		super.setUp();
		instrumentation = getInstrumentation();
		activity = getActivity();

		textInput = ((EditText) activity.findViewById(ca.ualberta.cs.lonelytwitter.R.id.body));
		oldTweetList = (ListView) activity.findViewById(ca.ualberta.cs.lonelytwitter.R.id.oldTweetsList);
		
	}
	
	
	
	public void testSettingText(){
		// set thread
		instrumentation.runOnMainSync(new Runnable(){
			@Override
			public void run(){
				textInput.setText("Text");
				
			}
		});
		
		instrumentation.waitForIdleSync();
		assertEquals("Text?","Text",textInput.getText().toString());
	}
	
	
	public void testAdapterTest(){
		int originalCount = oldTweetList.getAdapter().getCount();
		// set thread
			instrumentation.runOnMainSync(new Runnable(){
			@Override
			public void run(){
				makeTweet("Hello"); 
			}
		});
				
			instrumentation.waitForIdleSync();
			NormalTweetModel testTweet = (NormalTweetModel) oldTweetList.getAdapter().getItem(originalCount);
			assertEquals("new?",oldTweetList.getAdapter().getCount(),originalCount+1);
			assertTrue("type", testTweet instanceof NormalTweetModel);
			assertEquals("Text?", testTweet.getText(),"Hello");

	}
	/*
	 * fills in the input text field and clicks the 'save'
	 * button for the activity under test
	 */
	private void makeTweet(String text) {
		assertNotNull(activity.findViewById(ca.ualberta.cs.lonelytwitter.R.id.save));
		textInput.setText(text);
		((Button) activity.findViewById(ca.ualberta.cs.lonelytwitter.R.id.save)).performClick();
	}
}
