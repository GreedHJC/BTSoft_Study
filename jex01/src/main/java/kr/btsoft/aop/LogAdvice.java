package kr.btsoft.aop;

import lombok.extern.log4j.Log4j;
import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.AfterThrowing;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.springframework.stereotype.Component;

import java.util.Arrays;

/**
 * description
 *
 * @author : jcHwang
 */

@Aspect     //해당 클래스의 객체가 Aspect를 구현한 것임을 나타내기 위해 사용
@Log4j
@Component  //@Component는 AOP와는 관계가 없지만 스프링에서 Bean으로 인식하기 위해서 사용
public class LogAdvice {


    // execution은 AspectJ의 표현식, 맨 앞의 *은 접근제한자를 의미, 맨뒤의 *는 클래스의 이름과 메서드의 이름을 의미
    @Before( "execution(* kr.btsoft.service.SampleService*.*(..))")     //BeforeAdvice를 구현한 메서드에 추가
    public void logBefore() {
        log.info("===========================================");
    }

    // logBeforeWithParam() 'exception'으로 시작하는 Pointcut 설정에 doAdd()메서드를명시하고, 파라미터 타입을 지정함으로서 파라미터 추적
    // '&& args'를 이용하는 설정은 간단히 파라미터를 찾아서 기록할때는 유용하지만 파라미터가 다른여러 종류의 메서드에 적용하는 데에는 간단하지 않다는 단점.
    // 이 문제는 @Around 와 ProceedingJoinPoint 를 이용해서 해결 가능
    @Before( "execution(* kr.btsoft.service.SampleService*.doAdd(String, String)) && args(str1, str2)")     //BeforeAdvice를 구현한 메서드에 추가
    public void logBeforeWithParam(String str1, String str2) {
        log.info("str1: " + str1);
        log.info("str2: " + str2);
    }

    // 코드를 실행하다보면 파라미터의 값이 잘못되어서 예외가 발생하는 경우가 많으므로,
    // AOP의 @AfterThrowing 어노테이션을 사용하여 지정된 대상이 예외를 발생한 후에 동작하면서 문제를 해결할수있게 도와줌
    @AfterThrowing(pointcut = "execution(* kr.btsoft.service.SampleService*.*(..))", throwing = "exception")
    public void logException(Exception exception) {
        log.info("Exception...............!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!");
        log.info(("exception : " + exception));
    }

    @Around("execution(* kr.btsoft.service.SampleService*.*(..))")
    public Object logTime(ProceedingJoinPoint pjp){
        long start = System.currentTimeMillis();

        log.info("Target : " + pjp.getTarget());
        log.info("Param : " + Arrays.toString(pjp.getArgs()));

        //invoke method
        Object result =  null;

        try{
            result = pjp.proceed();
        }catch (Throwable e){
            // TODO Auto-generated catch block
            e.printStackTrace();
        }

        long end = System.currentTimeMillis();

        log.info("TIME : " + (end - start));
        return result;
    }
}
