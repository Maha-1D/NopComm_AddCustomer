package pages;

import org.junit.Assert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class LoginPage {

	WebDriver driver;

    public LoginPage(WebDriver rdriver) {

        // this.driver = driver;
        driver = rdriver;
        PageFactory.initElements(rdriver, this);

    }

    // Identification

//  By txtEmail = By.id("Email");
//  By txtPass = By.id("Password");
//  By chkRem = By.xpath("//input[@name='RememberMe']");
//  By btnLogin = By.tagName("button");

    
    
    @FindBy(id = "Email")
    WebElement txt_Email;
    
    @FindBy(id = "Password")
    WebElement txt_Pass;
    
    @FindBy(xpath  = "//input[@name='RememberMe']")
    WebElement chk_rem;
    
    @FindBy(tagName  = "button")
    WebElement btn_Login;
    
    @FindBy(linkText   = "Logout")
    WebElement btn_Logout;
    
    // Methods

    public void enterEmail(String email) {

        txt_Email.clear();
        txt_Email.sendKeys(email);
    }

    public boolean verifyElementPresent(By eleLocator) {

        return driver.findElement(eleLocator).isDisplayed();
    }

//  public boolean verifyEmailTxtboxDispalyed() {
//
//      return verifyElementPresent(txtEmail);
//  }

    public void enterPass(String pwd) {

        txt_Pass.clear();
        txt_Pass.sendKeys(pwd);
    }

    public void clickRememberCheckbox() {

        chk_rem.click();
    }

    public void clickLoginButton() {

        btn_Login.click();
    }

    public void clickLogoutButton() {

        btn_Logout.click();
    }
    
    public void verificationAppTitle(String expectedValue) {

        Assert.assertEquals(driver.getTitle(), expectedValue);
    }

}
