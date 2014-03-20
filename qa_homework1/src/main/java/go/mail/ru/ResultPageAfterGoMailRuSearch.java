package go.mail.ru;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

/**
 * Created by sofia on 19.03.14.
 */
public class ResultPageAfterGoMailRuSearch {
    //page with dimension convertor mix

    WebDriver driver;
    DimensionConvertor dimensionConvertor;

    public ResultPageAfterGoMailRuSearch(WebDriver driver) {
        this.driver = driver;

        dimensionConvertor = new DimensionConvertor(driver);
    }

    public DimensionConvertor getDimensionConvertor()
    {
        return dimensionConvertor;
    }

    public ResultPageAfterGoMailRuSearch runSearch(SearchForm searchForm, String text)
    {
        return searchForm.runSearch(text);
    }

    public ResultPageAfterGoMailRuSearch runSearch(SearchForm searchForm)
    {
        return searchForm.runSearch();
    }

    public ResultPageAfterGoMailRuSearch cleanSearchInput(SearchForm searchForm)
    {
        searchForm.clickCleanButton();
        return this;
    }
}
