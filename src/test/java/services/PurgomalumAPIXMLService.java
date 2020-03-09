package services;

import static io.restassured.RestAssured.given;
import io.restassured.response.Response;
import io.restassured.specification.RequestSpecification;

import org.junit.Assert;

public class PurgomalumAPIXMLService {
	
	// Variables
		private Response response;
	    private RequestSpecification request;
	    
	    private String PURGOMALUM_SERVICE_END_POINT = "https://www.purgomalum.com/service/xml?text=GetChip Sample Text";
	    
	    public void make_XML_REQUEST() {
	    	
	    	/*
	    	 * calling /service endpoint with JSON request
	    	 */
	    	response = given()
					   .when()
		     		   .get(PURGOMALUM_SERVICE_END_POINT);	
	    }
	    
	    public void checkContentTypeEqualsXML() {
	    	
	    	//Assert the content type is `application/XML`
	    	String contentType = response.header("Content-Type");
	    	Assert.assertEquals(contentType /* actual value */, "application/xml" /* expected value */);
	    }

}
