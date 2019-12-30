package kr.btsoft.config;

import org.springframework.web.filter.CharacterEncodingFilter;
import org.springframework.web.servlet.support.AbstractAnnotationConfigDispatcherServletInitializer;

import javax.servlet.Filter;
import javax.servlet.ServletRegistration;

// 3개의 추상 메서드를 오버라이드 하도록 작성.
public class WebConfig extends AbstractAnnotationConfigDispatcherServletInitializer {

    //root-context.xml을 대신하는 클래스를 지정하는곳이나 예제에서는 RootConfig 에서 대체하므로 리턴 null을 new Class[] {RootConfig.class}로 수정
    @Override
    protected Class<?>[] getRootConfigClasses() {
        return new Class[]{WebSecurityConfig.class, RootConfig.class};
    }

    @Override
    protected Class<?>[] getServletConfigClasses() {    //ServletConfig 클래스를 정상적으로 동작하기 위해 ServletConfig.class를 추가
        return new Class[]{ServletConfig.class};
    }

    @Override
    protected String[] getServletMappings() {        //스프링MVC의 기본 경로도 '/'로 변경
        return new String[]{"/"};
    }

    @Override
    protected void customizeRegistration(ServletRegistration.Dynamic registration) {
        registration.setInitParameter("throwExceptionIfNoHandlerFound", "true");
    }

    @Override
    protected Filter[] getServletFilters() {
        CharacterEncodingFilter encodingFilter = new CharacterEncodingFilter();
        encodingFilter.setEncoding("UTF-8");

        return new Filter[]{encodingFilter};
    }
}
