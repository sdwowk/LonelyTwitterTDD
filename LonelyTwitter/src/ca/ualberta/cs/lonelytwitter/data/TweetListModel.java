package ca.ualberta.cs.lonelytwitter.data;

import java.util.ArrayList;
import java.util.Collection;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;
import java.lang.RuntimeException;

import ca.ualberta.cs.lonelytwitter.AbstractTweet;
import ca.ualberta.cs.lonelytwitter.Tweet;

public class TweetListModel {

	private List<AbstractTweet> tweets = new ArrayList<AbstractTweet>();

	public TweetListModel() {
	}
	
	public TweetListModel(List<AbstractTweet> tweets) {
		this.tweets = tweets;
	}

	/**
	 * Appends the specified tweet to the end of this list. Throws
	 * IllegalArgumentException if it is a repeated tweet.
	 * 
	 * @param tweet
	 *            Tweet to be appended to this list
	 */
	public void addTweet(AbstractTweet tweet) {
		
		if( !this.hasTweet(tweet)){
			tweets.add(tweet);
		}
		else{
			throw new IllegalArgumentException("Tweet already in TweetListModel");
		}
		
	}

	/**
	 * Returns the number of tweets in this list.
	 * 
	 * @return the number of tweets in this list
	 */
	public int getCount() {
		return this.getList().size();
	}

	/**
	 * Returns true if this list contains the tweet
	 * 
	 * @param tweet
	 *            Tweet whose presence in this list is to be tested
	 * @return true if this list contains the specified element
	 */
	public boolean hasTweet(AbstractTweet tweet) {
		if(tweets.contains(tweet)){
			return true;
		}
		return false;
	}

	/**
	 * Removes the first occurrence of the specified tweet from this list, if it
	 * is present.
	 * 
	 * @param tweet
	 *            Tweet to be removed from this list, if present.
	 */
	public void removeTweet(AbstractTweet tweet) {
		tweets.remove(tweet);
	}

	/**
	 * Returns an array containing all of the tweets in this list in proper
	 * sequence.
	 * 
	 * @return an array containing the tweets of the list.
	 */
	public AbstractTweet[] getTweets() {
		AbstractTweet[] tweetArray = new AbstractTweet[this.getList().size()];
		List<AbstractTweet> thisList = this.getList();
		
		Collections.sort(thisList, new Comparator<AbstractTweet>(){
				public int compare(AbstractTweet t1, AbstractTweet t2){
					return t1.getTweetBody().compareTo(t2.getTweetBody());
				}

			});
		
		for(int i = 0; i < tweetArray.length; i++){
			tweetArray[i] = thisList.get(i);
		}
		return tweetArray;
	}

	/**
	 * Returns the list of tweets.
	 * 
	 * @return The list of tweets.
	 */
	public List<AbstractTweet> getList() {
		return tweets;
	}

	/**
	 * Removes all of the elements from this list. The list will be empty after
	 * this call returns.
	 */
	public void clear() {
		tweets.clear();
	}
}