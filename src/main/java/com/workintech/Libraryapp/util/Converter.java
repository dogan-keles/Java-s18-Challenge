package com.workintech.Libraryapp.util;

import com.workintech.Libraryapp.dto.AuthorResponse;
import com.workintech.Libraryapp.dto.BookResponse;
import com.workintech.Libraryapp.dto.CategoryResponse;
import com.workintech.Libraryapp.entity.Author;
import com.workintech.Libraryapp.entity.Book;
import com.workintech.Libraryapp.entity.Category;

import java.util.ArrayList;
import java.util.List;

public class Converter {
    public static CategoryResponse categoryConverter(Category category) {
        return new CategoryResponse(category.getName());
    }

    public static List<CategoryResponse> categoryListConverter(List<Category> categoryList) {
        List<CategoryResponse> categoryResponseList = new ArrayList<>();
        for (Category category : categoryList) {
            categoryResponseList.add(new CategoryResponse(category.getName()));
        }
        return categoryResponseList;
    }

    public static AuthorResponse authorConverter(Author author){
        return new AuthorResponse(author.getFirstName(), author.getLastName());
    }



    public static List<AuthorResponse> authorResponsesListConverter(List<Author> authorList){
        List<AuthorResponse> authorResponseList = new ArrayList<>();

        for(Author author : authorList){
            authorResponseList.add(new AuthorResponse(author.getFirstName(), author.getLastName()));
        }
        return authorResponseList;
    }

    public static BookResponse bookConverter(Book book){
        return new BookResponse(book.getName(), authorConverter(book.getAuthor()),categoryConverter(book.getCategory()));
    }

    public static List<BookResponse> bookResponseListConverter(List<Book> bookList){
        List<BookResponse> bookResponseList = new ArrayList<>();

        for(Book book : bookList){
            bookResponseList.add(bookConverter(book));
        }
        return bookResponseList;
    }
}