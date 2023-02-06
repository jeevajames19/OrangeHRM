package pom;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class Pagelogin {


public 	WebDriver driver;
	
	
	public Pagelogin(WebDriver driver)
	{
		
		this.driver=driver;
		
	}


By uname=By.xpath("/html/body/div/div[1]/div/div[1]/div/div[2]/div[2]/form/div[1]/div/div[2]/input");

By passcode=By.xpath("/html/body/div/div[1]/div/div[1]/div/div[2]/div[2]/form/div[2]/div/div[2]/input");

By submit=By.xpath("/html/body/div/div[1]/div/div[1]/div/div[2]/div[2]/form/div[3]/button");



public void credentials(String username,String password) {
	
	driver.findElement(uname).sendKeys(username);
	driver.findElement(passcode).sendKeys(password);
	
}

public void logging () {
	driver.findElement(submit).click();
}



}
