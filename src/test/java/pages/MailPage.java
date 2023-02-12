package pages;

import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class MailPage extends AbstractComponents {
    WebDriver driver;

    public MailPage(WebDriver driver) {
        super(driver);
        this.driver = driver;
        PageFactory.initElements(driver, this);
    }

    @FindBy(css = ".gb_h.gbii")
    WebElement profileButton;
    @FindBy(css = "div[class='T6SHIc'] div[class='BvDXcd'] div:nth-child(1)")
    WebElement logoutButton;
    @FindBy(css = ".T-I.T-I-KE.L3")
    WebElement createMailButton;
    @FindBy(xpath = "//input[@id=':10t']")
    WebElement recipientAddres;
    @FindBy(xpath = "//input[@id=':wv']")
    WebElement Subject;
    @FindBy(xpath = "//div[@id=':y4']")
    WebElement messageContent;
    @FindBy(xpath = "//div[@id=':wl']")
    WebElement sendButton;
    @FindBy(css = ".bqe")
    WebElement subjectOfReceivedMail;
    @FindBy(xpath = "//span[@id=':2o']")
    WebElement moreElements;
    @FindBy(css = "a[aria-label='Spam']")
    WebElement spamButton;
    @FindBy(css = ".TC")
    WebElement messageEmptySpamFolder;
    @FindBy(xpath = "//input[@placeholder='Przeszukaj pocztę']")
    WebElement searchField;
    @FindBy(xpath = "//input[@id=':wv']")
    WebElement subjectOfMessageAfterSearch;
    @FindBy(xpath = "//tr[@id=':cd']//td[1]")
    WebElement receivedMailButton;
    @FindBy(xpath = "//div[@id=':8k']")
    WebElement answearMailField;
    @FindBy(xpath = "//div[@aria-label='Odpowiedz']")
    WebElement replyButton;
    @FindBy(xpath = "//div[@id=':6z']")
    WebElement sendButtonForReplyMessage;
    @FindBy(xpath = "//span[@id=':5s']")
    WebElement starReceivedMail;


    public void starTheReceivedMail(){
        starReceivedMail.click();
    }

    public void clickOnReceivedMailAndReplyTheMessage() {
        receivedMailButton.click();
        replyButton.click();
        answearMailField.sendKeys("I answear to your mail.");
        sendButtonForReplyMessage.click();
    }

    public String getSubjectAfterSearchAction() {
        return subjectOfMessageAfterSearch.getText();
    }

    public void searchMessageBySubject() {
        searchField.sendKeys("Hello Tester!" + Keys.ENTER);
    }
    public void searchMessageByEmailAddress() {
        searchField.sendKeys("testworker00@gmail.com" + Keys.ENTER);
    }

    public void goToSpamFolder() {
        moreElements.click();
        spamButton.click();
    }
    public String getMessageOfEmptySpamFolder() {
        return messageEmptySpamFolder.getText();
    }
    public void createAndSendMailToMultipleRecipients(){
        createMailButton.click();
        recipientAddres.sendKeys("testworker00@gmail.com" +Keys.ENTER + "someemailwhereIcansendthemessage@gmail.com" +Keys.ENTER);
        Subject.sendKeys("Hello Tester!");
        messageContent.sendKeys("I would like to invite you to meeting at 9 p.m");
        sendButton.click();
    }


    public void createAndSendMailToRecipient() {
        createMailButton.click();
        recipientAddres.sendKeys("testworker00@gmail.com");
        Subject.sendKeys("Hello Tester!");
        messageContent.sendKeys("I would like to invite you to meeting at 9 p.m");
        sendButton.click();
    }
    public String getSubjectOfEmailText() {
        return subjectOfReceivedMail.getText();
    }

    public void clickProfileButtonAndLogoutAccount() {
        profileButton.click();
        logoutButton.click();
    }
}
