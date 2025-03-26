package SeleniumChromeDevTools;

import java.util.HashMap;

import org.openqa.selenium.By;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.devtools.DevTools;

public class CDPCommandsTestDirect {

	public static void main(String[] args) throws InterruptedException {
		// TODO Auto-generated method stub
		
		ChromeDriver driver = new ChromeDriver(); 
		DevTools devTools = driver.getDevTools();
		devTools.createSession();
		
		HashMap deviceMetrices = new HashMap();
		deviceMetrices.put("width", 600);
		deviceMetrices.put("height", 1000);
		deviceMetrices.put("deviceScaleFactor", 75);
		deviceMetrices.put("mobile", true);
		
		driver.executeCdpCommand("Emulation.setDeviceMetricsOverride", deviceMetrices);
		
		driver.get("https://rahulshettyacademy.com/angularAppdemo/");
		driver.findElement(By.className("navbar-toggler")).click();
		Thread.sleep(2000);
		driver.findElement(By.linkText("Library")).click();
		
	}

}
