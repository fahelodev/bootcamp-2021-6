package msabattini;

import java.util.Arrays;

public class KataColumnasCSV {
        //REARMAR
    public static String sortCsvColumns(String csvFileContent)
    {
        char[] arreglo_csv = csvFileContent.toCharArray();
        String[] arreglo_textos = new String[csvFileContent.length()];
        String[] arreglo_numero1 = new String[csvFileContent.length()];
        String[] arreglo_numero2 = new String[csvFileContent.length()];
        String string_auxiliar = "";
        int position = 0;

        for(int i=0; i<arreglo_csv.length;i++){
            if(arreglo_csv[i] != ';') {
                string_auxiliar += arreglo_csv[i];
            }else if(arreglo_csv[i] == '\n'){
                break;
            }
            else{
                arreglo_textos[i] = string_auxiliar;
                string_auxiliar= "";
            }
            position = i;
        }

        for(int j=position; j<arreglo_csv.length; j++){
            if(arreglo_csv[j] != ';'){
                string_auxiliar += arreglo_csv[j];
            }else if(arreglo_csv[j] == '\n'){
                break;
            }
            else{
                arreglo_numero1[j] = string_auxiliar;
                string_auxiliar= "";
                break;
            }
            position = j;
        }

        for(int k=position; k<arreglo_csv.length; k++){
            if(arreglo_csv[k] != ';'){
                string_auxiliar += arreglo_csv[k];
            }else if(arreglo_csv[k] == '\n'){
                break;
            }else{
                arreglo_numero2[k] = string_auxiliar;
                string_auxiliar= "";
                break;
            }
            position = k;
        }

        System.out.println(arreglo_textos);
        System.out.println(arreglo_numero1);
        System.out.println(arreglo_numero2);






















        return csvFileContent;
    }

}
