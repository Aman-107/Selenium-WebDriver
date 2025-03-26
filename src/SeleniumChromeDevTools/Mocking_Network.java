package SeleniumChromeDevTools;
// Fetch

import java.util.Optional;

import org.openqa.selenium.By;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.devtools.DevTools;
import org.openqa.selenium.devtools.v131.fetch.Fetch;

public class Mocking_Network {

	public static void main(String[] args) throws InterruptedException {
		// TODO Auto-generated method stub
		
		ChromeDriver driver = new ChromeDriver(); 
		DevTools devTools = driver.getDevTools();
		devTools.createSession();
		
		devTools.send(Fetch.enable(Optional.empty(), Optional.empty()));
		
		devTools.addListener(Fetch.requestPaused(), request -> 
		{
			if(request.getRequest().getUrl().contains("shetty")) 
			{
			String mockedURL = request.getRequest().getUrl().replace("=shetty", "=BadGuy");
				System.out.println(mockedURL);
				devTools.send(Fetch.continueRequest(request.getRequestId(),Optional.of(mockedURL), Optional.empty(), Optional.empty(), 
						Optional.empty(), Optional.empty()));
			}
			else {
				devTools.send(Fetch.continueRequest(request.getRequestId(),Optional.empty(), Optional.empty(), Optional.empty(), 
						Optional.empty(), Optional.empty()));
			}
		});
		
		driver.get("https://rahulshettyacademy.com/angularAppdemo/");
		driver.findElement(By.cssSelector("button[routerlink*='/library']")).click();
		Thread.sleep(3000);
		System.out.println(driver.findElement(By.tagName("p")).getText());
	}

}


/*
Fetch.requestPaused #
Issued when the domain is enabled and the request URL matches the specified filter. 
The request is paused until the client responds with one of continueRequest, failRequest or fulfillRequest.

*/