package com.workintech.Libraryapp.service;

import com.workintech.Libraryapp.entity.Author;
import com.workintech.Libraryapp.entity.Book;
import com.workintech.Libraryapp.exceptions.LibraryException;
import com.workintech.Libraryapp.repository.AuthorRepository;
import com.workintech.Libraryapp.repository.BookRepository;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class AuthorServiceImp implements AuthorService{
    private BookRepository bookRepository;
    private AuthorRepository authorRepository;

    public AuthorServiceImp(BookRepository bookRepository, AuthorRepository authorRepository) {
        this.bookRepository = bookRepository;
        this.authorRepository = authorRepository;
    }

    @Override
    public List<Author> findAll() {
        return authorRepository.findAll();
    }

    @Override
    public Author findById(long id) {
        Optional<Author> optionalAuthor = authorRepository.findById(id);
        if(optionalAuthor.isPresent()){
           return optionalAuthor.get();
        }
        throw new LibraryException("Given id is not exist", HttpStatus.NOT_FOUND);

    }

    @Override
    public Author save(Author author) {
        return authorRepository.save(author);
    }

    @Override
    public Author delete(long id) {
        Author author = findById(id);
      authorRepository.delete(author);
        return author;
    }

    @Override
    public Author saveByBookId(Author author, long id) {
        Optional<Book> optionalBook = bookRepository.findById(id);
        if(optionalBook.isPresent()){
            author.addBook(optionalBook.get());
           optionalBook.get().setAuthor(author);
            return authorRepository.save(author);
        }
        throw new LibraryException("Given id is not exist", HttpStatus.NOT_FOUND);

    }
}
