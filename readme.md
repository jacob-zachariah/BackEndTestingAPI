# Backend Services Tests

The Backend services test suites are based on Java with Maven, JUnit, RestAssured and cucumber (BDD)

## Setting up the test suites

You will need the following installed on your machine to get started:

- Java 1.8 (latest) SDK
- Git (<https://git-scm.com/>)
- Eclipse for Java (latest version ie <https://www.eclipse.org/downloads/download.php?file=/oomph/epp/2019-03/R/eclipse-inst-win64.exe>)
- JUnit Framework
- Eclipse cucumber plugin - http://cucumber.github.com/cucumber-eclipse/update-site
- Maven for dependency management -All the dependencies are added in the pom.xml in the root folder.

## Project Structure?
- src/test/java/service folder - All the service level logic and assertion mechanism
- src/test/java/stepdefs folder- Holds glue code for the feature file
- src/test/resources/io/cucumber/skeleton/ - Contains all the feature files /user stories l

## How to run tests?

- mvn clean testt
- You can run the tests by either executing mvn test or running the specified feature file.
- Currently, tests are classified into two tags 
	1. @health - this is to make sure all the services are up and running 
	2. @smoke - for functionality-wise tests

Once the test has completed you can refresh the test reports folder and open the latest 
report in an external browser window.

**Note: Future Enhancement**
1. plug this test script to the Jenkins pipeline to run e2e test along with deploymentt
2. Add third-party test reporting tools like extendreportt
3. Tag-based execution - We can run test suite based on various tags such as @hotfixes @bugs @flakes @payments or other critical services
