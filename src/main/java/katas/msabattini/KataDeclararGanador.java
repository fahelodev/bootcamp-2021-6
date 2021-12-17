package msabattini;

public class KataDeclararGanador {

    public static String declararGanador(Luchador luchador1, Luchador luchador2, String primerAtacante){

        if(primerAtacante == luchador1.nombre){
            while(luchador1.salud>0 && luchador2.salud>0){
                luchador2.salud-=luchador1.danioPorAtaque;
                if(luchador2.salud<=0) {
                    return luchador1.nombre;
                }
                luchador1.salud-= luchador2.danioPorAtaque;
                if(luchador1.salud<=0) {
                    return luchador2.nombre;
                }
            }
        }else{
            while(luchador1.salud>0 && luchador2.salud>0){
                luchador1.salud-=luchador2.danioPorAtaque;
                if(luchador1.salud<=0) {
                    return luchador2.nombre;
                }
                luchador2.salud-= luchador1.danioPorAtaque;
                if(luchador2.salud<=0) {
                    return luchador1.nombre;
                }
            }

        }

        return "";
    }

}
