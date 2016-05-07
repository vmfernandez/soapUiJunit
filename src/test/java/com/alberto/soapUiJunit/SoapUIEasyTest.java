package com.alberto.soapUiJunit;

import static org.junit.Assert.*;

import java.io.IOException;

import org.apache.xmlbeans.XmlException;
import org.junit.Test;

import com.eviware.soapui.impl.wsdl.WsdlProject;
import com.eviware.soapui.model.support.PropertiesMap;
import com.eviware.soapui.model.testsuite.TestCase;
import com.eviware.soapui.model.testsuite.TestRunner;
import com.eviware.soapui.model.testsuite.TestRunner.Status;
import com.eviware.soapui.model.testsuite.TestSuite;
import com.eviware.soapui.support.SoapUIException;
import com.eviware.soapui.tools.SoapUITestCaseRunner;

public class SoapUIEasyTest {

	private static final String TEST_FILE = "src/test/resources/REST-Project-1-soapui-project.xml";

	@Test
	public void shouldExecuteSpecificTestCase() throws XmlException, IOException, SoapUIException {
		// given
		WsdlProject project = new WsdlProject(TEST_FILE);
		TestSuite testSuite = project.getTestSuiteByName("TestSuite");
		TestCase testCase = testSuite.getTestCaseByName("TestCase");

		for (int i = 0; i < 10; i++) {

			PropertiesMap propertiesMap = new PropertiesMap();
			//Sets parameter defined in Soap UI teste case
			testCase.setPropertyValue("name", "aName_" + i);

			TestRunner runner = testCase.run(propertiesMap, false);
			assertEquals(Status.FINISHED, runner.getStatus());
		}
	}
	
	@Test
	public void shouldExecuteAllTestCases() throws Exception{
			SoapUITestCaseRunner soapUITestCaseRunner = new SoapUITestCaseRunner();
		    soapUITestCaseRunner.setProjectFile(TEST_FILE);
		    soapUITestCaseRunner.run();
		    //No asserts in this mode
	}
}
