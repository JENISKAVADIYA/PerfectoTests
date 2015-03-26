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

public class loginWeb extends PerfectoTest{
	RemoteWebDriver _driver;

	public loginWeb(RemoteWebDriver driver) {
		super(driver);
		_driver = driver;
	}


	@Override
	public void beforeTest() throws Exception {
		_driver.get("starbucks.com");
		_driver.manage().timeouts().implicitlyWait(20, TimeUnit.SECONDS);
 		_driver.manage().timeouts().pageLoadTimeout(20, TimeUnit.SECONDS);
	}


	@Override
	public void execTest() throws Exception {
		try{
 			_driver.findElement(By.id("signIn")).click();

 			// wait a meeting , it takes time to build the tree [bug? SE-1879 ]
			 sleep(120000);
		 	_driver.findElement(By.xpath("//input[contains(@placeholder,'Username')]")).sendKeys("uzi.eilon@gmail.com");
		 	_driver.findElement(By.xpath("//input[@type= 'password')]")).sendKeys("Perfecto1");
 		 	_driver.findElement(By.xpath("//button[@id='AT_SignIn_Button'])")).click();

 

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
