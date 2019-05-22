package online.cangjie.utils;

import java.io.UnsupportedEncodingException;
import java.net.URLDecoder;

public class JSONUtil {
	public static String getJSON(String str) throws UnsupportedEncodingException{
		return URLDecoder.decode(str, "utf-8");
	}
}
