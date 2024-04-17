package UITesting.util;

import org.openqa.selenium.WebElement;

public class UITests {

    public static boolean checkVisibility(WebElement element)
    {
        boolean result = false;
        try {
            result   =  element.isDisplayed();
        }
        catch (Exception e)
        {

        }
        return result;
    }
    public static boolean checkEnability(WebElement element)
    {
        boolean result = false;
        try {
            result   =  element.isEnabled();
        }
        catch (Exception e)
        {

        }
        return result;
    }

    public static String spellCheck(WebElement element)
    {
        String result = "";
        try {
            result   =  element.getText().trim();
        }
        catch (Exception e)
        {

        }
        return result;
    }

    public static String valueOfAttribute(WebElement element,String attribute)
    {
        String result = "";
        try {
            result   =  element.getAttribute(attribute);
        }
        catch (Exception e)
        {
            System.out.println(e);
        }
        return result;
    }
}
