package api_testing.iromero;

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
import static org.hamcrest.core.IsEqual.equalTo;


public class CovidCasosDePruebas {
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
    public void atc_Impresion_Respuesta() {
        String respuesta = given().header("x-rapidapi-key",this.key).
                and().header("x-rapidapi-host",this.host).
                param("name",this.name).
                param("date", this.date).
                get("report/country/name/").asPrettyString();

        System.out.println(respuesta);
    }

    @Test
    public void atc_ValidacionJson() {
        //validacion de json
        given().header("x-rapidapi-key", this.key).
                and().header("x-rapidapi-host", this.host).
                param("name", this.name).
                param("date", this.date).contentType(ContentType.JSON);
    }

    @Test
    public void atc_ValidacionJsonSchema() {
        File file = new File("src/test/java/api_testing/iromero/covid-schema.json");
        FileInputStream fileInputStream = null;
        try {
            fileInputStream = new FileInputStream(file);
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        }

        //validacion de json
        given().header("x-rapidapi-key", this.key).
                and().header("x-rapidapi-host", this.host).
                param("name", this.name).
                param("date", this.date).contentType(ContentType.JSON).
                when().get("/country").
                then().assertThat().body(matchesJsonSchema(new File("src/test/java/api_testing/iromero/covid-schema.json")));
    }

    @Test
    public void atc_PaisCorrecto(){
        //validacion de pais
        given().header("x-rapidapi-key", this.key).
                and().header("x-rapidapi-host", this.host).
                param("name", this.name).
                param("date", this.date).
                when().get("/report/country/name").
                then().assertThat().body("[0].country", equalTo(this.name));
    }
    @Test
    public void atc_EstrucuraArray(){
        //validacion de estructura de array
        given().header("x-rapidapi-key", this.key).
                and().header("x-rapidapi-host", this.host).
                param("name", this.name).
                param("date", this.date).
                when().get("/report/country/name").
                then().body("", hasSize(greaterThan(0)));
    }


    @Test
    public void atc_Respuesta_Valida() {
        given().header("x-rapidapi-key",this.key).
                and().header("x-rapidapi-host",this.host).
                param("name",this.name).
                param("date", this.date).
                when().
                get("report/country/name").
                then().assertThat().statusCode(200);
    }

}
