package cs544.bank.aop;

import cs544.bank.logging.ILogger;
import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.annotation.After;
import org.aspectj.lang.annotation.Aspect;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Aspect
@Component
public class DAOLogAdvice {

    private final ILogger logger;

    @Autowired
    public DAOLogAdvice(ILogger logger) {
        this.logger = logger;
    }

    @After("execution(* cs544.bank.dao.AccountDAO.*(..))")
    public void logDAOCall(JoinPoint joinPoint) {
        String methodName = joinPoint.getSignature().getName();
        logger.log("Method called: " + methodName);
    }
}
