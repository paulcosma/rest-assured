import com.jayway.restassured.RestAssured;
import com.jayway.restassured.http.Method;
import com.jayway.restassured.response.Header;
import com.jayway.restassured.response.Headers;
import com.jayway.restassured.response.Response;
import com.jayway.restassured.specification.RequestSpecification;
import org.junit.Assert;
import org.junit.Test;

public class TestExample1 {

    @Test
    public void getPosts(){
        RestAssured.baseURI = "https://jsonplaceholder.typicode.com";
        RequestSpecification httpRequest = RestAssured.given();
        Response response = httpRequest.get("/posts/1");
        String responseBody = response.getBody().asString();
        System.out.println("Response Body = " + responseBody);
        Headers allHeaders = response.headers();
        for(Header header : allHeaders)
        {
            System.out.println("Key: " + header.getName() + " Value: " + header.getValue());
        }
        int statusCode = response.getStatusCode();
        Assert.assertEquals(200, statusCode);
    }
}
