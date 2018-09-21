package Util;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.util.Properties;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.By;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class Lib {

	public static String readproperties(String key) throws IOException {
		File fl = new File("/Users/Mansoor/eclipse-workspace/phptravelpageobjectmodel/Locator.properties");
		FileInputStream fis = new FileInputStream(fl);
		Properties prop = new Properties();
		prop.load(fis);
		String locatr = prop.getProperty(key);
		return locatr;

	}

	// public static void takeSS(WebDriver driver) throws IOException {
	// File scr = ((TakesScreenshot) driver).getScreenshotAs(OutputType.FILE);
	// String filename = new SimpleDateFormat("yyyyMMddhhmmss'.txt'").format(new
	// Date(0, 0, 0));
	// File dest = new File("Users/Mansoor/eclipse-workspace/Learn" + filename);
	// FileUtils.copyFile(scr, dest);
	// }

	public static WebElement FindEle(WebDriver driver, String xpath) {

		WebElement Ele = driver.findElement(By.xpath(xpath));
		return Ele;
	}

	public static String GNprinttitle(WebDriver driver) {
		String value = driver.getTitle();
		// return value;
		System.out.println("The title of the current page is :: " + value);
		return value;
	}

	public static void captureScreenShot(WebDriver driver) {

		// Take screenshot and store as a file format
		File src = ((TakesScreenshot) driver).getScreenshotAs(OutputType.FILE);
		try {
			// now copy the screenshot to desired location using copyFile method

			FileUtils.copyFile(src,
					new File("/Users/Mansoor/eclipse-workspace/DemoQA/src/test" + System.currentTimeMillis() + ".png"));
		}

		catch (IOException e)

		{

			System.out.println(e.getMessage());

		}

	}
}
