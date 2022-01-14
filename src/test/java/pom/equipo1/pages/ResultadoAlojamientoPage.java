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

    By orderAccommodationAndHotel = By.xpath("(//select[@class=\"select-tag\"])[2]");
    By filterBreakfast = By.xpath("//aloha-checkbox-filter/ul/li//span[contains(text(),\"Desayuno\")]");
    By starFilter2 = By.xpath("//aloha-checkbox-filter//em/i");
    By hotelSpecification = By.xpath("//div[@class=\"pricebox-top-container\"]//p[contains(text(),\"3 personas\")]");
    By toMap = By.xpath("//div[contains(@class,\"right-buttons\")]//label");
    By nearbyLocation = By.xpath("//div[@class=\"input-container\"]/input[contains(@placeholder,\"lugares\")]");
    By nameLocation = By.xpath("(//div[contains(@class,\"tooltip-container\")]//ul/li)[1]");
    By hotels = By.xpath("//div[@class=\"hotel-marker\"]//span[contains(@class,\"marker-text\")]");
    By hotelSpecWithMap = By.xpath("//div[@class=\"reduced-cluster-wrapper\"]//p[contains(@class,\"first\")]");
    By location = By.xpath("(//div[@class=\"marker-container\"]//span[contains(@class,\"text\")])[1]");

    public void getNumberOfStars() throws InterruptedException {
        clickear(starFilter);
        clickear(selectFiveStars);
        clickear(applyFilter);
        Thread.sleep(2000);
        List<WebElement> stars = encontrarElementosWeb(numbersOfStars);
        Assert.assertEquals(5, stars.size());
    }

    public void getSpecf() throws InterruptedException {
        Thread.sleep(1000);
        filterOrderOfAccommodation();

        clickear(filterBreakfast);
        clickear(starFilter2);
        String specf = devolverTexto(hotelSpecification);
        Assert.assertEquals("30 noches, 3 personas", specf);

    }

    public void map() throws InterruptedException {
        clickear(filterBreakfast);
        Thread.sleep(2000);
        clickear(toMap);
        doSendKeys(nearbyLocation, "Copacabana");
        Thread.sleep(500);
        clickear(nameLocation);

        Thread.sleep(3000);
        nearbyHotels(hotels);
    }

    public void getSpecfWithMap() {
        String specf = devolverTexto(hotelSpecWithMap);
        Assert.assertEquals("30 noches, 7 personas", specf);
        String located = devolverTexto(location);
        Assert.assertEquals("Copacabana", located);
    }

    //Metodos privados
    private void filterOrderOfAccommodation() {
        Select order = new Select(encontrarElementoWeb(orderAccommodationAndHotel));
        order.selectByIndex(1);
    }

    private void nearbyHotels(By hotel) {
        List<WebElement> hotels = encontrarElementosWeb(hotel);
        int count = 0;

        for (int i = 1; i <= hotels.size(); i++) {
            By priceWithI = By.xpath("(//div[@class=\"hotel-marker\"]//span[contains(@class,\"marker-text\")])[" + i + "]");
            By priceWithIOneMore = By.xpath("(//div[@class=\"hotel-marker\"]//span[contains(@class,\"marker-text\")])[" + (i + 1) + "]");
            By priceWithCount = By.xpath("(//div[@class=\"hotel-marker\"]//span[contains(@class,\"marker-text\")])[" + count + "]");
            //si i+1 se sale del rango de cantidad hoteles hace un break
            if (i + 1 > hotels.size()) {
                break;
            }
            //obtencion de texto del precio en i
            String price = devolverTexto(priceWithI);
            //obtencion de texto del precio en i+1
            String priceAfter = devolverTexto(priceWithIOneMore);
            //transformacion en array
            String[] arr = price.split(" ");
            String[] arr2 = priceAfter.split(" ");
            //guardar el primer elemento
            String elemtOne = arr[1];
            String elemtTwo = arr2[1];
            //trasformar a entero usando un replace para quitar .
            int priceInt = Integer.parseInt(elemtOne.replace(".", ""));
            int priceAfterInt = Integer.parseInt(elemtTwo.replace(".", ""));
            //si count tiene un valor hace el mismo proceso de obtencion de texto
            if (count != 0) {
                price = devolverTexto(priceWithCount);
                arr = price.split(" ");
                elemtOne = arr[1];
                priceInt = Integer.parseInt(elemtOne.replace(".", ""));
            }
            //si el precio en i es mayo al de i+1
            if (priceInt > priceAfterInt) {
                //si contador es igual a 0 guardara se asignara i a count
                if (count == 0) {
                    count = i;
                }
            } else {//si el after price es mayor guardara i+1 en el count
                count = i + 1;
            }
        }
        By priceWithCount = By.xpath("(//div[@class=\"hotel-marker\"]//span[contains(@class,\"marker-text\")])[" + count + "]");

        clickear(priceWithCount);
    }

}
