package automationcraft.testcreation.mguzman.pages;

import automationcraft.engine.selenium.SeleniumBase;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class CarritoDeCompraParisPages extends SeleniumBase {

    By AñadirCarrito = By.xpath("//button[@id=\"486146999-add-to-cart\"]");
    By BtnContinuar = By.xpath("//button[@class=\"warranty-modal__button\"]");
    By IrAlCarro = By.xpath("//a[@id=\"mini-cart-link-cart\"]");
    By SumarProducto = By.xpath("//input[@id=\"GTM_cart_quantity-mas\"]");
    By ProductosEnCarro = By.xpath("//div[@class=\"info-carro clearfix\"]//h3//span[contains(text(),'(3 productos)')]");

    public CarritoDeCompraParisPages(WebDriver driver) {
        super(driver);
    }

    public void AñadirCarro(){click(AñadirCarrito);
        click(BtnContinuar);
    }
    public void IrCarro(){click(IrAlCarro);}
    public void AgregarProducto(){click(SumarProducto);}
    public void ProductosEnElCarro(){validacionText(ProductosEnCarro,"(20 productos)");}



}
