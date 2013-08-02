import java.util.Properties;

import org.junit.Before;
import org.junit.Test;
import org.junit.Ignore;
import org.stackbox.magic.TwitterAppInfo;

import twitter4j.Twitter;
import twitter4j.TwitterException;
import twitter4j.TwitterFactory;
import twitter4j.auth.AccessToken;
import twitter4j.auth.RequestToken;


public class TwitterLoginTest {

	@Before
	public void setUp() throws Exception {
		Properties systemProperties = System.getProperties(); 
		systemProperties.setProperty("http.proxyHost","127.0.0.1"); 
		systemProperties.setProperty("http.proxyPort","8087");
	}

	@Ignore
	public void test1() {
		Twitter twitter = new TwitterFactory().getInstance();
		twitter.setOAuthConsumer(TwitterAppInfo.CONSUMER_KEY, TwitterAppInfo.CONSUMER_SECRET);
		
		RequestToken requestToken = null;
		AccessToken accessToken = null;
		
		try {
			requestToken = twitter.getOAuthRequestToken();
			System.out.println("Request token:" + requestToken.getToken());
			System.out.println("Request token secret:" + requestToken.getTokenSecret());
			System.out.println("AuthorizationURL:" + requestToken.getAuthenticationURL());
			
			
			accessToken = twitter.getOAuthAccessToken(requestToken,"dbJP0JpcgKOqdepuAgNJnA5lVdQM0coPvjzVYymk");
			System.out.print("accessToken: " + accessToken.getToken());
			
			twitter.updateStatus("fine it is ok");
			
		} catch (TwitterException e) {
			e.printStackTrace();
		}
	}
	
	@Ignore
	public void testaccessOauth() {
		Twitter twitter = new TwitterFactory().getInstance();
		twitter.setOAuthConsumer(TwitterAppInfo.CONSUMER_KEY, TwitterAppInfo.CONSUMER_SECRET);
		AccessToken accessToken = new AccessToken("151812739-G9yMnvAGqL9PbSTDVsvMXtIiu19M2Kz6HyAjl8I", "D7OtW7GJk9glUb6qB9BDcmAeuPnB5gncdkkpIhq4dw");
		
		twitter.setOAuthAccessToken(accessToken);
		try {
			twitter.updateStatus("召唤成功 ^^");
		} catch (TwitterException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
	}
	
	@Test
	public void testObjectChange() {
		Integer a = 351;
		Object obj = (Object) a;
		System.out.println(obj.getClass());
	}

}
