package api_testing.fluzon;

import org.junit.*;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;

import static io.restassured.RestAssured.*;

import static io.restassured.RestAssured.given;
import static io.restassured.http.ContentType.JSON;
import static org.hamcrest.Matchers.*;
import static io.restassured.module.jsv.JsonSchemaValidator.*;


public class weather_datos_validos
{
    //variables del encabezado
    String key;
    String host;

    //parametros
    String q;
    String days;

    @Before
    public void init(){
        baseURI = "https://weatherapi-com.p.rapidapi.com";

        //parametros
        this.q = "Miami";
        this.days = "4";

        //encabezados
        this.key = "65c3a8ec1emsh38db88917d7c333p1cd20ajsn923976797f86";
        this.host = "weatherapi-com.p.rapidapi.com";

    }

    @Test
    public void ATC_Impresion_Respuesta()
    {
        String respuesta = given().header("x-rapidapi-key",this.key).
                and().header("x-rapidapi-host",this.host).
                param("q",this.q).
                param("days", this.days).
                get("/forecast.json").asPrettyString();

        System.out.println(respuesta);
    }

    @Test
    public void ATC_Respuesta_Valida()
    {
        given().header("x-rapidapi-key",this.key).
                and().header("x-rapidapi-host",this.host).
                param("q",this.q).
                param("days", this.days).
                when().
                get("/forecast.json").
                then().assertThat().statusCode(200);

    }

    @Test
    public void ATC_Ubicacion_Original()
    {
        given().header("x-rapidapi-key",this.key).
                and().header("x-rapidapi-host",this.host).
                param("q",this.q).
                param("days", this.days).
                when().
                get("/forecast.json").
                then().
                assertThat().statusCode(200).
                body("location.name",equalTo("Miami"));

    }

    @Test
    public void ATC_Estructura()
    {
        File file = new File("src/test/java/api_testing/fluzon/weather-schema.json");
        FileInputStream fileInputStream = null;
        try {
            fileInputStream = new FileInputStream(file);
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        }

        given().header("x-rapidapi-key",this.key).
                and().header("x-rapidapi-host",this.host).
                param("q",this.q).
                param("days", this.days).
                when().
                get("/forecast.json").
                then().
                assertThat().body(matchesJsonSchema(fileInputStream));

    }

}
