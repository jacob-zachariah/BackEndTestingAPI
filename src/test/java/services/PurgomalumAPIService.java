package services;

import static io.restassured.RestAssured.given;

import org.junit.Assert;

import io.restassured.response.Response;
import io.restassured.response.ResponseBody;
import io.restassured.specification.RequestSpecification;

public class PurgomalumAPIService {
	
	// Variables
	private Response response;
    private RequestSpecification request;
    private int statusCode,statusError;
    private int HTTP_STATUS = 200;
    private int HTTP_SERVER_ERROR = 405;

    private String PURGOMALUM_SERVICE_END_POINT = "https://www.purgomalum.com/service";
    
    //Check the statuscode
    public void get_CALL_SERVICE_ENDPOINT() {
  	  /*
  	   * Checking /service endpoint returns
  	   */
    	statusError = given()
  				   .when()
  	     		   .get(PURGOMALUM_SERVICE_END_POINT)
  	     		   .then()
  	     		   .extract()
  	     		   .statusCode();
  	 }
    
    public void make_JSON_REQUEST() {
    	
    	/*
    	 * calling /service endpoint with JSON request
    	 */
    	PURGOMALUM_SERVICE_END_POINT = PURGOMALUM_SERVICE_END_POINT+"/json?text=this is some test input";
    	
    	response = given()
				   .when()
	     		   .get(PURGOMALUM_SERVICE_END_POINT);	
    }
    
    public void checkMethodNotAllowedErrorMessage() {
    	//Negative assertion - Calling service Endpoint with no method
    	Assert.assertEquals(statusError, HTTP_SERVER_ERROR);
    }
    
    public void checkSuccessStatus() {
    	
    	//Checking sucesss status code 
    	statusCode = response.getStatusCode();
    	Assert.assertEquals(statusCode, HTTP_STATUS);
    }
    
    public void checkJSONBodyContainsValue() {
    	
    	// Retrieve the body of the Response
    	ResponseBody body = response.getBody();

    	// To check for sub string presence get the Response body as a String.
    	// Do a String.contains
    	String bodyAsString = body.asString();
    	Assert.assertEquals(bodyAsString.contains("this is some test input") /*Expected value*/, true /*Actual Value*/);
    }

}
