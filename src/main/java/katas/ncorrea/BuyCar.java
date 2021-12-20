package ncorrea;

public class BuyCar {

    public static int[] nbMonths(float startPriceOld, float startPriceNew, float savingperMonth, double percentLossByMonth) {
        percentLossByMonth = percentLossByMonth/100;
        float saved = 0;
        int mes = 0;

        while(true){
            if(saved+startPriceOld>=startPriceNew){
                return new int[]{mes, Math.round(saved+startPriceOld-startPriceNew)};
            }
            mes++;
            if(mes>0 && mes%2==0){
                percentLossByMonth += 0.5/100;
            }
            saved += savingperMonth;
            startPriceOld = (startPriceOld - (float)(startPriceOld*percentLossByMonth));
            startPriceNew = (startPriceNew - (float)(startPriceNew*percentLossByMonth));
        }
    }
}
