package api_testing.ncorrea;

import io.restassured.http.ContentType;
import org.junit.Before;
import org.junit.Test;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;

import static io.restassured.RestAssured.baseURI;
import static io.restassured.RestAssured.given;
import static io.restassured.module.jsv.JsonSchemaValidator.matchesJsonSchema;
import static org.hamcrest.Matchers.*;

public class Covid_tests {

    //variables del encabezado
    String key;
    String host;

    //parametros
    String date;
    String name;

    @Before
    public void init() throws InterruptedException {
        baseURI = "https://covid-19-data.p.rapidapi.com/";

        //parametros
        this.date = "2020-04-01";
        this.name = "USA";

        //encabezados
        this.key = "65c3a8ec1emsh38db88917d7c333p1cd20ajsn923976797f86";
        this.host = "covid-19-data.p.rapidapi.com";

        Thread.sleep(1000);
    }

    @Test
    public void atc_PaisCorrecto() {
        given().header("x-rapidapi-key", this.key).
                and().header("x-rapidapi-host", this.host).
                param("date", this.date).param("name", this.name).
                when().
                get("/report/country/name").
                then().assertThat().statusCode(200).
                body("[0].country", equalTo("USA"));
    }

    @Test
    public void atc_JSONRespuesta() {

                given().header("x-rapidapi-key", this.key).
                and().header("x-rapidapi-host", this.host).
                param("date", this.date).param("name", this.name).
                contentType(ContentType.JSON);
    }

    @Test
    public void atc_ValidacionEstructuraArray(){
            given().header("x-rapidapi-key", this.key).
                    and().header("x-rapidapi-host", this.host).
                    param("name", this.name).
                    param("date", this.date).
                    when().get("/report/country/name").
                    then().body("", hasSize(greaterThan(0)));
        }

    @Test
    public void atc_RespuestaValida() {
        given().header("x-rapidapi-key",this.key).
                and().header("x-rapidapi-host",this.host).
                param("name",this.name).
                param("date", this.date).
                when().
                get("report/country/name").
                then().assertThat().statusCode(200);
    }

    @Test
    public void atc_ImpresionRespuesta() {
        String respuesta = given().header("x-rapidapi-key",this.key).
                and().header("x-rapidapi-host",this.host).
                param("name",this.name).
                param("date", this.date).
                get("report/country/name/").asPrettyString();

        System.out.println(respuesta);
    }

    @Test
    public void atc_Estructura() {

        File file = new File("src/test/java/api_testing/ncorrea/covid-schema.json");
        FileInputStream fileInputStream = null;
        try {
            fileInputStream = new FileInputStream(file);
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        }

        given().header("x-rapidapi-key", this.key).
                and().header("x-rapidapi-host", this.host).
                param("date", this.date).
                param("name", this.name).
                when().
                get("/report/country/name").
                then().
                assertThat().body(matchesJsonSchema(fileInputStream));
    }
}
