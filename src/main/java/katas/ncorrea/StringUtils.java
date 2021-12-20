package ncorrea;

public class StringUtils {

    public static String toAlternativeString(String string) {

        char [] letters = string.toCharArray();

        for(int i=0; i<letters.length;i++){
            if(Character.isUpperCase(letters[i])){
                letters[i] = Character.toLowerCase(letters[i]);
            }
            else{
                letters[i] = Character.toUpperCase(letters[i]);
            }
        }
        return String.valueOf(letters);
    }
}
