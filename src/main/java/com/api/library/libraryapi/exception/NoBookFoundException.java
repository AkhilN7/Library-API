package com.api.library.libraryapi.exception;

public class NoBookFoundException extends Exception{
    public NoBookFoundException(){
        System.out.println("The Book you are searching for is not there!!");
    }
}