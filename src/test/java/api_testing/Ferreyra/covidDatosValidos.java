package api_testing.Ferreyra;
import org.junit.*;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import static io.restassured.module.jsv.JsonSchemaValidator.*;
import static io.restassured.RestAssured.*;
import static io.restassured.RestAssured.given;
import static org.hamcrest.Matchers.equalTo;



public class covidDatosValidos {

        //variables del encabezado
        String key;
        String host;

        //parametros
        String name;
        String date;


        @Before
        public void init(){
            baseURI = "https://covid-19-data.p.rapidapi.com";

            //parametros
            this.date = "2020-04-01";
            this.name= "USA";




            //encabezados
            this.key = "65c3a8ec1emsh38db88917d7c333p1cd20ajsn923976797f86";
            this.host = "covid-19-data.p.rapidapi.com";

        }

        @Test
        public void ATC_Impresion_Respuesta()
        {
            String respuesta = given().header("x-rapidapi-key",this.key).
                    and().header("x-rapidapi-host",this.host).
                    param("date", this.date).
                    param("name",this.name).
                    get("/report/country/name").asPrettyString();

            System.out.println(respuesta);
        }


    @Test
    public void ATC_Ubicacion_Original()
    {
        given().header("x-rapidapi-key",this.key).
                and().header("x-rapidapi-host",this.host).
                param("date",this.date).
                param("name", this.name).
                when().
                get("/report/country/name").
                then().
                assertThat().statusCode(200).
                body("[0].country",equalTo("USA"));

    }





    @Test
    public void ATC_Estructura()
    {
        File file = new File("src/test/java/api_testing/Ferreyra/covid-schema.json");
        FileInputStream fileInputStream = null;
        try {
            fileInputStream = new FileInputStream(file);
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        }

        given().header("x-rapidapi-key",this.key).
                and().header("x-rapidapi-host",this.host).
                param("date",this.date).
                param("name", this.name).
                when().
                get("/report/country/name").
                then().
                assertThat().body(matchesJsonSchema(fileInputStream));

    }







    }


