package pom.equipo2.pages;

import org.openqa.selenium.WebDriver;
import pom.equipo2.base.SeleniumBaseTraslados;

public class HomePageTraslados extends SeleniumBaseTraslados {

    public HomePageTraslados(WebDriver driver) {
        super(driver);
    }

    //Localizadores Test Case 03

    private String btnVerMas = "//em[@class='btn-text'][contains(text(),'Ver más ofertas')]";
    private String cardAuto = "//*[contains(@class, 'section-4')]//*[contains(@class, 'offer-cards-container')]/offer-card/div/a/div/div/img";
    private String dropDownDolar = "//*[@id='currency-select']";
    private String uSDValue = "USD";
    private String uSDTexto = "//*[contains(@class, 'clusters-container')]/div/transfer-cluster/div/div/div[2]/ds-cluster-pricebox/div/div/div/div[2]/span";
    private String btnComprar = "//*[contains(@class, 'clusters-container')]/div/transfer-cluster/div/div/div[2]/ds-cluster-pricebox/div/div/div[2]/button";



    public void cambiarPesoToDolar() {
        navigateTo("https://www.viajesfalabella.cl/traslados/");
        clickElement(btnVerMas);
        clickElement(cardAuto);
        SwitchTabs();
        selectFromDropdownByValue(dropDownDolar, uSDValue);
        validationText(uSDTexto,"US$");
        clickElement(btnComprar);
        SwitchTabs();
        CloseTabs();

    }

    //Localizadores Test Case 02

    private String fieldDesde = "//input[@placeholder='Ingresa un aeropuerto']";
    private String fieldHasta = "//input[@placeholder='Ingresa un hotel o dirección adónde quieras ir']";
    private String listResultFind = "//html/body/div[8]/div/div/ul/li";
    private String btnBuscarHome = "//*[contains(@class, 'sbox-search')]";
    private String fieldFechaArribo = "//*[contains(@class, 'sbox-checkin-container')]//*[contains(@class, 'input-container')]";
    private String fieldClickNumberFechaArribo = "//div[@class='_dpmg2--wrapper _dpmg2--onlyway _dpmg2--show-info _dpmg2--show']//div[@class='_dpmg2--month _dpmg2--o-6 _dpmg2--month-active']//span[@class='_dpmg2--date _dpmg2--available _dpmg2--weekend']/span[.='23']";
    private String fieldClickDropdownHora = "//*[contains(@class, 'sbox-time-arrival')]";
    private String fieldClickPasajeros = "//*[contains(@class, 'sbox-distri-input')]//*[contains(@class, 'input-container')]";
    private String fieldClickAddAdulto = "//*[contains(@class, '_pnlpk-stepper-adults')]//*[contains(@class, 'steppers-icon-right')]";
    private String fieldClickAddMenor = "//*[contains(@class, '_pnlpk-stepper-minors')]//*[contains(@class, 'steppers-icon-right')]";
    private String fieldDropdownEdad = "//*[contains(@class, '_pnlpk-minor-age-select-last-item')]//*[contains(@class, 'select-tag')]";
    private String btnAplicarPasajeros = "//a[text()='Aplicar']";
    private String btnComprarTraslado = "//*[contains(@class, 'clusters-container')]/div/transfer-cluster/div/div/div[2]/ds-cluster-pricebox/div/div/div[2]/button";
    private String textTraslado = "//div[contains(text(), 'De Aeropuerto Arturo Merino Benitez a Hyatt Centric Las Condes Santiago')]";


    public void busquedaEspecificaTrasladoIda() throws InterruptedException {
        navigateTo("https://www.viajesfalabella.cl/traslados/");
        write(fieldDesde,"Aeropuerto Arturo Merino Benitez, Santiago de Chile, Chile");
        clickElement(listResultFind);
        write(fieldHasta,"Hyatt Centric Las Condes Santiago - Enrique Foster, Las Condes, Chile");
        clickElement(listResultFind);
        clickElement(fieldFechaArribo);
        clickElement(fieldClickNumberFechaArribo);
        selectFromDropdownByValue(fieldClickDropdownHora,"450");
        clickElement(fieldClickPasajeros);
        clickElement(fieldClickAddAdulto);
        clickElement(fieldClickAddMenor);
        selectFromDropdownByValue(fieldDropdownEdad,"0");
        clickElement(btnAplicarPasajeros);
        clickElement(btnBuscarHome);
        clickElement(btnComprarTraslado);
        validationText(textTraslado,"De Aeropuerto Arturo Merino Benitez a Hyatt Centric Las Condes Santiago");

    }

    //Localizadores Test Case 01 Busqueda Traslado ida y regreso

    private String btnHaciaAeropuerto = "//*[contains(@class, 'sbox-radio-buttons')]/span[2]/label/i";
    private String fieldDesdeHacia = "//input[@placeholder='Ingresa un hotel o dirección adónde quieras ir']";
    private String fieldDesdeResultList = "//*[contains(@class, 'ac-group-items')]/li";
    private String fieldHastaHacia = "//input[@placeholder='Ingresa un aeropuerto']";
    private String fieldFechaArriboHacia = "//*[contains(@class, 'sbox-second-moment-container')]//*[contains(@class, 'sbox-moment-input-container')]/div";
    private String fieldClickNumberFechaArriboRegreso = "//*[contains(@class, '_dpmg2--show')]//*[contains(@class, '_dpmg2--has-start-range')]/div[4]/span[24]";
    private String btnClickNumberFechaAplicar = "//*[contains(@class, '_dpmg2--show')]//*[contains(@class, '_dpmg2--desktopFooter-button-apply')]";
    private String fieldClickDropdownHoraHacia = "//*[contains(@class, 'select-tag sbox-time-departure')]";
    private String btnComprarHacia = "//*[contains(@class, 'clusters-container')]/div/transfer-cluster/div/div/div[2]/ds-cluster-pricebox/div/div/div[2]/button";
    private String textValidateMsgHacia = "//div[@class='eva-3-h3 -eva-3-tc-gray-0']";


    public void busquedaEspecificaTrasladoIdaYVuelta() throws InterruptedException {
        navigateTo("https://www.viajesfalabella.cl/traslados/");
        clickElement(btnHaciaAeropuerto);
        write(fieldDesdeHacia,"santiago marriot chile");
        clickElement(fieldDesdeResultList);
        write(fieldHastaHacia,"Aeropuerto Arturo Merino Benitez");
        clickElement(fieldDesdeResultList);
        clickElement(fieldFechaArriboHacia);
        clickElement(fieldClickNumberFechaArribo);
        clickElement(fieldClickNumberFechaArriboRegreso);
        clickElement(btnClickNumberFechaAplicar);
        selectFromDropdownByValue(fieldClickDropdownHoraHacia,"480");
        clickElement(fieldClickPasajeros);
        clickElement(fieldClickAddAdulto);
        clickElement(fieldClickAddMenor);
        selectFromDropdownByValue(fieldDropdownEdad,"17");
        clickElement(btnAplicarPasajeros);
        clickElement(btnBuscarHome);
        clickElement(btnComprarHacia);
        validationText(textValidateMsgHacia,"De Santiago Marriott Hotel a Aeropuerto Arturo Merino Benitez");

    }


}
