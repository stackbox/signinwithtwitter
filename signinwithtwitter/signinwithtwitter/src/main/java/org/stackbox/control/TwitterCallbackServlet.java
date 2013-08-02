package org.stackbox.control;

import java.io.IOException;
import java.util.Properties;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.stackbox.magic.TwitterAppInfo;
import org.stackbox.util.CookieUtility;

import twitter4j.Twitter;
import twitter4j.TwitterException;
import twitter4j.TwitterFactory;
import twitter4j.auth.AccessToken;
import twitter4j.auth.RequestToken;
/**
 *  重复post等exception没有catch到，暂时没有处理返回status状态
 */

@WebServlet("/member/callback.do")
public class TwitterCallbackServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    public TwitterCallbackServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		this.doPost(request, response);
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		Properties systemProperties = System.getProperties(); 
		systemProperties.setProperty("http.proxyHost","127.0.0.1"); 
		systemProperties.setProperty("http.proxyPort","8087"); 
		
		Twitter twitter = new TwitterFactory().getInstance();
		twitter.setOAuthConsumer(TwitterAppInfo.CONSUMER_KEY, TwitterAppInfo.CONSUMER_SECRET);

		
		
		String oauthToken  = CookieUtility.getCookie(request, "oauthToken").getValue();
		String oauthSecret = CookieUtility.getCookie(request, "oauthSecret").getValue();
		String vefifier = request.getParameter("oauth_verifier");
		
		RequestToken requestToken = new RequestToken(oauthToken,oauthSecret);
			
		AccessToken  accessToken = null;
		
		System.out.println("OauthToken:" + oauthToken);
		System.out.println("OauthSecret:" + oauthSecret);
		
		try {
		    accessToken = twitter.getOAuthAccessToken(requestToken, vefifier);
		    
		    System.out.println("AccessToken:" + accessToken.getToken());
		    System.out.println("AccessTokenSecret:" + accessToken.getTokenSecret());
		    
			twitter.setOAuthAccessToken(accessToken);
			twitter.updateStatus("Hello " + twitter.getScreenName() + (new java.util.Date().toString()));
		} catch (TwitterException e) {
			e.printStackTrace();
		}
		
		String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+request.getContextPath()+"/"; 
		response.sendRedirect( basePath + "index.jsp");
	}

}
