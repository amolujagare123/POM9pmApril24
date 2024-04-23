package regression.clients;

import Utility.DoLogin;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;
import pages.Login;
import pages.Menu;
import pages.clients.AddClient;

public class AddClientTest extends DoLogin {
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
    }*/

    @Test
    public void addClientTest()
    {
        Menu menu = new Menu(driver);
        menu.clickAddClient();

        AddClient addClient = new AddClient(driver);


        addClient.setClientName("John");
        addClient.setClientSurname("Doe");
        addClient.setLanguage("Spanish");
        addClient.setStreetAddress1("123 Main St");
        addClient.setStreetAddress2("Apt 101");
        addClient.setCity("New York");
        addClient.setState("NY");
        addClient.setZipCode("10001");
        addClient.setCountry("India");
        addClient.setGender("Female");
        addClient.setBirthDate("05/09/1985");
        addClient.setPhoneNumber("555-1234");
        addClient.setFaxNumber("555-5678");
        addClient.setMobileNumber("555-9876");
        addClient.setEmailAddress("john.doe@example.com");
        addClient.setWebAddress("www.example.com");
        addClient.setVATID("123456789");
        addClient.setTaxesCode("TAX-123");
        // Submit the form
        addClient.clickSave();
    }
}
