package junit.rsobarzo;


import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collection;
import java.util.Collections;
import java.util.Comparator;
import java.util.HashMap;
import java.util.LinkedList;
import java.util.Map;
import java.util.Map.Entry;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class SortColumnsCSV {


    //ordena las columnas del csv
    public static String sortCsvColumns( String csvFileContent ) {

        Map<Integer, String> columns = new HashMap<Integer, String>();

        getColumnNames( csvFileContent, columns );

        //ordena las columnas
        int[] sortedColumns = sortMapByValue( columns );
        // System.out.print( "*** sortedColumn: " );
        // for ( int i = 0; i < sortedColumns.length; i++ ) {
        //
        // System.out.print( sortedColumns[i] + " " );
        // }

        //retorna columans ordenadas y contenido de archivo
        return sortColumns( sortedColumns, csvFileContent );
    }

    //obtiene el nombre de las columnas
    private static void getColumnNames( String csvFileContent, Map<Integer, String> columns ) {
        Pattern pattern = Pattern.compile( "([^;\\n]+)([;\\n])" );
        Matcher matcher = pattern.matcher( csvFileContent );

        int i = 0;
        while ( matcher.find() && !matcher.group( 2 ).equals( "\n" ) ) {
            columns.put( i, matcher.group( 1 ) );
            i++;
        }
        columns.put( i, matcher.group( 1 ) );

//		pritOutMap( columns );
        // System.out.println( "*** The column names input is ready" );

    }

//	private static void pritOutMap( Map<Integer, String> map ) {
//
//		for ( int i = 0; i < map.size(); i++ ) {
//			System.out.println( map.get( i ) );
//		}
//	}

    //retorna columnas ordenadas
    private static int[] sortMapByValue( Map<Integer, String> unsortedMap ) {
        LinkedList<Entry<Integer, String>> list = new LinkedList<Entry<Integer, String>>(
                (Collection<? extends Entry<Integer, String>>) unsortedMap.entrySet() );

        //compara listas de pre sorting y post sorting
        Collections.sort( list, new Comparator<Entry<Integer, String>>() {
            public int compare( Entry<Integer, String> o1, Entry<Integer, String> o2 ) {
                return o1.getValue().toLowerCase().compareTo( o2.getValue().toLowerCase() );
            }
        } );

        int[] sortedColumns = new int[unsortedMap.size()];
        int i = 0;
        for ( Entry<Integer, String> entry : list ) {
            sortedColumns[i] = entry.getKey();
            i++;
        }

        return sortedColumns;

    }

    //metodo que ordena las columnas
    private static String sortColumns( int[] sortedColumns, String csvFileContent ) {

        StringBuffer resultString = new StringBuffer();

        ArrayList<String> csvElements = new ArrayList<String>( Arrays.asList( csvFileContent.split( "[;\\n]" ) ) );

        // for ( int i = 0; i < csvElements.size(); i++ ) {
        // System.out.println( csvElements.get( i ) );
        // }

        for ( int j = 0; j < csvElements.size() / sortedColumns.length; j++ ) {
            for ( int i = 0; i < sortedColumns.length; i++ ) {

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
