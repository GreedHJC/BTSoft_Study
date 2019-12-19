package kr.btsoft.config;

import com.zaxxer.hikari.HikariConfig;
import com.zaxxer.hikari.HikariDataSource;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.mybatis.spring.SqlSessionFactoryBean;
import org.mybatis.spring.SqlSessionTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import javax.sql.DataSource;

//클래스의 인스턴스를 이용해 설정파일 대신
@Configuration
public class RootConfig {

    @Autowired
    private ApplicationContext applicationContext;

    @Bean
    public DataSource dataSource() {
        HikariConfig hikariConfig = new HikariConfig();
        hikariConfig.setDriverClassName("oracle.jdbc.driver.OracleDriver");
        hikariConfig.setJdbcUrl("jdbc:oracle:thin:@192.168.1.13:1521:orcl");
        hikariConfig.setUsername("study");
        hikariConfig.setPassword("bts5735!");

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

    @Bean
    public SqlSession sqlSession() throws Exception {
        SqlSessionTemplate sqlSessionTemplate = new SqlSessionTemplate(sqlSessionFactory());
        return sqlSessionTemplate;
    }
}
