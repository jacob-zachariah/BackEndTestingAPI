package stepdefs;

import services.PurgomalumAPIService;
import services.PurgomalumAPIXMLService;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;

public class BackEndSteps {
	
	//Calling service logic and implement the logic in glue code
	PurgomalumAPIService purgomalumApiServiceObj = new PurgomalumAPIService();
	PurgomalumAPIXMLService purgomalumApiXMLServiceObj = new PurgomalumAPIXMLService();
	
	@Given("the purgomalum URL is available")
	public void the_purgomalum_URL_is_available() {		
		//Setting up URL ENDPOINT	    
	}

	@Given("the user makes a GET call to Service End point")
	public void the_user_makes_a_GET_call_to_Service_End_point() {
		// Calling GET to /Service end with JSON method
		purgomalumApiServiceObj.make_JSON_REQUEST();
	   
	}
	
	@Then("check the status is {int}")
	public void check_the_status_is(Integer int1) {
		//Checking the success status code
		purgomalumApiServiceObj.checkSuccessStatus();
	}
	
	
	@Given("the purgomalum Service Endpoint is available")
	public void the_purgomalum_Service_Endpoint_is_available() {
	   //Setting up URL ENDPOINT
	}

	@Given("the user makes a GET call to Service End point with no param")
	public void the_user_makes_a_GET_call_to_Service_End_point_with_no_param() {	 
		//Calling SERVICE endpoint with no query parameter
		purgomalumApiServiceObj.get_CALL_SERVICE_ENDPOINT();		
	}

	@Then("service should return {int} status code and Method not allowed message")
	public void service_should_return_status_code_and_Method_not_allowed_message(Integer int1) {
		purgomalumApiServiceObj.checkMethodNotAllowedErrorMessage();
	}
	
	@Then("check the body should contains the input text as json")
	public void check_the_body_should_contains_the_input_text_as_json() {
		purgomalumApiServiceObj.checkJSONBodyContainsValue();
	}
	
	@Given("the user makes a GET call to Service End point with XML body type")
	public void the_user_makes_a_GET_call_to_Service_End_point_with_XML_body_type() {
	    // Make a call to /service endpoint with XML type
		purgomalumApiXMLServiceObj.make_XML_REQUEST();
	}

	@Then("check the content type equals xml")
	public void check_the_content_type_equals_xml() {
		 /*
		  *  Make a call to /service endpoint with XML type
		  *  and check the content type equals `application/xml`
		  */
		purgomalumApiXMLServiceObj.checkContentTypeEqualsXML();
	}


}
