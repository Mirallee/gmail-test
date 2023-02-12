package tests;

import org.testng.Assert;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;
import pages.BaseTest;
import pages.LandingPage;
import pages.MailPage;

import java.io.IOException;
import java.util.HashMap;
import java.util.List;


public class GmailLoginTest extends BaseTest {
    @Test(dataProvider = "getData")
    public void loginToAccount(HashMap<String, String> input)  {
        LandingPage landingPage = new LandingPage(driver);
        landingPage.userLogin(input.get("email"), input.get("password"));
    }

    @Test(dataProvider = "getData")
    public void logoutAccount(HashMap<String, String> input) {
        LandingPage landingPage = new LandingPage(driver);
        landingPage.userLogin(input.get("email"), input.get("password"));
        MailPage mailPage = new MailPage(driver);
        mailPage.clickProfileButtonAndLogoutAccount();
    }

    @Test(dataProvider = "getData")
    public void sendMailToRecipientAndVerifyThatSpamFolderIsClear(HashMap<String, String> input) {
        LandingPage landingPage = new LandingPage(driver);
        landingPage.userLogin(input.get("email"), input.get("password"));
        MailPage mailPage = new MailPage(driver);
        mailPage.createAndSendMailToRecipient();
        String subjectText = mailPage.getSubjectOfEmailText();
        Assert.assertTrue(subjectText.equalsIgnoreCase("Hello Tester!"));
        mailPage.goToSpamFolder();
        String spamMessage = mailPage.getMessageOfEmptySpamFolder();
        Assert.assertTrue(spamMessage.equalsIgnoreCase("Hurra! Nie ma spamu!"));
    }
    @Test(dependsOnMethods={"sendMailToRecipientAndVerifyThatSpamFolderIsClear"}, dataProvider = "getData")
    public void verifyThatMailCanBeSearchedBySubject(HashMap<String, String> input) {
        LandingPage landingPage = new LandingPage(driver);
        landingPage.userLogin(input.get("email"), input.get("password"));
        MailPage mailPage = new MailPage(driver);
        mailPage.searchMessageBySubject();
        String subjectText = mailPage.getSubjectAfterSearchAction();
        Assert.assertTrue(subjectText.equalsIgnoreCase("Hello Tester!"));
    }
    @Test(dependsOnMethods={"sendMailToRecipientAndVerifyThatSpamFolderIsClear"}, dataProvider = "getData")
    public void verifyThatMailCanBeSearchedByEmailAddress(HashMap<String, String> input) {
        LandingPage landingPage = new LandingPage(driver);
        landingPage.userLogin(input.get("email"), input.get("password"));
        MailPage mailPage = new MailPage(driver);
        mailPage.searchMessageByEmailAddress();
        String subjectText = mailPage.getSubjectAfterSearchAction();
        Assert.assertTrue(subjectText.equalsIgnoreCase("Hello Tester!"));
    }
    @Test(dataProvider = "getData")
    public void sendMailToMultipleRecipients(HashMap<String, String> input) {
        LandingPage landingPage = new LandingPage(driver);
        landingPage.userLogin(input.get("email"), input.get("password"));
        MailPage mailPage = new MailPage(driver);
        mailPage.createAndSendMailToMultipleRecipients();
    }
    @Test( dataProvider = "getData")
    public void emailReplyFuncionality(HashMap<String, String> input) {
        LandingPage landingPage = new LandingPage(driver);
        landingPage.userLogin(input.get("email"), input.get("password"));
        MailPage mailPage = new MailPage(driver);
        mailPage.clickOnReceivedMailAndReplyTheMessage();
    }
    @Test(dependsOnMethods = {"sendMailToRecipientAndVerifyThatSpamFolderIsClear"}, dataProvider = "getData")
    public void starTheReceivedMail(HashMap<String, String> input) {
        LandingPage landingPage = new LandingPage(driver);
        landingPage.userLogin(input.get("email"), input.get("password"));
        MailPage mailPage = new MailPage(driver);
        mailPage.starTheReceivedMail();
    }


    @DataProvider
    public Object[][] getData() throws IOException {
        List<HashMap<String, String>> data = getJsonDataToMap(System.getProperty("user.dir")
                + "//src//test//java//utilities//dataFile.json");
        return new Object[][]{{data.get(0)}};
    }
}
