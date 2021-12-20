package katas.msabattini;
import com.sun.org.apache.xpath.internal.operations.Equals;


public class KataReverse {

        public static String reverseWords(final String original)
        {
            char[] array_origin = original.toCharArray();
            StringBuilder assistant = new StringBuilder();
            String reverseString= "";
            String reverseString_final ="";

            for(int i=0; i<array_origin.length; i++){

                if(array_origin[i] != ' '){
                    assistant.append(array_origin[i]);
                }if(array_origin[i] == ' ' || i == array_origin.length - 1){
                    reverseString += assistant.reverse();
                    reverseString_final += reverseString;
                    reverseString_final+=" ";
                    assistant.delete(0, assistant.length());
                    reverseString = "";
                }

            }

            reverseString_final += reverseString;

            return reverseString_final.substring(0,reverseString_final.length()-1);

        }

}
