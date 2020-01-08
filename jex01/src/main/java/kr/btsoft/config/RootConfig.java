package kr.btsoft.config;

import com.zaxxer.hikari.HikariConfig;
import com.zaxxer.hikari.HikariDataSource;
import kr.btsoft.vo.DatasourceVo;
import org.apache.ibatis.ognl.ParseException;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.mybatis.spring.SqlSessionFactoryBean;
import org.mybatis.spring.SqlSessionTemplate;
import org.mybatis.spring.annotation.MapperScan;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.support.PropertySourcesPlaceholderConfigurer;
import org.springframework.jdbc.datasource.DataSourceTransactionManager;
import org.springframework.transaction.PlatformTransactionManager;
import org.springframework.transaction.annotation.EnableTransactionManagement;

import javax.sql.DataSource;
import java.io.IOException;
import java.net.URISyntaxException;
import java.security.GeneralSecurityException;

//클래스의 인스턴스를 이용해 설정파일 대신
@EnableTransactionManagement
@Configuration
@MapperScan(basePackages = {"kr.btsoft.dao"})
@ComponentScan(basePackages = {"kr.btsoft.vo"})
public class RootConfig {

    @Autowired
    private ApplicationContext applicationContext;

    @Autowired
    private DatasourceVo datasourceVo;

    @Bean
    public DataSource dataSource() {
        HikariConfig hikariConfig = new HikariConfig();
        hikariConfig.setDriverClassName(datasourceVo.getClassname());
        hikariConfig.setJdbcUrl(datasourceVo.getUrl());
        hikariConfig.setUsername(datasourceVo.getUser());
        hikariConfig.setPassword(datasourceVo.getPassword());

        HikariDataSource dataSource = new HikariDataSource(hikariConfig);

        return dataSource;
    }

    @Bean
    public SqlSessionFactory sqlSessionFactory() throws  Exception{
        SqlSessionFactoryBean sqlSessionFactory = new SqlSessionFactoryBean();
        sqlSessionFactory.setDataSource((dataSource()));
        sqlSessionFactory.setMapperLocations(applicationContext.getResources("classpath*:/mappers/*.xml"));
        return (SqlSessionFactory) sqlSessionFactory.getObject();
    }

//    @Bean
//    public SqlSession sqlSession() throws Exception {
//        SqlSessionTemplate sqlSessionTemplate = new SqlSessionTemplate(sqlSessionFactory());
//        return sqlSessionTemplate;
//    }

    @Bean
    public PlatformTransactionManager transactionManager() throws URISyntaxException, GeneralSecurityException, ParseException, IOException {
        return new DataSourceTransactionManager(dataSource());
    }
}
