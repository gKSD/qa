package go.tests;

import go.mail.ru.GoMailRuPage;
import go.mail.ru.ResultPageAfterGoMailRuSearch;
import go.mail.ru.SearchForm;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.openqa.selenium.remote.RemoteWebDriver;
import org.testng.Assert;
import org.testng.annotations.*;
import sun.reflect.generics.reflectiveObjects.NotImplementedException;

import java.awt.*;
import java.net.MalformedURLException;
import java.net.URL;
import java.util.Random;
import java.util.concurrent.TimeUnit;


/**
 * Created by sofia on 19.03.14.
 */

public class DimensionConverterMix
{
    private WebDriver driver;

    @BeforeMethod
    //@Parameters({"browser", "hub", "url"})
    //public void setUp(String browser, String hub, String url) throws MalformedURLException {
    //@BeforeTest
    public void setUp() {
        /*if (browser.toLowerCase().equals("chrome"))
            this.driver = new RemoteWebDriver(new URL(hub), DesiredCapabilities.chrome());
        else if (browser.toLowerCase().equals("firefox"))
            this.driver = new RemoteWebDriver(new URL(hub), DesiredCapabilities.firefox());
        else
            throw new NotImplementedException();
        this.driver.manage().window().maximize();
        this.driver.get(url);
        */

        driver = new FirefoxDriver();
        driver.navigate().to("http://go.mail.ru");
        //driver.get("http://go.mail.ru");
        driver.manage().timeouts().implicitlyWait(5, TimeUnit.SECONDS);
    }

    /*@Test
    public void test1()
    //проверка на правильность заполнения  и отрабатывания подмеса при вводе данных в основной поисковиковой строке
    {

        ResultPageAfterGoMailRuSearch result = new GoMailRuPage(this.driver).getSearchForm().runSearch("3 кг в фунтах");
        System.out.println(result.getMixRightTypeValue());

        Assert.assertTrue(result.getMixOvalValue().contains("6,61387"));
        Assert.assertTrue(result.getMixInputValue().contains("3"));
        Assert.assertTrue(result.getMixLeftTypeValue().contains("килограмма"));
        Assert.assertTrue(result.getMixRightTypeValue().contains("фунта"));
        Assert.assertTrue(result.getMixConverterSpanValue().contains("вес"));
    }

    @Test
    public void test2()
    //проверка на появление конвертера величин, тип величин указана
    {
        ResultPageAfterGoMailRuSearch result = new GoMailRuPage(this.driver).getSearchForm().runSearch("конвертер величин кг в фунты");
        Assert.assertTrue(result.getMixLeftTypeValue().contains("килограмм"));
        Assert.assertTrue(result.getMixRightTypeValue().contains("фунта"));
        Assert.assertTrue(result.getMixConverterSpanValue().contains("вес"));
    }
    */

    @Test
    public void test3()
    //проверка на склонение слов при введении разных чисел, для килограммов и для фунтов соответственно
    {
        ResultPageAfterGoMailRuSearch result = new GoMailRuPage(this.driver).getSearchForm().runSearch("конвертер величин кг в фунты");

        int val;
        int n = 0; //можно поставить и больше
        //*************************************************************************************************************
        //если единицы --> {0, 1, 5, 6, 7, 8, 9} - килограмм, но если единицы числа --> {2, 3, 4} - килограмма
        for (int i = 0; i < n; i++)
        {
            val = i*10;

            result.clearMixInput();
            result.enterTextIntoMixInput(Integer.toString(val + 0));
            Assert.assertTrue(result.getMixLeftTypeValue().contains("килограмм"));

            result.clearMixInput();
            result.enterTextIntoMixInput(Integer.toString(val + 1));
            Assert.assertTrue(result.getMixLeftTypeValue().contains("килограмм"));

            result.clearMixInput();
            result.enterTextIntoMixInput(Integer.toString(val + 2));
            if ((val + 2) % 100 == 12)
                Assert.assertTrue(result.getMixLeftTypeValue().contains("килограмм"));
            else
                Assert.assertTrue(result.getMixLeftTypeValue().contains("килограмма"));

            result.clearMixInput();
            result.enterTextIntoMixInput(Integer.toString(val + 3));
            if ((val + 3) % 100 == 13)
                Assert.assertTrue(result.getMixLeftTypeValue().contains("килограмм"));
            else
                Assert.assertTrue(result.getMixLeftTypeValue().contains("килограмма"));

            result.clearMixInput();
            result.enterTextIntoMixInput(Integer.toString(val + 4));
            if ((val + 4) % 100 == 14)
                Assert.assertTrue(result.getMixLeftTypeValue().contains("килограмм"));
            else
                Assert.assertTrue(result.getMixLeftTypeValue().contains("килограмма"));

            result.clearMixInput();
            result.enterTextIntoMixInput(Integer.toString(val + 5));
            Assert.assertTrue(result.getMixLeftTypeValue().contains("килограмм"));

            result.clearMixInput();
            result.enterTextIntoMixInput(Integer.toString(val + 6));
            Assert.assertTrue(result.getMixLeftTypeValue().contains("килограмм"));

            result.clearMixInput();
            result.enterTextIntoMixInput(Integer.toString(val + 7));
            Assert.assertTrue(result.getMixLeftTypeValue().contains("килограмм"));

            result.clearMixInput();
            result.enterTextIntoMixInput(Integer.toString(val + 8));
            Assert.assertTrue(result.getMixLeftTypeValue().contains("килограмм"));

            result.clearMixInput();
            result.enterTextIntoMixInput(Integer.toString(val + 9));
            Assert.assertTrue(result.getMixLeftTypeValue().contains("килограмм"));
        }
        //*************************************************************************************************************

        result.clickCleanButton();
        result.runSearch(new SearchForm(driver), "конвертер величин фунты в кг");

        //*************************************************************************************************************
        //если единицы --> {0, 1, 5, 6, 7, 8, 9} - килограмм, но если единицы числа --> {2, 3, 4} - килограмма
        n = 10;
        for (int i = 0; i < n; i++)
        {
            val = i*10;

            result.clearMixInput();
            result.enterTextIntoMixInput(Integer.toString(val + 0));
            Assert.assertTrue(result.getMixLeftTypeValue().contains("фунтов"));

            result.clearMixInput();
            result.enterTextIntoMixInput(Integer.toString(val + 1));
            if ((val + 1) % 100 == 11)
                Assert.assertTrue(result.getMixLeftTypeValue().contains("фунтов"));
            else
                Assert.assertTrue(result.getMixLeftTypeValue().contains("фунт"));

            result.clearMixInput();
            result.enterTextIntoMixInput(Integer.toString(val + 2));
            if ((val + 2) % 100 == 12)
                Assert.assertTrue(result.getMixLeftTypeValue().contains("фунтов"));
            else
                Assert.assertTrue(result.getMixLeftTypeValue().contains("фунта"));

            result.clearMixInput();
            result.enterTextIntoMixInput(Integer.toString(val + 3));
            if ((val + 3) % 100 == 13)
                Assert.assertTrue(result.getMixLeftTypeValue().contains("фунтов"));
            else
                Assert.assertTrue(result.getMixLeftTypeValue().contains("фунта"));

            result.clearMixInput();
            result.enterTextIntoMixInput(Integer.toString(val + 4));
            if ((val + 4) % 100 == 14)
                Assert.assertTrue(result.getMixLeftTypeValue().contains("фунтов"));
            else
                Assert.assertTrue(result.getMixLeftTypeValue().contains("фунта"));

            result.clearMixInput();
            result.enterTextIntoMixInput(Integer.toString(val + 5));
            Assert.assertTrue(result.getMixLeftTypeValue().contains("фунтов"));

            result.clearMixInput();
            result.enterTextIntoMixInput(Integer.toString(val + 6));
            Assert.assertTrue(result.getMixLeftTypeValue().contains("фунтов"));

            result.clearMixInput();
            result.enterTextIntoMixInput(Integer.toString(val + 7));
            Assert.assertTrue(result.getMixLeftTypeValue().contains("фунтов"));

            result.clearMixInput();
            result.enterTextIntoMixInput(Integer.toString(val + 8));
            Assert.assertTrue(result.getMixLeftTypeValue().contains("фунтов"));

            result.clearMixInput();
            result.enterTextIntoMixInput(Integer.toString(val + 9));
            Assert.assertTrue(result.getMixLeftTypeValue().contains("фунтов"));
        }
        //*************************************************************************************************************
    }

    /*@Test
    public void test4()
    //проверка на ввод больших значений
    {
        ResultPageAfterGoMailRuSearch result = new GoMailRuPage(this.driver).getSearchForm().runSearch("конвертер величин кг в фунты");
    }*/

    //@AfterTest
    @AfterMethod
    public void tearDown()
    {
        System.out.println("qweqweqwe");
        this.driver.close();
    }
}
