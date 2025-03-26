package SeleniumChromeDevTools;

import java.util.HashMap;
import java.util.Map;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.devtools.DevTools;
// Emulation
public class SetGeoLocation {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

		// Moscow -> 55 ,36
		// New delhi -> 28 , 77
		
		ChromeDriver driver = new ChromeDriver(); 
		DevTools devTools = driver.getDevTools();
		devTools.createSession();
		
		Map<String,Object> coordinates = new HashMap<String,Object>();
		coordinates.put("latitude", 40);
		coordinates.put("longitude", 116);
		coordinates.put("accuracy", 1);
		
		driver.executeCdpCommand("Emulation.setGeolocationOverride", coordinates);
		
		driver.get("https://www.google.com/");
		driver.findElement(By.name("q")).sendKeys("Netflix",Keys.ENTER);
		driver.findElement(By.xpath("//h3[contains(text(),'Netflix - Watch TV Shows Online, Watch Movies Onli')]")).click();
		
		String title = driver.findElement(By.cssSelector(".default-ltr-cache-jmnaey")).getText();
		System.out.println("Moscow Netflix title : " + title );
	//	driver.close();
		
//		ChromeDriver driver1 = new ChromeDriver(); 
//		DevTools devTools1 = driver.getDevTools();
//		devTools1.createSession();
//		
//		Map<String,Object> coordinates1 = new HashMap<String,Object>();
//		coordinates1.put("latitude", 28);
//		coordinates1.put("longitude", 77);
//		coordinates1.put("accuracy", 1);
//		
//		driver1.executeCdpCommand("Emulation.setGeolocationOverride", coordinates1);
//		
//		driver1.get("https://www.google.com/");
//		driver1.findElement(By.name("q")).sendKeys("Netflix",Keys.ENTER);
//		driver1.findElements(By.cssSelector(".LC20lb.MBeuO.DKV0Md")).get(0).click();
//		
//		String title1 = driver.findElement(By.cssSelector("default-ltr-cache-jmnaey")).getText();
//		System.out.println("New Delhi Netflix title : " + title1 );
		
		
		
	}

}
