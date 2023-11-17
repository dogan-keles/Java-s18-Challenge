package com.workintech.Libraryapp.service;

import com.workintech.Libraryapp.entity.Author;

import java.util.List;

public interface AuthorService {
    List<Author> findAll();
    Author findById(long id);
    Author save(Author author);
    Author delete(long id);
    Author saveByBookId(Author author, long id);
}
