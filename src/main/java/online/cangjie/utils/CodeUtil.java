package online.cangjie.utils;

import java.util.Random;

public class CodeUtil {
	public static String getCode(){
		Random random = new Random();
		StringBuffer sb = new StringBuffer();
		for (int i = 0; i < 6; i++) {
			sb.append(String.valueOf(random.nextInt(9)));
		}
		return sb.toString();
	}
}
