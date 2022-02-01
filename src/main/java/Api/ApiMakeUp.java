package Api;

import io.restassured.response.Response;
import org.junit.Assert;

import java.net.MalformedURLException;
import java.net.URL;
import java.util.List;
import java.util.stream.Collectors;

import static io.restassured.RestAssured.filters;
import static io.restassured.RestAssured.given;

public class ApiMakeUp {



    public int apiMakeUpBuscaPorMarcas(String marca) {
        URL url = null;
        try {
            url = new URL("http://makeup-api.herokuapp.com/api/");
        } catch (MalformedURLException e) {
            e.printStackTrace();
        }
        Response res = given().relaxedHTTPSValidation().get(url + "v1/products.json?brand=" + marca);
        res.prettyPrint();
        List<Object> brand = res.getBody().jsonPath().getJsonObject("brand");
        for(Object marcas: brand){
           String result  = marcas.toString();
           Assert.assertEquals(result,marca);
        }
        return res.statusCode();
    }
}
