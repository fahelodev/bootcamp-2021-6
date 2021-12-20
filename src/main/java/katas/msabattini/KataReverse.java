package katas.msabattini;

public class KataReverse {

    public static String reverseString(String string) {

        //CORREGIR

        char[] cadena_auxiliar = string.toCharArray();
        String string_completo = "";
        char ultimo_caracter = string.charAt(string.length() - 1);

        for (int i=0; i<cadena_auxiliar.length; i++){
            if(cadena_auxiliar[i] == ' ' || cadena_auxiliar[i] == ultimo_caracter) {
                for(int j=i-1; j>=0; j--){
                    if(cadena_auxiliar[j] == ' '){
                        break;
                    }else if(cadena_auxiliar[j+1] == ultimo_caracter){
                        string_completo = string_completo + cadena_auxiliar[j+1];
                    }
                    string_completo = string_completo + cadena_auxiliar[j];
                }
                string_completo = string_completo + " ";

            }

        }

        return string_completo.substring(0, string_completo.length() - 1);
    }


}
