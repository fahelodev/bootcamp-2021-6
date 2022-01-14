package api_testing.fluzon;

import org.junit.Before;
import org.junit.Test;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;

import static io.restassured.RestAssured.baseURI;
import static io.restassured.RestAssured.given;
import static io.restassured.http.ContentType.JSON;
import static io.restassured.module.jsv.JsonSchemaValidator.matchesJsonSchema;
import static org.hamcrest.Matchers.equalTo;
import static org.hamcrest.Matchers.hasKey;

public class  covid_con_provincias {

    //variables del encabezado
    String key;
    String host;

    //parametros
    String country_name;
    String fecha;

    @Before
    public void init(){
        baseURI = "https://covid-19-data.p.rapidapi.com/report/country/name";

        //parametros
        this.country_name = "USA";
        this.fecha = "2020-04-01";

        //encabezados
        this.key = "65c3a8ec1emsh38db88917d7c333p1cd20ajsn923976797f86";
        this.host = "covid-19-data.p.rapidapi.com";

    }

    @Test
    public void ATC_Nombre_Pais_Exacto()
    {
        //Testeamos Get a traves de la estructura tipoo BDD
        given().header("x-rapidapi-key",this.key).
                and().header("x-rapidapi-host",this.host).
                param("name",this.country_name).
                param("date", this.fecha).
        when().
                get("/").
        then().
                body("[0].country",equalTo("USA"));

    }

    @Test
    public void ATC_Respuesta_JSON()
    {
        //Testeamos Get a traves de la estructura tipoo BDD
        given().header("x-rapidapi-key",this.key).
                and().header("x-rapidapi-host",this.host).
                param("name",this.country_name).
                param("date", this.fecha).
        when().
                get("/").
        then().
                contentType(JSON);

    }

    @Test
    public void ATC_Atributos_Localizacion()
    {
        //Testeamos Get a traves de la estructura tipoo BDD
        given().header("x-rapidapi-key",this.key).
                and().header("x-rapidapi-host",this.host).
                param("name",this.country_name).
                param("date", this.fecha).
        when().
                get("/").
        then().
                body("[0]", hasKey("latitude")).
                body("[0]", hasKey("longitude")).
                body("[0]", hasKey("date"));

    }

    @Test
    public void ATC_Estructura()
    {
        File file = new File("src/test/java/api_testing/fluzon/covid-schema.json");
        FileInputStream fileInputStream = null;
        try {
            fileInputStream = new FileInputStream(file);
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        }

        //Testeamos Get a traves de la estructura tipoo BDD
        given().header("x-rapidapi-key",this.key).
                and().header("x-rapidapi-host",this.host).
                param("name",this.country_name).
                param("date", this.fecha).
        when().
                get("/").
        then().
                assertThat().body(matchesJsonSchema(fileInputStream));

    }
}
