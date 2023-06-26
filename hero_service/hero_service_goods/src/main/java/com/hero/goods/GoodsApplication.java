package com.hero.goods;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;

/**
 * @Author: pzhu
 * @Date: 2023/6/26 10:54
 */
@SpringBootApplication
@EnableDiscoveryClient
@MapperScan(basePackages = {"com.hero.goods.mapper"})
public class GoodsApplication {
    public static void main(String[] args) {
        SpringApplication.run(GoodsApplication.class);
    }

}
