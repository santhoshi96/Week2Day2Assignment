package week2.day2.assignment;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.Select;

import io.github.bonigarcia.wdm.WebDriverManager;

public class CreateContact {

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
		//click Contacts
		driver.findElement(By.linkText("Contacts")).click();
		//click create contact
		driver.findElement(By.linkText("Create Contact")).click();
		//firstname
		driver.findElement(By.id("firstNameField")).sendKeys("santa");
		//lastname
		driver.findElement(By.id("lastNameField")).sendKeys("meenu");
		//firstname(local)
		driver.findElement(By.id("createContactForm_firstNameLocal")).sendKeys("san");
		//secondname(local)
		driver.findElement(By.id("createContactForm_lastNameLocal")).sendKeys("mee");
		//department
		driver.findElement(By.id("createContactForm_departmentName")).sendKeys("testing");
		//description
		driver.findElement(By.id("createContactForm_description")).sendKeys("Happy testing");
		//email
		driver.findElement(By.id("createContactForm_primaryEmail")).sendKeys("xyz@gmail.com");
		//state/province
		WebElement dropdown = driver.findElement(By.name("generalStateProvinceGeoId"));
		Select dd = new Select(dropdown);
		dd.selectByVisibleText("84057");
		//click create contact
		driver.findElement(By.name("submitButton")).click();
		//click edit
		Thread.sleep(3000);
		driver.findElement(By.linkText("Edit")).click();
		//clear description
		driver.findElement(By.id("updateContactForm_description")).clear();
		//important note
		driver.findElement(By.id("updateContactForm_importantNote")).sendKeys("Week2 assignment");
		//click update
		driver.findElement(By.xpath("//input[@name='submitButton']")).click();
		//get Title of Resulting Page
		String text=driver.findElement(By.id("sectionHeaderTitle_contacts")).getText();
		System.out.println(text);
				
	}

}
