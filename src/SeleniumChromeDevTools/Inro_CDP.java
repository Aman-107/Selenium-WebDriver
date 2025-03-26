package SeleniumChromeDevTools;

import java.util.Optional;

import org.openqa.selenium.By;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.devtools.DevTools;
import org.openqa.selenium.devtools.v131.emulation.Emulation;

// https://chromedevtools.github.io/devtools-protocol/  -> Documentation 
public class Inro_CDP {
	
	public static void main(String[] args) throws InterruptedException {
		
		ChromeDriver driver = new ChromeDriver(); // here we are using the ChromeDriver instead of WebDriver bcoz dev tool is present in chrome and edge only but webdriver will point to every browser like mozilla, firefox so avaoid any hiccups we explicityly use ChromeDriver.
		DevTools devTools = driver.getDevTools();
		devTools.createSession(); // creating session
		
		// send commands to CDP Methods -> CDP method will invoke and get access to chrome dev tools. (from document help)
		// in multiple options for same command check the version of your chrome and implement that code only.
		// Optional.empty() is implemented bcoz there field is present but we want to pass that argument as empty.
		// opening in phone mode i.e. pixel
		devTools.send(Emulation.setDeviceMetricsOverride(412, 915, 100, true, Optional.empty(), Optional.empty(), Optional.empty(), Optional.empty(), Optional.empty(), Optional.empty(), Optional.empty(), Optional.empty(), Optional.empty(), Optional.empty()));
		
	driver.get("https://rahulshettyacademy.com/angularAppdemo/");
	driver.findElement(By.className("navbar-toggler")).click();
	Thread.sleep(2000);
	driver.findElement(By.linkText("Library")).click();
	}
	
}

/*
What are ChromeDevTools : 
Chrome DevTools is a set of web developer tools built directly into the Google Chrome browser i.e. Inspect window.
With Chrome DevTools, developers have deeper access to the Apllications which render on browser.

Que : What is Chrome DevTools Potocol(CDP)?
Ans :a) The Chrome DevTools Protocol provide tools to instrument, inspect, debug, and profile Chromium, Chrome and Other Blink-based 
      browsers.
     b) Selenium 4 introduces powerful commands which are wrapper around the CDP Domains to grants access to Chrome DevTools 
     directly from our Automated tests.
     c) With this CDP Support Selenium opens up the possibilities of out of Box Testing with the complete access and control to the 
     browser features within the Test. 
     Examples -
     * Capture, Monitor and Stub the Network requests and responses
     * Inject Session Cookies and Perform basic Auth
     * Mock Device Coordinates for Mobile/Tabs view
     * Check and monitor the site's performance.
     * Mock geolocations of the user.
     * Block the Network requests.
     * Mock faster/slower networks speed.
     * Execute and debug JavaScript.
     * View Console Logs
     
Que : Code Snippet to initialize ChromeDevTools connection with Selenium
Ans : Chromium Driver class has predefined methods to access the DevTools.
      Chrome Driver and Edge Driver are inherited from Chromium Driver. So, we can access to Devtools with Chrome and edge browsers.
      
      Step 1 :
      Initiate Chromium Driver.
      
      Step 2 : 
      Create the object for Chrome Dev tools with getDevTools() Method.
      DevTools devTools = driver.getDevTools();
      returns the new DevTools objects which allows us to send() the built-in Selenium commands for CDP.
      Create
*/