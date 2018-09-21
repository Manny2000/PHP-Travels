package Pages;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.Select;

import Util.Lib;

public class homepg extends Lib {

	// public static void SearchIAD(WebDriver driver) throws InterruptedException {
	// // WebElement a =
	// // driver.findElement(By.xpath("//input[contains(@class,'select2-inputselect2-focused')]"));
	// // a.click();
	// WebElement b = driver.findElement(
	// By.xpath("html/body/div[4]/section/div[2]/div/div[2]/div/div[1]/form/div[1]/div/div[2]/a/span[1]"));
	// b.click();
	// WebElement c = driver.findElement(By.xpath("html/body/div[16]/div/input"));
	// c.sendKeys("IAD");
	//
	// Select searchdrop = new Select(driver.findElement(By.xpath("null")));
	// searchdrop.selectByVisibleText("Nashua, United States");
	// Thread.sleep(8000);
	// }

	public static void googlesearch(WebDriver driver) throws InterruptedException {

		WebElement a = driver.findElement(By.xpath("//*[contains (@class,'gLFyf')]"));
		a.click();
		a.sendKeys("testing");

		List<WebElement> b = driver.findElements(By.xpath("//ul[@role='listbox']/child::li"));

		int c = b.size();

		System.out.println("Total number of search suggestions is :: " + c);

		Thread.sleep(6000);

		for (int i = 0; i < b.size(); i++) {

			WebElement Result = b.get(i);
			String result = Result.getText();

			if (result.contentEquals("testing center"))

			{
				Result.click();
				break;
//				 } else {
//				 System.out.println("Unavailable");
//				 break;
			}
		}
		String pageURL = driver.getTitle();
		System.out.println("Current page Title is:: " + pageURL);
	}
}