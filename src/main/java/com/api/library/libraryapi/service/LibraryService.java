package com.api.library.libraryapi.service;

import java.util.List;

import com.api.library.libraryapi.exception.NoBookFoundException;
import com.api.library.libraryapi.pojo.Book;

public interface LibraryService {
    public void bookAdd(Book book);
    public void bookUpdate(String id,Book book) throws NoBookFoundException;
    public void bookDelete(String id) throws NoBookFoundException;
    public Book bookGet(String id) throws NoBookFoundException;
    public List<Book> booksget();
}
