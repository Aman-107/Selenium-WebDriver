package SeleniumChromeDevTools;

import java.util.Arrays;
import java.util.List;
import java.util.Optional;

import org.openqa.selenium.By;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.devtools.DevTools;
import org.openqa.selenium.devtools.v131.fetch.Fetch;
import org.openqa.selenium.devtools.v131.fetch.model.RequestPattern;
import org.openqa.selenium.devtools.v131.network.model.ErrorReason;

// Network + Fetch for enable to listen
public class NetworkFailing {

	public static void main(String[] args) throws InterruptedException {
		// TODO Auto-generated method stub
		
		ChromeDriver driver = new ChromeDriver(); 
		DevTools devTools = driver.getDevTools();
		devTools.createSession();
		
		// Designing pattern which URL has to pick -> so will pick only URL which contain 'GetBoook'
		//java.util.Optional<java.util.List<org.openqa.selenium.devtools.v131.fetch.model.RequestPattern>> patterns
		Optional<List<RequestPattern>> patterns = Optional.of(Arrays.asList(new RequestPattern(Optional.of("*GetBook*"), Optional.empty(), Optional.empty())));
		devTools.send(Fetch.enable(patterns, Optional.empty()));
		
		devTools.addListener(Fetch.requestPaused(), request -> {
			devTools.send(Fetch.failRequest(request.getRequestId(), ErrorReason.FAILED));
		});
		
		driver.get("https://rahulshettyacademy.com/angularAppdemo/");
		driver.findElement(By.cssSelector("button[routerlink*='/library']")).click();
		Thread.sleep(3000);
	}

}
