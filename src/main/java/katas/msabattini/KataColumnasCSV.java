package katas.msabattini;

import java.lang.reflect.Array;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class KataColumnasCSV { //Kata grupal

    public static String sortCsvColumns(String csvFileContent)
    {

        String[] rows = csvFileContent.split("\n"); //guardar filas
        String[] title = rows[0].split(";");
        String result ="";
        String[][] matrix_rows = new String[rows.length][title.length];

        for (int i =0; i<rows.length; i++) matrix_rows [i] = rows[i].split(";");
        Arrays.sort(title,String.CASE_INSENSITIVE_ORDER); //ordenar
        for(int j=0; j<title.length; j++){
            for(int k=0; k< title.length; k++){
                if(title[j].equals(matrix_rows[0][k])){ //comparar si los string son iguales
                    for(int x=0; x<rows.length; x++){
                        //comenzar a "relacionar"
                        String assistant = matrix_rows[x][j];
                        matrix_rows[x][j] = matrix_rows[x][k];
                        matrix_rows[x][k] = assistant;
                    }
                }
            }
        }

        for(int i=0; i<rows.length; i++){
            for(int j=0; j< title.length; j++){
                result+=matrix_rows[i][j];
                if(j!=title.length-1) result +=";";
            }
            if(i!= rows.length-1) result+="\n";
        }

        return result;
    }

}
