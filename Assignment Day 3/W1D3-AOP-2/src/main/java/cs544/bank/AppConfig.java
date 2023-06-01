package cs544.bank;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.EnableAspectJAutoProxy;

import cs544.bank.aop.DAOLogAdvice;
import cs544.bank.aop.JMSLogAdvice;
import cs544.bank.aop.StopWatchAdvice;
import cs544.bank.dao.AccountDAO;
import cs544.bank.dao.IAccountDAO;
import cs544.bank.jms.IJMSSender;
import cs544.bank.jms.JMSSender;
import cs544.bank.logging.ILogger;
import cs544.bank.logging.Logger;
import cs544.bank.service.AccountService;
import cs544.bank.service.CurrencyConverter;
import cs544.bank.service.IAccountService;
import cs544.bank.service.ICurrencyConverter;

@Configuration
@EnableAspectJAutoProxy
@ComponentScan("cs544")
public class AppConfig {
    @Bean
    public IAccountDAO accountDAO() {
        return new AccountDAO();
    }
    @Bean
    public ICurrencyConverter currencyConverter() {
        return new CurrencyConverter();
    }
    @Bean
    public IJMSSender jmsSender() {
        return new JMSSender();
    }
    @Bean
    public ILogger logger() {
        return new Logger();
    }
    @Bean
    public IAccountService accountService() {
        return new AccountService();
    }
    @Bean
    public StopWatchAdvice stopWatchAdvice() {
        return new StopWatchAdvice();
    }

    @Bean
    public JMSLogAdvice jmsLogAdvice() {
        return new JMSLogAdvice(logger());
    }

    @Bean
    public DAOLogAdvice daoLogAdvice() {
        return new DAOLogAdvice(logger());
    }
}
