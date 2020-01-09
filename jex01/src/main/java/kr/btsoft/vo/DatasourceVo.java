package kr.btsoft.vo;

import lombok.Getter;
import lombok.ToString;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.PropertySource;
import org.springframework.stereotype.Component;

@Component
@PropertySource("classpath:config/datasource.properties")
@Getter
@ToString
public class DatasourceVo {

    @Value("${datasource.classname}")
    private String classname;

    @Value("${datasource.username}")
    private String user;

    @Value("${datasource.password}")
    private String password;

    @Value("${datasource.dburl}")
    private String url;

}
