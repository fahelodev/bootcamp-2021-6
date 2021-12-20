package iromero;

public class AlternatingCase {
    public static String toAlternativeString(String string) {

        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < string.length(); i++) {
            if (Character.isUpperCase(string.charAt(i))) {
                sb.append(Character.toLowerCase(string.charAt(i)));

            }else if (Character.isLowerCase(string.charAt(i))) {
                sb.append(Character.toUpperCase(string.charAt(i)));
            }else if(Character.isSpaceChar(string.charAt(i))){
                sb.append(" ");
            }else{
                sb.append(string.charAt(i));
            }
        }

        return sb.toString();
    }
}
