package gmail.anastasiacoder.config;

import org.aeonbits.owner.Config;

@Config.Sources("classpath:api.properties")

public interface ApiConfig extends Config {

    @Key("baseUrl")
    @DefaultValue("https://github.com")
    String getBaseUrl();

    @Key("token")
    String getToken();
}