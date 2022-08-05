package by.zadziarnouski.unittesting.util;

public class StringUtils {

  public static boolean isPalindrome(String s1) {
    StringBuffer sb = new StringBuffer();
    char[] chars = s1.toCharArray();

    for (int i = chars.length - 1; i >= 0; i--) {
        sb.append(chars[i]);
    }
    return s1.equalsIgnoreCase(sb.toString());
  }
}
