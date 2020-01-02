package kr.btsoft.config;

import com.zaxxer.hikari.HikariConfig;
import com.zaxxer.hikari.HikariDataSource;
import org.apache.ibatis.session.SqlSessionFactory;
import org.mybatis.spring.SqlSessionFactoryBean;
import org.mybatis.spring.annotation.MapperScan;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.EnableAspectJAutoProxy;

import javax.sql.DataSource;

//클래스의 인스턴스를 이용해 설정파일 대신
@Configuration
@ComponentScan(basePackages = {"kr.btsoft.sample","kr.btsoft.controller", "kr.btsoft.service"})
@ComponentScan(basePackages = "kr.btsoft.aop")
@EnableAspectJAutoProxy

@MapperScan(basePackages = {"kr.btsoft.mapper"})
public class RootConfig {

    @Bean
    public DataSource dataSource() {
        HikariConfig hikariConfig = new HikariConfig();
        hikariConfig.setDriverClassName("net.sf.log4jdbc.sql.jdbcapi.DriverSpy");
        hikariConfig.setJdbcUrl("jdbc:log4jdbc:oracle:thin:@localhost:1521:orcl");
//        hikariConfig.setDriverClassName("oracle.jdbc.driver.OracleDriver");
//        hikariConfig.setJdbcUrl("jdbc:oracle:thin:@localhost:1521:orcl");
        hikariConfig.setUsername("book_ex");
        hikariConfig.setPassword("bts5735");

        HikariDataSource dataSource = new HikariDataSource(hikariConfig);

        return dataSource;
    }

    @Bean
    public SqlSessionFactory sqlSessionFactory() throws  Exception{
        SqlSessionFactoryBean sqlSessionFactory = new SqlSessionFactoryBean();
        sqlSessionFactory.setDataSource((dataSource()));
        return (SqlSessionFactory) sqlSessionFactory.getObject();
    }
}
