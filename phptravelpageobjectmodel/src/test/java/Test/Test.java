//Maven project for Page Object Model - phptravels

package Test;

import java.util.concurrent.TimeUnit;

import org.junit.After;
import org.junit.BeforeClass;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

import Pages.homepg;
import Pages.homepg2;

public class Test {

	public static WebDriver driver;

	@BeforeClass
	public static void Initialize() {
		System.setProperty("webdriver.drive.chrome",
				"/Users/Mansoor/eclipse-workspace/phptravelpageobjectmodel/chromedriver");
		driver = new ChromeDriver();
		driver.manage().window().maximize();
		driver.get("https://www.google.net/");
		driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
	}

	@org.junit.Test
	public void test() throws InterruptedException {
		System.out.println("Testing has started");
		homepg.googlesearch(driver);
		driver.get("https://www.phptravels.net/");
		homepg2.searchAsh(driver);
		homepg2.checkin(driver, "09/20/2018");
		homepg2.checkout(driver, "09/30/2018");
		homepg2.searchbtn(driver);
	}

	@After
	public void close() {
		System.out.println("Test Finished");
		driver.manage().deleteAllCookies();
		driver.close();

	}

}
