package api_testing.dcabral;

import org.junit.*;
import static io.restassured.RestAssured.*;
import static io.restassured.RestAssured.given;
import static org.hamcrest.Matchers.*;

public class CovidReportDatos {
    //variables del encabezado
    String key;
    String host;

    //parametros
    String date;
    String name;

    @Before
    public void init(){
        baseURI = "https://covid-19-data.p.rapidapi.com";

        //parametros
        this.date = "2020-04-01";
        this.name = "USA";

        //encabezados
        this.key = "65c3a8ec1emsh38db88917d7c333p1cd20ajsn923976797f86";
        this.host = "covid-19-data.p.rapidapi.com";
    }

    @Test
    public void ATC_Impresion_Respuesta(){
        String respuesta = given().header("x-rapidapi-key",this.key).
                and().header("x-rapidapi-host",this.host).
                param("date",this.date).
                param("name", this.name).
                get("report/country/name").asPrettyString();

        System.out.println(respuesta);
    }

    /*
    ID: ATC-Dato exacto
    Descripcion: La propiedad 'country' retorna 'USA.
    */
    @Test
    public void atc_dato_exacto(){
        given().header("x-rapidapi-key",this.key).
                and().header("x-rapidapi-host",this.host).
                param("date",this.date).
                param("name", this.name).
                when().
                get("report/country/name").
                then().assertThat().statusCode(200).
                body("[0].country", equalTo("USA"));
    }
}
