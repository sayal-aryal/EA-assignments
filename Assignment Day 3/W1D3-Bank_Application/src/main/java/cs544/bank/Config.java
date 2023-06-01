package cs544.bank;

import cs544.bank.dao.AccountDAO;
import cs544.bank.dao.IAccountDAO;
import cs544.bank.jms.IJMSSender;
import cs544.bank.jms.JMSSender;
import cs544.bank.logging.ILogger;
import cs544.bank.logging.Logger;
import cs544.bank.service.CurrencyConverter;
import cs544.bank.service.ICurrencyConverter;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;

@Configuration
@ComponentScan("cs544")
public class Config {
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
}