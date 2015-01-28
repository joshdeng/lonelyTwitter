package ca.ualberta.cs.lonelytwitter;

import java.util.ArrayList;


public class TwitterListModel {
	
	private  ArrayList<LonelyTweetModel>tweets;
	private int count;
	

	public TwitterListModel(){
		count = 0;
		tweets = new ArrayList<LonelyTweetModel>();
	}
	
	public int getListLength(){
		return count;
		
	}
	
	public void addTweet(LonelyTweetModel tweet){
		tweets.add(tweet);
		count++;
		
	}
	
	public LonelyTweetModel[] getTweets(int index){
		LonelyTweetModel [] alist = new LonelyTweetModel [tweets.size()]; 
		for (int i=0;i<tweets.size();i++){
			alist[i] = tweets.get(i);
		}
		
		return alist;
	}
	
	public boolean hasTweet(LonelyTweetModel a){
		
		return tweets.contains(a);
	}
	
	public void removeTweet(LonelyTweetModel a){
		tweets.remove(a);
	}
	
	public int getCount(){
		
		return tweets.size();
		
	}
}
