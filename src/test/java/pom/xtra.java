package pom;

import java.io.File;
import java.io.IOException;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.By;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.remote.RemoteWebDriver;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import io.qameta.allure.Description;
import io.qameta.allure.Epic;
import io.qameta.allure.Feature;
import io.qameta.allure.Severity;
import io.qameta.allure.SeverityLevel;
import io.qameta.allure.Story;

public class xtra {
	WebDriver driver;
	public static ThreadLocal<WebDriver> tdriver=new ThreadLocal<WebDriver>();

	@BeforeTest 
	public WebDriver setup() throws InterruptedException
	{
		// TODO Auto-generated method stub

		System.setProperty("webdriver.chrome.driver","C:\\Users\\R.Jeeva Pandian\\Downloads\\chromedriver.exe");
		driver =new ChromeDriver();

		driver.get("https://c3.omshealth.com/omstestdemo/#/");
		driver.manage().window().maximize();
		String logpage=(driver.getTitle()); 
		System.out.println("title page is:"+" "+logpage);
		//validating login page with invalid inputs
		driver.findElement(By.xpath("/html/body/div/div/div/div/div/div/form/div/div/div[1]/input")).sendKeys("cardio/omstes");
		driver.findElement(By.xpath("/html/body/div/div/div/div/div/div/form/div/div/div[2]/input")).sendKeys("Password@12305");
		driver.findElement(By.xpath("/html/body/div/div/div/div/div/div/form/div/div/div[3]/div[2]/button")).click();

		Thread.sleep(2000);
		if(driver.findElement(By.xpath("/html/body/div/div/div/div/div/div/form/div/h5")).isDisplayed());
		{
			String quotes=driver.findElement(By.xpath("/html/body/div/div/div/div/div/div/form/div/h5")).getText();
			System.out.println(quotes);
			//C3BASECLASS.CaptureScreenshot();
		}
		//validating login page with invalid inputs
		Thread.sleep(2000);
		driver.findElement(By.xpath("/html/body/div/div/div/div/div/div/form/div/div/div[1]/input")).clear();
		driver.findElement(By.xpath("/html/body/div/div/div/div/div/div/form/div/div/div[1]/input")).sendKeys("cardio/omstest");
		Thread.sleep(2000);
		driver.findElement(By.xpath("/html/body/div/div/div/div/div/div/form/div/div/div[2]/input")).clear();
		driver.findElement(By.xpath("/html/body/div/div/div/div/div/div/form/div/div/div[2]/input")).sendKeys("Password@12345");
		Thread.sleep(2000);
		driver.findElement(By.xpath("/html/body/div/div/div/div/div/div/form/div/div/div[3]/div[2]/button")).click();
		Thread.sleep(5000);
		boolean dashboard=driver.findElement(By.linkText("Billing")).isDisplayed();
		Thread.sleep(5000);
		if(dashboard==true)
		{
			System.out.println("valid user and password - login passed");
		}
		else
		{
			System.out.println("access denied please have vaild user and password");
		}
		tdriver.set(driver);
		return getDriver();


	}

	@Test (priority=1)
	@Description("CARDIOVASCUALAR INPUT VALIDATION")
	@Epic("OMS C3-CCM-CARE PLAN")
	@Feature("FEATURE : CAN HAVE ALL TYPES OF INPUTS(SPL,NUMBER,CHAR,STRING) IN ALL INPUTS BUT NOT IN SBP,DBP,HEART RATE,WEIGHT WHICH TAKES ONLY NUMBERS(INTEGERS)")
	@Story("Story: PATIENT'S CARDIOVASCULAR DATA")
	@Severity(SeverityLevel.NORMAL)
	public void CARDIOVASCULAR_TEST() throws InterruptedException, IOException
	{
		//billing



		Thread.sleep(5000);
		driver.findElement(By.linkText("Billing")).click();
		Thread.sleep(15000);
		driver.findElement(By.xpath("/html/body/div/div[15]/div/div/div/div[4]/div/div[3]/div/div/div/div[4]/div/div/div/div/div[1]/table/tbody/tr/td[1]/table/tr/td[1]")).click();
		Thread.sleep(20000);


		//notes
		driver.findElement(By.xpath("/html/body/div/div[24]/div/div/div/div[1]/div/div[1]/div[4]/div/div[5]/div/button")).click();
		Thread.sleep(1000); 

		//careplans (GENERAL INFO)    
		driver.findElement(By.linkText("Care Plans")).click();


		//REVIEW 
		driver.findElement(By.linkText("Review of Symptoms")).click();

		//CARDIOVASCULAR
		Thread.sleep(3000);

		driver.findElement(By.xpath("/html/body/div/div[24]/div/div/div/div[1]/div/div[1]/div[4]/div/div[5]/div/div/div/div[2]/form/div/div[4]/div/div/div[1]/div/table/tbody/tr[21]/td/button")).click();

		Thread.sleep(3000);

		//Input today’s BP/HR/Wt.reading

		//SBP

		driver.findElement(By.id("txt_cn_vitalsbp")).clear();

		driver.findElement(By.id("txt_cn_vitalsbp")).sendKeys("87");


		//DBP
		driver.findElement(By.id("txt_cn_today_vitalbp")).clear();
		driver.findElement(By.id("txt_cn_today_vitalbp")).sendKeys("69");

		//HEART RATE	
		driver.findElement(By.id("txt_cn_today_vitalhr")).clear();
		driver.findElement(By.id("txt_cn_today_vitalhr")).sendKeys("82");//SHOULD NOT ACCEPT BECAUSE SBP,HR,DBP,WT SHOULD BE IN INTEGERS


		//WIEGHT 
		driver.findElement(By.id("txt_cn_today_vitalwei")).clear();
		driver.findElement(By.id("txt_cn_today_vitalwei")).sendKeys("70");


		//DATE VALIDATION
		driver.findElement(By.xpath("/html/body/div/div[24]/div/div/div/div[1]/div/div[1]/div[4]/div/div[5]/div/div/div/div[2]/form/div/div[4]/div/div/div[1]/div/table/tbody/tr[22]/td/table/tbody/tr[11]/td/div/div[1]/input")).click();
		for(int i=100;i>=1;i--)
		{
			//	Thread.sleep(2000);
			driver.findElement(By.xpath("/html/body/div/div[24]/div/div/div/div[1]/div/div[1]/div[4]/div/div[5]/div/div/div/div[2]/form/div/div[4]/div/div/div[1]/div/table/tbody/tr[22]/td/table/tbody/tr[11]/td/div/div[2]/header/span[1]")).click();
			//Thread.sleep(2000);
			String month=(driver.findElement(By.xpath("/html/body/div/div[24]/div/div/div/div[1]/div/div[1]/div[4]/div/div[5]/div/div/div/div[2]/form/div/div[4]/div/div/div[1]/div/table/tbody/tr[22]/td/table/tbody/tr[11]/td/div/div[2]/header/span[2]")).getText());

			if(month.equals("Jun 2022"))

			{
				String date1=(driver.findElement(By.xpath("/html/body/div/div[24]/div/div/div/div[1]/div/div[1]/div[4]/div/div[5]/div/div/div/div[2]/form/div/div[4]/div/div/div[1]/div/table/tbody/tr[22]/td/table/tbody/tr[11]/td/div/div[2]/div/span[30]")).getText());

				driver.findElement(By.xpath("/html/body/div/div[24]/div/div/div/div[1]/div/div[1]/div[4]/div/div[5]/div/div/div/div[2]/form/div/div[4]/div/div/div[1]/div/table/tbody/tr[22]/td/table/tbody/tr[11]/td/div/div[2]/div/span[30]")).click();
				Thread.sleep(2000);
				System.out.println("fixed date is :"+month +"-"+date1);
				break;
			} 

			else
			{
				Thread.sleep(2000);
				continue;
			}


			//future date validation for cardiovascular

			/*
	driver.findElement(By.xpath("/html/body/div/div[24]/div/div/div/div[1]/div/div[1]/div[4]/div/div[5]/div/div/div/div[2]/form/div/div[4]/div/div/div[1]/div/table/tbody/tr[22]/td/table/tbody/tr[11]/td/div/div[1]/input")).click();
	for(int i=100;i>=1;i--)
	{
		Thread.sleep(2000);
		driver.findElement(By.xpath("/html/body/div/div[24]/div/div/div/div[1]/div/div[1]/div[4]/div/div[5]/div/div/div/div[2]/form/div/div[4]/div/div/div[1]/div/table/tbody/tr[22]/td/table/tbody/tr[11]/td/div/div[2]/header/span[3]")).click();
		Thread.sleep(2000);
		String month=(driver.findElement(By.xpath("/html/body/div/div[24]/div/div/div/div[1]/div/div[1]/div[4]/div/div[5]/div/div/div/div[2]/form/div/div[4]/div/div/div[1]/div/table/tbody/tr[22]/td/table/tbody/tr[11]/td/div/div[2]/header/span[2]")).getText());

		if(month.equals("Jun 2023"))

		{
			String date1=(driver.findElement(By.xpath("/html/body/div/div[24]/div/div/div/div[1]/div/div[1]/div[4]/div/div[5]/div/div/div/div[2]/form/div/div[4]/div/div/div[1]/div/table/tbody/tr[22]/td/table/tbody/tr[11]/td/div/div[2]/div/span[30]")).getText());

			driver.findElement(By.xpath("/html/body/div/div[24]/div/div/div/div[1]/div/div[1]/div[4]/div/div[5]/div/div/div/div[2]/form/div/div[4]/div/div/div[1]/div/table/tbody/tr[22]/td/table/tbody/tr[11]/td/div/div[2]/div/span[30]")).click();
			Thread.sleep(2000);
			System.out.println("fixed date is :"+month +"-"+date1);
			break;

		} 

		else
		{
			Thread.sleep(2000);
			continue;
		}

			 */

		}	

		driver.findElement(By.xpath("/html/body/div/div[24]/div/div/div/div[1]/div/div[1]/div[4]/div/div[5]/div/div/div/div[2]/form/div/div[4]/div/div/div[1]/div/table/tbody/tr[22]/td/table/tbody/tr[12]/td/textarea")).clear();

		driver.findElement(By.xpath("/html/body/div/div[24]/div/div/div/div[1]/div/div[1]/div[4]/div/div[5]/div/div/div/div[2]/form/div/div[4]/div/div/div[1]/div/table/tbody/tr[22]/td/table/tbody/tr[12]/td/textarea")).sendKeys("testing@1234");


		//Have you been experiencing any of the following symptoms?		

		//if denies checkbox is switched then all other symptoms should dis-selected


		//Palpitations

		boolean cardiocheck1=(driver.findElement(By.id("rdo_cn_htn_cardio_pal")).isSelected());
		Thread.sleep(1000);
		if (cardiocheck1==true)
		{
			driver.findElement(By.id("rdo_cn_htn_cardio_pal")).click();

		}
		else
		{
			driver.findElement(By.id("rdo_cn_htn_cardio_pal")).click();

		}
		//dizziness
		boolean cardiocheck2=(driver.findElement(By.id("rdo_cn_htn_cardio_syn")).isSelected());
		Thread.sleep(1000);
		if (cardiocheck2==true)
		{
			driver.findElement(By.id("rdo_cn_htn_cardio_syn")).click();

		}
		else
		{
			driver.findElement(By.id("rdo_cn_htn_cardio_syn")).click();

		}
		//chest pain
		boolean cardiocheck3=(driver.findElement(By.id("rdo_cn_htn_cardio_pan")).isSelected());
		Thread.sleep(1000);
		if (cardiocheck3==true)
		{
			driver.findElement(By.id("rdo_cn_htn_cardio_pan")).click();

		}
		else
		{
			driver.findElement(By.id("rdo_cn_htn_cardio_pan")).click();

		}
		//weaknessor fatigue
		boolean cardiocheck4=(driver.findElement(By.id("rdo_cn_htn_cardio_fat")).isSelected());
		Thread.sleep(1000);
		if (cardiocheck4==true)
		{
			driver.findElement(By.id("rdo_cn_htn_cardio_fat")).click();

		}
		else
		{
			driver.findElement(By.id("rdo_cn_htn_cardio_fat")).click();

		}
		//swellling
		boolean cardiocheck5=(driver.findElement(By.id("rdo_cn_htn_cardio_swe")).isSelected());
		Thread.sleep(1000);
		if (cardiocheck5==true)
		{
			driver.findElement(By.id("rdo_cn_htn_cardio_swe")).click();

		}
		else
		{
			driver.findElement(By.id("rdo_cn_htn_cardio_swe")).click();

		}
		//Claudication
		boolean cardiocheck6=(driver.findElement(By.id("rdo_cn_htn_cardio_cal")).isSelected());
		Thread.sleep(1000);
		if (cardiocheck6==true)
		{
			driver.findElement(By.id("rdo_cn_htn_cardio_cal")).click();

		}
		else
		{
			driver.findElement(By.id("rdo_cn_htn_cardio_cal")).click();

		}
		//denies any cardio symptoms
		boolean cardiocheck7=(driver.findElement(By.id("rdo_cn_htn_cardio_cal_denies")).isSelected());
		Thread.sleep(1000);
		if (cardiocheck7==true)
		{
			driver.findElement(By.id("rdo_cn_htn_cardio_cal_denies")).click();

		}
		else
		{
			driver.findElement(By.id("rdo_cn_htn_cardio_cal_denies")).click();


		}

		//after enabling deny switch
		System.out.println("denies switch is enabled");
		Thread.sleep(2000);
		System.out.println("when denies checkbox is switched then all other symptoms should dis-selected ");
		Thread.sleep(3000);
		boolean cardiocheck1a=(driver.findElement(By.id("rdo_cn_htn_cardio_pal")).isSelected());
		if(cardiocheck1a==false)
		{
			System.out.println("Palpitations is unselected");
		}
		else
		{
			System.out.println("Palpitations is  not unselected");

		}

		boolean cardiocheck2a=(driver.findElement(By.id("rdo_cn_htn_cardio_syn")).isSelected());
		if(cardiocheck2a==false)
		{
			System.out.println("dizziness is unselected");
		}
		else
		{
			System.out.println("dizziness is  not unselected");

		}

		boolean cardiocheck3a=(driver.findElement(By.id("rdo_cn_htn_cardio_fat")).isSelected());
		if(cardiocheck3a==false)
		{
			System.out.println("chest pain  is unselected");
		}
		else
		{
			System.out.println("chest pain is  not unselected");

		}
		
		boolean cardiocheck4a=(driver.findElement(By.id("rdo_cn_htn_cardio_swe")).isSelected());
		if(cardiocheck4a==false)
		{
			System.out.println("swelling is unselected");
		}
		else
		{
			System.out.println("swelling is  not unselected");

		}
		
		boolean cardiocheck5a=(driver.findElement(By.id("rdo_cn_htn_cardio_cal")).isSelected());
		if(cardiocheck5a==false)
		{
			System.out.println("Claudication is unselected");
		}
		else
		{
			System.out.println("Claudication is  not unselected");

		}	
		Thread.sleep(3000);

		WebElement ele=driver.findElement(By.xpath("//*[@id=\"q_hyp_form\"]/div/table/tbody/tr[22]/td/table"));
		//File
		TakesScreenshot takesScreenshot = (TakesScreenshot) ele;
		File sourceFile = takesScreenshot.getScreenshotAs(OutputType.FILE);
		File destFile = new File("./Screenshots/img1.jpg");
		FileUtils.copyFile(sourceFile, destFile);
		System.out.println("Screenshot saved successfully");
		Thread.sleep(4000);

	}
	@AfterTest


	public void teardown() throws InterruptedException
	{
		//LOGOUT
		Thread.sleep(2000);
		driver.findElement(By.xpath("/html/body/div/div[24]/div/div/div/div[1]/div/div[1]/div[4]/div/div[5]/div/div/div/div[2]/form/div/div[4]/div/div/div[2]/table/tr/div[2]/button[4]")).click();
		Thread.sleep(3000);

		Thread.sleep(2000);
		driver.findElement(By.id("dashboard")).click();

		driver.findElement(By.xpath("/html/body/div/div[24]/div/div/div/nav/div/div[2]/ul[2]/li")).click();

		Thread.sleep(2000);

		driver.findElement(By.linkText("Logout")).click();

		Thread.sleep(1000);
		boolean frontpage=(driver.findElement(By.xpath("/html/body/div/div/div/div/div/div/div")).isDisplayed());
		if (frontpage=true)
		{
			System.out.println("logged out successfully");

		}
		else
		{
			System.out.print("logout failed");
		}
		Thread.sleep(2000);
		driver.close();
	}



	public static synchronized WebDriver getDriver() {
		return tdriver.get();
	}



}
