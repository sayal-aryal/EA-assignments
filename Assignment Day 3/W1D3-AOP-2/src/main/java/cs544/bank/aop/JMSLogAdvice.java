package cs544.bank.aop;

import org.aspectj.lang.annotation.After;
import org.aspectj.lang.annotation.Aspect;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import cs544.bank.logging.ILogger;


@Aspect
@Component
public class JMSLogAdvice {

    private final ILogger logger;

    @Autowired
    public JMSLogAdvice(ILogger logger) {
        this.logger = logger;
    }

    @After("execution(* cs544.bank.jms.JMSSender.sendJMSMessage(..)) && args(message)")
    public void logJMSMessage(String message) {
        logger.log("JMS message sent: " + message);
    }
}
