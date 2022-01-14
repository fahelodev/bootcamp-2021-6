package api_testing.fluzon.fMercado;

import io.restassured.specification.Argument;
import org.hamcrest.collection.IsArrayContainingInOrder;
import org.junit.Before;
import org.junit.Test;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.lang.reflect.Array;
import java.util.List;

import static io.restassured.RestAssured.baseURI;
import static io.restassured.RestAssured.given;
import static io.restassured.module.jsv.JsonSchemaValidator.matchesJsonSchema;
import static org.hamcrest.Matchers.*;


public class COVID19_datos_validos
{
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
        this.name = "USA";
        this.date = "2020-04-01";

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
                get("report/country/name").asPrettyString();

        System.out.println(respuesta);
    }

    @Test
    public void ATC_Respuesta_Valida()
    {
        given().header("x-rapidapi-key",this.key).
                and().header("x-rapidapi-host",this.host).
                param("name",this.name).
                param("date", this.date).
                when().
                get("report/country/name").
                then().assertThat().statusCode(200);

    }

    @Test
    public void ATC_Dato_Nulo()
    {
        given().header("x-rapidapi-key",this.key).
                and().header("x-rapidapi-host",this.host).
                param("name",this.name).
                param("date", this.date).
                when().
                get("report/country/name").
                then().
                assertThat().statusCode(200).
                body("estadocritico[0]",equalTo(null));

    }



    @Test
    public void ATC_Ubicacion_Pais()
    {
        given().header("x-rapidapi-key",this.key).
                and().header("x-rapidapi-host",this.host).
                param("name",this.name).
                param("date", this.date).
                when().
                get("report/country/name").
                then().
                assertThat().statusCode(200).
                body("country[0]",equalTo("USA"));

    }

    @Test
    public void ATC_Test_de_datos_de_la_provincia_Alabama()
    {
        given().header("x-rapidapi-key",this.key).
                and().header("x-rapidapi-host",this.host).
                param("name",this.name).
                param("date", this.date).
                when().
                get("report/country/name").
                then().
                assertThat().statusCode(200).
                body("provinces[0].province[0]",equalTo("Alabama"),
                        "provinces[0].confirmed[0]",equalTo(1060),
                        "provinces[0].recovered[0]",equalTo(0),
                        "provinces[0].deaths[0]",equalTo(27),
                        "provinces[0].active[0]",equalTo(0));

    }



    @Test
    public void ATC_Estructura()
    {
        File file = new File("src/test/java/api_testing/fMercado/COVID19-schema.json");
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
                get("report/country/name").
                then().
                assertThat().body(matchesJsonSchema(fileInputStream));

    }

}
