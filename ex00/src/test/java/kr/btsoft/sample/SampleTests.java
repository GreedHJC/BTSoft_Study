package kr.btsoft.sample;


import lombok.Setter;
import lombok.extern.log4j.Log4j;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import static org.junit.Assert.assertNotNull;

@RunWith(SpringJUnit4ClassRunner.class)  // 테스트 코드가 스프링을 실행하는 역할
//지정된 클래스나 문자열을 이용해서 필요한 객체를 스프링 내에 객체로 등록(스프링 빈) ex: classpath: OR file:
@ContextConfiguration("file:src/main/webapp/WEB-INF/spring/root-context.xml")
@Log4j
public class SampleTests {

    @Setter(onMethod_ = { @Autowired })
    private Restaurant restaurant;

    @Test
    public void testExist() {

        assertNotNull(restaurant); //restaurant 변수가 null이 아니어야만 테스트가 성공한다는것을 의미

        log.info(restaurant);
        log.info("============================================");
        log.info(restaurant.getChef());
    }
}
