package junit.rgutierrez;

public class BuyCarKata {

    public static int[] nbMonths(int startPriceOld, int startPriceNew, int savingperMonth, double percentLossByMonth) {

        double currentPriceOld = startPriceOld;
        double currentPriceNew = startPriceNew;
        double currentSaving = currentPriceOld;
        double currentPercentLoss = percentLossByMonth;
        int currentMonth = 0;

        if (currentPriceOld >= currentPriceNew) {
            int saving = (int)(currentPriceOld - currentPriceNew);
            int[] resultArr = { 0, saving};
            return resultArr;
        }

        while (currentSaving <=  currentPriceNew) {

            currentMonth++;

            if(currentMonth % 2 == 0) {
                currentPercentLoss += 0.5;
            }

            currentPriceOld = currentPriceOld - (currentPriceOld * currentPercentLoss/100);
            currentPriceNew = currentPriceNew - (currentPriceNew * currentPercentLoss/100);

            currentSaving = currentPriceOld + (savingperMonth * currentMonth);

            if (currentSaving >= currentPriceNew) {
                int saving = (int)Math.round((currentSaving - currentPriceNew));
                int[] resultArr = { currentMonth, saving};
                return resultArr;
            }

        }
        return null;
    }
}
