package UITesting;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.Color;
import org.testng.Assert;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;
import pages.Login;

import static UITesting.util.UITests.*;

public class LoginTest {
    WebDriver driver;
    Login login;
    @BeforeClass
    public void initLogin()
    {

        WebDriver driver = new ChromeDriver();
        driver.manage().window().maximize();
        driver.get("http://localhost/ip");
        login = new Login(driver);
    }

    @Test
    public void checkTxtUsernameVisibility()
    {
        boolean expected = true;
      /*  boolean actual = false;
        try {
            actual   =  login.txtUsername.isDisplayed();
        }
        catch (Exception e)
        {

        }*/

        boolean actual = checkVisibility(login.txtUsername);

        Assert.assertEquals(actual,expected,"username textbox is absent");
    }

    @Test
    public void checkTxtPasswordVisibility()
    {
        boolean expected = true;
        boolean actual = checkVisibility(login.txtPassword);
        Assert.assertEquals(actual,expected,"");
    }

    @Test
    public void checkTxtPasswordEnability()
    {
        boolean expected = true;
        boolean actual = checkEnability(login.txtPassword);
        Assert.assertEquals(actual,expected,"");
    }

    @Test
    public void checkTxtUsernameEnability()
    {
        boolean expected = true;
        boolean actual = checkEnability(login.txtUsername);
        Assert.assertEquals(actual,expected,"");
    }

    @Test
    public void checkLblEmailSpell()
    {
        String expected = "Email";
        String actual = spellCheck(login.lblEmail);
        System.out.println("expected="+expected);
        System.out.println("actual="+actual);
        Assert.assertEquals(actual,expected,"");
    }

    @Test
    public void checkTxtPasswordWatermark()
    {
        String expected = "Password";
        String actual = valueOfAttribute(login.txtPassword,"placeholder");
        System.out.println("expected="+expected);
        System.out.println("actual="+actual);
        Assert.assertEquals(actual,expected,"");
    }

    @Test
    public void checkLblEmailFontSize()
    {
        String expected = "14px";
        String actual = styleValueOfElement(login.lblEmail,"font-size");
        System.out.println("expected="+expected);
        System.out.println("actual="+actual);
        Assert.assertEquals(actual,expected,"incorrect font size");
    }

    @Test
    public void checkLblEmailFontFamily()
    {
        String expected = "-apple-system, system-ui, BlinkMacSystemFont, \"Segoe UI\", Roboto, \"Helvetica Neue\", Arial, sans-serif";
        String actual = styleValueOfElement(login.lblEmail,"font-family");
        System.out.println("expected="+expected);
        System.out.println("actual="+actual);
        Assert.assertEquals(actual,expected,"incorrect font family");
    }

    @Test
    public void checkBtnLoginColor()
    {
        String expected = "#2C8EDD";
        String rgbColor = styleValueOfElement(login.btnLogin,"background-color");
        String actual = Color.fromString(rgbColor).asHex().toUpperCase();

        System.out.println("expected="+expected);
        System.out.println("actual="+actual);
        Assert.assertEquals(actual,expected,"incorrect background-color");
    }
}
