package utils;

import java.util.HashMap;
import java.util.Map;

 import org.openqa.selenium.remote.RemoteWebDriver;

public class automationActions {

	public automationActions() {
		// TODO Auto-generated constructor stub
	}

	
	public static void startApp(String appName,RemoteWebDriver d )
	{
 		Map<String,String> params = new HashMap<String,String>();
		params.put("name", appName);
		d.executeScript("mobile:application:open", params);
	}
}
