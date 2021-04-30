package week2.day2.assignment;

import org.openqa.selenium.By;
import org.openqa.selenium.chrome.ChromeDriver;

import io.github.bonigarcia.wdm.WebDriverManager;

public class DeleteLead {

	public static void main(String[] args) throws InterruptedException {
		// TODO Auto-generated method stub
		WebDriverManager.chromedriver().setup();
		ChromeDriver driver = new ChromeDriver();
		driver.get("http://leaftaps.com/opentaps");
		driver.manage().window().maximize();
		//username
		driver.findElement(By.id("username")).sendKeys("DemoSalesManager");
		//password
		driver.findElement(By.id("password")).sendKeys("crmsfa");
		//login button
		driver.findElement(By.className("decorativeSubmit")).click();
		//CRM/SFA
		driver.findElement(By.linkText("CRM/SFA")).click();
		//Click Lead
		driver.findElement(By.linkText("Leads")).click();
		//Click findlead
		driver.findElement(By.linkText("Find Leads")).click();
		//Click Phone
		driver.findElement(By.xpath("//span[text()='Phone']")).click();
		//Enter Phone Number
		driver.findElement(By.name("phoneNumber")).sendKeys("322-5111");
		//Click find leads
		driver.findElement(By.xpath("//button[text()='Find Leads']")).click();
	    //capture lead
		String idcap = driver.findElement(By.linkText("DemoLeadA")).getText();
		driver.findElement(By.linkText("DemoLeadA")).click();
		//click delete
		driver.findElement(By.linkText("Delete")).click();
		//click find leds
		driver.findElement(By.linkText("Find Leads")).click();
// Enter the lead id
		driver.findElement(By.name("id")).sendKeys(idcap);

		// Click on Find Leads button
		driver.findElement(By.xpath("//button[text()='Find Leads']")).click();
		
		Thread.sleep(2000);

		// No Records Found - Verification
		String leadi_del = driver.findElement(By.xpath("//div[text()='No records to display']")).getText();

		if (leadi_del.contains("No records to display"))

		{
			System.out.println("No Records Found - Verified");
		} else {
			System.out.println("Verified - Records found");
		}
	}

}
