package katas.fmarfull;

public class StringUtils {
    public static String toAlternativeString(String string) {
        String res = "";
        for (int letter = 0; letter < string.length(); letter++) {
            if (Character.isUpperCase(string.charAt(letter))) {
                res += Character.toLowerCase(string.charAt(letter));
            } else {
                res += Character.toUpperCase(string.charAt(letter));
            }
        }
        return res;
    }
}
