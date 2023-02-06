package tests;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;

import java.time.Duration;

public class ValidTests {
    public static void main(String[] args) {
        WebDriverManager.chromedriver().setup();
        WebDriver driver = new ChromeDriver();
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
        driver.get("https://accounts.google.com/v3/signin/identifier?dsh=S-166957957%3A1675283150536526&continue=https%3A%2F%2Fmail.google.com" +
                "%2Fmail%2Fu%2F0%2F%3Fhl%3Dpl&emr=1&followup=https%3A%2F%2Fmail.google.com%2Fmail%2Fu%2F0%2F%3Fhl%3Dpl&hl=pl" +
                "&osid=1&passive=1209600&service=mail&flowName=GlifWebSignIn&flowEntry=ServiceLogin&ifkv=AWnogHcwVr2FfaUr2X-" +
                "eLGDafa0oXfAmOXPbYX1BdYrf0W79qRSTxSYf4SG6bd2JRaBo67l-sdRBZg");
        driver.findElement(By.cssSelector("#identifierId")).sendKeys("testworker00@gmail.com");
        driver.findElement(By.cssSelector(".VfPpkd-LgbsSe.VfPpkd-LgbsSe-OWXEXe-k8QpJ.VfPpkd-LgbsSe-OWXEXe-dgl2Hf.nCP5yc.AjY5Oe.DuMIQc.LQeN7.qIypjc.TrZEUc.lw1w4b")).click();
        driver.findElement(By.cssSelector("input[name='Passwd']")).sendKeys("testasdasdasd1@@3" + Keys.ENTER);
        String failMessage = driver.findElement(By.cssSelector("div[class='OyEIQ uSvLId'] div span")).getText();
        Assert.assertTrue(failMessage.equalsIgnoreCase("Nieprawidłowe hasło. Spróbuj jeszcze raz lub kliknij „Nie pamiętasz hasła?”, by je zresetować."));
    }
}
