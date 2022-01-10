package pom.equipo1.pages;

import org.junit.Assert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.Select;
import pom.equipo1.base.SeleniumBase;

import java.util.List;

public class ResultadoAlojamientoPage extends SeleniumBase {

    public ResultadoAlojamientoPage(WebDriver driver) {
        super(driver);
    }

    By numbersOfStars = By.xpath("(//div[contains(@class,\"card-rating\")])[1]//i");
    By starFilter = By.xpath("//div[@class=\"filter-tags-wrapper\"]//span[contains(text(),\"Estrellas\")]");
    By selectFiveStars = By.xpath("//span[contains(@class,\"-show-tooltip\")]//em[contains(text(),\"5\")and contains(@class,\"filter-name\")]");
    By applyFilter = By.xpath("//span[contains(@class,\"-show-tooltip\")]//em[contains(text(),\"Aplicar\")]");

    By orderAccommodationAndHotel = By.xpath("//aloha-select[contains(@class,\"sorting\")]//select");
    By filterBreakfast = By.xpath("//aloha-checkbox-filter/ul/li//span[contains(text(),\"Desayuno\")]");
    By starFilter2 = By.xpath("//aloha-checkbox-filter//em/i");
    By hotelSpecification = By.xpath("//div[@class=\"pricebox-top-container\"]//p[contains(text(),\"3 personas\")]");

    public void getNumberOfStars() throws InterruptedException {
        clickear(starFilter);
        clickear(selectFiveStars);
        clickear(applyFilter);
        Thread.sleep(2000);
        List<WebElement> stars = encontrarElementosWeb(numbersOfStars);
        Assert.assertEquals(5, stars.size());
    }

    public void getSpecf() {
        filterOrderOfAccommodation(2);
        clickear(filterBreakfast);
        clickear(starFilter2);
        String specf = devolverTexto(hotelSpecification);
        Assert.assertEquals("30 noches, 3 personas", specf);

    }

    private void filterOrderOfAccommodation(int index) {
        Select order = new Select(encontrarElementoWeb(orderAccommodationAndHotel));
        order.selectByIndex(index);
    }
}
