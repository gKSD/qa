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

    public ResultPageAfterGoMailRuSearch(WebDriver driver) {
        this.driver = driver;
    }

    public WebElement getMixForm()
    {
        return driver.findElement(By.id("smack-converter__form"));
    }

    public WebElement getMixInput()
    {
        return driver.findElement(By.id("ival"));
    }

    public WebElement getMixLeftType()
    {
        return driver.findElement(By.id("icode"));
    }

    public WebElement getMixRightType()
    {
        return driver.findElement(By.id("ocode"));
    }

    public WebElement getMixOval()
            //число после перевод
    {
        return driver.findElement(By.id("oval"));
    }

    public WebElement getMixConverterSpan()
    {
        return driver.findElement(By.cssSelector(".smack-converter__title-span"));
    }

    public WebElement getConvertTypeItem(String indexInList)
    {
        String xpath = "//div[@id = 'measureSelector']/ul/li[" + indexInList + "]/a";
        System.out.println(xpath);
        System.out.println(driver.findElement(By.xpath(xpath)).getTagName());
        return driver.findElement(By.xpath(xpath));
    }

    public String getMixInputValue()
    {
        return getMixInput().getAttribute("value");
    }

    public String getMixOvalValue()
    {
        return getMixOval().getText();//getAttribute("value");
    }

    public String getMixLeftTypeValue()
    {
        return getMixLeftType().getText();
    }

    public String getMixRightTypeValue()
    {
        return getMixRightType().getText();
    }

    public String getMixConverterSpanValue()
    {
        return getMixConverterSpan().getText();
    }

    public ResultPageAfterGoMailRuSearch enterTextIntoMixInput(String text)
    {
        getMixInput().sendKeys(text);
        return this;
    }

    public ResultPageAfterGoMailRuSearch clearMixInput()
    {
        getMixInput().clear();
        return this;
    }

    public WebElement getCleanButton()
    {
        return driver.findElement(By.id("go-form__qclear"));
    }

    public ResultPageAfterGoMailRuSearch clickCleanButton() {
        getCleanButton().click();
        return this;
    }

    public WebElement getSubmitButton()
    //получение кнопки субмита
    {
        return driver.findElement(By.cssSelector(".js-is-not-scrollable"));
    }



    public ResultPageAfterGoMailRuSearch runSearch(SearchForm searchForm, String text)
    {
        return searchForm.runSearch(text);
    }

    public ResultPageAfterGoMailRuSearch runSearch(SearchForm searchForm)
    {
        return searchForm.runSearch();
    }
}
