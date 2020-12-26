package com.imooc.aspect;

import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.stereotype.Component;


@Component
@Aspect
public class ServiceLogAspect {
    private static final Logger logger = LoggerFactory.getLogger(ServiceLogAspect.class);

    @Around("execution(* com.imooc.service.impl..*.*(..))")
    public Object recordTimeLog(ProceedingJoinPoint joinPoint) throws Throwable {
        logger.info("===== 开始执行{}.{} ====",
                joinPoint.getTarget().getClass(),
                joinPoint.getSignature().getName());
        Long start = System.currentTimeMillis();
        Object result = joinPoint.proceed();
        Long end = System.currentTimeMillis();
        Long time = end - start;
        if (time > 3000) {
            logger.error("====== 执行结束，耗时：{} 毫秒 ======", time);
        } else if (time > 2000) {
            logger.warn("====== 执行结束，耗时：{} 毫秒 ======", time);
        } else {
            logger.info("====== 执行结束，耗时：{} 毫秒 ======", time);
        }
        return result;
    }

}
