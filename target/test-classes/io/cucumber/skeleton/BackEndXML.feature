Feature: Test BackEnd API with XML
@health @smoke
Scenario: Health Check purgomalum Service
	Given the purgomalum URL is available 
	And the user makes a GET call to Service End point 
	Then check the status is 200
@health @smoke
Scenario: Negative - Method not allowed test on Service Endpoint
	Given the purgomalum Service Endpoint is available 
	And the user makes a GET call to Service End point with no param
	Then service should return 405 status code and Method not allowed message
@health @smoke
Scenario: Check content type equals XML
	Given the purgomalum URL is available 
	And the user makes a GET call to Service End point with XML body type
	Then check the content type equals xml