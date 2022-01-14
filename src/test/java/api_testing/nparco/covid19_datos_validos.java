package api_testing.nparco;

import org.junit.Before;
import org.junit.Test;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.lang.reflect.Array;
import java.util.Arrays;
import java.util.List;

import static io.restassured.RestAssured.*;
import static io.restassured.module.jsv.JsonSchemaValidator.matchesJsonSchema;
import static org.hamcrest.Matchers.equalTo;

public class covid19_datos_validos {

    //variables de encabezado
    String key;
    String host;

    //parametros
    String date;
    String name;

    @Before
    public void init(){
//        baseUri = "https://covid-19-data.p.rapidapi.com";

        //parametros
        this.date = "2020-04-01";
        this.name = "USA";

        //Headers
        this.key = "65c3a8ec1emsh38db88917d7c333p1cd20ajsn923976797f86";
        this.host = "covid-19-data.p.rapidapi.com";
    }

    @Test
    public void ATC_Impresion_Respuesta(){
        String response = given().header("x-rapidapi-key",this.key).
                and().header(" x-rapidapi-host",this.host).
                param("date",this.date).
                param("name",this.name).
                when().
                get("https://covid-19-data.p.rapidapi.com/report/country/name").asPrettyString();
        System.out.println(response);
    }

    @Test
    public void ATC_Respuesta_Valida()
    {
        given().header("x-rapidapi-key",this.key).
                and().header("x-rapidapi-host",this.host).
                param("date",this.date).
                param("name",this.name).
                when().
                get("https://covid-19-data.p.rapidapi.com/report/country/name").
                then().assertThat().statusCode(200);

    }

    @Test
    public void ATC_Pais_Valido()
    {
        String response = String.valueOf(given().header("x-rapidapi-key",this.key).
                and().header("x-rapidapi-host",this.host).
                param("date",this.date).
                param("name",this.name).
                when().
                get("https://covid-19-data.p.rapidapi.com/report/country/name").
                then().
                assertThat().statusCode(200).
                body("country[0]",equalTo("USA")));

    }

    @Test
    public void Datos_Validos()
    {
        String response = String.valueOf(given().header("x-rapidapi-key",this.key).
                and().header("x-rapidapi-host",this.host).
                param("date",this.date).
                param("name",this.name).
                when().
                get("https://covid-19-data.p.rapidapi.com/report/country/name").
                then().
                assertThat().statusCode(200).
                body("provinces[0].province[0]",equalTo("Alabama")).
                body("provinces[0].recovered[0]",equalTo(0)).
                body("provinces[0].confirmed[0]",equalTo(1060)).
                body("provinces[0].deaths[0]",equalTo(27)));
    }


    @Test
    public void ATC_Estructura()
    {
        File file = new File("src/test/java/api_testing/nparco/covid19-schema.json");
        FileInputStream fileInputStream = null;
        try {
            fileInputStream = new FileInputStream(file);
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        }

        given().header("x-rapidapi-key",this.key).
                and().header("x-rapidapi-host",this.host).
                param("date",this.date).
                param("name",this.name).
                when().
                get("https://covid-19-data.p.rapidapi.com/report/country/name").
                then().
                assertThat().body(matchesJsonSchema(fileInputStream));

    }
}
