package kr.btsoft.config;

import org.springframework.context.annotation.ComponentScan;
import org.springframework.web.servlet.config.annotation.EnableWebMvc;
import org.springframework.web.servlet.config.annotation.ResourceHandlerRegistry;
import org.springframework.web.servlet.config.annotation.ViewResolverRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;
import org.springframework.web.servlet.view.InternalResourceViewResolver;
import org.springframework.web.servlet.view.JstlView;

@EnableWebMvc
@ComponentScan(basePackages = {"kr.btsoft.controller"})     //@ComponentScan 다른 패키지에 작성된 스프링의 객체(bean)를 인식
//servlet-context.xml을 대신하는곳
//ServletConfig를 정상적으로 실행하기 위해서 WebConfig의 설정에 추가
public class ServletConfig implements WebMvcConfigurer { //WebMvcConfigurer는 스프링 MVC와 관련된 설정을 메서도르로 오버라이드 하는 형태로 이용할때 사용

    @Override
    public void configureViewResolvers(ViewResolverRegistry registry) {
        InternalResourceViewResolver bean = new InternalResourceViewResolver();
        bean.setViewClass(JstlView.class);
        bean.setPrefix("/WEB-INF/views/");
        bean.setSuffix(".jsp");
        registry.viewResolver(bean);
    }

    @Override
    public void addResourceHandlers(ResourceHandlerRegistry registry){
        registry.addResourceHandler("/resources/**").addResourceLocations("/resources/");
    }
}
