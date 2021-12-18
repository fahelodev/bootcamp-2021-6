package nmarinucci;

public class BuyCar {
    public static int[] nbMonths(float startPriceOld, float startPriceNew, float savingperMonth, double percentLossByMonth) {
        int month = 0;
        float total = 0;
        double devaluo = percentLossByMonth;


        while (total + startPriceOld < startPriceNew) {
            month++;
            if (month % 2 == 0 && month != 0) {
                devaluo = (devaluo + 0.5);
            }
            total += savingperMonth;
            startPriceNew -= startPriceNew * (devaluo / 100);
            startPriceOld -= startPriceOld * (devaluo / 100);
        }

        return new int[]{month, Math.round(total + startPriceOld - startPriceNew)};

    }
}