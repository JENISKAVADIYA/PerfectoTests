package starbucks;

 
import org.openqa.selenium.remote.RemoteWebDriver;

import utils.PerfectoTest;

public class login extends PerfectoTest{
	RemoteWebDriver _driver;

	public login(RemoteWebDriver driver) {
		super(driver);
 	}

 
	@Override
	public void beforeTest() throws Exception {
		switchToContext(_driver, "NATIVE_APP");
		_driver.get("Starbucks");
 	}
	

	@Override
	public void execTest() throws Exception {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void endTest() throws Exception {
		// TODO Auto-generated method stub
		
	}

}
