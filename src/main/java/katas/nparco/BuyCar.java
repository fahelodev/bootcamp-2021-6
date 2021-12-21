package katas.nparco;

public class BuyCar {

    public static final double increment_percent = 0.5;

    public static int[] nbMonths(int startPriceOld, int startPriceNew, int savingPerMonth, double percentLossByMonth){
        int months = 0;
        double moneyLeft = 0;
        double priceOld = startPriceOld;
        double priceNew = startPriceNew;
        double savings = 0;

        while ((priceOld + savings) < priceNew){
            months++;
            if (months % 2 == 0){
                percentLossByMonth = percentLossByMonth + increment_percent;
            }
            priceOld -= priceOld * (percentLossByMonth / 100);
            priceNew -= priceNew * (percentLossByMonth / 100);
            savings = savings + savingPerMonth;
        }
        moneyLeft = (savings + priceOld) - priceNew;
        return new int[]{months, (int) Math.round(moneyLeft)};
    }
}
