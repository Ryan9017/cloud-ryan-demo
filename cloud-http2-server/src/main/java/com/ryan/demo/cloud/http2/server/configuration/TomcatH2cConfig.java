package com.ryan.demo.cloud.http2.server.configuration;

import org.apache.coyote.http2.Http2Protocol;
import org.springframework.boot.web.embedded.tomcat.TomcatServletWebServerFactory;
import org.springframework.boot.web.server.WebServerFactoryCustomizer;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

/**
 * @ClassName TomcatH2cConfig
 * @Description TODO
 * @Author ryan
 * @Date 2026/1/13 14:06
 * @Version 1.0
 **/
@Configuration
public class TomcatH2cConfig {

    @Bean
    public WebServerFactoryCustomizer<TomcatServletWebServerFactory> h2cCustomizer() {
        return factory -> factory.addConnectorCustomizers(connector -> {
            connector.addUpgradeProtocol(new Http2Protocol());
        });
    }
}

