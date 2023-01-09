package org.base;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Properties;
import java.util.Set;
import java.util.concurrent.TimeUnit;


import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.CellType;
import org.apache.poi.ss.usermodel.DateUtil;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import org.openqa.selenium.Alert;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.Keys;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.ie.InternetExplorerDriver;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.Select;

import io.github.bonigarcia.wdm.WebDriverManager;

/**
 * 
 * @author ManojKumar
 * @date 07-12-2022
 * @see maintains resuable methods
 *
 */

public class BaseClass {
	public static WebDriver driver;

	
	/**
	 * 
	 * @param browser
	 * @see getDriver
	 */
	public static void getDriver(String browser) {

		switch (browser) {
		case "Chrome":
			WebDriverManager.chromedriver().setup();
			driver = new ChromeDriver();
			break;

		case "Firefox":
			WebDriverManager.firefoxdriver().setup();
			driver = new FirefoxDriver();
			break;

		case "ie":
			WebDriverManager.iedriver().setup();
			driver = new InternetExplorerDriver();
			break;
		case "edge":
			WebDriverManager.edgedriver().setup();
			driver = new EdgeDriver();
			break;

		default:
			break;
		}

	}

	/**
	 * 
	 * @param Url\
	 * @see enterApplnUrl
	 */
	public static void enterApplnUrl(String Url) {
		driver.get(Url);
	}

	/**
	 * 
	 * @param element
	 * @return String
	 * @see Getattribute
	 */
	public static String Getattribute(WebElement element) {
		String attribute = element.getAttribute("value");

		return attribute;

	}

	/**
	 * 
	 * @param element
	 * @param attributename
	 * @return String
	 * @see Getattribute
	 */
	public static String Getattribute(WebElement element, String attributename) {
		String attribute = element.getAttribute(attributename);
		return attribute;

	}

	/**
	 * 
	 * @return String
	 * @see getProjectPath
	 */
	public static String getProjectPath() {

		String path = System.getProperty("user.dir");
		return path;
	}

	/**
	 * 
	 * @param key
	 * @return String
	 * @throws FileNotFoundException
	 * @throws IOException
	 * @see getPropertyFileValue
	 */
	public static String getPropertyFileValue(String key) throws FileNotFoundException, IOException {

		Properties properties = new Properties();
		properties.load(new FileInputStream(getProjectPath()+
				"\\src\\test\\resources\\Config\\config.properties"));
		Object object = properties.get(key);

		String value = (String) object;
		return value;

	}
	
	/**
	 * 
	 * @return byte[]
	 * @see screenShot
	 */

	public  byte[] screenShot() {

		TakesScreenshot screenshot = (TakesScreenshot) driver;
		byte[] b = screenshot.getScreenshotAs(OutputType.BYTES);
		return b;

	}

	/**
	 * @see maximizewindow
	 */
	public static void maximizewindow() {
		driver.manage().window().maximize();
	}

	/**
	 * 
	 * @param element
	 * @param data
	 * @see elementSendkeysJs
	 */
	public void elementSendkeysJs(WebElement element, String data) {
		JavascriptExecutor executor = (JavascriptExecutor) driver;
		executor.executeScript("arguments[0].setAttribute('value','" + data + "')", element);
	}

	/**
	 * 
	 * @param element
	 * @see elementClick
	 */
	public static void elementClick(WebElement element) {
		element.click();
	}

	/**
	 * 
	 * @param attributeValue
	 * @return WebElement
	 * @see findLocatorByID
	 */
	public WebElement findLocatorByID(String attributeValue) {
		WebElement element = driver.findElement(By.id(attributeValue));
		return element;
	}

	public WebElement findLocatorByName(String attributeValue) {
		WebElement element = driver.findElement(By.name(attributeValue));
		return element;
	}

	public WebElement findLocatorByClassName(String attributeValue) {
		WebElement element = driver.findElement(By.className(attributeValue));
		return element;
	}

	public WebElement findLocatorByXpath(String attributeValue) {
		WebElement element = driver.findElement(By.xpath(attributeValue));
		return element;
	}

	public String getAppTitle() {
		String title = driver.getTitle();
		return title;
	}

	public String getApplnUrl(String string) {
		String currentUrl = driver.getCurrentUrl();
		return currentUrl;
	}

	public void closewindow() {
		driver.close();
	}

	public static void quitwindow() {
		driver.quit();
	}

	public static String elementGetText(WebElement element) {
		String text = element.getText();
		return text;
	}

	public static String elementGetAttributeValue(WebElement element) {
		String attribute = element.getAttribute("value");
		return attribute;
	}

	public String elementGetAttributeValue(WebElement element, String attributeName) {
		String attribute = element.getAttribute(attributeName);
		return attribute;
	}

	public void selectByVisibleText(WebElement element, String hotels) {
		Select select = new Select(element);
		select.selectByVisibleText(hotels);
	}

	public void selectOptionByText(WebElement element, String text) {

		Select s = new Select(element);
		s.selectByVisibleText(text);

	}

	public void selectOptionByAttribute(WebElement element, String value) {
		Select s = new Select(element);
		s.selectByValue(value);

	}

	public void selectOptionByIndex(WebElement element, int index) {
		Select s = new Select(element);
		s.selectByIndex(index);

	}

	public static void clearText(WebElement element) {
		element.clear();
	}

	public void SelectByAttribute(WebElement element, String value) {
		Select select = new Select(element);
		select.selectByValue(value);
	}

	public void SelectByIndex(WebElement element, int index) {
		Select select = new Select(element);
		select.selectByIndex(index);
	}

	public void doubleClick(WebElement element) {
		Actions actions = new Actions(driver);
		actions.doubleClick(element).perform();
	}

	public void switchtochildwindow() {
		String handle = driver.getWindowHandle();
		Set<String> handles = driver.getWindowHandles();
		{
			for (String x : handles) {
				if (handle.equals(x)) {
					driver.switchTo().window(x);
				}
			}
		}
	}

	public void rightClick(WebElement element) {
		Actions actions = new Actions(driver);
		actions.contextClick(element).perform();
	}

	public void dragandDrop(WebElement source, WebElement destination) {
		Actions actions = new Actions(driver);
		actions.dragAndDrop(source, destination).perform();
	}

	public void enterValuetoTextbox(WebElement element, String text) {
		element.sendKeys(text, Keys.ENTER);
	}

	public void mouseMovetoElement(WebElement element) {
		Actions actions = new Actions(driver);
		actions.moveToElement(element).perform();

	}

	public void Takescreenshot() {
		TakesScreenshot ts = (TakesScreenshot) driver;
		ts.getScreenshotAs(OutputType.FILE);
	}

	public void cleartextbox(WebElement element) {
		element.clear();
	}

	public void getAllwindowsId() {
		Set<String> handles = driver.getWindowHandles();
	}

	public void getparentwindow() {
		String string = driver.getWindowHandle();
	}

	public void deselectAll(WebElement element) {
		Select select = new Select(element);
		select.deselectAll();
	}

	public void deselectbyvisibletext(WebElement element, String text) {
		Select select = new Select(element);
		select.selectByValue(text);
	}

	public void deselectbyvalue(WebElement element, String value) {
		Select select = new Select(element);
		select.selectByValue(value);
	}

	public void deselectByIndex(WebElement element, int index) {
		Select select = new Select(element);
		select.selectByIndex(index);
	}

	public void implicitwait(int time) {
		driver.manage().timeouts().implicitlyWait(time, TimeUnit.SECONDS);
	}

	public String getdatafromcell(String Sheetname, int rownum, int cellnum) {
		return Sheetname;

	}

	public void elementsendkeys(WebElement element, String n) {
		element.sendKeys(n);
	}

	public String getDatafromCell(String sheetName, int rownum, int cellnum) throws IOException {

		String res = "";

		File file = new File("C:\\Users\\mnm\\eclipse-workspace\\Maven\\EXCEL\\Data.xlsx");
		FileInputStream stream = new FileInputStream(file);
		Workbook book = new XSSFWorkbook(stream);
		Sheet sheet = book.getSheet(sheetName);
		Row row = sheet.getRow(rownum);
		Cell cell = row.getCell(cellnum);
		CellType type = cell.getCellType();

		switch (type) {
		case STRING:
			res = cell.getStringCellValue();
			break;
		case NUMERIC:
			if (DateUtil.isCellDateFormatted(cell)) {
				Date dateCellValue = cell.getDateCellValue();
				SimpleDateFormat dateFormat = new SimpleDateFormat("dd/MM/yyyy");
				res = dateFormat.format(dateCellValue);
			} else {
				double numericCellValue = cell.getNumericCellValue();

				long check = Math.round(numericCellValue);
				if (numericCellValue == check) {
					res = String.valueOf(check);
				} else {
					res = String.valueOf(numericCellValue);
				}
			}
		default:
			break;
		}
		return res;
	}

	@SuppressWarnings("deprecation")

//	public static String elementGetttributeValue(WebElement element) {
//		String attribute = element.getAttribute("value");
//		return attribute;
//	}

	public static void insertDataInCell(String sheetName, int rowNum, int cellNum, String data) throws IOException {
		File file = new File("C:\\Users\\mnm\\eclipse-workspace\\Maven\\EXCEL\\Data.xlsx");
		FileInputStream fileInputStream = new FileInputStream(file);
		Workbook workbook = new XSSFWorkbook(fileInputStream);
		Sheet sheet = workbook.getSheet(sheetName);
		Row row = sheet.getRow(rowNum);
		Cell cell = row.createCell(cellNum);
		cell.setCellValue(data);
		FileOutputStream out = new FileOutputStream(file);
		workbook.write(out);
	}

	public static Object[][] getDataFromExcellusingObject(String SheetName) throws IOException {

		String res = "";

		File file = new File("C:\\Users\\mnm\\eclipse-workspace\\Maven\\EXCEL\\Data.xlsx");
		FileInputStream stream = new FileInputStream(file);
		Workbook book = new XSSFWorkbook(stream);
		Sheet sheet = book.getSheet(SheetName);
		Object[][] data = new Object[sheet.getLastRowNum()][sheet.getRow(0).getLastCellNum()];
		for (int i = 0; i < sheet.getLastRowNum(); i++) {
			for (int j = 0; j < sheet.getRow(0).getLastCellNum(); j++) {

				Cell cell = sheet.getRow(i).getCell(j);
				System.out.println(cell);
				CellType type = sheet.getRow(i).getCell(j).getCellType();
				switch (type) {
				case STRING:
					res = cell.getStringCellValue();

					break;

				case NUMERIC:
					if (DateUtil.isCellDateFormatted(cell)) {
						Date dateCellValue = cell.getDateCellValue();
						SimpleDateFormat dateformat = new SimpleDateFormat("dd/mm/yyyy");
						res = dateformat.format(dateCellValue);

					} else {
						double numericCellValue = cell.getNumericCellValue();
						long check = Math.round(numericCellValue);
						if (check == numericCellValue) {
							res = String.valueOf(check);

						} else {
							res = String.valueOf(numericCellValue);
						}

					}

				default:
					break;
				}

			}

		}
		return data;

	}

	public void alertok() {
		Alert alert = driver.switchTo().alert();
		alert.accept();
	}

	// 8.FindElementById
	public WebElement FindElementById1(String Attributevalue) {
		WebElement element = driver.findElement(By.id(Attributevalue));

		return element;
	}

	// 8.FindElementById
	public WebElement FindElementById(String attributevalue) {
		WebElement element = driver.findElement(By.id(attributevalue));

		return element;
	}

	// 9.FindElementByName
	public WebElement FindElementByName(String Attributevalue) {
		WebElement element = driver.findElement(By.name(Attributevalue));

		return element;

	}

	// 10.FindElementByClassName
	public WebElement FindElementByClassName(String Attributevalue) {
		WebElement element = driver.findElement(By.className(Attributevalue));

		return element;

	}

	// 11.FindElementByXpath
	public WebElement FindElementByXpath(String expression) {
		WebElement element = driver.findElement(By.xpath(expression));

		return element;

	}

}
