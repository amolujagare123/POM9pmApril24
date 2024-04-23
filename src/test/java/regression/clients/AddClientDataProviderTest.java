package regression.clients;

import Utility.DoLogin;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;
import pages.Login;
import pages.Menu;
import pages.clients.AddClient;

import java.io.IOException;

import static Utility.ForDataProvider.getMyData;

public class AddClientDataProviderTest extends DoLogin {
  /*  WebDriver driver;
    @BeforeClass
    public void doLogin()
    {
        driver = new ChromeDriver();
        driver.manage().window().maximize();
        driver.get("http://localhost/ip");

        Login login = new Login(driver);

        login.setTxtUsername("amolujagare@gmail.com");
        login.setTxtPassword("admin123");
        login.clickLogin();
    }
*/
    @Test (dataProvider = "getData")
    public void addClientTest(String clientName, String clientSurname, String language, String streetAddress1,
                              String streetAddress2, String city, String state, String zipCode, String country,
                              String gender, String birthDate, String phoneNumber, String faxNumber,
                              String mobileNumber, String emailAddress, String webAddress, String vatId,
                              String taxesCode,String expected,String xpathActual )
    {
        Menu menu = new Menu(driver);
        menu.clickAddClient();

        AddClient addClient = new AddClient(driver);


        addClient.setClientName(clientName);
        addClient.setClientSurname(clientSurname);
        addClient.setLanguage(language);
        addClient.setStreetAddress1(streetAddress1);
        addClient.setStreetAddress2(streetAddress2);
        addClient.setCity(city);
        addClient.setState(state);
        addClient.setZipCode(zipCode);
        addClient.setCountry(country);
        addClient.setGender(gender);
        addClient.setBirthDate(birthDate);
        addClient.setPhoneNumber(phoneNumber);
        addClient.setFaxNumber(faxNumber);
        addClient.setMobileNumber(mobileNumber);
        addClient.setEmailAddress(emailAddress);
        addClient.setWebAddress(webAddress);
        addClient.setVATID(vatId);
        addClient.setTaxesCode(taxesCode);
        // Submit the form
        addClient.clickSave();

        String actual = "";
        try{
             actual = driver.findElement(By.xpath(xpathActual)).getText();
        }
        catch(Exception e )
        {
        }

        System.out.println("expected="+expected);
        System.out.println("actual="+actual);
        Assert.assertEquals(actual,expected);

    }

    @DataProvider
    Object[][] getData() throws IOException {
       return getMyData("Data/Data.xlsx","Data - 2");
    }
}
