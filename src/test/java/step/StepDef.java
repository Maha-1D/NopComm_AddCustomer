package step;

import java.io.FileInputStream;
import java.io.IOException;
import java.util.Properties;

import org.apache.log4j.Level;
import org.apache.log4j.Logger;
import org.apache.log4j.PropertyConfigurator;
import org.junit.Assert;
import org.openqa.selenium.By;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;

import cucumber.api.java.Before;
import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;
import io.github.bonigarcia.wdm.WebDriverManager;
import pages.AddCustomerPage;
import pages.LoginPage;

public class StepDef extends BaseClass{
	
	String email;
	String fName;
	String lName;
	
	@Before
	public void setup() throws IOException{
				//Logging
				logger=Logger.getLogger("nopCommerceDemoRun");
				PropertyConfigurator.configure("./testData/log4j.properties");
				logger.setLevel(Level.DEBUG);
				
				//Load properties file
				configProp= new Properties();
				FileInputStream configPropfile = new FileInputStream("./testData/config.properties");
				configProp.load(configPropfile);
				
				String br=configProp.getProperty("browser");
				
				//Launching browser
				if (br.equalsIgnoreCase("firefox")) {
					WebDriverManager.firefoxdriver().setup();
					driver = new FirefoxDriver();
				}

				else if (br.equals("chrome")) {
					WebDriverManager.chromedriver().setup();
					driver = new ChromeDriver();
				}
				
				else if (br.equals("edge")) {
					WebDriverManager.edgedriver().setup();
					driver = new EdgeDriver();
				}
	}
	@Given("User launch chrome browser")
	public void user_launch_chrome_browser() {
		logger.info("************* Launching Browser *****************");
	    lp = new LoginPage(driver);

	}

	@When("user open app URL {string}")
	public void user_open_app_URL(String url) {
		logger.info("************* Opening URL  *****************");
		driver.get(url);
		driver.manage().window().maximize();
	}
	
	@When("user enter email as {string} and password as {string}")
	public void user_enter_email_as_and_password_as(String email, String pwd) {
		logger.info("************* Prvding user and password *****************");

		lp.enterEmail(email);
        lp.enterPass(pwd);
        
		logger.info("************* entered user and password on application $$$$*****************");

	}

	@When("click on Login")
	public void click_on_Login() {
		logger.info("************* click on login *****************");
        lp.clickLoginButton();
	}

	@Then("User can view Dashboard")
	public void user_can_view_Dashboard(){
		acp=new AddCustomerPage(driver);
		
		logger.info("********* Verifying Dashboard page title after login successful **************");
		Assert.assertEquals("Dashboard / nopCommerce administration",acp.getPageTitle());
		
		}

	
	
	@When("User click on customers Menu")
	public void user_click_on_customers_Menu() throws InterruptedException {
		Thread.sleep(3000);
		logger.info("********* Clicking on customer main menu **************");
		acp.clickOnCustomersMenu();
	}

	@When("click on customers Menu Item")
	public void click_on_customers_Menu_Item() throws InterruptedException {
		Thread.sleep(2000);
		logger.info("********* Clicking on customer sub menu **************");
		acp.clickOnCustomersMenuItem();
	}

	@When("click on Add new button")
	public void click_on_Add_new_button() throws InterruptedException {
		Thread.sleep(2000);
		 acp.clickOnAddnew();
	}

	@Then("User can view Add new customer page")
	public void user_can_view_Add_new_customer_page() {
		 Assert.assertEquals("Add a new customer / nopCommerce administration", acp.getPageTitle());
	}

	@When("User enter customer info")
	public void user_enter_customer_info() throws InterruptedException {
		
				//read data from csv/text/excel or DB
				email = randomestring() + "@gmail.com";
				System.out.println("Email Value: " + email);				
				acp.setEmail(email);
				
				Thread.sleep(5000);
				acp.setPassword("test123");
				
				fName = randomestring();
				System.out.println("FirstName Value: " + fName);
				acp.setFirstName(fName);
				
				lName = randomestring();
				System.out.println("LastName Value: " + lName);
				acp.setLastName(lName);
				
				acp.setGender("Female");

				acp.setDob("1/12/1999"); // Format: D/MM/YYY
				
				Thread.sleep(3000);
				
				acp.setCompanyName("XYZ");
				acp.setAdminContent("This is for testing purpose.........");
				Thread.sleep(3000);
				
				acp.setCustomerRoles("Guest");
				Thread.sleep(3000);

				acp.setManagerOfVendor("Vendor 2");
				
				
				
	}

	@When("click on Save button")
	public void click_on_Save_button() throws InterruptedException {
		logger.info("********* Saving customer details **************");   
		acp.clickOnSave();
		Thread.sleep(2000);	}

	@Then("User can view confirmation message {string}")
	public void user_can_view_confirmation_message(String string) {
		Assert.assertTrue(driver.findElement(By.tagName("body")).getText()
				.contains("new customer has been added successfully"));
	}

	@Then("close browser")
	public void close_browser() throws InterruptedException {
		logger.info("************* closing browser *****************");
		   driver.quit();
	}
	
}
