package msabattini;

import static java.lang.Character.*;

public class KataAlternativeString {

    public static String AlternativeString(String string){

        char [] arreglo_caracteres = string.toCharArray();
        String string_final="";

        for(int i=0; i<arreglo_caracteres.length; i++){
            if(isUpperCase(arreglo_caracteres[i])){
                string_final+= toLowerCase(arreglo_caracteres[i]);
            }else{
                string_final+= toUpperCase(arreglo_caracteres[i]);
            }
        }

        return string_final;

    }
}
