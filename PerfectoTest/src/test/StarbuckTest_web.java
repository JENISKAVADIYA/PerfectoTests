package test;

import java.io.UnsupportedEncodingException;
import java.net.MalformedURLException;
import java.net.URL;
import java.net.URLEncoder;
import java.util.concurrent.TimeUnit;

import starbucks.*;

import org.junit.Before;
import org.openqa.selenium.Platform;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.openqa.selenium.remote.RemoteWebDriver;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

public class StarbuckTest_web {
	loginWeb l;
	@BeforeTest
	public void Before() {
		
		
		DesiredCapabilities capabilities = new DesiredCapabilities("MobileOS", "", Platform.ANY);
		capabilities.setCapability("platformName", "Android");
		capabilities.setCapability("description", "Uzi");
 		String host = "demo.perfectomobile.com";
 		String user;
		try {
			user = URLEncoder.encode("uzie@perfectomobile.com", "UTF-8");
	 		String password = URLEncoder.encode("Perfecto1", "UTF-8");
	 		RemoteWebDriver driver = new RemoteWebDriver(new URL("https://" + user + ':' + password + '@' + host + "/nexperience/wd/hub"), capabilities);
	 		l = new loginWeb(driver);
		} catch (UnsupportedEncodingException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (MalformedURLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	 
		try {
			l.beforeTest();
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
 		
	}
	@Test
	public void f() {
		try {
			l.execTest();
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	@AfterTest
	public void After() {
		l.closeTest();
	}
}
