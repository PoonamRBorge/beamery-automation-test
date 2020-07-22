# beamery-automation-test
**Information:**

The test is written in Java using Selenium with TestNG and Cucumber framework with page object model. 
The feature file contains:
1. A Scenario Outline which will test 2 test cases as follows:  
    - The successful registration process
    - Failed registration by not passing one of the mandatory field value (First name)
    (**Note**: This test case can be written to test all the mandatory fields) 
2. A Scenario which will test a case where the email address is already registered.

**Jars required:**
cucumber-core
cucumber-java
cucumber-junit
cucumber-jvm-deps
cucumber-reporting
gherkin
testng
selenium-java
selenium-server-standalone

**Running the tests:**  
Please execute the runner TestRunner.java



