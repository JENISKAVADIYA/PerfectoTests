package starbucks;


import java.util.HashMap;
import java.util.Map;
import java.util.concurrent.TimeUnit;

import org.apache.xalan.xsltc.compiler.sym;
import org.junit.Assert;
import org.openqa.selenium.By;
import org.openqa.selenium.remote.DriverCommand;
import org.openqa.selenium.remote.RemoteExecuteMethod;
import org.openqa.selenium.remote.RemoteWebDriver;

import utils.PerfectoTest;
import utils.automationActions;

public class login extends PerfectoTest{
	RemoteWebDriver _driver;

	public login(RemoteWebDriver driver) {
		super(driver);
		_driver = driver;
	}


	@Override
	public void beforeTest() throws Exception {
		switchToContext(_driver, "NATIVE_APP");
		automationActions.startApp("Starbucks",_driver);
	}


	@Override
	public void execTest() throws Exception {
		try{
			switchToContext(_driver, "NATIVE_APP");
			_driver.manage().timeouts().implicitlyWait(20, TimeUnit.SECONDS);
		//	sleep(5000);
			System.out.println(getCurrentContextHandle(_driver));
			_driver.findElement(By.xpath("//*[text()='SIGN IN']")).click();

			// Login 
			_driver.findElement(By.xpath("//textfield[contains(text(),'Username')]")).sendKeys("uzi.eilon@gmail.com");
			_driver.findElement(By.xpath("(//secure | //textfield[contains(text(),'password')])")).sendKeys("Perfecto1");
			_driver.findElement(By.xpath("//button[text()='SIGN IN']")).click();

			switchToContext(_driver, "VISUAL");
			_driver.findElement(By.linkText("PAY")) ;


		}catch(Exception e)
		{
			//test Error
			Assert.assertTrue("LogIn Error"+e.getMessage(),false);
		}

	}

	@Override
	public void endTest() throws Exception {
		// TODO Auto-generated method stub

	}

}
