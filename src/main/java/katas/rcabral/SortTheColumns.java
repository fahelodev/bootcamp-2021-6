package katas.rcabral;

import java.util.Arrays;

public class SortTheColumns {
    public static String sortCsvColumns(String csvFileContent)
    {
        String resultado = "";
        String[] filas = csvFileContent.split("\n");
        String[] copiaTitulo = filas[0].split(";");
        String[][] filasSeparadas = new String[filas.length][copiaTitulo.length];
        for(int i = 0; i < filas.length; i++){
            filasSeparadas[i] = filas[i].split(";");
        }

        Arrays.sort(copiaTitulo, String.CASE_INSENSITIVE_ORDER);
        for(int i=0; i < copiaTitulo.length; i++){
            for(int j = 0; j < copiaTitulo.length; j++){
                if(copiaTitulo[i].equals(filasSeparadas[0][j])){
                    for(int k = 0; k < filas.length; k++){
                        String aux = filasSeparadas[k][i];
                        filasSeparadas[k][i] = filasSeparadas[k][j];
                        filasSeparadas[k][j] = aux;
                    }
                }
            }
        }
        for(int i = 0; i < filas.length; i++){
            for(int j = 0; j < copiaTitulo.length; j++){
                resultado += filasSeparadas[i][j];
                if(j != copiaTitulo.length-1){
                    resultado += ";";
                }
            }
            if(i != filas.length-1){
                resultado += "\n";
            }
        }
        return resultado;
    }
}
