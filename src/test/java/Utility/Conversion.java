package Utility;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

public class Conversion {

    public static String convertCountry(String shortCountry)
    {
        String countryFullForm="";

        switch (shortCountry)
        {
            case "IN" : countryFullForm ="India"; break;
            case "US" : countryFullForm ="United States"; break;
            case "CN" : countryFullForm ="China"; break;
            case "JP" : countryFullForm ="Japan"; break;
            case "GB" : countryFullForm ="United Kingdom"; break;
            case "DE" : countryFullForm ="Germany"; break;
            case "FR" : countryFullForm ="France"; break;
            case "BR" : countryFullForm ="Brazil"; break;
            case "RU" : countryFullForm ="Russia"; break;
            case "AU" : countryFullForm ="Australia"; break;
        }

        return countryFullForm;
    }


    public static String getGender(String genderId)
    {
        String gender = "";
        switch (genderId)
        {
            case "0":gender="Male";break;
            case "1":gender="Female";break;
            case "2":gender="Other";break;
        }
        return gender;
    }

    public static String convertedDate(String dbDateStr) throws ParseException // yyyy-MM-dd
    {
        //dd/MM/yyyy

        SimpleDateFormat sd1 = new SimpleDateFormat("yyyy-MM-dd");
        Date dbDate = sd1.parse(dbDateStr);

        SimpleDateFormat sd2 = new SimpleDateFormat("dd/MM/yyyy");
        String convertedDate = sd2.format(dbDate);
        return convertedDate;
    }
}
