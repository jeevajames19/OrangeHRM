package pom;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class Pagelogout {

	
public WebDriver driver;
	
	
	public Pagelogout(WebDriver driver)
	{
		this.driver=driver;
	}

	
	By droplog=By.xpath("/html/body/div/div[1]/div[1]/header/div[1]/div[2]/ul/li");
	
	By out=By.linkText("Logout");
	





public void logout() throws InterruptedException
{
	driver.findElement(droplog).click();
Thread.sleep(6000);
driver.findElement(out).click();
Thread.sleep(6000);


}










}
