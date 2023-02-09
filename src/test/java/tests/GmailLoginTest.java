package tests;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;
import pages.BaseTest;
import pages.LandingPage;

import java.io.IOException;
import java.util.HashMap;
import java.util.List;


public class GmailLoginTest extends BaseTest
{
    @Test(dataProvider = "getData")
    public void submitForm(HashMap<String, String> input) throws InterruptedException {
        LandingPage landingPage = new LandingPage(driver);
        landingPage.userLogin(input.get("email"), input.get("password"));
    }



    @DataProvider
    public Object[][] getData() throws IOException {
        List<HashMap<String, String>> data = getJsonDataToMap(System.getProperty("user.dir")
                + "//src//test//java//utilities//dataFile.json");
        return new Object[][]{{data.get(0)}};
    }
}
