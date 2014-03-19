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

    public WebElement getConvertTypeItem(String indexInList)
    {
        String xpath = "//div[@id = 'measureSelector']/ul/li[" + indexInList + "]/a";
        System.out.println(driver.findElement(By.xpath(xpath)).getTagName());
        return driver.findElement(By.xpath(xpath));
    }

}
