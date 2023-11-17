package com.workintech.Libraryapp.service;

import com.workintech.Libraryapp.entity.Category;

import java.util.List;

public interface CategoryService {
    Category findById(long id);
    List<Category> findAll();
    Category save(Category category);
    Category delete(long id);
    Category saveBookById(Category category, long id);
}
