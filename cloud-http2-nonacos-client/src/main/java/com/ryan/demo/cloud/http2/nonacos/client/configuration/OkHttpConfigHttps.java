package com.ryan.demo.cloud.http2.nonacos.client.configuration;

/**
 * @ClassName OkHttpConfig
 * @Description 1。使用cloud-h2（HTTP/2 over TLS）
 * @Author ryan
 * @Date 2026/1/12 13:19
 * @Version 1.0
 **/

import okhttp3.ConnectionPool;
import okhttp3.OkHttpClient;
import okhttp3.Protocol;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import javax.net.ssl.SSLContext;
import javax.net.ssl.TrustManager;
import javax.net.ssl.X509TrustManager;
import java.security.SecureRandom;
import java.security.cert.X509Certificate;
import java.util.List;
import java.util.concurrent.TimeUnit;

//@Configuration
public class OkHttpConfigHttps {

//    @Bean
    public OkHttpClient rawOkHttpClient() {
        try {
            TrustManager[] trustAllCerts = new TrustManager[]{
                    new X509TrustManager() {
                        public void checkClientTrusted(X509Certificate[] chain, String authType) {}
                        public void checkServerTrusted(X509Certificate[] chain, String authType) {}
                        public X509Certificate[] getAcceptedIssuers() {
                            return new X509Certificate[0];
                        }
                    }
            };

            SSLContext sslContext = SSLContext.getInstance("TLS");
            sslContext.init(null, trustAllCerts, new SecureRandom());

            return new OkHttpClient.Builder()
                    .sslSocketFactory(
                            sslContext.getSocketFactory(),
                            (X509TrustManager) trustAllCerts[0]
                    )
                    .hostnameVerifier((hostname, session) -> true)
                    .protocols(List.of(
                            Protocol.HTTP_2,
                            Protocol.HTTP_1_1
                    ))
                    .connectionPool(new ConnectionPool(
                            200, 5, TimeUnit.MINUTES
                    ))
                    .addInterceptor(chain -> {
                        var resp = chain.proceed(chain.request());
                        System.out.println("Protocol = " + resp.protocol());
                        return resp;
                    })
                    .build();

        } catch (Exception e) {
            throw new RuntimeException(e);
        }
    }
}







