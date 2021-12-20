package fabriciof;

public class ComprarCarroJava {

    public static final double incremento_porciento_de_perdida = 0.5;

    public static int[] nbMonths(int InicioPrecioViejo, int InicioPrecioNuevo, int AhorroPorMes, double PerdidaPorMes) {
        int meses = 0;
        double faltaDinero = 0;
        double priceOld = InicioPrecioViejo;
        double priceNew = InicioPrecioNuevo;
        double Ahorros = 0;

        while ((priceOld + Ahorros) < priceNew){//mientas precio viejo+ahorros sean < precio nuevo incrementa mess
            meses++;

            if (meses % 2 == 0) {
                PerdidaPorMes = PerdidaPorMes + incremento_porciento_de_perdida;
            }

            priceOld = priceOld - priceOld * (PerdidaPorMes / 100); //perdidaPorMes 1,5
            priceNew = priceNew - priceNew * (PerdidaPorMes / 100);
            Ahorros = Ahorros + AhorroPorMes;
        }

        faltaDinero = (Ahorros + priceOld) - priceNew;

        return new int[]{meses, (int) Math.round(faltaDinero)};//math.round retorna un valor redondeando al entero mas cercano
    }

}
