package ru.lernup.transaction.dao.exeption;

public class NotHaveBookException extends RuntimeException{
    public NotHaveBookException(Object o){
        super(o.toString());
    }
}
