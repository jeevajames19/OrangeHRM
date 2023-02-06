//package pom;
//
//import org.testng.Assert;
//import org.testng.annotations.Listeners;
//import org.testng.annotations.Test;
//
//
//
//@Listeners({AllureListeners.class})
//public class Testhrm extends Baseclass{
// 
//	
//	@Test(priority=1)
//	public void loginhrm() throws InterruptedException {
//	Baseclass bs =new Baseclass();
//	bs.initialize_Driver();
//		driver.get("https://opensource-demo.orangehrmlive.com/web/index.php/auth/login");
//		    Thread.sleep(4000);
//		    
//     Pagelogin login =new Pagelogin(driver);
//     Thread.sleep(4000);
//	    
//		
//	login.credentials("Admin","admin123");
//	Thread.sleep(4000);
//    
//	login.logging();
//	Thread.sleep(4000);
//    
//	String Actualurl=driver.getCurrentUrl();
//	Thread.sleep(6000);
//    
//	Assert.assertEquals(Actualurl, "https://opensource-demo.orangehrmlive.com/webserve/index.php");
//	
//	}
//	
//	/*@Test(priority=2)
//	public void admin() throws InterruptedException {
//		
//	adminpage admin=new adminpage(driver);		
//		
//	Thread.sleep(4000);
//    
//	admin.admin();
//	Thread.sleep(4000);
//    
//	admin.username();
//	Thread.sleep(4000);
//    
//    admin.Droprole();	
//    Thread.sleep(4000);
//    
//	admin.DropStatus();	
//	Thread.sleep(4000);
//    
//	admin.submit();
//	Thread.sleep(4000);
//    
//	admin.employee();
//	Thread.sleep(4000);
//    
//	
//	}*/
//	@Test(priority=2)
//	public void admin_table() throws InterruptedException
//	{
//		adminpage admin=new adminpage(driver);		
//		
//		Thread.sleep(4000);
//	    
//		admin.admin();
//		Thread.sleep(4000);
//		AdminWebtable tables=new AdminWebtable(driver);		
//		
//		tables.tabledetails();
//		
//		
//	}
//	
//	@Test(priority=3)
//	public void logut() throws InterruptedException {
//		
//	Pagelogout logout= new Pagelogout(driver);	
//	Thread.sleep(4000);
//    
//	logout.logout();
//	String Actualurl=driver.getCurrentUrl();
//	Assert.assertEquals(Actualurl, "https://opensource-demo.orangehrmlive.com/web/index.php/auth/login");
//	
//	driver.close();
//	}
//	
//	
//	
//	
//}
