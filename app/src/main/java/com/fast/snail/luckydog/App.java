package com.fast.snail.luckydog;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;
import org.springframework.context.annotation.Bean;
import org.springframework.web.cors.CorsConfiguration;
import org.springframework.web.cors.UrlBasedCorsConfigurationSource;
import org.springframework.web.filter.CorsFilter;

@SpringBootApplication
@EnableDiscoveryClient
public class App {

    public static void main(String[] args) {
        SpringApplication.run(App.class, args);
    }
    @Bean
    public CorsFilter corsFilter() {

        //创建CorsConfiguration对象后添加配置
        CorsConfiguration config = new CorsConfiguration();
        //设置放行哪些原始域
        config.addAllowedOrigin("*");
        //放行哪些原始请求头部信息
        config.addAllowedHeader("*");
        //暴露哪些头部信息
        config.addExposedHeader("*");
        //放行哪些请求方式
        //        config.addAllowedMethod("GET");     //get
        //        config.addAllowedMethod("PUT");     //put
        //        config.addAllowedMethod("POST");    //post
        //        config.addAllowedMethod("DELETE");  //delete
        config.addAllowedMethod("*");     //放行全部请求

        //是否发送Cookie
        config.setAllowCredentials(true);

        //2. 添加映射路径
        UrlBasedCorsConfigurationSource corsConfigurationSource =
            new UrlBasedCorsConfigurationSource();
        corsConfigurationSource.registerCorsConfiguration("/**", config);
        //返回CorsFilter
        return new CorsFilter(corsConfigurationSource);
    }

//    @Bean
//    public BeanRegistrationAotProc beanRegistrationAotProc() {
//        return new BeanRegistrationAotProc();
//    }
}
