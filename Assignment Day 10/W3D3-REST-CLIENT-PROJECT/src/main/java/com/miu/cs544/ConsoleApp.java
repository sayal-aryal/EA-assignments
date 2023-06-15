package com.miu.cs544;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

@Component
public class ConsoleApp implements CommandLineRunner {
    @Autowired
    private BookServiceProxy bookServiceProxy;
    @Override
public void run(String... args) {
        Book book = bookServiceProxy.get(1);
        bookServiceProxy.add(new Book(null,"Book","1233445234523","Nischal",30.5));
        System.out.println(bookServiceProxy.getAll());
        book.setPrice(50);
        bookServiceProxy.update(book);
        System.out.println(bookServiceProxy.getAll());
        bookServiceProxy.delete(1);
        System.out.println(bookServiceProxy.getAll());
        book = bookServiceProxy.getAll().get(0);
        System.out.println(book.getAuthor());
}
}
