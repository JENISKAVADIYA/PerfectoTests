package utils;
 
import org.openqa.selenium.remote.RemoteWebDriver;
 
/*
 *
 *   Class Name  : PerfectoMobileBasicTest
 *	Author      : Uzi Eilon <uzie@perfectomobile.com>
 *	
 *	Description :
	Basic abstract perfecto mobile test - Each test need to extend this class and implement the actual test in the PerfectoMobileBasicTest
 *	This basic test handles the driver and the device
 */

public abstract class PerfectoTest implements Runnable{


	String _DeviceId = null;
	RemoteWebDriver _driver;
	boolean _status = true; 


	public PerfectoTest (RemoteWebDriver driver)
	{
		_driver = driver;
	} 



	public Boolean getStatus() {
		return _status  ;
	}

	public void setDeviceID(String Device) {
		_DeviceId= Device;

	}

	public  void sleep(long millis) {
		try {
			Thread.sleep(millis);
		} catch (InterruptedException e) {
		}
	}

	public  void closeTest( ) {
		_driver.quit();

	}

	public abstract void beforeTest() throws Exception ;
	public abstract void execTest() throws Exception ;
	public abstract void endTest() throws Exception ;

}

