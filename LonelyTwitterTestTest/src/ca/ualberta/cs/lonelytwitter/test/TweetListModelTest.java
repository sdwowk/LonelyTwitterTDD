package ca.ualberta.cs.lonelytwitter.test;

import java.util.List;

import ca.ualberta.cs.lonelytwitter.AbstractTweet;
import ca.ualberta.cs.lonelytwitter.LonelyTwitterActivity;
import ca.ualberta.cs.lonelytwitter.Tweet;
import ca.ualberta.cs.lonelytwitter.data.TweetListModel;
import android.test.ActivityInstrumentationTestCase2;

public class TweetListModelTest extends ActivityInstrumentationTestCase2<LonelyTwitterActivity> {

	public TweetListModelTest() {
		super(LonelyTwitterActivity.class);
		// TODO Auto-generated constructor stub
	}

	public void testGetCount(){
		TweetListModel testModel = new TweetListModel();
		AbstractTweet t = new Tweet("Try adding");
		testModel.addTweet(t);
		
		assertEquals("Array size incorrect", testModel.getCount(), 1);
		
		testModel.removeTweet(t);
		
		assertEquals("Still elements in model", testModel.getCount(), 0);
		
		AbstractTweet t2 = new Tweet("Hello");
		
		testModel.addTweet(t2);
		assertEquals("Array size incorrect now", testModel.getCount(), 1);
		try{
		testModel.addTweet(t2);
		}catch(IllegalArgumentException e){
			assertEquals("Array size incorrect third test", testModel.getCount(), 1);
		}
	}
	
	
	public void testaddTweet(){
		TweetListModel testModel = new TweetListModel();
		AbstractTweet t = new Tweet("Try adding");
		testModel.addTweet(t);
		
		assertEquals("No tweet in test", testModel.getCount(), 1);
		
		AbstractTweet t2 = new Tweet("Second Add");
		testModel.addTweet(t2);
		
		assertEquals("two tweets not in test", testModel.getCount(), 2);
		
		try{
			AbstractTweet t3 = new Tweet("Second Add");
			testModel.addTweet(t3);
		
		}catch(IllegalArgumentException e){
		
			assertEquals("Adding too many tweets", testModel.getCount(), 2);
		}
	}
	
	public void testHasTweet(){
		TweetListModel testModel = new TweetListModel();
		AbstractTweet t = new Tweet("Try adding");
		
		testModel.addTweet(t);
		assertTrue("Does not have tweet", testModel.hasTweet(t));
		
		assertFalse("Tweet is in the ListModel",testModel.hasTweet(new Tweet("Hi")));
	}
	
	public void testRemoveTweet(){
		TweetListModel testModel = new TweetListModel();
		AbstractTweet t = new Tweet("Try adding");
		
		testModel.addTweet(t);
		testModel.removeTweet(t);
		assertFalse("tweet was not removed",testModel.hasTweet(t));
		assertEquals("Tweet model not empty", testModel.getCount(), 0);
	
	}
	
	public void testGetTweets(){
		TweetListModel testModel1 = new TweetListModel();
		TweetListModel testModel2 = new TweetListModel();
		
		AbstractTweet t = new Tweet("a");
		AbstractTweet t2 = new Tweet("b");
		AbstractTweet t3 = new Tweet("c");
		
		testModel1.addTweet(t);
		testModel1.addTweet(t2);
		testModel1.addTweet(t3);
		AbstractTweet[] newArray = testModel1.getTweets();
		
		testModel2.addTweet(t);
		testModel2.addTweet(t2);
		testModel2.addTweet(t3);
		AbstractTweet[] secondArray = testModel2.getTweets();
		
		assertEquals("Array Lists not sorted", newArray[0].getTweetBody(),secondArray[0].getTweetBody());
	}
	
	public void testGetList(){
		TweetListModel testModel = new TweetListModel();
		
		AbstractTweet t = new Tweet("a");
		AbstractTweet t2 = new Tweet("b");
		AbstractTweet t3 = new Tweet("c");
		
		testModel.addTweet(t);
		testModel.addTweet(t2);
		testModel.addTweet(t3);
		
		List<AbstractTweet> newList = testModel.getList();
		assertEquals("Array is not the right length", newList.size(), 3);
	}
	
	public void testClear(){
		TweetListModel testModel = new TweetListModel();
		
		AbstractTweet t = new Tweet("a");
		AbstractTweet t2 = new Tweet("b");
		AbstractTweet t3 = new Tweet("c");
		
		testModel.addTweet(t);
		testModel.addTweet(t2);
		testModel.addTweet(t3);
		
		testModel.clear();
		assertEquals("Array not empty", testModel.getCount(), 0);
	}
	
	
}
