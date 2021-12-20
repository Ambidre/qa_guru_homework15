package gmail.anastasiacoder.config;

import java.util.Objects;
import java.util.function.Supplier;

import org.aeonbits.owner.ConfigFactory;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.openqa.selenium.remote.RemoteWebDriver;

public class WebDriverProvider implements Supplier<WebDriver> {

    private final WebConfig config;

    public WebDriverProvider() {

        config = ConfigFactory.create(WebConfig.class, System.getProperties());
    }

    @Override
    public WebDriver get() {
        WebDriver driver = createWebDriver();
        driver.get(config.getBaseUrl());
        return driver;
    }

    private WebDriver createWebDriver() {
        if (Objects.isNull(config.getRemoteUrl())) {
            if (config.getBrowser().equals(Browser.FIREFOX)) {
                return new FirefoxDriver();
            }
            if (config.getBrowser().equals(Browser.CHROME)) {
                return new ChromeDriver();
            }
        } else {
            return new RemoteWebDriver(config.getRemoteUrl(), DesiredCapabilities.chrome());
        }
        throw new NullPointerException("No such browser");
    }

}