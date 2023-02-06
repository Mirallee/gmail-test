package pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class LandingPage extends AbstractComponents {
    WebDriver driver;

    public LandingPage(WebDriver driver) {
        super(driver);
        this.driver = driver;
        PageFactory.initElements(driver, this);
    }

    @FindBy(css = "#identifierId")
    WebElement userEmail;
    @FindBy(css = "input[name='Passwd']")
    WebElement userPassword;

    public void userLogin(String email, String password ){
        userEmail.sendKeys(email);
        userPassword.sendKeys(password);

    }
    public void goTo() {
        driver.get("https://accounts.google.com/v3/signin/identifier?dsh=S-166957957%3A1675283150536526&continue=https%3A%2F%2Fmail.google.com" +
                "%2Fmail%2Fu%2F0%2F%3Fhl%3Dpl&emr=1&followup=https%3A%2F%2Fmail.google.com%2Fmail%2Fu%2F0%2F%3Fhl%3Dpl&hl=pl" +
                "&osid=1&passive=1209600&service=mail&flowName=GlifWebSignIn&flowEntry=ServiceLogin&ifkv=AWnogHcwVr2FfaUr2X-" +
                "eLGDafa0oXfAmOXPbYX1BdYrf0W79qRSTxSYf4SG6bd2JRaBo67l-sdRBZg");
    }

}
