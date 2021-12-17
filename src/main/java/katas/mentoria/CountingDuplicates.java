package katas.mentoria;

public class CountingDuplicates {

    public static int duplicateCount(String text) {

        //1. guardar String -> Lista/Array caracteres
        char[] textoEnCaracteres = text.toLowerCase().toCharArray();

        //2. Objeto para Armar el String
        StringBuilder caracteresDuplicados = new StringBuilder();
        //3. contador de valores duplicados
        int contadorDuplicados = 0;
        //4. validacion para alfanumerico
        boolean cumpleAlfanumerico = text.matches("^[a-zA-Z0-9]+$");


        //5. validar si cumple el alfanumerico sino retorna -1
        if(cumpleAlfanumerico){
        //2. comparar los valores del array
        for (int i = 0; i <textoEnCaracteres.length ; i++) {
            for (int j = i+1; j <textoEnCaracteres.length ; j++) {
                // si los caracteres son iguales lo agregamos
                if(textoEnCaracteres[i]==textoEnCaracteres[j] && !caracteresDuplicados.toString().contains(String.valueOf(textoEnCaracteres[i]))){
                    caracteresDuplicados.append(textoEnCaracteres[i]);
                    contadorDuplicados++;
                    break;
                }

            }

        }}else{
            return -1;
        }
        return contadorDuplicados;
    }
}