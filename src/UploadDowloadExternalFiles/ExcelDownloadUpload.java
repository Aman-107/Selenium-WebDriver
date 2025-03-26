package UploadDowloadExternalFiles;

import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.time.Duration;
import java.util.Iterator;

import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.CellType;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;

public class ExcelDownloadUpload {

	public static void main(String[] args) throws IOException {
		// TODO Auto-generated method stub
		
		 String fruitName = "Mango"; // The fruit name to search for
	        String updateValue = "1299"; // The value to update
		
		ChromeOptions options = new ChromeOptions();
		options.addArguments("-incognito");
		WebDriver driver = new ChromeDriver(options);
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(5));

		driver.get("https://rahulshettyacademy.com/upload-download-test/");

		// Download
		driver.findElement(By.cssSelector(".button")).click();

		// Upload
		WebElement upload = driver.findElement(By.cssSelector("#fileinput"));
		upload.sendKeys("C://Users//akthe//Downloads//download.xlsx");

		// Wait for success message to show up and wait for disappear

		By toastLocator = By.cssSelector(".Toastify__toast-body div:nth-child(2)");
		WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(5));
		wait.until(ExpectedConditions.visibilityOfElementLocated(toastLocator));
		String toastText = driver.findElement(toastLocator).getText();
		Assert.assertEquals("Updated Excel Data Successfully.", toastText);

		wait.until(ExpectedConditions.invisibilityOfElementLocated(toastLocator));

		// Verfiy updated excel data showing in the web table
		String priceColumn = driver.findElement(By.xpath("//div[text()='Price']")).getAttribute("data-column-id");
		By fruitLocator = By.xpath("//div[text()='" + fruitName + "']/parent::div/parent::div/div[@id='cell-"
				+ priceColumn + "-undefined']");
		String actualPrice = driver.findElement(fruitLocator).getText();
		System.out.println(actualPrice);
		Assert.assertEquals("299", actualPrice);

		// edit excel - getColumnNumber of Price - getRownumber of Mango -> update excel
		// with row,col
        String filename = "C://Users//akthe//Downloads//download.xlsx";

       

        int col = getColumnNumber(filename, "price");
        int row = getRownumber(filename, fruitName);

        if (row == -1 || col == -1) {
            System.out.println("Could not find the specified row or column.");
            return;
        }

        boolean result = updateCell(filename, row, col, updateValue);
        System.out.println("Cell update status: " + result);
    }

    private static boolean updateCell(String filename, int row, int col, String value) throws IOException {
        FileInputStream fis = new FileInputStream(filename);
        XSSFWorkbook workbook = new XSSFWorkbook(fis);
        XSSFSheet sheet = workbook.getSheet("Sheet1");

        // Update the cell
        Row rowUpdate = sheet.getRow(row);
        Cell cellUpdate = rowUpdate.getCell(col);
        if (cellUpdate == null) {
            cellUpdate = rowUpdate.createCell(col); // Create cell if it doesn't exist
        }
        cellUpdate.setCellValue(value);

        // Write the changes to the file
        fis.close(); // Close the input stream before writing
        FileOutputStream fos = new FileOutputStream(filename);
        workbook.write(fos);
        fos.close();
        workbook.close();
        return true;
    }

    private static int getRownumber(String filename, String string) throws IOException {
        FileInputStream fis = new FileInputStream(filename);
        XSSFWorkbook workbook = new XSSFWorkbook(fis);

        int k = 0; // Start from the first row
        int desRow = -1;

        XSSFSheet sheet = workbook.getSheet("Sheet1");

        Iterator<Row> rows = sheet.iterator(); // Sheet is a collection of rows
        while (rows.hasNext()) {
            Row row = rows.next();
            Iterator<Cell> cells = row.cellIterator();

            while (cells.hasNext()) {
                Cell cell = cells.next();

                // Check the type of the cell
                if (cell.getCellType() == CellType.STRING) {
                    if (cell.getStringCellValue().equalsIgnoreCase(string)) {
                        desRow = k; // Desired row found
                        break; // Stop checking further cells in this row
                    }
                } else if (cell.getCellType() == CellType.NUMERIC) {
                    // Convert numeric value to String and compare
                    String cellValue = String.valueOf((int) cell.getNumericCellValue());
                    if (cellValue.equalsIgnoreCase(string)) {
                        desRow = k;
                        break;
                    }
                }
            }
            k++;
        }

        workbook.close();
        fis.close();
        return desRow;
    }

    private static int getColumnNumber(String filename, String string) throws IOException {
        FileInputStream fis = new FileInputStream(filename);
        XSSFWorkbook workbook = new XSSFWorkbook(fis);

        int k = 0; // Column index
        int desColumn = -1;

        XSSFSheet sheet = workbook.getSheet("Sheet1");

        // Get the first row (header)
        Iterator<Row> rows = sheet.iterator();
        if (rows.hasNext()) {
            Row firstRow = rows.next(); // Get the first row
            Iterator<Cell> cells = firstRow.cellIterator(); // Row is a collection of cells

            while (cells.hasNext()) {
                Cell cell = cells.next();
                System.out.println("Header cell value: " + cell.getStringCellValue());
                if (cell.getStringCellValue().trim().equalsIgnoreCase(string)) {
                    desColumn = k;
                    break;
                }
                k++;
            }
        }

        if (desColumn == -1) {
            System.out.println("Column " + string + " not found.");
        } else {
            System.out.println("Column " + string + " found at index: " + desColumn);
        }

        workbook.close();
        fis.close();
        return desColumn;
    }
}