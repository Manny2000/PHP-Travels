package Pages;

import java.io.File;
import java.util.Iterator;
import java.util.Set;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.Alert;
import org.openqa.selenium.By;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedCondition;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;

public class InterviewQuestions {
	WebDriver driver;

	// How do you handle alerts?, is alert present?

	public boolean isAlertPresent() {
		try {
			driver.switchTo().alert();
			return true;
		} catch (Exception e) {
			return false;
		}
	}

	public void InterviewQuestions() {
		// How do you accept or dismiss alerts?
		driver = new FirefoxDriver();
		driver.switchTo().alert().accept();
		driver.switchTo().alert().dismiss();

		Alert text = driver.switchTo().alert();
		System.out.println(text);

		// How do you select frame?
		// Switch to fram can be based on name, index, and element.
		driver.switchTo().frame(0);
		driver.switchTo().frame("WebElement");
		driver.switchTo().frame("");

		// How do switch between windows?
		String pwindow = driver.getWindowHandle();
		Set<String> allwindows = driver.getWindowHandles();
		Iterator<String> allwindow = allwindows.iterator();

		// How do you go from child window to the parent window?
		driver.switchTo().defaultContent(); // will get the user back to the default page.

		// implicit wait and explicit wait.
		// implicit wait.
		driver.manage().timeouts().implicitlyWait(5000, TimeUnit.SECONDS); // driver will wait 30 seconds to load all
																			// the dom of the page. If page is not
																			// loaded in the given time. It will give a
																			// timeout exception.

		// explicit wait
		WebDriverWait wait = new WebDriverWait(driver, 30);
		wait.until(ExpectedConditions.visibilityOfAllElementsLocatedBy(By.xpath(""))); // Can be used to wait for a
		// specific element to load. One scenrio where page will ge loaded, but
		// advertizement popup will pop up after 30 seconds.

		// How to do mouseover in selenium?

		Actions act = new Actions(driver);
		act.moveToElement(driver.findElement(By.xpath(""))).build().perform();

		// How to select dropdown options?
		// Make the object of Select class, and supply the location of the element that
		// you are trying to select.

		Select sel = new Select((WebElement) driver);
		sel.selectByIndex(0);
		sel.selectByValue("");

		// How to perform drag n drop?
		// make an object for the actions class, and use draganddrop option.
		// drag and drop is performed using the source, and target.

		// how to get a screenshot in selenium?

		// have to cast driver with the take screenshot class
		File srcfile = ((TakesScreenshot) driver).getScreenshotAs(OutputType.FILE);

	}
}
