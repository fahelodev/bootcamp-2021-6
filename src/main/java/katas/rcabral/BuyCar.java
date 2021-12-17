package katas.rcabral;

import static java.lang.Math.round;

public class BuyCar {
    public static int[] nbMonths(int startPriceOld, int startPriceNew, int savingperMonth, double percentLossByMonth) {
        // your code
        int meses = 0;
        double resultado;
        double precioAutoViejo = startPriceOld;
        double precioAutoNuevo = startPriceNew;
        double ahorros = 0;

        while(precioAutoNuevo > (precioAutoViejo + ahorros)){
            meses ++;
            if(meses % 2 == 0){
                percentLossByMonth += .5; //nos aseguramos de que se aplique cada 2 meses.
            }
            ahorros += savingperMonth;
            precioAutoViejo -= precioAutoViejo * (percentLossByMonth / 100);
            precioAutoNuevo -= precioAutoNuevo * (percentLossByMonth / 100);
        }
        resultado = (ahorros + precioAutoViejo) - precioAutoNuevo;
        return new int [] {meses, (int) round(resultado)};
    }
}
