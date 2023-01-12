package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.Select;

public class AddCustomerPage {

	WebDriver driver;

    public AddCustomerPage(WebDriver rdriver) {
        driver = rdriver;
        PageFactory.initElements(rdriver, this);
    }
    
    @FindBy(xpath="//p[text()[normalize-space()='Customers']]")
    WebElement customers_menu;
	
//	@FindBy(xpath="//p[text()='Customers']")
	@FindBy(xpath="/html/body/div[3]/aside/div/div[4]/div/div/nav/ul/li[4]/ul/li[1]/a/p")
	WebElement customersMenu;
	
	@FindBy(xpath="//a[@href='/Admin/Customer/Create']")
	WebElement btnAdd;
	
	@FindBy(xpath="//input[@id='Email']")
	WebElement user_Email;
	
	@FindBy(xpath="//input[@id='Password']")
	WebElement user_Password;
	
	@FindBy(xpath="(//div[@class='k-multiselect-wrap k-floatwrap'])[2]")
	WebElement customerRoles;
	
	@FindBy(xpath="//*[@id=\"SelectedCustomerRoleIds_taglist\"]/li/span[2]")
	WebElement defaultRole;
	
	@FindBy(xpath="//li[contains(text(),'Administrators')]")
	WebElement administrationItem;
	
	@FindBy(xpath="//li[contains(text(),'Registered')]")
	WebElement registerItem;
	
	@FindBy(xpath="//li[contains(text(),'Guests')]")
	WebElement guestItem;
	
	@FindBy(xpath="//li[contains(text(),'Vendors')]")
	WebElement vendorItem;
		
	@FindBy(xpath="//*[@id='VendorId']")
	WebElement vendor;
	
	
	@FindBy(id="Gender_Female")
	WebElement FemaleGender;
	
	
	@FindBy(xpath="//input[@id='FirstName']")
	WebElement firstName;
	
	
	@FindBy(xpath="//input[@id='LastName']")
	WebElement lastName;
	
	
	@FindBy(xpath="//input[@id='DateOfBirth']")
	WebElement dob;
	
	
	@FindBy(xpath="//input[@id='Company']")
	WebElement companyName;
	
	@FindBy(xpath="//textarea[@id='AdminComment']")
	WebElement adminContent;
	
	@FindBy(xpath="//button[@name='save']")
	WebElement btnSave;
	
	public String getPageTitle()
	{
		return driver.getTitle();
	}
	
	public void clickOnCustomersMenu() throws InterruptedException {
		customers_menu.click();
		Thread.sleep(1000);
	}

	public void clickOnCustomersMenuItem() throws InterruptedException {
		customersMenu.click();
		Thread.sleep(1000);
	}
	
	public void clickOnAddnew() throws InterruptedException {
		btnAdd.click();
		Thread.sleep(3000);
	}
	
	public void setEmail(String email)
	{
		user_Email.sendKeys(email);
	}
	
	public void setPassword(String password)
	{
		user_Password.sendKeys(password);
	}
	
	
	public void setCustomerRoles(String role) throws InterruptedException 
		{
			
			if(!role.equals("Vendors")) //If role is vendors should not delete Register as per req.
			{
				defaultRole.click();
			}
			
			customerRoles.click();
						
			WebElement listitem;
			
			Thread.sleep(3000);
						
			if(role.equals("Administrators"))
			{
				listitem=administrationItem; 
			}
			else if(role.equals("Guests"))
			{
				listitem=guestItem;
			}
			else if(role.equals("Registered"))
			{
				listitem=registerItem;
			}
			else if(role.equals("Vendors"))
			{
				listitem=vendorItem;
			}
			else
			{
				listitem=guestItem;
			}
						
			//listitem.click();
			//Thread.sleep(3000);
			
			JavascriptExecutor js = (JavascriptExecutor)driver;
			js.executeScript("arguments[0].click();", listitem);
			
	}

	public void setManagerOfVendor(String value)
	{
		Select drp=new Select(vendor);
		drp.selectByVisibleText(value);
	}
	
	public void setGender(String gender) {

		FemaleGender.click();
	}
	
	public void setFirstName(String fname)
	{
		firstName.sendKeys(fname);
	}
	
	public void setLastName(String lname)
	{
		lastName.sendKeys(lname);
	}
	
	public void setDob(String dob1)
	{
		dob.sendKeys(dob1);
	}
	
	public void setCompanyName(String comname)
	{
		companyName.sendKeys(comname);
	}
	
	public void setAdminContent(String content)
	{
		adminContent.sendKeys(content);
	}
	
	public void clickOnSave()
	{
		btnSave.click();
	}
	
	
}
