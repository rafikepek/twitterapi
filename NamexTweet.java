import java.io.IOException;

import twitter4j.ResponseList;
import twitter4j.Status;
import twitter4j.Twitter;
import twitter4j.TwitterException;
import twitter4j.TwitterFactory;
import twitter4j.auth.AccessToken;

public class NamexTweet {
    private final static String CONSUMER_KEY = "AGAl2therDp72hUmsGluyheyO";
    private final static String CONSUMER_KEY_SECRET = "wCYAgYQxypaEeHUHdrlf1ithfyxhzsc1j9XnCBpmJeNN2xVYfl";

    public void start() throws TwitterException, IOException {

	Twitter twitter = new TwitterFactory().getInstance();
	twitter.setOAuthConsumer(CONSUMER_KEY, CONSUMER_KEY_SECRET);

	// here's the difference
	String accessToken = getSavedAccessToken();
	String accessTokenSecret = getSavedAccessTokenSecret();
	AccessToken oathAccessToken = new AccessToken(accessToken,
		accessTokenSecret);

	twitter.setOAuthAccessToken(oathAccessToken);
	// end of difference

	twitter.updateStatus("Carilah tempat yang (ny)aman");

	System.out.println("\nMy Timeline:");

	// I'm reading your timeline
	ResponseList<Status> list = twitter.getHomeTimeline();
	for (Status each : list) {

	    System.out.println("Sent by: @" + each.getUser().getScreenName()
		    + " - " + each.getUser().getName() + "\n" + each.getText()
		    + "\n");
	}

    }

    private String getSavedAccessTokenSecret() {
	// consider this is method to get your previously saved Access Token
	// Secret
	return "6xAJNYPYa1w4u123xBbWfaUMNUp17ghMePN8w3VChM6wM";
    }

    private String getSavedAccessToken() {
	// consider this is method to get your previously saved Access Token
	return "1140806324969545730-0udqwhdrnnGkQhLENJMtyxj374k8MU";
    }

    public static void main(String[] args) throws Exception {
	new NamexTweet().start();
    }
}