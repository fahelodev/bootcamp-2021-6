package pom.equipo6.test;
/*1. Cargar Home
2. Ir a servicio Alojamientos
3. Ingresar en campo ciudad destino "Madrid, Comunidad de Madrid, España"
4. Seleccionar la casilla "Todavía no he decidido la fecha"
5. Seleccionar el primer un hotel de la lista
6.En Comentarios sobre este alojamiento marcar, Ordenar por "Menor Puntaje"*/

import org.junit.Assert;
import org.junit.Test;
import pom.equipo1.pages.ResultadoTrasladoPage;
import pom.equipo1.pages.TrasladoPage;
import pom.equipo1.pages.VFHomePage;
import pom.equipo6.base.JunitTestBase;

import pom.equipo6.pages.Alojamientopage;
import pom.equipo6.pages.FalabellaHomePage;
import pom.equipo6.pages.ResultadoAlojamientoPage;
import pom.equipo6.pages.ResultadoHotel;

public class atc01OrdenarLosComentariosdDeHotelPorMenorPuntajeAlojamiento extends JunitTestBase {


    private FalabellaHomePage home;
    private Alojamientopage alojamiento;
    private ResultadoAlojamientoPage ResultadoAlojamiento;
    private ResultadoHotel hotelResultado;

    @Test
    public void Test() throws InterruptedException {
        //usar POM :: declarar las pages asoiciadas a la prueba
        home = new FalabellaHomePage(driver);
        alojamiento = new Alojamientopage(driver);
        ResultadoAlojamiento = new ResultadoAlojamientoPage(driver);
        hotelResultado = new ResultadoHotel(driver);

        home.irAAlojamientos();
        alojamiento.BuscarHotel();;
        ResultadoAlojamiento.Resultado();
        hotelResultado.PuntajeHotel();



    }
}
