package api_testing.dYanez.covid;
import io.restassured.http.ContentType;
import io.restassured.path.json.JsonPath;
import io.restassured.response.Response;
import io.restassured.response.ValidatableResponse;
import io.restassured.specification.RequestSpecification;
import org.hamcrest.Matchers;
import org.junit.*;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.util.List;

import static io.restassured.RestAssured.*;

import static io.restassured.RestAssured.given;
import static io.restassured.http.ContentType.JSON;
import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.Matchers.*;
import static io.restassured.module.jsv.JsonSchemaValidator.*;

public class CovidPaisFechaValidos {

    //variables del encabezado
    String key;
    String host;

    //parametros
    String name;
    String date;

    private RequestSpecification request;


    @Before
    public void init(){
        baseURI = "https://covid-19-data.p.rapidapi.com/";

        //parametros
        this.name = "Chile";
        this.date = "2020-04-01";

        //encabezados
        this.key = "65c3a8ec1emsh38db88917d7c333p1cd20ajsn923976797f86";
        this.host = "covid-19-data.p.rapidapi.com";

    }

    @Test
    public void ATC_ContentType_Json()
    {
         request = given().header("x-rapidapi-key",this.key).
                and().header("x-rapidapi-host",this.host).
                param("name",this.name).
                param("date", this.date).
                contentType(ContentType.JSON);

    }

    @Test
    public void ATC_Validate_Size_one_country()
    {
        given().header("x-rapidapi-key",this.key).
                and().header("x-rapidapi-host",this.host).
                param("name",this.name).
                param("date", this.date).
                when().
                get("report/country/name")
                .then().assertThat()
                .body("size()",is(1));


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
    public void ATC_Respuesta_Valida()
    {
         given().header("x-rapidapi-key",this.key).
                and().header("x-rapidapi-host",this.host).
                param("name",this.name).
                param("date", this.date).
                when().
                get("report/country/name")
                .then().assertThat().statusCode(200);

    }

    @Test
    public void ATC_Ubicacion_Original()
    {
        String respuesta = given().header("x-rapidapi-key",this.key).
                and().header("x-rapidapi-host",this.host).
                param("name",this.name).
                param("date", this.date).
                get("report/country/name/").asPrettyString();

        JsonPath j = new JsonPath(respuesta);
        String zip = j.getString("country");
        Assert.assertEquals(zip,"[Chile]");

    }

    @Test
    public void ATC_Estructura()
    {
        File file = new File("src/test/java/api_testing/dYanez/covid/covid-schema.json");
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
                get("/covid-schema.json").
                then().
                assertThat().body(matchesJsonSchema(fileInputStream));

    }

}
