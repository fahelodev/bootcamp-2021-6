package pom.equipo2.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import pom.equipo2.base.SeleniumBasePaquetes;


public class HomePagePaquetes extends SeleniumBasePaquetes {
    private String URL = "https://www.viajesfalabella.cl/paquetes/";
    public HomePagePaquetes(WebDriver driver) {
        super(driver);
    }
    // localizadores de la pagina

    By TBX_Origen = By.xpath("//input[@class='input-tag sbox-main-focus sbox-origin sbox-primary sbox-places-first sbox-origin-container places-inline']");
    By TBX_Destino = By.xpath("//input[@class='input-tag sbox-main-focus sbox-destination sbox-secondary sbox-places-second places-inline']");
    By TBX_SegundoDestino = By.xpath("//input[@class='input-tag sbox-main-focus sbox-hotel-second-destination sbox-primary undefined']");

    By TBX_FechaIda = By.xpath("//input[@class='input-tag sbox-checkin-date']");
    By TBX_Fechavuelta = By.xpath("//input[@class='input-tag sbox-checkout-date']");

    By btn_numFechaInit = By.xpath("//span[@class=\"_dpmg2--date-number\" and text()=\"20\"]");
    By btn_numFechaEnd = By.xpath("//span[@class=\"_dpmg2--date-number\" and text()=\"30\"]");
    By btn_numFechaSegundoDestino = By.xpath("//span[@class=\"_dpmg2--date-number\" and text()=\"25\"]");


    By btn_aplicarFechasPaquetes = By.xpath("//div[@class='_dpmg2--wrapper _dpmg2--roundtrip _dpmg2--show-info _dpmg2--show _dpmg2--transition-displacement']//em[@class='_dpmg2--desktopFooter-button-apply-text btn-text']");
    By BTN_Buscar = By.xpath("//em[.='Buscar']");
    By BTN_VerMasOfertas = By.xpath("//*[contains(@class, 'section-5')]//em[text()='Ver más ofertas']");
    By SegundoItem = By.xpath("//*[contains(@class, 'section-5')]//*[contains(@class, 'offer-cards-container')]/offer-card[5]/div/a/div/div/img");
    By popup = By.xpath("//span[@class='eva-3-h3']");
    By modificar_destino = By.xpath("//input[@class='input-tag sbox-main-focus sbox-destination sbox-secondary sbox-places-second places-inline']");
    By BTN_vueloDosAlojamientos = By.xpath("//*[contains(@class, 'sbox-radio-vhh')]");
    By origen_paquete = By.xpath("//input[@class='input-tag sbox-main-focus sbox-origin sbox-primary sbox-places-first sbox-origin-container places-inline']");
    By destino_paquete = By.xpath("//input[@class='input-tag sbox-main-focus sbox-destination sbox-secondary sbox-places-second places-inline']");
    By seundo_destino = By.xpath("//input[@class='input-tag sbox-main-focus sbox-hotel-first-destination sbox-primary undefined']");
    By BTN_AplicarFechaPaquete = By.xpath("//div[@class='_dpmg2--wrapper _dpmg2--roundtrip _dpmg2--show-info _dpmg2--show _dpmg2--transition-displacement']//em[@class='_dpmg2--desktopFooter-button-apply-text btn-text']");
    By BTN_BuscarPaquete = By.xpath("//*[contains(@class, 'sbox-search')]");


    public void buscarVueloYalojamiento() throws InterruptedException {

        /* 1. Seleccionar paquete de Vuelo y Alojamiento
        2. Ingresar Origen
        3. Ingresar Destino nacional
        4. Seleccionar fecha de ida
        5. Seleccionar fecha de vuelta
        5. Añadir cantidad de habitaciones y adultos
        6. Hacer click en el botón buscar*/

        ObtenerURL(URL);
        clic(TBX_Origen);
        enviarSantiago(TBX_Origen);
        Thread.sleep(2000);
        clic(TBX_Destino);
        enviarArica(TBX_Destino);
        Thread.sleep(2000);
        clic(TBX_FechaIda);
        clic(btn_numFechaInit);
        clic(TBX_Fechavuelta);
        clic(btn_numFechaEnd);
        clic(btn_aplicarFechasPaquetes);
        clic(BTN_Buscar);
    }

    public void destinoYorigenIguales() throws InterruptedException {
        /*1. Seleccionar "Ver mas ofertas"
        2. Ingresar en la segunda opcion
        3.Ingresar a la opcion del popup
        4.Click en Modificar
        5.Ingresar Santiago de Chile en origen.
        6.Ingresar Santiago de Chile en Destino.
        7.Click en Buscar */
        ObtenerURL(URL);
        clic(BTN_VerMasOfertas);
        clic(SegundoItem);
        clic(popup);
        SwitchTabs(); // cambio de ventana
        clic(modificar_destino);
        limpiarCajaTextoDestino(modificar_destino);
        enviarSantiago(modificar_destino);
        Thread.sleep(2000);
        clic(BTN_Buscar);
        validarOrigenYdestino();


    }

    public void vueloConDosAlojamientos() throws InterruptedException {
        /* 1. Seleccionar paquete de Vuelo y Dos Alojamientos ok
        2. Ingresar Origen ok
        3. Ingresar Destino internacional ok
        4. Seleccionar fecha de ida ok
        5. Seleccionar fecha de vuelta ok
        6. Añadir primer destino ok
        7. Ingresar fecha límite del primer destino ok
        8. Añadir segundo destino ok
        9. Ingresar fecha límite del segundo destino ok
        10. Añadir cantidad de habitaciones y adultos
        11. Hacer click en el botón buscar */
        ObtenerURL(URL);
        clic(BTN_vueloDosAlojamientos);

        // origen
        enviarSantiago(origen_paquete);
        Thread.sleep(2000);

        //destino
        enviarRio(destino_paquete);
        Thread.sleep(2000);

        //fecha ida
        clic(TBX_FechaIda);
        clic(btn_numFechaInit);
        Thread.sleep(2000);
        //fecha vuelta
        clic(TBX_Fechavuelta);
        clic(btn_numFechaEnd);
        Thread.sleep(2000);

        //aplicarfecha paquetes
        clic(BTN_AplicarFechaPaquete);

        //segundo destino
        clic(TBX_SegundoDestino);
        enviarSanPAblo(TBX_SegundoDestino);

        //boton buscar
        clic(BTN_BuscarPaquete);
        validaTC03();


    }
}

