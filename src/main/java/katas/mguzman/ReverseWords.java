package katas.mguzman;

public class ReverseWords {

    public static String reverseWords(final String original)
    {
        String[] arreglo= original.split(" ");
        String invertida="";

        if(arreglo.length == 0) {
            return original;
        }
        else{
            for (int i = 0; i < arreglo.length; i++) {
                if(i>=1) {
                    invertida += " ";
                }
                for (int j = arreglo[i].length()-1; j >=0 ; j--) {

                    invertida += arreglo[i].charAt(j);
                }
            }
        }
        return invertida;
    }
}
