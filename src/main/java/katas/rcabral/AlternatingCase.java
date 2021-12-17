package katas.rcabral;

import java.util.Arrays;

public class AlternatingCase {
    public static String toAlternativeString(String string) {
        // your code here!
        char[] arrayString = string.toCharArray();
        String stringAlternado = "";

        for(int i=0; i<string.length(); i++){
            if(Character.isUpperCase(arrayString[i])){
                stringAlternado += Character.toLowerCase(arrayString[i]); //si está en mayúsculas lo pasamos a minúsculas
            }else{
                stringAlternado += Character.toUpperCase(arrayString[i]); //si es minúsculas lo pasamos a mayúsculas
            }
        }
        return stringAlternado;

    }
}
