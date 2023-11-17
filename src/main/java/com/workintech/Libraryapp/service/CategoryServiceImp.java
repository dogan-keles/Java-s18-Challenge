package com.workintech.Libraryapp.service;

import com.workintech.Libraryapp.entity.Book;
import com.workintech.Libraryapp.entity.Category;
import com.workintech.Libraryapp.exceptions.LibraryException;
import com.workintech.Libraryapp.repository.BookRepository;
import com.workintech.Libraryapp.repository.CategoryRepository;
import org.aspectj.weaver.NewConstructorTypeMunger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class CategoryServiceImp implements CategoryService{
    private CategoryRepository categoryRepository;
    private BookRepository bookRepository;
    @Autowired
    public CategoryServiceImp(CategoryRepository categoryRepository, BookRepository bookRepository) {
        this.categoryRepository = categoryRepository;
        this.bookRepository = bookRepository;
    }




    @Override
    public Category findById(long id) {
        Optional<Category> categoryOptional = categoryRepository.findById(id);
        if(categoryOptional.isPresent()) {
            categoryOptional.get();

        }
        throw new LibraryException("Given id is not exist", HttpStatus.NOT_FOUND);
    }

    @Override
    public Category save(Category category) {
        return categoryRepository.save(category);
    }

    @Override
    public List<Category> findAll() {
        return categoryRepository.findAll();
    }

    @Override
    public Category delete(long id) {
        Category category = findById(id);
        categoryRepository.delete(category);
        return category;
    }

    @Override
    public Category saveBookById(Category category, long id) {
        Optional<Book> optionalBook = bookRepository.findById(id);
        if(optionalBook.isPresent()){
            category.addBook(optionalBook.get());
            optionalBook.get().setCategory(category);
            return categoryRepository.save(category);
        }

        throw new LibraryException("Given id is not exist", HttpStatus.NOT_FOUND);
    }
}
