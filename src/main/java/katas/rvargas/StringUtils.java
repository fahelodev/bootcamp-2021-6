package katas.rvargas;

public class StringUtils {
    public static String toAlternativeString(String string) {

        char[] palabra = string.toCharArray();
        String palabra1;

        for (int i = 0; i < palabra.length; i++) {
            if (Character.isLowerCase(palabra[i])) {

                palabra[i]=Character.toUpperCase(palabra[i]);
            }
            else if (Character.isUpperCase(palabra[i])) {

                palabra[i]=Character.toLowerCase(palabra[i]);
            }
        }
        palabra1=String.valueOf(palabra);
        return palabra1;
    }

}
