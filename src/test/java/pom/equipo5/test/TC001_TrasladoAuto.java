package pom.equipo5.test;

import org.junit.Test;
import pom.equipo5.base.TestBaseE5;
import pom.equipo5.pages.PageTraslados;
import pom.equipo5.pages.VFHomePageE5;
import pom.mentoria.pages.VFHomePage;

public class TC001_TrasladoAuto extends TestBaseE5 {

    protected PageTraslados paginatraslados;
    protected VFHomePageE5 paginahome;


    @Test
    public void Test(){
        //usar POM :: declarar las pages asoiciadas a la prueba
        paginatraslados = new PageTraslados(driver);
        paginahome = new VFHomePageE5(driver);
        paginahome.abrirHome();
        paginatraslados.SeccionDeTraslados();
        paginatraslados.IngresaUnAeropuerto();
        paginatraslados.SeleccionarUnAeropuerto();
        paginatraslados.IngresoUnHotel();
        paginatraslados.SeleccionarUnHotel();
        paginatraslados.FechaDeArribo();
        paginatraslados.PasajerosAdultos();
        paginatraslados.Buscar();
        paginatraslados.ValidarText();

    }

}
