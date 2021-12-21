package katas.rvargas;

public class ReverseWords {
    public static String reverse(String text) {

        char[] palabra = text.toCharArray();
        String invertida = "";

        for (int i = palabra.length - 1; i >= 0; i--) {
            invertida += palabra[i];
        }
        return invertida;
    }

    public static String reverseWords(final String original) {

        String[] palabras = original.split(" ");

        StringBuilder textoInvertido = new StringBuilder();

        for (int i = 0; i < palabras.length; i++) {

            String palabraInvertida = reverse(palabras[i]);

            textoInvertido.append(palabraInvertida + " ");
        }
        return textoInvertido.toString().trim();
    }
}