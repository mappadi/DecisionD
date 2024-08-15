package org.everydayhealth.tests;

import framework.TestRepeater;
import org.testng.ITestContext;
import org.testng.ITestNGMethod;
import org.testng.annotations.BeforeTest;

/**
 * BaseTest
 */
public class BaseTest extends TestRepeater {

	@BeforeTest(alwaysRun = true)
	public void testRepeater(ITestContext context) {
		for (ITestNGMethod method : context.getAllTestMethods()) {
			method.setRetryAnalyzer(new TestRepeater());
		}
	}
}
