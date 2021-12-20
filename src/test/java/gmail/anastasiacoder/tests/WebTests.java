package gmail.anastasiacoder.tests;

import static gmail.anastasiacoder.config.Browser.CHROME;
import static org.assertj.core.api.AssertionsForClassTypes.assertThat;

import gmail.anastasiacoder.config.WebConfig;
import gmail.anastasiacoder.config.WebDriverProvider;
import org.junit.jupiter.api.Test;
import org.openqa.selenium.WebDriver;
import org.aeonbits.owner.ConfigFactory;


public class WebTests {

    private WebDriver driver = new WebDriverProvider().get();

    @Test
    public void webChromeLocalTest() {
        System.setProperty("environment", "chromeLocal");
        WebConfig webConfig = ConfigFactory.create(WebConfig.class, System.getProperties());

        assertThat(webConfig.getBrowser()).isEqualTo(CHROME);
        assertThat(webConfig.getBrowserVersion()).isEqualTo("96.0");
    }

    @Test
    public void webSelenoidTest() {
        System.setProperty("environment", "selenoid");
        WebConfig webConfig = ConfigFactory.create(WebConfig.class, System.getProperties());

        assertThat(webConfig.getBrowser()).isEqualTo(CHROME);
        assertThat(webConfig.getBrowserVersion()).isEqualTo("96.0");
        assertThat(webConfig.getRemoteUrl()).isEqualTo(
                "https://user1:1234@selenoid.autotests.cloud/wd/hub/");
    }
}