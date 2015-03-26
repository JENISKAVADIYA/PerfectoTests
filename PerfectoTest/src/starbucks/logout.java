package starbucks;


import org.junit.Assert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.remote.RemoteWebDriver;

import utils.PerfectoTest;
import utils.automationActions;

public class logout extends PerfectoTest{
	RemoteWebDriver _driver;

	public logout(RemoteWebDriver driver) {
		super(driver);
		_driver = driver;
	}


	@Override
	public void beforeTest() throws Exception {
		//validate the app is open 
		switchToContext(_driver, "VISUAL");
		_driver.findElement(By.linkText("PAY")) ;
	}


	@Override
	public void execTest() throws Exception {
		try{
			switchToContext(_driver, "NATIVE_APP");
			try {
				WebElement menu;
				try
				{
					menu = _driver.findElement(By.xpath("//*[@resourceid='android:id/up']"));

				}catch(Exception e1)
				{
					menu = _driver.findElement(By.xpath("(//*[@class='android.widget.ImageView'])[2]"));
				}

				menu.click();
				_driver.findElement(By.xpath("//text[text()='SETTINGS']")).click();
				try {
					Thread.sleep(2000);
				} catch (InterruptedException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
				automationActions.swipe("50%,80%", "50%,25%",_driver);
 
				_driver.findElement(By.xpath("//text[text()='Sign Out']")).click();
				_driver.findElement(By.xpath("//button[text()='SIGN OUT']")).click();




			}catch(Exception e)
			{
				//test Error
				Assert.assertTrue("LogIn Error"+e.getMessage(),false);
			}
		}catch(Exception e)
		{
			 
			Assert.assertTrue("LogIn Error"+e.getMessage(),false);
		}
	}

	@Override
	public void endTest() throws Exception {
		// TODO Auto-generated method stub

	}

}
