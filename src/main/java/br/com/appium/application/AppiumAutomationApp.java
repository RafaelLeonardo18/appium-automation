package br.com.appium.application;

import br.com.appium.configuration.DriverSessionConfig;
import io.appium.java_client.AppiumBy;
import io.appium.java_client.android.AndroidDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.remote.DesiredCapabilities;

import java.net.MalformedURLException;
import java.net.URL;

public class AppiumAutomationApp {

    public static void main(String[] args) throws MalformedURLException {
        DesiredCapabilities sessionCapabilities = DriverSessionConfig.getDesiredCapabilities();
        URL url = new URL("http://127.0.0.1:4723/wd/hub");
        AndroidDriver driver = new AndroidDriver(url, sessionCapabilities);
        WebElement app = (WebElement) driver.findElement(AppiumBy.accessibilityId("WhatsApp, 1 novo item"));
        app.click();
        driver.quit();
    }
}
