package katas.ifuentes;

public class invertirCadena
{
    public static String palabrasinversas(final String text)
    {
        String[] array = text.split(" ");
        if(array.length == 0)
            return text;
        int i = 0;
        for(String string : array){
            array[i] = new StringBuilder(string).reverse().toString();
            i++;
        }

        return String.join(" ",array);
    }
}