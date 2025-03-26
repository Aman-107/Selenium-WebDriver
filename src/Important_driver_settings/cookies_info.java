package Important_driver_settings;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;

public class cookies_info {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		ChromeOptions options = new ChromeOptions();
		options.addArguments("--incognito");
		WebDriver driver = new ChromeDriver(options);
		
		// Maximising the window
		driver.manage().window().maximize();
		
		// To delete all the cookies before execution of the script
		driver.manage().deleteAllCookies();
		
		// To delete a specific cookie and it's string has to be passed as an argument.
		driver.manage().deleteCookieNamed("C"); // Remember in foundit we were having the cookie name as C which stores the recruiter details
		
	}

}
