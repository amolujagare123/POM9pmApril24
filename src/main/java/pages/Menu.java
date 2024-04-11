package pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class Menu {

    public Menu(WebDriver driver)
    {
        PageFactory.initElements(driver,this);
    }

    @FindBy(xpath = "//a[normalize-space()='Dashboard']")
    WebElement dashboard;
    void clickDashboard()
    {
        dashboard.click();
    }

    @FindBy(xpath = "//span[normalize-space()='Clients']")
    WebElement clients;
    @FindBy(xpath = "//a[normalize-space()='Add Client']")
    WebElement addClient;

    public void clickAddClient()
    {
        clients.click();
        addClient.click();
    }

    @FindBy(xpath = "//a[normalize-space()='View Clients']")
    WebElement viewClients;

    public void clickViewClients()
    {
        clients.click();
        viewClients.click();
    }
    @FindBy(xpath = "//span[normalize-space()='Quotes']")
    WebElement quotes;
    @FindBy(xpath = "//a[normalize-space()='Create Quote']")
    WebElement createQuote;

    public void clickCreateQuote()
    {
        quotes.click();
        createQuote.click();
    }
    @FindBy(xpath = "//a[normalize-space()='View Quotes']")
    WebElement viewQuotes;

    public void clickViewQuote()
    {
        quotes.click();
        viewQuotes.click();
    }

}
