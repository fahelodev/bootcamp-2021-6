package katas.fmercado;

public class ReverseWords {
    public static String reverseWords(final String original){
        String[] words = original.split(" ");
        StringBuilder reversedWords = new StringBuilder();
        if (words.length == 0) {
            return original;
        }

        for (int i = 0; i < words.length; i++){
            for (int j = words[i].length() - 1; j >= 0; j--){
                reversedWords.append(words[i].charAt(j));
            }
            if (i != words.length -1){
                reversedWords.append(" ");
            }
        }
        return reversedWords.toString();
    }
}
