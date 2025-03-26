package SeleniumChromeDevTools;

import java.util.HashMap;
import java.util.Map;
import java.util.Optional;

import org.openqa.selenium.By;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.devtools.DevTools;
import org.openqa.selenium.devtools.v129.network.model.ConnectionType;
import org.openqa.selenium.devtools.v130.network.Network;

// Network 
public class NetworkSpeed {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		ChromeDriver driver = new ChromeDriver(); 
		DevTools devTools = driver.getDevTools();
		devTools.createSession();
		
		devTools.send(Network.enable(Optional.empty(), Optional.empty(), Optional.empty()));
//		devTools.send(Network.emulateNetworkConditions(false, 3000, 20000, 100000, Optional.of(ConnectionType.ETHERNET),
//				Optional.empty(),Optional.empty(), Optional.empty())); // using direct bcoz unable to recognise
		
		Map<String,Object> networkConditions = new HashMap<String,Object>();
		networkConditions.put("offline", false); // marking it as true to disconnect the internet
		networkConditions.put("latency", 3000);
		networkConditions.put("downloadThroughput", 20000);
		networkConditions.put("uploadThroughput", 100000);
		networkConditions.put("connectionType", ConnectionType.ETHERNET);
		
		driver.executeCdpCommand("Network.emulateNetworkConditions", networkConditions);
		// time == 14673
		// method to check the error the in network
		devTools.addListener(Network.loadingFailed(), loadingFailed ->{
			System.out.println(loadingFailed.getErrorText());
			System.out.println(loadingFailed.getTimestamp());
		});
		long startTime = System.currentTimeMillis();
		driver.get("https://rahulshettyacademy.com/angularAppdemo/");
		driver.findElement(By.cssSelector("button[routerlink*='/library']")).click();
		long endtTime = System.currentTimeMillis();
		System.out.println(endtTime-startTime);
		// no lag time == 611
	}

}
