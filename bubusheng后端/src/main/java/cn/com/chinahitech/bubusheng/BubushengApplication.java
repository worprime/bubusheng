package cn.com.chinahitech.bubusheng;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
@MapperScan(basePackages = {"cn.com.chinahitech.bubusheng.*.mapper"})
public class BubushengApplication {

    public static void main(String[] args) {
        SpringApplication.run(BubushengApplication.class, args);
    }

}
