package fabriciof;

public class CasoAlternativoJava {

int i= 0;


    public static String toAlternativeString(String string) {

        String aux = "";
        for (int i =0; i < string.length(); i++) {
            String c = Character.toString(string.charAt(i));
            if (c.toUpperCase() == c) {
                aux += c.toLowerCase();
            } else {
                aux += c.toUpperCase();
            }
        }
        return aux;

    }


}
