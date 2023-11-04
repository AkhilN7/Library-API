package com.api.library.libraryapi.repository;

import java.util.ArrayList;
import java.util.List;

import org.springframework.stereotype.Repository;

import com.api.library.libraryapi.pojo.Book;

@Repository
public class LibraryRepository {

    List<Book> books=new ArrayList<>();

    public List<Book> getBooks(){
        return books;
    }

    public Book getBook(int index){
        return books.get(index);
    }

    public void addBook(Book book){
        books.add(book);
    }

    public void updateBook(int index,Book book){
        books.set(index,book);
    }


    public void deleteBook(int index){
        books.remove(index);
    }
    
}
