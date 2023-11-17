package com.workintech.Libraryapp.service;

import com.workintech.Libraryapp.entity.Book;

import java.util.List;

public interface BookService {
    List<Book> findAll();
    Book findById(long id);
    Book save(Book book);
    Book saveByCategoryId(Book book , long id);
    Book saveByAuthorId(Book book , long id);
    Book saveByCategoryAndAuthorId(Book book , long categoryId , long authorId);
    Book delete(long id);
}
