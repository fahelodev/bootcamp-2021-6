package katas.rvargas;

public class BuyCar {

    public static int[] nbMonths(int startPriceOld, int precioInicialNuevo, int ahorroPorMes, double porcetajePerdida) {
        double ahorros = 0;
        double precioAutoNuevo = precioInicialNuevo;
        double precioAutoViejo = startPriceOld;
        int cantidadMeses = 0;
        while ((ahorros + precioAutoViejo)<precioAutoNuevo){
            cantidadMeses=cantidadMeses+1;
            if (cantidadMeses%2==0){
                porcetajePerdida=porcetajePerdida+ 0.5;
            }
            precioAutoNuevo= precioAutoNuevo- precioAutoNuevo * (porcetajePerdida/100);
            precioAutoViejo= precioAutoViejo- precioAutoViejo * (porcetajePerdida/100);
            ahorros= ahorros + ahorroPorMes;
        }
        double dineroRestante= (precioAutoViejo+ahorros)- precioAutoNuevo;
        int [] resultado = new int [] {cantidadMeses,(int)Math.round (dineroRestante)};

        return resultado;

    }
}


