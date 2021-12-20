package ncorrea;

import java.util.HashMap;

public class ReverseWords {

    public static String reverseWords(final String original){

        String [] array = original.split(" ");

        if (array.length == 0) {
            return original;
        }

        HashMap<Integer, String> mapa = new HashMap<>();

        for(int i=0;i<array.length;i++){
            mapa.put(i,array[i]);
        }

        for(int i=0; i<mapa.size();i++){
            String elemento = new StringBuilder(mapa.get(i)).reverse().toString();
            mapa.put(i,elemento);
        }

        return String.join(" ",mapa.values());
    }
}
