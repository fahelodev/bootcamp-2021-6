package katas.nparco;

import java.util.Arrays;

public class SortCsvColumns {
    public static String sortCsvColumns(String csvFileContent)
    {
        String[] lines = csvFileContent.split("\n");
        String[] header = lines[0].split(";");
        String[] sortedHeader = lines[0].split(";");
        Integer[] indexes = new Integer[header.length];
        Arrays.sort(sortedHeader, String.CASE_INSENSITIVE_ORDER);
        for (int word = 0; word < header.length; word++) {
            indexes[word] = (Arrays.asList(header).indexOf(sortedHeader[word]));
        }
        csvFileContent = String.join(";", sortedHeader) + "\n";

        for (int line = 1; line < lines.length; line++) {
            String[] cells = lines[line].split(";");
            String[] sortedLine = new String[header.length];
            for (int cell = 0; cell < cells.length; cell++) {
                sortedLine[cell] = cells[indexes[cell]];
            }
            csvFileContent += String.join(";", sortedLine);
            if (line != lines.length-1) {
                csvFileContent += "\n";
            }
        }
        return csvFileContent;
    }
}