package kr.btsoft.config;

import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.FilterType;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.ControllerAdvice;

@Configuration
@ComponentScan(basePackages = {"kr.btsoft"}, excludeFilters = {@ComponentScan.Filter(type= FilterType.ANNOTATION, value={Controller.class, ControllerAdvice.class, Configuration.class})})
public class MultipartConfigElement {
	private final String location;
	private final long maxFileSize;
	private final long maxRequestSize;
	private final int fileSizeThreshold;
	
	public MultipartConfigElement(String location) {
		if(location != null) {
			this.location = location;
		} else {
			this.location = "";
		}
		this.maxFileSize = -1;
		this.maxRequestSize = -1;
		this.fileSizeThreshold = 0;
	}
}
