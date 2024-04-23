package regression;

import Utility.OpenURL;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;
import pages.Login;

import java.io.IOException;

import static util.ConfigReader.*;

public class LoginTest extends OpenURL {

    @Test
    public void loginTest() throws IOException {
       /* WebDriver driver = new ChromeDriver();
        driver.manage().window().maximize();
        driver.get(getUrl());*/

        Login login = new Login(driver);

        login.setTxtUsername(getUsername());
        login.setTxtPassword(getPassword());
        login.clickLogin();



    }
}
