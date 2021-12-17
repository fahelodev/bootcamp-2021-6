package katas.iromero;

public class BuyCar {
    public static int[] nbMonths(float startPriceOld, float startPriceNew, float savingperMonth, double percentLossByMonth) {
        int month = 0;
        float total = 0;
        double devalued = percentLossByMonth;


        while (total + startPriceOld < startPriceNew) {
            month++;
            if (month % 2 == 0 && month != 0) {
                devalued = (devalued + 0.5);
            }
            total += savingperMonth;
            startPriceNew -= startPriceNew * (devalued / 100);
            startPriceOld -= startPriceOld * (devalued / 100);
        }

        return new int[]{month,Math.round(total + startPriceOld - startPriceNew)};

    }
}
