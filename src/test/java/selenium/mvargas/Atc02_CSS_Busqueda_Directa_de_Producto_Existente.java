package selenium.mvargas;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

public class Atc02_CSS_Busqueda_Directa_de_Producto_Existente {

    public static void main(String[] args) throws InterruptedException
    {
        WebDriver driver;
        //Inicialización del WebDriver con Chrome
        WebDriverManager.chromedriver().setup();
        driver = new ChromeDriver();
        //Cargar la páginas
        driver.get("http://automationpractice.com/");
        //Introducir 'printed chiffon dress' en campo busqueda
        driver.findElement(By.cssSelector("#search_query_top")).sendKeys("printed chiffon dress");
        //Hacer click en campo SEARCH
        driver.findElement(By.cssSelector("#searchbox > button")).click();

       // WebElement firstName = driver.findElement(By.cssSelector("input[name='first_name']")

        WebElement producto = driver.findElement(By.cssSelector("a.product-name]"));
        String primerProducto = producto.getText();
        System.out.println("Titulo: " + producto);
        String parametro = "Printed Chiffon Dress";

        System.out.println("Titul2: " + parametro);

        if(primerProducto == parametro) {
            System.out.println("Prueba Exitosa");
        }else {
            System.out.println("Prueba no Exitosa");
        }

        Thread.sleep(10000);
        driver.close();
    }
}