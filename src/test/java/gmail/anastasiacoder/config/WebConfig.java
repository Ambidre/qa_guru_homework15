package gmail.anastasiacoder.config;

import org.aeonbits.owner.Config;

import java.net.URL;

@Config.Sources("classpath:${environment}.properties")
public interface WebConfig extends Config {

    @Config.Key("browser")
    @Config.DefaultValue("CHROME")
    Browser getBrowser();

    @Key("browserVersion")
    @DefaultValue("96.0")
    String getBrowserVersion();

    @Config.Key("remoteUrl")
    URL getRemoteUrl();

    @Config.Key("baseUrl")
    @Config.DefaultValue("https://github.com")
    String getBaseUrl();
}
