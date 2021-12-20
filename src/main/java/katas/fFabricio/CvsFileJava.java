package katas.fFabricio;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collection;
import java.util.Collections;
import java.util.Comparator;
import java.util.HashMap;
import java.util.LinkedList;
import java.util.Map;

import java.util.regex.Matcher;
import java.util.regex.Pattern;



public class CvsFileJava {

    public static String sortCsvColumns( String csvFileContent ) {

        Map<Integer, String> columns = new HashMap<Integer, String>();

        getColumnNames( csvFileContent, columns );

        int[] sortedColumns = sortMapByValue( columns );


        return sortColumns( sortedColumns, csvFileContent );//retorna columnas ord
    }

    private static void getColumnNames( String csvFileContent, Map<Integer, String> columns ) { //entrada de  los nombres de las columnas
        Pattern pattern = Pattern.compile( "([^;\\n]+)([;\\n])" );
        Matcher matcher = pattern.matcher( csvFileContent ); //trae las columnas del pre

        int i = 0;
        while ( matcher.find() && !matcher.group( 2 ).equals( "\n" ) ) {
            columns.put( i, matcher.group( 1 ) );
            i++;
        }
        columns.put( i, matcher.group( 1 ) );



    }

    private static int[] sortMapByValue( Map<Integer, String> unsortedMap ) {
        LinkedList<Map.Entry<Integer, String>> list = new LinkedList<Map.Entry<Integer, String>>( //trae las columnas
                (Collection<? extends Map.Entry<Integer, String>>) unsortedMap.entrySet() );

        Collections.sort( list, new Comparator<Map.Entry<Integer, String>>() { //compara y las ordena
            public int compare( Map.Entry<Integer, String> o1, Map.Entry<Integer, String> o2 ) {
                return o1.getValue().toLowerCase().compareTo( o2.getValue().toLowerCase() );
            }
        } );

        int[] sortedColumns = new int[unsortedMap.size()];
        int i = 0;
        for ( Map.Entry<Integer, String> entry : list ) {
            sortedColumns[i] = entry.getKey();
            i++;
        }

        return sortedColumns;

    }
    private static String sortColumns( int[] sortedColumns, String csvFileContent ) { //trae tdo del pre

        StringBuffer resultString = new StringBuffer();

        ArrayList<String> csvElements = new ArrayList<String>( Arrays.asList( csvFileContent.split( "[;\\n]" ) ) );


        for ( int j = 0; j < csvElements.size() / sortedColumns.length; j++ ) {
            for ( int i = 0; i < sortedColumns.length; i++ ) { //los ordena

                resultString.append( csvElements.get( j * sortedColumns.length + sortedColumns[i] ) );
                if ( i < sortedColumns.length - 1 ) {

                    resultString.append( ";" );
                }
            }
            if ( j < csvElements.size() / sortedColumns.length - 1 ) {
                resultString.append( "\n" );
            }
        }
        return resultString.toString();
    }


}
