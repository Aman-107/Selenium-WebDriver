package Projects;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

public class Assig_8_sec_104{

    public static void main(String[] args) throws InterruptedException {
        // Initialize WebDriver
        WebDriver driver = new ChromeDriver();
        driver.manage().window().maximize();

        // Navigate to the URL
        driver.get("https://rahulshettyacademy.com/AutomationPractice/");

        // Locate the input box and enter 'uni'
        WebElement inputBox = driver.findElement(By.id("autocomplete"));
        inputBox.sendKeys("un");
        Thread.sleep(2000); // Wait for suggestions to load

        List<WebElement> suggestion = driver.findElements(By.className("ui-menu-item"));
        // Use ARROW_DOWN to navigate and grab the text
        String selectedText = "";
        for (int i = 0; i < suggestion.size(); i++) { // Assuming the target is within 5 suggestions
            inputBox.sendKeys(Keys.ARROW_DOWN);
            Thread.sleep(500); // Small delay for highlight to update
            selectedText = inputBox.getAttribute("value"); // Get the text of the highlighted suggestion

            System.out.println("Current suggestion: " + selectedText);

            // Check if the desired suggestion is highlighted
            if (selectedText.equals("United States (USA)")) {
                inputBox.sendKeys(Keys.ENTER); // Select the highlighted suggestion
                break;
            }
        }

        // Verify the selected text
        System.out.println("Final selection: " + inputBox.getAttribute("value"));

        // Close the browser
        driver.quit();
    }
}

