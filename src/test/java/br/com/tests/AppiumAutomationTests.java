package br.com.tests;

import br.com.appium.configuration.DriverSessionConfig;
import io.appium.java_client.AppiumBy;
import io.appium.java_client.android.AndroidDriver;
import org.apache.commons.io.FileUtils;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.io.File;
import java.io.IOException;
import java.net.MalformedURLException;
import java.net.URL;
import java.time.Duration;

public class AppiumAutomationTests {

    private DesiredCapabilities capabilities;

    private AndroidDriver driver;

    @BeforeEach
    public void setUp() throws MalformedURLException {
        URL url = new URL("http://127.0.0.1:4723/wd/hub");
        capabilities = DriverSessionConfig.getDesiredCapabilities();
        driver = new AndroidDriver(url, capabilities);
        //driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(60));
    }

    @Test
    public void openWhatsApp() throws IOException{
        WebElement app = driver.findElement(AppiumBy.accessibilityId("WhatsApp"));
        app.click();
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
        wait.until(ExpectedConditions.visibilityOf(driver.findElement(AppiumBy.id("com.whatsapp:id/action_bar_root"))));
        File screenshot = driver.getScreenshotAs(OutputType.FILE);
        FileUtils.copyFile(screenshot, new File ("src/test/resources/evidences/whats_screenshot.jpg"));
    }

    @Test
    public void findElements() throws IOException {
        WebElement app = driver.findElement(AppiumBy.xpath("//android.widget.FrameLayout[@content-desc=\"Telegram\"]/android.widget.ImageView"));
        app.click();
        WebElement searchIcon = driver.findElement(AppiumBy.accessibilityId("Buscar"));
        searchIcon.click();
        WebElement searchBar = driver.findElement(AppiumBy.className("android.widget.EditText"));
        searchBar.sendKeys("William");
        File screenshot = driver.getScreenshotAs(OutputType.FILE);
        FileUtils.copyFile(screenshot, new File ("src/test/resources/evidences/screenshot.jpg"));
    }

    @AfterEach
    public void tearDown() {
        driver.quit();
    }
}
