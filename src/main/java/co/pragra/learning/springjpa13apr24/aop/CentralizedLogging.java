package co.pragra.learning.springjpa13apr24.aop;

import com.fasterxml.jackson.databind.ObjectMapper;
import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Pointcut;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Component;

import java.time.Instant;

@Aspect
@Component
public class CentralizedLogging {
    Logger logger = LoggerFactory.getLogger(CentralizedLogging.class);

    // Point Cut
    @Pointcut(value = "execution(* co.pragra.learning.springjpa13apr24.service.*.*(..))")
    public void firstPointCut(){
    }

    @Around(value = "firstPointCut()")
    public void loggingAdvice(ProceedingJoinPoint pjp) throws Throwable{
        ObjectMapper mapper = new ObjectMapper();
        String className = pjp.getTarget().getClass().toString();
        String methodName = pjp.getSignature().getName();
        Object[] args = pjp.getArgs();
        logger.info(Instant.now() + " Method Invoked: "
                + className + " : " + methodName +
                " Arguments: " + mapper.writeValueAsString(args));
        Object proceed = pjp.proceed();
        logger.info(Instant.now() + " Method Finished: "
                + className + " : " + methodName +
                " Returns: " + mapper.writeValueAsString(proceed));
    }
}
