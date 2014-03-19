package go.mail.ru;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

/**
 * Created by sofia on 19.03.14.
 */
public class SearchForm
{
    WebDriver driver;

    public SearchForm(WebDriver driver)
    {
        this.driver = driver;
    }

    public WebElement getSearchInputElement()
    //получение доступа к элементу поисковой строки
    {
        return driver.findElement(By.id("q"));
    }

    public WebElement getSubmitButton()
    //получение кнопки субмита
    {
        return driver.findElement(By.cssSelector(".js-is-not-scrollable"));
    }

    public SearchForm enterText(String text)
    {
        getSearchInputElement().sendKeys(text);
        return this;
    }

    public  ResultPageAfterGoMailRuSearch clickSubmitButton()
    {
        getSubmitButton().click();
        return new ResultPageAfterGoMailRuSearch(driver);
    }

    public ResultPageAfterGoMailRuSearch runSearch(String text)
    {
        this.enterText(text);
        return this.clickSubmitButton();
    }

    public ResultPageAfterGoMailRuSearch runSearch()
    {
        return this.clickSubmitButton();
    }
}
