package pom;

import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.testng.ITestContext;
import org.testng.ITestListener;
import org.testng.ITestResult;

import io.qameta.allure.Attachment;


public class AllureListeners implements ITestListener {


	
@Override
	public void onTestFailedButWithinSuccessPercentage(ITestResult result) {
		// TODO Auto-generated method stub
	System.out.println("i am on test Failure method"+getTestMethodname(result)+"Partially passed but Failed");
    Object testclass =result.getInstance();
     WebDriver driver= baseclass.getDriver();
	if(driver instanceof WebDriver)
{
System.out.println("Screenshot captured for"+getTestMethodname(result));			
	
	saveFailureScreenShot(driver);
}	
saveTextlog(getTestMethodname(result)+"partially passed but failed case is been screenshotted");
}

	



@Override
	public void onStart(ITestContext context) {

	System.out.println("on Start "+ context.getName());
	context.setAttribute("WebDriver", baseclass.getDriver());
	}


@Override
	public void onFinish(ITestContext context) {
	System.out.println("on Finish "+ context.getName());

	}

@Override
	public void onTestStart(ITestResult result)
	{
		System.out.println(getTestMethodname(result)+"is Started");	
		
		
	}


@Override
	public void onTestSuccess(ITestResult result) {
			// TODO Auto-generated method stub
			
			System.out.println(getTestMethodname(result)+"is passed");	
			
		}

@Override
	public void onTestFailure(ITestResult result) {
		// TODO Auto-generated method stub
				System.out.println("i am on test Failure method"+getTestMethodname(result)+"Failed");
                Object testclass =result.getInstance();
	             WebDriver driver= baseclass.getDriver();
				if(driver instanceof WebDriver)
	{
	System.out.println("Screenshot captured for"+getTestMethodname(result));			
				
				saveFailureScreenShot(driver);
	}	
	saveTextlog(getTestMethodname(result)+"failed case is been screenshotted");
	}






	private static String getTestMethodname(ITestResult result)
	{
	return result.getMethod().getConstructorOrMethod().getName();

	}
   
@Attachment
	public byte []saveFailureScreenShot(WebDriver driver)
	{
	return ((TakesScreenshot)driver).getScreenshotAs(OutputType.BYTES);
	}
	@Attachment (value = "{0}" ,type="text/plain")
	public static String saveTextlog(String message)
	{
	return message;

	}

	
	


		}