package kr.btsoft.config;

import org.springframework.web.servlet.support.AbstractAnnotationConfigDispatcherServletInitializer;

// 3개의 추상 메서드를 오버라이드 하도록 작성.
public class WebConfig extends AbstractAnnotationConfigDispatcherServletInitializer {

	//root-context.xml을 대신하는 클래스를 지정하는곳이나 예제에서는 RootConfig 에서 대체하므로 리턴 null을 new Class[] {RootConfig.class}로 수정
	@Override
	protected Class<?>[] getRootConfigClasses() {
		return new Class[] {RootConfig.class};
	}

	@Override
	protected Class<?>[] getServletConfigClasses() {
		return new Class[] {ServletConfig.class};
	}

	@Override
	protected String[] getServletMappings() {
		return new String[]{"/"};
	}

}
