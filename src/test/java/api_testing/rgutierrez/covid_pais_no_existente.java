package api_testing.rgutierrez;

import io.restassured.http.ContentType;
import io.restassured.response.Response;
import org.junit.*;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;

import static io.restassured.RestAssured.*;

import static io.restassured.RestAssured.given;
import static io.restassured.http.ContentType.JSON;
import static io.restassured.module.jsv.JsonSchemaValidator.*;

public class covid_pais_no_existente {

    //variables del encabezado
    String key;
    String host;

    //parametros
    String name;
    String date;

    @Before
    public void init(){
        baseURI = "https://covid-19-data.p.rapidapi.com/";

        //parametros
        this.name = "AAA";
        this.date = "2020-06-01";

        //encabezados
        this.key = "65c3a8ec1emsh38db88917d7c333p1cd20ajsn923976797f86";
        this.host = "covid-19-data.p.rapidapi.com";

    }

    @Test
    public void ATC_Impresion_Respuesta()
    {
        String respuesta = given().header("x-rapidapi-key",this.key).
                and().header("x-rapidapi-host",this.host).
                param("name",this.name).
                param("date", this.date).
                get("report/country/name/").asPrettyString();

        System.out.println(respuesta);
    }

    @Test
    public void ATC01_Respuesta_con_codigo_de_status_200()
    {
        given().header("x-rapidapi-key",this.key).
                and().header("x-rapidapi-host",this.host).
                param("name",this.name).
                param("date", this.date).
                when().
                get("/report/country/name/").
                then().assertThat().statusCode(200);
    }

    @Test
    public void ATC02_tipos_de_datos_y_propiedades_validos()
    {
        File file = new File("src/test/java/api_testing/rgutierrez/covid-error-schema.json");
        FileInputStream fileInputStream = null;
        try {
            fileInputStream = new FileInputStream(file);
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        }

        given().header("x-rapidapi-key",this.key).
                and().header("x-rapidapi-host",this.host).
                param("name",this.name).
                param("date", this.date).
                when().
                get("report/country/name/").
                then().
                assertThat().body(matchesJsonSchema(fileInputStream));

    }

    @Test
    public void ATC03_retorna_country_not_found()
    {
        String message = given().header("x-rapidapi-key",this.key).
                and().header("x-rapidapi-host",this.host).
                param("name",this.name).
                param("date", this.date).
                when().
                get("report/country/name/").
                jsonPath().
                getString("message");

        Assert.assertEquals(message, "Country not found");

    }

    @Test
    public void ATC04_Respuesta_es_Json() {
        Response response = given().header("x-rapidapi-key", this.key).
                and().header("x-rapidapi-host", this.host).
                param("name", this.name).
                param("date", this.date).
                when().
                get("/report/country/name/");


        String contentType = response.header("Content-Type");

        Assert.assertEquals("application/json", contentType);
    }




}
