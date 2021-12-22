package katas.ifuentes;
public class BuyCar {

    public static int[] nbMonths(int startPriceOld, int startPriceNew, int savingperMonth, double percentLossByMonth) {
        int month=0;
        int currentBalance = 0;
        int sumSaving = 0;
        if(startPriceOld >= startPriceNew) {
            currentBalance = startPriceOld  - startPriceNew;
            int[] purchase = new int[]{0,currentBalance};
            return purchase;
        }else if(startPriceOld < startPriceNew && startPriceOld >= 0) {
            double priceOld = startPriceOld;
            double priceNew = startPriceNew;
            do {
                month ++;
                sumSaving += savingperMonth;
                if (month % 2 == 0) {
                    percentLossByMonth += 0.5;
                }

                priceOld -= priceOld * percentLossByMonth/100 ;
                priceNew -= priceNew * percentLossByMonth/100 ;
                currentBalance = (int)(priceOld + sumSaving - priceNew);
            }while ((priceOld + sumSaving) < priceNew);
            int[] purchase = new int[]{month , currentBalance};
            return purchase;
        }
        return null;
    }
}