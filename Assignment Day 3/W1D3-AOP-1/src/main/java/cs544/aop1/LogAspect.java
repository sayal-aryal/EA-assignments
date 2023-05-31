package cs544.aop1;

import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.annotation.After;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Pointcut;
import org.springframework.stereotype.Component;

import java.time.LocalDateTime;
import java.util.Date;
import java.util.logging.LogManager;
import java.util.logging.Logger;

@Aspect
@Component
public class LogAspect {

//    @After("execution(* cs544.aop1.EmailSender.sendEmail(String, String))")
//    public void afterSendEmail(JoinPoint joinPoint) {
//        System.out.println(new Date() +" method= "+ joinPoint.getSignature().getName());
//    }

    @Pointcut("execution(* cs544.aop1.EmailSender.sendEmail(String, String))")
    public void logEmailSend() {
    }

    @After("logEmailSend()")
    public void afterSendEmail(JoinPoint joinPoint) {
        System.out.println(new Date() +" method= "+ joinPoint.getSignature().getName());
        Object[] objs = joinPoint.getArgs();
        System.out.println("address = "+objs[0]+" message = "+objs[1]);
        EmailSender sender = (EmailSender) joinPoint.getTarget();
        System.out.println("outgoing mail server = " + sender.outgoingMailServer);
    }


}
