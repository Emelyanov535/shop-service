package ru.mediasoft.shop.configuration.properties;

import lombok.Getter;
import lombok.Setter;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.context.annotation.Configuration;

@Configuration
@ConfigurationProperties(prefix = "rest")
@Getter
@Setter
public class RestConfig {

    private Currency currency;
    private Account account;
    private Crm crm;

    @Getter
    @Setter
    public static class Currency {
        private String host;
        private Methods methods;

        @Getter
        @Setter
        public static class Methods {
            private String getExchangeRates;
        }
    }

    @Getter
    @Setter
    public static class Account {
        private String host;
        private Methods methods;

        @Getter
        @Setter
        public static class Methods {
            private String getAccountNumber;
        }
    }

    @Getter
    @Setter
    public static class Crm {
        private String host;
        private Methods methods;

        @Getter
        @Setter
        public static class Methods {
            private String getCrmInn;
        }
    }
}

