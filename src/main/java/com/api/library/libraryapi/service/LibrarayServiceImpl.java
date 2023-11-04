package com.api.library.libraryapi.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.api.library.libraryapi.exception.NoBookFoundException;
import com.api.library.libraryapi.pojo.Book;
import com.api.library.libraryapi.repository.LibraryRepository;

@Service
public class LibrarayServiceImpl {
    
    @Autowired
    LibraryRepository libraryRepository;

    public void bookAdd(Book book){
        libraryRepository.addBook(book);
    }

    public List<Book> booksget(){
        return libraryRepository.getBooks();
    }

    public Book bookGet(String id) throws NoBookFoundException{
        int index=findIndexById(id);
        if(index==-1)
            throw new NoBookFoundException();
        
        return libraryRepository.getBook(index);
    }

    public void bookUpdate(String id,Book book) throws NoBookFoundException{
        int index=findIndexById(id);
        if(index==-1)
            throw new NoBookFoundException();
        libraryRepository.updateBook(index, book);
    }

    public void bookDelete(String id) throws NoBookFoundException{
        int index=findIndexById(id);
        if(index==-1)
            throw new NoBookFoundException();
        libraryRepository.deleteBook(index);
    }

    public int findIndexById(String id){
        int index=0;
        List<Book> bs=libraryRepository.getBooks();
        for(Book b:bs){
            if(b.getId().equals(id))
                return index;
            index++;

        }
        return -1;
    }
}
