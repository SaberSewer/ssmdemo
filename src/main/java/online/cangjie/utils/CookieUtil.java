package online.cangjie.utils;

import java.util.HashMap;
import java.util.Map;

import javax.servlet.http.Cookie;

public class CookieUtil {
	public static Map<String, String> getCookieAsMap(Cookie []cookies){
		Map<String, String> map = new HashMap<>();
		for (Cookie cookie : cookies) {
			map.put(cookie.getName().toLowerCase(), cookie.getValue());
		}
		return map;
	}
}
