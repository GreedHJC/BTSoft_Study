package kr.btsoft.config;

import com.zaxxer.hikari.HikariConfig;
import com.zaxxer.hikari.HikariDataSource;
import org.apache.ibatis.session.SqlSessionFactory;
import org.mybatis.spring.SqlSessionFactoryBean;
import org.mybatis.spring.annotation.MapperScan;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;

import javax.sql.DataSource;

//클래스의 인스턴스를 이용해 설정파일 대신
@Configuration
@ComponentScan(basePackages = {"kr.btsoft.sample"})
@MapperScan(basePackages = {"kr.btsoft.mapper"})
public class RootConfig {

    @Bean
    public SqlSessionFactory sqlSessionFactory() throws  Exception{
        SqlSessionFactoryBean sqlSessionFactory = new SqlSessionFactoryBean();
        sqlSessionFactory.setDataSource((dataSource()));
        return (SqlSessionFactory) sqlSessionFactory.getObject();
    }
    @Bean
    public DataSource dataSource() {
        HikariConfig hikariConfig = new HikariConfig();
        hikariConfig.setDriverClassName("oracle.jdbc.driver.OracleDriver");
        hikariConfig.setJdbcUrl("jdbc:oracle:thin:@localhost:1521:orcl");
        hikariConfig.setUsername("book_ex");
        hikariConfig.setPassword("bts5735");

        HikariDataSource dataSource = new HikariDataSource(hikariConfig);

        return dataSource;
    }
}
