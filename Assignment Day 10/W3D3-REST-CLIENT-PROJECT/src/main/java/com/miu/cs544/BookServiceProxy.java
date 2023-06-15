package com.miu.cs544;

import java.net.URI;
import java.util.List;
import java.util.regex.Pattern;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.ParameterizedTypeReference;
import org.springframework.http.HttpMethod;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;



@Service
public class BookServiceProxy implements IBookService{
    @Autowired
private RestTemplate restTemplate;
private final String bookUrl = "http://localhost:8082/books/{id}";
private final String booksUrl = "http://localhost:8082/books";

    public Book get(int id) {
    return restTemplate.getForObject(booksUrl+"/"+String.valueOf(id), Book.class, id);
    }

    public List<Book> getAll() {
    ResponseEntity<List<Book>> response =
    restTemplate.exchange(booksUrl, HttpMethod.GET, null,
    new ParameterizedTypeReference<List<Book>>() {});
    return response.getBody();
    }

    public Integer add(Book book) {
    URI uri = restTemplate.postForLocation(booksUrl, book);
    if (uri == null) { return null; }
    java.util.regex.Matcher m = Pattern.compile(".*/books/(\\d+)").matcher(uri.getPath());
    m.matches();
    return Integer.parseInt(m.group(1));
    }


    public void update(Book book) {
        restTemplate.put(bookUrl, book, book.getId());
    }

    public void delete(int id) {
        restTemplate.delete(bookUrl, id);
    }

}