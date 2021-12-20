package katas.mguzman;

import java.util.ArrayList;
import java.util.Collections;

public class Alfa {
    public static String sortCsvColumns(String csvFileContent)
    {
        ArrayList <String> arreglo  = new ArrayList<String>();
        String Ordenado="";
        Collections.sort(arreglo);

        for (int i = 0; i < arreglo.toArray().length; i++) {
                Ordenado += arreglo;



        }

        return csvFileContent;
    }


}
