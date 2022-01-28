package top.cgblogs.testdemo1;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;
import springfox.documentation.swagger2.annotations.EnableSwagger2;

@EnableSwagger2
@EnableDiscoveryClient
@SpringBootApplication
@MapperScan("top.cgblogs.testdemo1.mapper")
public class TestDemo1Application {
    public static void main(String[] args) {
        SpringApplication.run(TestDemo1Application.class, args);
    }
}
