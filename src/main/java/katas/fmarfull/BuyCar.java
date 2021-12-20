package katas.fmarfull;

public class BuyCar {
    public static int[] nbMonths(int startPriceOld, int startPriceNew, int savingperMonth, double percentLossByMonth) {
        int leftOver = startPriceOld - startPriceNew;
        int amountMonths = startPriceOld > startPriceNew ? -1 : 0;
        double dStartPriceOld = startPriceOld;
        double dStartPriceNew = startPriceNew;
        while (leftOver < 0) {
            amountMonths += 1;
            if ((amountMonths % 2) == 0) {
                percentLossByMonth += 0.5;
            }
            dStartPriceOld = dStartPriceOld - (dStartPriceOld * percentLossByMonth / 100d);
            dStartPriceNew = dStartPriceNew - (dStartPriceNew * percentLossByMonth / 100d);
            int sumOldNew = (int)Math.round(dStartPriceOld - dStartPriceNew);
            leftOver = sumOldNew + (savingperMonth * (amountMonths));
        }
        amountMonths = Math.max(amountMonths, 0);
        return new int[] {amountMonths, leftOver};
    }
}