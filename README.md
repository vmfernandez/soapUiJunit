# soapUiJunit: Maven project to run SoapUI test inside jUnit
This is a maven project with everything configured to run Soap UI test inside a jUnit @Test, as stated in the official documentation: https://www.soapui.org/test-automation/junit/junit-integration.html

But this project adds the struture and dependencies of a Maven project that works, so you can use it in your own projects.

In src/test/resource you can find the SoapUI 5.2.1 project that makes REST get request to a local server at http://localhost:3000/rest/name that responses with the "name" paremeter passed in the URL. The Test case has a property called "nombre" that is used by the case step to make a call to the service using this parameter. In the jUnit @Test, this paremeter is configured to show how you can change the parameter and hence the call from the jUnit @Test without having to alter the original SoapUI test

Also: the soapui-5.2.1.jar file is included in the src/test/resources and defined as a local dependency in maven's pom.xml
