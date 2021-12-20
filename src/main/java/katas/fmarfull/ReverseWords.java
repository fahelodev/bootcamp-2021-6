package katas.fmarfull;

public class ReverseWords {
    public static String reverseWords(final String original)
    {
        String[] words = original.split(" ");
        StringBuilder res = new StringBuilder();
        for (int word = 0; word < words.length; word++) {
            for (int letter = 0; letter < words[word].length(); letter++) {
                res.append(words[word].charAt(words[word].length() - 1 - letter));
            }
            if (word < words.length-1) {
                res.append(" ");
            }
        }
        return res.toString();
    }
}
