package steps;

import cucumber.api.java.ru.И;
import cucumber.api.java.ru.Пусть;
import edu.DriverInit;
import edu.ObjectMapper;
import org.junit.After;
import org.junit.Assert;
import org.junit.Before;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class BaseSteps {
    private static WebDriver driver;

    @Before
    public void before() {
        DriverInit driverInit = new DriverInit();
        driver = driverInit.getDriver();
    }

    @Пусть("Открыта страница по адресу \"(.*)\"")
    public static void open(String url) {
        driver.get(url);
    }

    @И("В поле ввода \"(.*)\" введено значение \"(.*)\"")
    public static void fillFieldValue(String fieldName, String fieldValue) throws Exception {
        WebDriverWait wait = new WebDriverWait(driver, 10);
        WebElement webElement = wait.until(ExpectedConditions.presenceOfElementLocated(ObjectMapper.getElementLocatorByName(fieldName)));
        webElement.sendKeys(fieldValue);
    }

    @И("Нажата кнопка \"(.*)\"")
    public static void clickButton(String buttonName) throws Exception {
        WebDriverWait wait = new WebDriverWait(driver, 10);
        WebElement webElement = wait.until(ExpectedConditions.presenceOfElementLocated(ObjectMapper.getElementLocatorByName(buttonName)));
        webElement.click();
    }

    @И("Отображен текст \"(.*)\"")
    public static void containsText(String text) {
        Assert.assertTrue(driver.getPageSource().contains(text));
    }

    @After
    public void after() {
        driver.quit();
    }
}
