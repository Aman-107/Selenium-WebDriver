package Important_driver_settings;

import java.io.File;
import java.io.IOException;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;

public class Screenshot {

	public static void main(String[] args) throws IOException {
		// TODO Auto-generated method stub
		
		ChromeOptions options = new ChromeOptions();
		options.addArguments("--incognito");
		WebDriver driver = new ChromeDriver(options);
		driver.manage().window().maximize();
		
		driver.get("https://www.google.co.in/");
		
		File src = ((TakesScreenshot)driver).getScreenshotAs(OutputType.FILE);
		FileUtils.copyFile(src,new File("E:\\SDET\\Screenshots\\screenshot.png"));
		// at the end write the file name you want to save
	} 

}

/* Steps to take and store the screenshots :
 
 Step 1 : Cast the driver to TakeScreeShots
 Step 2 : Convert the output as FILE type.
 Step 3 : Assign the file to 'src' only;
 Step 4: Store in desired location by using FileUtils.copyFile 'src' and pass the local address as argument
 
NOTE : Window will not allow any file or screenshot to store in local disk 'C' instead provide the other local disk path or 
       give the user directory address if there is only one local disk i.e. 'C' e.g -> C:\Users\akthe 
       
       2. FileUtils will throw error hence we need to add apache jar (from local download jar) 

*/