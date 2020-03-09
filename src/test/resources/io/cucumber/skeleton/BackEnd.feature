Feature: Test BackEnd API with JSON
@health @smoke
Scenario: Health Check purgomalum Service with JSON
	Given the purgomalum URL is available 
	And the user makes a GET call to Service End point 
	Then check the status is 200
@smoke
Scenario: Negative - Method not allowed test on Service Endpoint
	Given the purgomalum Service Endpoint is available 
	And the user makes a GET call to Service End point with no param
	Then service should return 405 status code and Method not allowed message
@smoke	
Scenario: Call /service endpoint with input text as JSON 
	Given the purgomalum URL is available 
	And the user makes a GET call to Service End point 
	Then check the body should contains the input text as json
	