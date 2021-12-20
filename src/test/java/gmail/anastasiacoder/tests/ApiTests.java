package gmail.anastasiacoder.tests;

import gmail.anastasiacoder.config.ApiConfig;
import org.aeonbits.owner.ConfigFactory;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;

public class ApiTests {

    ApiConfig apiConfig = ConfigFactory.create(ApiConfig.class, System.getProperties());

    @Test
    public void apiTest() {
        ApiConfig apiConfig = ConfigFactory.create(ApiConfig.class, System.getProperties());
        assertThat(apiConfig.getBaseUrl()).isEqualTo("https://github.com");
        assertThat(apiConfig.getToken()).isEqualTo("some_token");
    }
}