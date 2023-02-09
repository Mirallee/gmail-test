package tests;
import org.testng.Assert;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;
import pages.BaseTest;
import pages.LandingPage;
import java.io.IOException;
import java.util.HashMap;
import java.util.List;

public class Validations extends BaseTest
{
    @Test(dataProvider = "getData")
    public void submitForm(HashMap<String, String> input) {
        LandingPage landingPage = new LandingPage(driver);
        landingPage.userLogin(input.get("email2"), input.get("password2"));
        String errorText = landingPage.getErrorMessage();
        Assert.assertTrue(errorText.equalsIgnoreCase("Nieprawidłowe hasło. Spróbuj jeszcze raz lub kliknij „Nie pamiętasz hasła?”, by je zresetować."));
    }



    @DataProvider
    public Object[][] getData() throws IOException {
        List<HashMap<String, String>> data = getJsonDataToMap(System.getProperty("user.dir")
                + "//src//test//java//utilities//dataFile.json");
        return new Object[][]{{data.get(1)}};
    }
}

