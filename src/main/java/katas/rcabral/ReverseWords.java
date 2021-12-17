package katas.rcabral;

public class ReverseWords {
    public static String reverseWords(final String original)
    {
        String stringReverso = "";
        String palabra = "";
        for (int i = 0; i < original.length(); i++){
            if(original.charAt(i) != ' '){ //si el caracter no es un espacio
                palabra = original.charAt(i) + palabra; //armamos la palabra de manera reversa
            }
            if(original.charAt(i) == ' '){ //si el caracter es un espacio
                stringReverso += palabra; //introducimos la palabra reversa
                palabra = "";
                stringReverso += " ";
            }
        }
        stringReverso += palabra; //concatenamos la última palabra reversa.
        return stringReverso;
    }
}
