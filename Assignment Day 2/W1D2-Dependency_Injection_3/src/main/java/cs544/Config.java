package cs544;

import java.util.ArrayList;
import java.util.List;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class Config {
    
    @Bean
    public IBookSupplier amazon() {
        return new Amazon();
    }
    
    @Bean
    public IBookSupplier barnesAndNoble() {
        return new BarnesAndNoble();
    }
    
    @Bean
    public IBookSupplier eBooks() {
        return new EBooks();
    }

    @Bean
    public IBookSupplier borders(){
        return new Borders();
    }
    
    @Bean
    public IBookService bookService() {
        List<IBookSupplier> suppliers = new ArrayList<>();
        suppliers.add(amazon());
        suppliers.add(barnesAndNoble());
        suppliers.add(eBooks());
        suppliers.add(borders());
        return new BookService(suppliers);
    }
}
