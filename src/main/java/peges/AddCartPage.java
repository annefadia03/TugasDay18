package peges;

import com.juaracoding.selenium.strategies.DriverSingleton;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class AddCartPage {
    private WebDriver driver;
    public AddCartPage(){
        this.driver = DriverSingleton.getDriver();
        PageFactory.initElements(driver, this);
    }
//
    @FindBy(xpath = "//a[@class='custom-logo-link']//img[@alt='ToolsQA Demo Site']")
    WebElement txtShopTools;
    @FindBy(xpath = "//a[normalize-space()='black ribbed short sleeve lettuce hem midi dress']")
    WebElement txtDress;
    @FindBy(xpath = "//h1[@class='page-title']")
    WebElement txtHeader;
    @FindBy(xpath = "//select[@id='pa_color']")
    WebElement selecColor;
    @FindBy(xpath = "//select[@id='pa_size']")
    WebElement selecSize;
    @FindBy(xpath = "//button[@class='qty-increase']")
    WebElement selecQYT;
    @FindBy(xpath = "//button[normalize-space()='Add to cart']")
    WebElement btnAddcart;
    @FindBy(xpath = "//span[@class='cart-name-and-total']")
    WebElement txtCart;
    @FindBy(xpath = "//h1[@class='page-title']")
    WebElement txtAddCart;

    public String getTxtDress(){
        return  txtDress.getText();
    }
    public String getTxtShopTools(){
        return txtShopTools.getText();
    }
    public String getTxtHeader(){
        return txtHeader.getText();
    }
    public String getTxtCart(){
        return txtCart.getText();
    }
    public String getTxtAddCart(){
        return txtAddCart.getText();
    }
    public void login(String selecColor, String selecSize, String selecQYT ){
        this.selecColor.sendKeys(selecColor);
        this.selecSize.sendKeys(selecSize);
        this.selecQYT.sendKeys(selecQYT);
        btnAddcart.click();
    }

}
