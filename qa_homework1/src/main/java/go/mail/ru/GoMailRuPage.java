package go.mail.ru;

import org.openqa.selenium.WebDriver;

/**
 * Created by sofia on 19.03.14.
 */
public class GoMailRuPage {

    WebDriver driver;

    public GoMailRuPage(WebDriver driver) {
        this.driver = driver;
    }

    public SearchForm getSearchForm()
    {
        return new SearchForm(driver);
    }
}
