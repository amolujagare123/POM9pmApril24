package DatabaseTesting.clients;

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
import java.sql.*;
import java.text.ParseException;
import java.util.ArrayList;

import static Utility.Conversion.*;
import static Utility.ForDataProvider.getMyData;

public class AddClientDataProviderTest {
    WebDriver driver;
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

    @Test (dataProvider = "getData")
    public void addClientTest(String clientName, String clientSurname, String language, String streetAddress1,
                              String streetAddress2, String city, String state, String zipCode, String country,
                              String gender, String birthDate, String phoneNumber, String faxNumber,
                              String mobileNumber, String emailAddress, String webAddress, String vatId,
                              String taxesCode) throws SQLException, ClassNotFoundException, ParseException {
        ArrayList<String> expected = new ArrayList<>();
        expected.add(clientName);
        expected.add(clientSurname);
        expected.add(language.toLowerCase());
        expected.add(streetAddress1);
        expected.add(streetAddress2);
        expected.add(city);
        expected.add(state);
        expected.add(zipCode);
        expected.add(country);
        expected.add(gender);
        expected.add(birthDate);
        expected.add(phoneNumber);
        expected.add(faxNumber);
        expected.add(mobileNumber);
        expected.add(emailAddress);
        expected.add(webAddress);
        expected.add(vatId);
        expected.add(taxesCode);

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

        // 1. loading a driver
        Class.forName("com.mysql.cj.jdbc.Driver");

        // 2. creating a connection
        String username = "root";
        String password = "root";
        String connectionURL = "jdbc:mysql://localhost:3306/ip";

        Connection con = DriverManager.getConnection(connectionURL,username,password);

        // 3. creating a statement
        Statement st = con.createStatement();

        //4. execute the query ( DDL - data definition language query)
        // select
        String sql = "select * from ip_clients where client_name='"+clientName+"';";

        ResultSet rs = st.executeQuery(sql);

        ArrayList<String> actual = new ArrayList<>();


        while (rs.next())
        {
            actual.add(rs.getString("client_name"));
            actual.add(rs.getString("client_surname"));
            actual.add(rs.getString("client_language"));
            actual.add(rs.getString("client_address_1"));
            actual.add(rs.getString("client_address_2"));
            actual.add(rs.getString("client_city"));
            actual.add(rs.getString("client_state"));
            actual.add(rs.getString("client_zip"));

            String shortCountry = rs.getString("client_country");
            String fullFormCountry = convertCountry(shortCountry);
            actual.add(fullFormCountry);

         //   actual.add(convertCountry(rs.getString("client_country")));


            actual.add(getGender(rs.getString("client_gender")));


            actual.add(convertedDate(rs.getString("client_birthdate")));

            actual.add(rs.getString("client_phone"));
            actual.add(rs.getString("client_fax"));
            actual.add(rs.getString("client_mobile"));
            actual.add(rs.getString("client_email"));
            actual.add(rs.getString("client_web"));
            actual.add(rs.getString("client_vat_id"));
            actual.add(rs.getString("client_tax_code"));

        }

        System.out.println("expected="+expected);
        System.out.println("actual="+actual);
        Assert.assertEquals(actual,expected);

    }

    @DataProvider
    Object[][] getData() throws IOException {
       return getMyData("Data/Data.xlsx","Database Testing");
    }
}
