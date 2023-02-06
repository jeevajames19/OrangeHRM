package pom;

import org.openqa.selenium.By;
import org.testng.Assert;
import org.testng.annotations.Listeners;
import org.testng.annotations.Test;


@Listeners({AllureListeners.class})
public class HRMallure extends baseclass{
	 
	@Test(priority=1)
	public void loginhrm() throws InterruptedException {

		driver.get("https://opensource-demo.orangehrmlive.com/web/index.php/auth/login");
		Thread.sleep(4000);
		By uname=By.xpath("/html/body/div/div[1]/div/div[1]/div/div[2]/div[2]/form/div[1]/div/div[2]/input");

		By passcode=By.xpath("/html/body/div/div[1]/div/div[1]/div/div[2]/div[2]/form/div[2]/div/div[2]/input");

		By submit=By.xpath("/html/body/div/div[1]/div/div[1]/div/div[2]/div[2]/form/div[3]/button");

		driver.findElement(uname).sendKeys("Admin");
		driver.findElement(passcode).sendKeys("admin123");
		driver.findElement(submit).click();
	
		String Actualurl=driver.getCurrentUrl();
		Thread.sleep(6000);
	    
		Assert.assertEquals(Actualurl, "https://opensource-demo.orangehrmlive.com/web/index.php/dashboard/index");
		
	}


	@Test(priority=2)
	public void adminhrm() throws InterruptedException {

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


		driver.findElement(adminbtn).click();
        Thread.sleep(4000);
		driver.findElement(user).sendKeys("carlos_pareja");;
		Thread.sleep(3000);
		driver.findElement(droprole).click();
		Thread.sleep(2000);
		driver.findElement(droprole).sendKeys("e");

       Thread.sleep(3000);
		driver.findElement(dropstaus).click();
		Thread.sleep(2000);
		driver.findElement(dropstaus).sendKeys("e");
		Thread.sleep(3000);


		Thread.sleep(3000);
		driver.findElement(searchbtn).click();	
		Thread.sleep(3000);
		String actualname=driver.findElement(empName).getText();
		String expected="Carlos Solano Rivera";
		Assert.assertEquals(actualname, expected);
		Thread.sleep(3000);
	}    


	@Test(priority=3)
	public void logouthrm() throws InterruptedException {

		By droplog=By.xpath("/html/body/div/div[1]/div[1]/header/div[1]/div[2]/ul/li");
		
		By out=By.linkText("Logout");
		Thread.sleep(3000);
		driver.findElement(droplog).click();
		Thread.sleep(6000);
		driver.findElement(out).click();
		Thread.sleep(6000);
	driver.close();

	}

}