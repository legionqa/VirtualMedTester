package com.legion.utilities;

import java.time.Duration;

import com.legion.pages.PageGenerator;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.support.ui.WebDriverWait;
import io.github.bonigarcia.wdm.WebDriverManager;

public class BaseTest {
    protected WebDriver driver;
    protected WebDriverWait wait;
    protected PageGenerator page;

    @BeforeEach
    public void classLevelSetup() {
        WebDriverManager.chromedriver().clearDriverCache();
        WebDriverManager.chromedriver().setup();
        // Create a new instance of the ChromeOptions class
        ChromeOptions options = new ChromeOptions();
        options.addArguments("--start-maximized");
        // Set Chrome to run in headless mode
        options.addArguments("--headless");
        driver = new ChromeDriver(options);
        wait = new WebDriverWait(driver, Duration.ofSeconds(10));
        page = new PageGenerator(driver);
    }

    @AfterEach
    public void teardown() {
        if (driver != null)
            driver.quit();
    }


}
