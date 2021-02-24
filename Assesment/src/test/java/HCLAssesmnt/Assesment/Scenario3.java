package HCLAssesmnt.Assesment;

import java.io.IOException;

import org.testng.annotations.Test;

import api_scenario.APITest;

public class Scenario3 extends APITest {

	@Test(priority = 0)
	public void testServiceWithoutApiKey() throws IOException {
		testServiceWithoutApiKey();
		testregisterFirstStations();
		getAddedStations();

	}

}
