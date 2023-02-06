package pom;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.testng.Assert;

public class adminpage {

 public WebDriver driver;//instance or global variable


public adminpage(WebDriver driver)
{
	this.driver=driver;// this keyword is used to refer current class(instance or global variable)
	
}

By adminbtn=By.xpath("/html/body/div/div[1]/div[1]/aside/nav/div[2]/ul/li[1]/a");

By user=By.xpath("/html/body/div/div[1]/div[2]/div[2]/div/div[1]/div[2]/form/div[1]/div/div[1]/div/div[2]/input");


//drop-down user role

By droprole=By.xpath("/html/body/div/div[1]/div[2]/div[2]/div/div[1]/div[2]/form/div[1]/div/div[2]/div/div[2]/div/div");
By ess=By.xpath("/html/body/div/div[1]/div[2]/div[2]/div/div[1]/div[2]/form/div[1]/div/div[2]/div/div[2]/div/div/div[1]");

//drop down status

By dropstaus=By.xpath("/html/body/div/div[1]/div[2]/div[2]/div/div[1]/div[2]/form/div[1]/div/div[4]/div/div[2]/div");
By enabled=By.xpath("/html/body/div/div[1]/div[2]/div[2]/div/div[1]/div[2]/form/div[1]/div/div[4]/div/div[2]/div/div/div[1]");

By searchbtn=By.xpath("/html/body/div/div[1]/div[2]/div[2]/div/div[1]/div[2]/form/div[2]/button[2]");



//empName
By empName=By.xpath("/html/body/div/div[1]/div[2]/div[2]/div/div[2]/div[3]/div/div[2]/div/div/div[4]");

public void admin()
{
	driver.findElement(adminbtn).click();
}

public void username()
{
	driver.findElement(user).sendKeys("carlos_pareja");;
}

public void Droprole() throws InterruptedException {
	driver.findElement(droprole).click();
	Thread.sleep(2000);
	driver.findElement(droprole).sendKeys("e");
}

public void DropStatus() throws InterruptedException {
	driver.findElement(dropstaus).click();
Thread.sleep(2000);
	driver.findElement(dropstaus).sendKeys("e");

	


}
public void submit()
{
driver.findElement(searchbtn).click();	
}

public void employee() {
	String actualname=driver.findElement(empName).getText();
String expected="Carlos Solano Rivera";
Assert.assertEquals(actualname, expected);
}


}

















