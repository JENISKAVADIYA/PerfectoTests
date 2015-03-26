package starbucks;

import java.io.UnsupportedEncodingException;
import java.net.MalformedURLException;
import java.net.URL;
import java.net.URLEncoder;

import org.openqa.selenium.Platform;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.openqa.selenium.remote.RemoteWebDriver;

public class debugExe {

	public debugExe() {
		// TODO Auto-generated constructor stub
	}

	public static void main(String[] args) {

		DesiredCapabilities capabilities = new DesiredCapabilities("MobileOS", "", Platform.ANY);
		capabilities.setCapability("platformName", "Android");
		capabilities.setCapability("description", "Uzi");
 		String host = "demo.perfectomobile.com";
 		String user;
 		RemoteWebDriver driver = null;
		try {
			user = URLEncoder.encode("uzie@perfectomobile.com", "UTF-8");
	 		String password = URLEncoder.encode("Perfecto1", "UTF-8");
	 		  driver = new RemoteWebDriver(new URL("https://" + user + ':' + password + '@' + host + "/nexperience/wd/hub"), capabilities);
			login l = new login(driver);
			l.beforeTest();
			l.execTest();
			
		} catch (UnsupportedEncodingException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (MalformedURLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}finally
		{
			driver.close();
		}
		
	}

}
