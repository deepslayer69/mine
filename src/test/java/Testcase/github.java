package Testcase;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.testng.annotations.Test;
import base.Basetest;


public class github extends Basetest{
	@Test
	public  void geturl() throws InterruptedException {
	
		System.out.println("browser opend");
		driver.findElement(By.xpath("/html/body/div[1]/div[1]/header/div/div[2]/div/div/div/a")).click();
		Thread.sleep(1000);
		driver.findElement(By.xpath("//*[@id=\"login_field\"]")).sendKeys(loc.getProperty("username"));
		driver.findElement(By.xpath("//*[@id=\"password\"]")).sendKeys(loc.getProperty("password"));
		logger.info("Login credentials entered.");
		driver.findElement(By.xpath("//*[@id=\"login\"]/div[4]/form/div/input[13]")).click();
		Thread.sleep(2000);
		
		/* to make new repo
		driver.findElement(By.xpath("//*[@id=\"global-create-menu-button\"]/span")).click();
		driver.findElement(By.xpath("/html/body/div[1]/div[1]/header/div/div[2]/div[2]/action-menu/focus-group/anchored-position/div/div/div/ul/li[1]/a/span[2]")).click();
		Thread.sleep(6000);
		driver.findElement(By.xpath("//*[@id=\":r3:\"]")).sendKeys("temp");
		driver.findElement(By.xpath("/html/body/div[1]/div[6]/main/react-app/div/form/div[5]/button")).click();
		Thread.sleep(3000);
		*/
		
		driver.findElement(By.xpath("//aside[@aria-label='Account']//li[1]//div[1]//div[1]//a[1]")).click();
		driver.findElement(By.xpath("//a[normalize-space()='uploading an existing file']")).click();
		Thread.sleep(3000);
		WebElement fileInput =driver.findElement(By.xpath("//*[@id=\"upload-manifest-files-input\"]"));
		String filePath = "//Users//aayan//selemiun workplace//baba";
        fileInput.sendKeys(filePath);

		
		
		
	}

}
