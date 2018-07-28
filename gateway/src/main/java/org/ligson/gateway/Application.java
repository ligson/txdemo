package org.ligson.gateway;

import com.netflix.discovery.util.RateLimiter;
import org.ligson.gateway.filters.RateLimitFilter;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;
import org.springframework.cloud.client.loadbalancer.LoadBalanced;
import org.springframework.cloud.netflix.eureka.EnableEurekaClient;
import org.springframework.cloud.netflix.zuul.EnableZuulProxy;
import org.springframework.cloud.netflix.zuul.EnableZuulServer;
import org.springframework.context.annotation.Bean;
import org.springframework.http.client.ClientHttpRequestFactory;
import org.springframework.http.client.HttpComponentsClientHttpRequestFactory;
import org.springframework.http.client.Netty4ClientHttpRequestFactory;
import org.springframework.web.client.RestTemplate;

/**
 * Created by ligson on 2016/12/13.
 */
@SpringBootApplication
@EnableDiscoveryClient
@EnableEurekaClient
@EnableZuulProxy
public class Application {
    @Bean
    public ClientHttpRequestFactory nettyHttpRequestFactory() {
        //注意使用nettyclient时需要修改netty版本到4.1.0
        Netty4ClientHttpRequestFactory requestFactory = new Netty4ClientHttpRequestFactory();
        return requestFactory;
    }

   /* @Bean
    public ClientHttpRequestFactory httpclientRequestFactory() {
        HttpComponentsClientHttpRequestFactory client = new HttpComponentsClientHttpRequestFactory();
        return client;
    }*/

    /*@Bean
    public ILoadBalancer loadBalancer() {
        return new ZoneAwareLoadBalancer();
    }*/

    @Bean
    @LoadBalanced
    public RestTemplate restTemplate(ClientHttpRequestFactory clientHttpRequestFactory) {
        RestTemplate restTemplate = new RestTemplate();
        restTemplate.setRequestFactory(clientHttpRequestFactory);
        return restTemplate;
    }

    @Bean
    public RateLimitFilter rateLimitFilter() {
        return new RateLimitFilter();
    }

    public static void main(String[] args) {
        SpringApplication.run(Application.class, args);
    }
}
