package Basics;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.edge.EdgeOptions;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.firefox.FirefoxOptions;
// Debugging in watch mode :-> can write the code as well after and check in debug console.
// Step 1: Set a breakpoint at the line which needs to be dubug.
// Step 2: Switch to the dubug mode from header
// Step 3: Now select the whole line of debug i.e. which is green
// Step 4: Right click highlighted line -> select watch option
// Step 5: Right the operations in Add New Expression

public class Self_Intro {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

//        ChromeOptions options = new ChromeOptions(); // Set up ChromeOptions
//        options.addArguments("--incognito");
//        WebDriver driver = new ChromeDriver(options); // Initialize the WebDriver with options
		
		
//        FirefoxOptions options = new FirefoxOptions();  // Set up FirefoxOptions
//        options.addArguments("-private");
//        WebDriver driver = new FirefoxDriver(options);  // Initialize the WebDriver with options

		
          EdgeOptions options = new EdgeOptions();  // Set up EdgeOptions
          options.addArguments("--inprivate");
          WebDriver driver = new EdgeDriver(options);  // Initialize the WebDriver with options
		
		driver.get("https://rahulshettyacademy.com/");
		driver.navigate().to("https://www.google.com/maps");
		driver.navigate().back();
		driver.navigate().forward(); 
		driver.navigate().refresh();
		
		System.out.println(driver.getTitle());
		System.out.println(driver.getCurrentUrl());
		driver.close(); // when we want to close a specific window or tab but continue working with others in the same session.
		driver.quit();  // when we are done with the entire WebDriver session to ensure proper cleanup of resources.
		
		
	}

}



/* Invoking Browser -> create object of that driver here ChromeDriver driver = new ChromeDriver();
* Chrome -> ChromeDriver -> Methods(eg : get,find etc) -> methods will be same for all the browser drivers.
* WebDriver is an interface which we uses and it provides methods to use
* WebDriver methods + class methods hence we use 'WebDriver driver = new ChromeDriver();'

* Chromedriver.exe -> Chrome browser Selenium Manager

* Steps to invoke chrome driver

* Step 1 : by calling via local chromedriver
* System.setPropery("webdriver.chrome.driver","C:/Users/akthe/Downloads/Java notes");      // (drivername , path of driver)
* WebDriver driver = new new ChromeDriver(); 
* Note : path will be differentiated by backward slash ('/') manually change instead of backward slash ('\') by default

* Step 2 : by calling via Selenium Manager
* WebDriver driver = new ChromeDriver();

* Use get() when you only need to open a webpage and wait for it to load completely.
* Use navigate().to() when you need additional navigation functionalities, such as going back, forward, or refreshing the page 
  in the same session. 
  
  
Feature	                              get()	                          			navigate().to()
Part of Interface					 WebDriver									Navigation
Primary Use							 Load a URL									Load a URL or navigate between pages
Wait for Page Load					 Waits until the page is fully loaded		Does not always wait for full load
Supports Back/Forward				 No											Yes
Code 								 Simplicity									Simpler and more commonly used	Slightly more 
  																					verbose
* 
*/