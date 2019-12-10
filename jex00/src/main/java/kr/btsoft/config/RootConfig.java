package kr.btsoft.config;

import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;

//클래스의 인스턴스를 이용해 설정파일 대신
@Configuration
@ComponentScan(basePackages = {"kr.btsoft.sample"})
public class RootConfig {
	
}
