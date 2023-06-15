package com.miu.cs544;

import java.util.List;

interface IBookService  {
   
   public List<Book> getAll();
       
   public Integer add(Book book) ;
        
   public Book get(int id);
        
   public void update(Book book);
        
   public void delete(int id);
        
}
