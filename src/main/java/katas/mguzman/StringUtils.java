package katas.mguzman;

public class StringUtils {

    public static String toAlternativeString(String palabra){
        char[] p1 = palabra.toCharArray();
            for (int i = 0; i < p1.length; i++){
                if(Character.isUpperCase(p1[i])){
                    p1[i]= Character.toLowerCase(p1[i]);
                }
                else {
                    p1[i]= Character.toUpperCase(p1[i]);
                }
            }
            String p2 = String.valueOf(p1);

            return p2;
    }
}
