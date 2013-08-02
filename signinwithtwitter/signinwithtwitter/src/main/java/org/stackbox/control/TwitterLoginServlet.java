package org.stackbox.control;

import java.io.IOException;
import java.util.Properties;

import javax.servlet.ServletContext;
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
import twitter4j.auth.RequestToken;

/**
 * Servlet implementation class TwitterLoginServlet
 */
@WebServlet("/member/loginWithTwitter.do")
public class TwitterLoginServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

    public TwitterLoginServlet() {
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
		request.getSession().setAttribute("twitter", twitter);
		
		try {
			RequestToken requestToken = twitter.getOAuthRequestToken();
			
			String oauthToken  = requestToken.getToken();
			String oauthSecret = requestToken.getTokenSecret();
			
			/*
			request.getCookies().setAttribute("requestToken", requestToken);
			request.getSession().setAttribute("oauthToken", oauthToken);
			request.getSession().setAttribute("oauthSecret", oauthSecret);
			*/
			
			//response.addCookie(new Cookie("oauthToken",oauthToken));
			//response.addCookie(new Cookie("oauthSecret",oauthSecret));
			CookieUtility.setCookie(response, "oauthToken",oauthToken);
			CookieUtility.setCookie(response, "oauthSecret",oauthSecret);
			
			//response.sendRedirect("index.jsp");
			response.sendRedirect(requestToken.getAuthenticationURL());
			
					
		} catch (TwitterException e) {
			e.printStackTrace();
		}
		
		
	}

}
