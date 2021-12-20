package katas.nparco;

public class AlternatingCase {
    public static String toAlternativeString(String s) {
    char[] str = s.toCharArray();
    String str1 = "";
        for (int i = 0; i < str.length; i++) {
            if (Character.isUpperCase(str[i])){
                str1 += Character.toLowerCase(str[i]);
            }else{
                str1 += Character.toUpperCase(str[i]);
            }
        }
        return str1;
    }
}
