package peges;

import com.juaracoding.selenium.strategies.DriverSingleton;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class LoginPageT18 {
    private WebDriver driver;
    public LoginPageT18(){
        this.driver = DriverSingleton.getDriver();
        PageFactory.initElements(driver, this);
    }

    @FindBy(xpath = "//input[@id='username']")
    WebElement username;
    @FindBy(xpath = "//input[@id='password']" )
    WebElement password;
    @FindBy(xpath = "//button[@name='login']")
    WebElement btnLogin;
    @FindBy(xpath = "//h1[@class='page-title']")
    WebElement txtMyaccount;
    @FindBy(xpath = "//h2[normalize-space()='Login']")
    WebElement txtLoginTitle;

    @FindBy(xpath = "//div[@id='primary']//li[1]")
    WebElement txtErrorLostpassword;

    public String getTxtLoginTitle(){
        return txtLoginTitle.getText();
    }
    public String getTxtMyaccount(){
        return txtMyaccount.getText();
    }
    public String getTxtErrorLostpassword(){
        return txtErrorLostpassword.getText();
    }

    public void login(String username, String password){
        this.username.sendKeys(username);
        this.password.sendKeys(password);
        btnLogin.click();
    }
}
