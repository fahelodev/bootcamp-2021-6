package dYañez;

public class AlternatingCase {
    public static String toAlternativeString(String string){
        char[] arrayString = string.toCharArray();
        String stringAlternado = "";

        for (int i = 0; i < string.length(); i++) {
            if (Character.isUpperCase(arrayString[i])){
                stringAlternado += Character.toLowerCase(arrayString[i]);
            }else{
                stringAlternado+= Character.toUpperCase(arrayString[i]);
            }
        }
        return stringAlternado;
    }
}


/*public class StringUtils {
    public static String toAlternativeString(String string) {
        String result = "";
        for (char c : string.toCharArray()) {
            if(Character.isUpperCase(c)) {
                result += Character.toLowerCase(c);
            } else {
                result += Character.toUpperCase(c);
            }
        }
        return result;
    }
}*/
