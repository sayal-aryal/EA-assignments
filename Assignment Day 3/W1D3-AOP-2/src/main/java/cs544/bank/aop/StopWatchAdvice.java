package cs544.bank.aop;
import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;
import org.springframework.stereotype.Component;
import org.springframework.util.StopWatch;

@Aspect
@Component
public class StopWatchAdvice {
    @Around("execution(* cs544.bank.service.*.*(..))")
    public Object methodTimer(ProceedingJoinPoint joinPoint) throws Throwable {
        StopWatch stopWatch = new StopWatch();
        stopWatch.start();
        Object result = joinPoint.proceed();
        stopWatch.stop();
        String methodName = joinPoint.getSignature().getName();
        System.out.println("Method: " + methodName + " - Duration: " + stopWatch.getTotalTimeMillis() + " ms");
        return result;
    }
}
