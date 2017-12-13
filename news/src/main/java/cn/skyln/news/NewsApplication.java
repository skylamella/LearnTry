package cn.skyln.news;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Configuration;

@SpringBootApplication
@Configuration
@MapperScan("cn.skyln.news.dao")
public class NewsApplication {

	
	public static void main(String[] args) {
		SpringApplication.run(NewsApplication.class, args);
	}
}
