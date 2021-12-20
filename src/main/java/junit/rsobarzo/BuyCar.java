package junit.rsobarzo;

public class BuyCar {

    public static final double incremento_porciento_de_perdida = 0.5;

    public static int[] nbMonths(int PrecioViejo, int PrecioNuevo, int AhorroPorMes, double PerdidaPorMes) {
        int meses = 0;
        double faltaDinero = 0;
        double priceOld = PrecioViejo;
        double priceNew = PrecioNuevo;
        double Ahorros = 0;

        while ((priceOld + Ahorros) < priceNew){
            meses++;

            if (meses % 2 == 0) {
                PerdidaPorMes = PerdidaPorMes + incremento_porciento_de_perdida;
            }

            priceOld = priceOld - priceOld * (PerdidaPorMes / 100);
            priceNew = priceNew - priceNew * (PerdidaPorMes / 100);
            Ahorros = Ahorros + AhorroPorMes;
        }

        faltaDinero = (Ahorros + priceOld) - priceNew;

        return new int[]{meses, (int) Math.round(faltaDinero)};
    }

}
