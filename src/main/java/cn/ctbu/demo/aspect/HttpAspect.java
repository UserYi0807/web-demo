package cn.ctbu.demo.aspect;

import lombok.extern.slf4j.Slf4j;
import org.aspectj.lang.annotation.*;
import org.springframework.stereotype.Component;

@Component
@Aspect
@Slf4j
public class HttpAspect {

    @Pointcut("execution(* cn.ctbu.demo.webapi.StudentRestController.getAll(..))")
    public void log() {

    }

    @Before("log()")
    public void doBefore() {
        System.out.println("准备执行 getAll");
    }

    @After("log()")
    public void doAfter() {
        System.out.println("执行完毕");
    }

    @AfterReturning(returning = "object", pointcut = "log()")
    public void afterR(Object object) {
        log.info("response={}", object);
    }
}
