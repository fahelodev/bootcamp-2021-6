package katas.rvargas;

import java.text.Collator;
import java.util.Arrays;
import java.util.List;

public class SortCSVColumns {

    public static String sortCsvColumns(String csvFileContent) {
        // declaraciones
        String[] rows = csvFileContent.split("\n");
        int totalRows = rows.length;
        int totalColumns = rows[0].split(";").length;

        String[][] matrix = new String[totalRows][totalColumns];

        // cargar la matrix
        for (int i = 0; i < totalRows; i++) matrix[i] = rows[i].split(";");

        String[] sortedHeaders = matrix[0].clone();
        Arrays.sort(sortedHeaders, Collator.getInstance());
        int[] transpose = new int[totalColumns];
        List<String> sortedHeadersList = Arrays.asList(sortedHeaders);

        for (int i = 0; i < totalColumns; i++) transpose[i] = sortedHeadersList.indexOf(matrix[0][i]);

        // Cargar la matrix ordenada
        String[][] sortedMatrix = new String[totalRows][totalColumns];
        for (int i = 0; i < totalRows; i++)
            for (int j = 0; j < totalColumns; j++) sortedMatrix[i][transpose[j]] = matrix[i][j];

        // Generar resultado
        StringBuilder result = new StringBuilder();
        for (int i = 0; i < totalRows; i++) {
            List<String> rowList = Arrays.asList(sortedMatrix[i]);
            result.append(String.join(";", rowList));

            if (i != totalRows - 1) result.append("\n");
        }

        return result.toString();
    }
}
