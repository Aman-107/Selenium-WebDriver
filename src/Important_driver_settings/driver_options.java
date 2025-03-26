package Important_driver_settings;

import java.io.File;
import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

import org.openqa.selenium.Proxy;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;

public class driver_options {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

		// *** Refer this URL for details
		// https://developer.chrome.com/docs/chromedriver/capabilities ***

		ChromeOptions options = new ChromeOptions();

		// for incognito mode to open
		options.addArguments("--incognito");

		// for accepting the proceed to unsafe -> https://expired.badssl.com/
		options.setAcceptInsecureCerts(true);
		
		options.addExtensions(new File("/path/to/extension.crx")); // for adding any extension to the chrome driver
		// download extension in local and then pass the location as arguments

		// Add the WebDriver proxy capability. -> it used to land on specific webpage
		// which uses some proxy/VPN
		Proxy proxy = new Proxy();
		proxy.setHttpProxy("myhttpproxy:3337");
		options.setCapability("proxy", proxy);
		// Add a ChromeDriver-specific capability.
		options.addExtensions(new File("/path/to/extension.crx"));

		// Block dialog windows
		options.setExperimentalOption("excludeSwitches", Arrays.asList("disable-popup-blocking"));

		// Set download directory
		Map<String, Object> prefs = new HashMap<String, Object>();
		prefs.put("download.default_directory", "/directory/path");
		options.setExperimentalOption("prefs", prefs);

		WebDriver driver = new ChromeDriver(options);
		driver.manage().window().maximize();

		driver.get("https://expired.badssl.com/");
		System.out.println(driver.getTitle());
	}

}
