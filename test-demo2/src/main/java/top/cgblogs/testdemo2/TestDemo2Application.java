package top.cgblogs.testdemo2;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;
import org.springframework.cloud.openfeign.EnableFeignClients;
import springfox.documentation.swagger2.annotations.EnableSwagger2;

@EnableSwagger2
@EnableFeignClients
@EnableDiscoveryClient
@SpringBootApplication
@MapperScan("top.cgblogs.testdemo2.mapper")
public class TestDemo2Application {
    public static void main(String[] args) {
        SpringApplication.run(TestDemo2Application.class, args);
    }
}
