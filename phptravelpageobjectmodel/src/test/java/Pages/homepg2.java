package Pages;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class homepg2 {
	public static void searchAsh(WebDriver driver) throws InterruptedException {
		WebElement a = driver.findElement(
				By.xpath("html/body/div[4]/section/div[2]/div/div[2]/div/div[1]/form/div[1]/div/div[2]/a/span[1]"));
		a.click();
		WebElement b = driver.findElement(By.xpath("html/body/div[16]/div/input"));
		b.sendKeys("Ash");
		List<WebElement> ab = driver.findElements(By.xpath("//ul[@class='select2-result-sub']/child::li"));
		int c = ab.size();
		System.out.println("Total number of search suggestions is :: " + c);
		Thread.sleep(6000);
		for (int i = 0; i < ab.size(); i++) {
			WebElement Result = ab.get(i);
			String result = Result.getText();
			if (result.contentEquals("Ashley, United States")) {
				Result.click();
				break;
			}
		}
		String pageURL = driver.getTitle();
		System.out.println("Current page Title is:: " + pageURL);
	}

	public static void checkin(WebDriver driver, String a) {
		WebElement ab = driver.findElement(By.xpath("//*[@name='checkin']"));
		ab.click();
		ab.sendKeys(a);
	}

	public static void checkout(WebDriver driver, String a) {
		WebElement ab = driver.findElement(By.xpath("//*[@name='checkout']"));
		ab.click();
		ab.sendKeys(a);
	}

	public static void searchbtn(WebDriver driver) {
		WebElement Btn = driver.findElement(By.xpath("//*[@class='btn btn-lg btn-block btn-danger pfb0 loader']"));
		Btn.click();
	}
}
