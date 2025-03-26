package WindowHandling;

import java.io.File;
import java.io.IOException;
import java.time.Duration;
import java.util.HashMap;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;

public class FileUploadAutoIT {

	public static void main(String[] args) throws InterruptedException, IOException {
		// TODO Auto-generated method stub
		String downloadPath = System.getProperty("user.dir");
		
		ChromeOptions options = new ChromeOptions();
		// Downloading file to the user's current project directory 
		HashMap<String, Object> chromePrefs = new HashMap<String, Object>();
		chromePrefs.put("profile.default_content_settings.popups", 0);
		chromePrefs.put("download.default_directory", downloadPath);
		options.addArguments("--incognito");
		options.setExperimentalOption("prefs", chromePrefs);
		
		WebDriver driver = new ChromeDriver(options);
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(5));
		
		driver.get("https://www.ilovepdf.com/pdf_to_jpg");
		driver.findElement(By.id("pickfiles")).click();
		Thread.sleep(2000);
		Runtime.getRuntime().exec("E:\\SDET Codes Ecllipse\\fileupload_pdftoimage.exe");
		
		driver.findElement(By.id("processTask")).click();
		WebDriverWait wait = new WebDriverWait(driver,Duration.ofSeconds(10));
		wait.until(ExpectedConditions.visibilityOfElementLocated(By.id("pickfiles")));
		
		driver.findElement(By.id("pickfiles")).click();
		Runtime.getRuntime().exec("E:\\SDET Codes Ecllipse\\SaveAsbutton.exe");
		Thread.sleep(5000);
		
		File file = new File(downloadPath+"\\ilovepdf_pages-to-jpg.zip");
		if(file.exists()) {
			Assert.assertTrue(file.exists());
			if(file.delete()) {
				System.out.println("File got deleted");
			}
		}
		
		
		
	}

}


/*AutoIT software needs to be download in PC through which we'll find file's location in windows/system (AutoIt Full Installation)
 * Install Setup
 * a) SciTE.exe (C:\Program Files (x86)\AutoIt3\SciTE) -> Editor
 * b) Au3Info_x64.exe (C:\Program Files (x86)\AutoIt3) -> Object finder tool
 * 
 * Steps --
 * 1. Open the webpage e.g. -> (https://www.ilovepdf.com/pdf_to_jpg)
 * 2. Navigate to 'select PDF file' button.
 * 3. Now using (b) find the location.
 * 4. In the editor (a) write the script -> 
  ControlFocus("Open","","Edit1")  //second field i.e. text can be left blank -> select file_name edit box
  ControlSetText("Open","","Edit1","C:\Users\akthe\Downloads\Document1.pdf") // passing the file path to edit box
  ControlClick("Open","","Button1") // clicking on open button

  Here controlID i.e. 3rd argument will be concatanation of 'class' and 'Instance'
 * 5. Now compile the script ->go to saved location of script(E/SDET Eclipse) -> right click -> compile script(x86) ->.exe file created
 * 6. Come to selenium -> invoke the file of .exe from selenium
 * 
 * Udemy Steps : 
 * Au3info -> record window component objects
 * Build Script -> script.exe
 * Save -it -> .au3 extension
 * Convert file into .exe by compiling .au3 file
 * Call .exe file with Runtime class in java into your selenium tests
 */