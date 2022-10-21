package automatedTestCase;

import static io.restassured.RestAssured.*;
import static org.hamcrest.Matchers.*;

import io.restassured.http.ContentType;
import org.testng.annotations.Test;

public class TestResponseData {

    @Test
    public void verifyCriteria() {
        when().
                get("https://api.tmsandbox.co.nz/v1/Categories/6327/Details.json?catalogue=false").
                then().
                contentType(ContentType.JSON).
                statusCode(200).
                assertThat().
                body(
                        "Name", equalTo("Carbon credits"),
                        "CanRelist", is(true),
                        "Promotions.findAll{ it.Name == 'Gallery' && it.Description == 'Good position in category'}", not(empty())
                );
    }
}
