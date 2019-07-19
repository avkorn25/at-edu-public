package edu;

import org.openqa.selenium.Capabilities;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriverService;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.openqa.selenium.remote.RemoteWebDriver;

import java.io.IOException;
import java.nio.file.Path;
import java.nio.file.Paths;

public class DriverInit {
    private static Path chromePath = Paths.get(System.getProperties().getProperty("user.dir"), "Drivers", "chromedriver.exe");
    private static ChromeDriverService service;
    private WebDriver driver;

    static {
        service = new ChromeDriverService.Builder()
                .usingDriverExecutable(chromePath.toFile())
                .usingAnyFreePort()
                .build();
        try {
            service.start();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public DriverInit() {
        DesiredCapabilities newDesiredCapabilities = DesiredCapabilities.chrome();
        newDesiredCapabilities.merge(createExtra());
        driver = new RemoteWebDriver(service.getUrl(), newDesiredCapabilities);
    }

    private ChromeOptions createExtra() {
        ChromeOptions extra = new ChromeOptions();
        extra.addArguments("start-maximized");

        return extra;
    }

    public WebDriver getDriver() {
        return driver;
    }

    public void quitDriver() {
        driver.quit();
    }

    public static void main(String[] args) {

    }
}
