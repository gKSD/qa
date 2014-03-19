package go.tests;

import go.mail.ru.GoMailRuPage;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.openqa.selenium.remote.RemoteWebDriver;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;
import sun.reflect.generics.reflectiveObjects.NotImplementedException;

import java.net.MalformedURLException;
import java.net.URL;
import java.util.concurrent.TimeUnit;


/**
 * Created by sofia on 19.03.14.
 */

public class DimensionConverterMix
{
    private WebDriver driver;
    private WebDriver driver1;

    @BeforeMethod
    @Parameters({"browser", "hub", "url"})
    public void setUp(String browser, String hub, String url) throws MalformedURLException {
        /*if (browser.toLowerCase().equals("chrome"))
            this.driver = new RemoteWebDriver(new URL(hub), DesiredCapabilities.chrome());
        else if (browser.toLowerCase().equals("firefox"))
            this.driver = new RemoteWebDriver(new URL(hub), DesiredCapabilities.firefox());
        else
            throw new NotImplementedException();
        this.driver.manage().window().maximize();
        this.driver.get(url);
        */

        driver1 = new FirefoxDriver();
        driver1.navigate().to("http://go.mail.ru");
        driver1.manage().timeouts().implicitlyWait(5, TimeUnit.SECONDS);
    }

    @Test
    public void test1()
    {
        new GoMailRuPage(this.driver1).getSearchForm().runSearch("3 кг в фунтах");
        //Assert.assertTrue(suggests.contains("вконтакте"));
    }

    @Test
    public void test2()
    {

    }

    @AfterMethod
    public void tearDown() {
        this.driver.close();
    }
}
