package rgutierrez;

public class AlternateCaseKata {

    public static String toAlternativeString(String string) {

        StringBuilder result = new StringBuilder();
        String[] strArr = string.split("");

        for (String letter: strArr) {
            if(letter.matches("[a-z]")) {
                result.append(letter.toUpperCase());
            } else if (letter.matches("[A-Z]")) {
                result.append(letter.toLowerCase());
            }
            else {
                result.append(letter);
            }
        }
        

        return result.toString();
    }
}
