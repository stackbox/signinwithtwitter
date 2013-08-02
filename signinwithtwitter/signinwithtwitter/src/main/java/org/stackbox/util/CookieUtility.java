package org.stackbox.util;

import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;



public class CookieUtility {
	public static Cookie getCookie(HttpServletRequest request, String keyName) {
		Cookie[] cookies = request.getCookies();
		Cookie cookie = null;
		
		if(null != cookies) {
			for(Cookie tmpCookie : cookies) {
				if(tmpCookie.getName().equals(keyName)) {
					cookie = tmpCookie;
					break;
				}
			}
		}
		return cookie;
	}
	
	public static void setCookie(HttpServletResponse response, String keyName, String value) {
		Cookie cookie = new Cookie(keyName, value);
		response.addCookie(cookie);
	}
}
