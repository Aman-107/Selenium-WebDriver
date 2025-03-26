package SeleniumChromeDevTools;
import java.util.Optional;

import org.openqa.selenium.By;
// Network
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.devtools.DevTools;
import org.openqa.selenium.devtools.v130.network.Network;

import com.google.common.collect.ImmutableList;

public class BLockingNetworkRequest {

	public static void main(String[] args) throws InterruptedException {
		// TODO Auto-generated method stub

		ChromeDriver driver = new ChromeDriver(); 
		DevTools devTools = driver.getDevTools();
		devTools.createSession();
			
		devTools.send(Network.enable(Optional.empty(), Optional.empty(), Optional.empty()));
		devTools.send(Network.setBlockedURLs(ImmutableList.of("*.jpg","*.css")));
		// time took == 769
		long startTime = System.currentTimeMillis();
		driver.get("https://rahulshettyacademy.com/angularAppdemo/");
		driver.findElement(By.linkText("Browse Products")).click();
		driver.findElement(By.linkText("Selenium")).click();
		// Time took == 721 ms
		//Thread.sleep(2000);
		driver.findElement(By.cssSelector(".add-to-cart")).click();
		System.out.println(driver.findElement(By.cssSelector("p")).getText());
		long endTime = System.currentTimeMillis();
		System.out.println(endTime - startTime);
		
	}

}
