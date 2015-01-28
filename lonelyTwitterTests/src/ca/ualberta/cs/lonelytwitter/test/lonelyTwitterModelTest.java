package ca.ualberta.cs.lonelytwitter.test;

import ca.ualberta.cs.lonelytwitter.LonelyTwitterActivity;
import android.test.ActivityInstrumentationTestCase2;

public class lonelyTwitterModelTest extends ActivityInstrumentationTestCase2<LonelyTwitterActivity> {
	
	private int count;
	public lonelyTwitterModelTest() {
		super(LonelyTwitterActivity.class);
	}

	protected void setUp() throws Exception {
		super.setUp();
	}
	
	//public void testFail(){
		//fail("This is a failing test");
		
	//}
	
	public void testTrue(){
		assertEquals("This is true",5,5);
	}
	
	
	
	
}
