package com.api.library.libraryapi.web;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.api.library.libraryapi.pojo.Book;
import com.api.library.libraryapi.service.LibrarayServiceImpl;

@RestController
public class LibraryController{

    @Autowired
    private LibrarayServiceImpl libraryServiceImpl;

    @GetMapping("/book/{id}")
    public ResponseEntity<Book> getBook(@PathVariable String id){
        try{
            Book b=libraryServiceImpl.bookGet(id);
            System.out.println("Name:"+b.getName()+" Id:"+b.getId()+" Author Name:"+b.getAuthor_name());
            return new ResponseEntity<>(b,HttpStatus.OK);
        }catch(Exception e){
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
        
    }

    @GetMapping("/book/all")
    public ResponseEntity<List<Book>> getBooks(){
        
        List<Book> bs=libraryServiceImpl.booksget();
        return new ResponseEntity<>(bs,HttpStatus.OK);
    
    }

    @PostMapping("/book")
    public ResponseEntity<HttpStatus> addBook(@RequestBody Book book){
        libraryServiceImpl.bookAdd(book);
        return new ResponseEntity<>(HttpStatus.OK);
    }

    @PutMapping("/book/{id}")
    public ResponseEntity<HttpStatus> updateBook(@RequestBody Book book,@PathVariable String id){
        try{
            libraryServiceImpl.bookUpdate(id, book);
            return new ResponseEntity<>(HttpStatus.OK);                
        }catch(Exception e){
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
    }

    @DeleteMapping("/book/{id}")
    public ResponseEntity<HttpStatus> deleteBook(@PathVariable String id){
        try{
            libraryServiceImpl.bookDelete(id);
            return new ResponseEntity<>(HttpStatus.OK);
        }catch(Exception e){
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
    }
}