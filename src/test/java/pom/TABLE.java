package pom;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.Test;

import io.github.bonigarcia.wdm.WebDriverManager;

public class TABLE {

	
	WebDriver driver;
	@Test
	public void table_test() throws InterruptedException
	{	
	WebDriverManager.chromedriver().setup();
	driver=new ChromeDriver();
	
	driver.navigate().to("https://demo.guru99.com/test/web-table-element.php");
	
	WebElement table=driver.findElement(By.className("dataTable"));
	
	
	//headers
	List<WebElement> headers=table.findElements(By.tagName("th"));
 	int head=headers.size();
 	System.out.println(head);
	for(WebElement i:headers)	
 	{
 		System.out.println(i.getText());
 	}
	
	
	//rows
	List<WebElement> row=table.findElements(By.xpath("//*[@id=\"leftcontainer\"]/table/tbody/tr"));
	int rows= row.size();
	System.out.println(rows);
	
	
	//datas

	List<WebElement> data=table.findElements(By.xpath("//*[@id=\"leftcontainer\"]/table/tbody/tr/td"));
	int totaldata= data.size();
	System.out.println(totaldata);
	
	for(int i=0;i<rows;i++)
	{
		List<WebElement> datas=row.get(i).findElements(By.tagName("td")); 
		WebElement 	company=datas.get(0);

	String name= company.getText();
	System.out.println(name);
		if(name.equals("YES Bank Ltd."))
		{
System.out.println(i);
			WebElement companyprice=row.get(i).findElement(By.tagName("/td/td/td/td"));
		String cmp=companyprice.getText();
			System.out.println(cmp);	
		}
		//*[@id="leftcontainer"]/table/tbody/tr[12]/td[4]
		//*[@id="leftcontainer"]/table/tbody/tr[12]/td[5]
		
		
	}
	
	
	
	
	
	
	
	
	
	
	
	}
	
	
	
	
	
	
}
