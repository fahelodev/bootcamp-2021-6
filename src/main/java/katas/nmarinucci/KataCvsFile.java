package katas.nmarinucci;

import java.util.ArrayList;
import java.util.Arrays;



public class KataCvsFile {
    public static String sortCsvColumns(String csvFileContent) {

        String [] lines = csvFileContent.split("\n");
        String [] header = lines[0].split(";");
        String [] sortedHeader = lines[0].split(";");
        Integer [] indexes = new Integer[header.length];
        Arrays.sort(sortedHeader, String.CASE_INSENSITIVE_ORDER);

        for (int i=0; i< header.length;i++){
            indexes[i] = (Arrays.asList(header).indexOf(sortedHeader[i]));
        }
        csvFileContent = String.join(";", sortedHeader) + "\n";

        for (int j = 1; j< lines.length;j++){
            String [] cells = lines[j].split(";");
            String [] sortedLine = new String[header.length];

            for( int cell = 0; cell< cells.length; cell++){
                sortedLine[cell] = cells[indexes[cell]];
            }

            csvFileContent += String.join(";",sortedLine);
            if(j != lines.length-1){
                csvFileContent += "\n";
            }
        }
        return csvFileContent;
    }
}
