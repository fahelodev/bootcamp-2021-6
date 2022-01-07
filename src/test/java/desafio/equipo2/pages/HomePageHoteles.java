package desafio.equipo2.pages;

import desafio.equipo2.base.SeleniumBase;
import org.junit.Assert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class HomePageHoteles extends SeleniumBase {
    private String URL = "https://www.viajesfalabella.cl/hoteles/";
    public HomePageHoteles(WebDriver driver) {
        super(driver);}
    //atributos de la pagina -> Localizadores

    By TBX_Destino = By.xpath("//input[@class=\"input-tag sbox-main-focus sbox-destination sbox-primary undefined\"]");
    By TBX_FechaInicio= By.xpath("//input[@class=\"input-tag sbox-checkin-date\"]");
    By TBX_FechaSalida= By.xpath("//input[@class=\"input-tag sbox-checkout-date\"]");
    By btn_numFechaInit= By.xpath("//span[@class=\"_dpmg2--date-number\" and text()=\"20\"]");
    By btn_numFechaEnd= By.xpath("//span[@class=\"_dpmg2--date-number\" and text()=\"30\"]");
    By BTN_Buscar= By.xpath("//a[@class=\"sbox-3-btn -primary -md sbox-search\"]");
    By CheckBox = By.cssSelector(".checkbox-check");
    By BTN_Predictivo = By.xpath("//span[@class=\"item-text\"]");
    By BTN_Estrellas = By.xpath("//span[text()='Estrellas']");
    By Btn_AplicarFechas= By.xpath("//em[@class=\"_dpmg2--desktopFooter-button-apply-text btn-text\"]");
    By CheckBox_3_Estrellas = By.xpath("//em[@class=\"filter-name\" and text()=\"3\"]");
    By BTN_Aplicar_estrellas = By.xpath("//a[@class=\"eva-3-btn -md -primary\"]");
    By Item_PrimerElementoBusqueda = By.xpath("//div[@class=\"cluster-content\"][1]");
    By STR_HotelRoyalty = By.xpath("//span[text()='Royalty Barra Hotel']");
    By btn_SeleccionarReserva= By.xpath("//em[text()='Reservar ahora']");
    By BtnPaquete = By.xpath("//*[contains(@class, 'activity-highlight-slide')]//*[contains(@class, 'highlight-card-container')]");
    By BtnConfirmarPaquete= By.xpath("//*[contains(@class, 'detail-actions')]//*[contains(@class, 'btn-text')]");
    By btn_ConfirmarReservaPaquetes= By.cssSelector(".pricebox-sticky-button .btn-text");

    //metodos de la pagina - Keyword Driven

    public void IngresarDestino_Buscar() throws InterruptedException {
        ObtenerURL(URL);
        Click(TBX_Destino);
        SendKeysArica(TBX_Destino);
        Thread.sleep(2000);
        Click(BTN_Predictivo);
        Click(CheckBox);
        Click(BTN_Buscar);
    }
    public void FiltrarEstrellas() throws InterruptedException {
        ObtenerURL(URL);
        Click(TBX_Destino);
        SendKeysArica(TBX_Destino);
        Thread.sleep(2000);
        Click(BTN_Predictivo);
        Click(CheckBox);
        Click(BTN_Buscar);
        Click(BTN_Estrellas);
        Click(CheckBox_3_Estrellas);
        Click(BTN_Aplicar_estrellas);
        Thread.sleep(2000);
        Click(Item_PrimerElementoBusqueda);
        CloseTabs();
        SwitchTabs();
        ValidacionATC2();
    }
    public void CheckoutInternacional() throws InterruptedException {
        ObtenerURL(URL);
        Click(TBX_Destino);
        SendKeysRio(TBX_Destino);
        Thread.sleep(2000);
        Click(BTN_Predictivo);
        Click(TBX_FechaInicio);
        Thread.sleep(1000);
        Click(btn_numFechaInit);
        Click(btn_numFechaEnd);
        Click(Btn_AplicarFechas);
        Click(BTN_Buscar);
        Thread.sleep(1000);
        Click(STR_HotelRoyalty);
        CloseTabs();
        SwitchTabs();
        MostrarFotos();
        MostrarMapa();
        Click(btn_SeleccionarReserva);
        Click(BtnPaquete);
        Click(BtnConfirmarPaquete);
        Click(btn_ConfirmarReservaPaquetes);
        Thread.sleep(3000);
        ValidacionATC3();
    }
}
