package nmarinucci;

public class KataReverseWords {
    public static String reverseWords(String original) {
        String[] palabrasCortadas = original.split(" ");
        String palabrasInvertidas = "";

        for (String palabra : palabrasCortadas){
            for (int i = palabra.length()-1 ;i>=0; i--){
                palabrasInvertidas += palabra.charAt(i);
            }
            palabrasInvertidas += " ";
        }
        palabrasInvertidas = palabrasInvertidas.substring(0,palabrasInvertidas.length()-1);
        return palabrasInvertidas;
    }
}