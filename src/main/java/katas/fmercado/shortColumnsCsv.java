package katas.fmercado;

import java.util.*;

public class shortColumnsCsv {
    public static String sortCsvColumns(String csvFileContent)
    {
        List<String[]> list = new ArrayList<>();
        for(String s : csvFileContent.split("\n")) {
            list.add(s.split(";"));
        }
        List<List<String>> list2 = new ArrayList<>();
        for(int i = 0; i < list.get(0).length; i++) {
            List<String> list3 = new ArrayList<>();
            for (String[] strings : list) {

                list3.add((strings[i]));
            }
            list2.add(list3);
        }

        list2.sort(Comparator.comparing(x -> x.get(0).toLowerCase(Locale.ROOT)));
        List<List<String>> list4 = new ArrayList<>();

        for(int i = 0; i < list2.get(0).size(); i++) {
            List<String> list5 = new ArrayList<>();
            for (List<String> strings : list2) {

                list5.add((strings.get(i)));
            }
            list4.add(list5);
        }
        List<String> list6 = new ArrayList<>();
        for(List<String> i : list4) {
            String s = String.join(";", i);
            list6.add(s);
        }
        String finalText = String.join("\n", list6);
        return finalText;
    }
}
