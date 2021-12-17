package dYañez;

import java.util.Stack;
import java.util.StringTokenizer;

public class ReverseWord {

    public static String reverseWords(String word) {

        String[] arr1=word.split(" ");

        String reverseWorlds="";

        if(arr1.length==0){
            return word;
        }

        for(int positionUno=0;positionUno<=arr1.length-1;positionUno++) {

            String reverseString="";

            for(int positionDos=arr1[positionUno].length()-1;positionDos>=0;positionDos--) {

                char ch=arr1[positionUno].charAt(positionDos);
                reverseString=reverseString+ch;

            }
            if(positionUno==0) {
                reverseWorlds+=reverseString;
            }else {
                reverseWorlds+=" "+reverseString;
            }
        }
        return reverseWorlds;
    }
}

/*
import java.lang.StringBuilder;

public class Kata
{
    public static String reverseWords(final String original)
    {
        String[] array = original.split(" ");

        if(array.length == 0)
            return original;


        int i = 0;
        for(String string : array){
            array[i] = new StringBuilder(string).reverse().toString();
            i++;
        }

        return String.join(" ",array);
    }
}

*/
