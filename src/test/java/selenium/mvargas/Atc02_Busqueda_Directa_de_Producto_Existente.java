package selenium.mvargas;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

public class Atc02_Busqueda_Directa_de_Producto_Existente {

    public static void main(String[] args) throws InterruptedException
    {
        WebDriver driver;
        //Inicialización del WebDriver con Chrome
        WebDriverManager.chromedriver().setup();
        driver = new ChromeDriver();
        //Cargar la páginas
        driver.get("http://automationpractice.com/");
        //Introducir 'printed chiffon dress' en campo busqueda
        driver.findElement(By.xpath("//*[@id=\'search_query_top\']")).sendKeys("printed chiffon dress");
        //Hacer click en campo SEARCH
        driver.findElement(By.xpath("//*[@id=\'searchbox\']/button")).click();
        WebElement producto = driver.findElement(By.xpath("//*[@id='center_column']/ul/li[1]/div/div[2]/h5/a"));
        String primerProducto = producto.getText();
        System.out.println("Titulo: " + primerProducto);
        String parametro = "Printed Chiffon Dress";
        System.out.println("Titulo2: " + primerProducto);

        //if(primerProducto == parametro) {

        if(primerProducto.equals(parametro)) {
            System.out.println("Prueba Exitosa");
        }else {
            System.out.println("Prueba no Exitosa");
        }

        Thread.sleep(10000);
        driver.close();
    }
}