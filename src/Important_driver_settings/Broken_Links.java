package Important_driver_settings;
/* Steps -> 
1. Checking for broken links on a webpage involves finding all the links (<a> tags)
2. extracting their href attributes
3. sending HTTP requests to verify if they are valid or broken.
*/

import java.io.IOException;
import java.net.HttpURLConnection;
import java.net.URL;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

public class Broken_Links {

	public static void main(String[] args) throws IOException {
		// Set up the WebDriver
		WebDriver driver = new ChromeDriver();
		driver.manage().window().maximize();
		driver.get("https://rahulshettyacademy.com/AutomationPractice/");

		// Find all anchor tags
		List<WebElement> links = driver.findElements(By.tagName("a"));

		System.out.println("Total links found: " + links.size());

		// Loop through each link and check its status
		for (WebElement link : links) {
			String url = link.getAttribute("href");

			// Check if the URL is valid and non-null
			if (url == null || url.isEmpty()) {
				System.out.println("URL is empty or null");
				continue;
			}

			try {
				// Verify the URL using HTTP connection
				HttpURLConnection connection = (HttpURLConnection) new URL(url).openConnection();
				connection.setRequestMethod("HEAD");
				connection.connect();

				int responseCode = connection.getResponseCode();
				if (responseCode >= 400) {
					System.out.println("Broken link: " + link.getText()+ " " + url + " - Response code: " + responseCode);
				} 
//				else {
//					System.out.println("Valid link: " + link.getText()+ " " + url + " - Response code: " + responseCode);
//				}

			} catch (Exception e) {
				System.out.println("Error checking URL: "+ link.getText()+ " " + url + " - " + e.getMessage());
			}
		}
		// Close the browser
		driver.quit();
	}
}


/* Udemy Code 

import java.io.IOException;
import java.net.HttpURLConnection;
import java.net.MalformedURLException;
import java.net.URL;
import java.net.URLConnection;
import java.util.List;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.asserts.SoftAssert;

public class BrokenLinks {

public static void main(String[] args) throws MalformedURLException, IOException {

// TODO Auto-generated method stub
         WebDriver driver=new ChromeDriver();
         //broken URL
         //Step 1 - IS to get all urls tied up to the links using Selenium
         //  Java methods will call URL's and gets you the status code
         //if status code >400 then that url is not working-> link which tied to url is broken
         //a[href*="soapui"]'
         driver.get("https://rahulshettyacademy.com/AutomationPractice/");
         
      List<WebElement> links=   driver.findElements(By.cssSelector("li[class='gf-li'] a"));

      SoftAssert a =new SoftAssert();

      for(WebElement link : links)
      {
          String url= link.getAttribute("href");

          HttpURLConnection   conn= (HttpURLConnection)new URL(url).openConnection();
          conn.setRequestMethod("HEAD");
          conn.connect();
          
          int respCode = conn.getResponseCode();
          System.out.println(respCode);
          a.assertTrue(respCode<400, "The link with Text"+link.getText()+" is broken with code" +respCode);
      }
      a.assertAll();
}
private static Object getReturnCode(WebElement link) {
// TODO Auto-generated method stub
return null;
}
}

*/ 



