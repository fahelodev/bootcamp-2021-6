package junit.rgutierrez;

public class ReverseWordsKata
{
    public static String reverseWords(final String original)
    {
        if(original.trim().isEmpty()) {
            return original;
        }

        // 1. Separo en los espacios y guardo las palabras en el arreglo words
        String[] words = original.split(" ");
        StringBuilder result = new StringBuilder();

        // 2. Recorro cada palabra del arreglo
        for (int i = 0; i < words.length; i++) {

            String word = words[i];

            // 5. En caso de ser un espacio en blanco, lo agrego y salto a la siguiente iteracion
            if (word.equals("")) {
                result.append(" ");
                continue;
            }

            // 3. itero en reversa por cada letra de la palabra y la agrego al StringBuilder
            for (int j = word.length()-1; j >= 0 ; j--) {
                result.append(word.charAt(j));
            }


            // 4. En caso de ser la ultima palabra del arreglo no agrego un espacio
            if (words.length - 1 == i) {
                break;
            }

            result.append(" ");

        }

        return (result.toString());
    }
}
