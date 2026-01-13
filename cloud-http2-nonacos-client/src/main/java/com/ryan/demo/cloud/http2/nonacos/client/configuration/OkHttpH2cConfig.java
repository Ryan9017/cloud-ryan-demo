package com.ryan.demo.cloud.http2.nonacos.client.configuration;

/**
 * @ClassName OkHttpH2cConfig
 * @Description 使用cloud-h2c（HTTP/2 over cleartext）
 * @Author ryan
 * @Date 2026/1/13 10:30
 * @Version 1.0
 **/
import okhttp3.ConnectionPool;
import okhttp3.OkHttpClient;
import okhttp3.Protocol;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import java.time.Duration;
import java.util.List;
import java.util.concurrent.TimeUnit;

@Configuration
public class OkHttpH2cConfig {

    /**
     * OkHttp h2c（HTTP/2 cleartext）Client
     */
    @Bean
    public OkHttpClient rawOkHttpClient() {
        return new OkHttpClient.Builder()
                // ⚠️ 只允许 HTTP_2（h2c）
                .protocols(List.of(Protocol.H2_PRIOR_KNOWLEDGE))

                // 大连接池，保证复用
                .connectionPool(
                        new ConnectionPool(
                                200,               // max idle connections
                                5,                 // keep-alive
                                TimeUnit.MINUTES
                        )
                )

                // 超时尽量小，避免干扰 benchmark
                .connectTimeout(Duration.ofSeconds(3))
                .readTimeout(Duration.ofSeconds(5))
                .writeTimeout(Duration.ofSeconds(5))

                // 打印实际使用的协议
                .addInterceptor(chain -> {
                    var resp = chain.proceed(chain.request());
//                    System.out.println("Protocol = " + resp.protocol());
                    return resp;
                })

                .build();
    }
}

