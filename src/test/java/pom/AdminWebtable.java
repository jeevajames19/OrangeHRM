package pom;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class AdminWebtable {
WebDriver driver;

	public AdminWebtable(WebDriver driver)
	{
		this.driver=driver;
	}

 By  adtable =By.xpath("/html/body/div/div[1]/div[2]/div[2]/div/div[2]/div[3]");
 


public void tabledetails()

{
WebElement table=driver.findElement(adtable);	
List<WebElement> headers=table.findElements(By.xpath("//div[@role='columnheader']"));	

System.out.println("Total no.of columns  present in the admin tables are: ");
int columns=headers.size();
System.out.println(columns);


for(WebElement i:headers)
{
	System.out.println("the headers present in the admin tables are: ");
	System.out.println(i.getText());

}


List<WebElement> rows =table.findElements(By.xpath("//div[@role='row']"));	

System.out.println("Total no.of rows  present in the admin tables are: ");
System.out.println(rows.size());

for (WebElement row:rows)
{
List<WebElement> firstrows_firsrcolums_elements=row.findElements(By.xpath("//div[@role='cell']"));
WebElement firstcolumn=firstrows_firsrcolums_elements.get(1);
System.out.println(firstcolumn.getText());

}



}





}















