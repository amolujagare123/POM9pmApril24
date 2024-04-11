package pages.clients;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class AddClient {

    public AddClient(WebDriver driver)
    {
        PageFactory.initElements(driver,this);
    }
    @FindBy(xpath = "//input[@id='client_name']")
    WebElement clientName;
    @FindBy(xpath = "//input[@id='client_surname']")
    WebElement clientSurname;
    @FindBy(xpath = "//input[@id='client_address_1']")
    WebElement streetAddress1;
    @FindBy(xpath = "//input[@id='client_address_2']")
    WebElement streetAddress2;
    @FindBy(xpath = "//input[@id='client_city']") WebElement clientCity;
    @FindBy(xpath = "//input[@id='client_state']") WebElement clientState;
    @FindBy(xpath = "//input[@id='client_zip']") WebElement zipCode;
    @FindBy(xpath = "//input[@id='client_phone']") WebElement phoneNumber;
    @FindBy(xpath = "//input[@id='client_fax']") WebElement faxNumber;
    @FindBy(xpath = "//input[@id='client_mobile']") WebElement mobileNumber;
    @FindBy(xpath = "//input[@id='client_email']") WebElement emailAddress;
    @FindBy(xpath = "//input[@id='client_web']") WebElement webAddress;
    @FindBy(xpath = "//input[@id='client_vat_id']") WebElement vATID;
    @FindBy(xpath = "//input[@id='client_tax_code']") WebElement taxesCode;
    @FindBy(xpath = "//button[@id='btn-submit']") WebElement save;


    public void setClientName(String name) {
        clientName.sendKeys(name);
    }

    public void setClientSurname(String surname) {
        clientSurname.sendKeys(surname);
    }

    public void setStreetAddress1(String address) {
        streetAddress1.sendKeys(address);
    }

    public void setStreetAddress2(String address) {
        streetAddress2.sendKeys(address);
    }

    public void setCity(String city) {
        clientCity.sendKeys(city);
    }

    public void setState(String state) {
        clientState.sendKeys(state);
    }

    public void setZipCode(String zip) {
        zipCode.sendKeys(zip);
    }

    public void setPhoneNumber(String number) {
        phoneNumber.sendKeys(number);
    }

    public void setFaxNumber(String number) {
        faxNumber.sendKeys(number);
    }

    public void setMobileNumber(String number) {
        mobileNumber.sendKeys(number);
    }

    public void setEmailAddress(String email) {
        emailAddress.sendKeys(email);
    }

    public void setWebAddress(String web) {
        webAddress.sendKeys(web);
    }

    public void setVATID(String vatId) {
        vATID.sendKeys(vatId);
    }

    public void setTaxesCode(String taxCode) {
        taxesCode.sendKeys(taxCode);
    }

    public void clickSave() {
        save.click();
    }
}
