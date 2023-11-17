package com.workintech.Libraryapp.controller;

import com.workintech.Libraryapp.dto.CategoryResponse;
import com.workintech.Libraryapp.entity.Category;
import com.workintech.Libraryapp.service.CategoryService;
import com.workintech.Libraryapp.util.Converter;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/category")
public class CategoryController {
    private CategoryService categoryService;
@Autowired
    public CategoryController(CategoryService categoryService) {
        this.categoryService = categoryService;
    }


@PostMapping("/")
    public CategoryResponse save(@RequestBody Category category){
    return Converter.categoryConverter(categoryService.save(category));
    }


    @GetMapping("/{id}")
    public CategoryResponse get(@PathVariable long id){
        return  Converter.categoryConverter(categoryService.findById(id));
    }

    @GetMapping("/")
    public List<CategoryResponse> findAll(){
    return  Converter.categoryListConverter(categoryService.findAll());
    }
@DeleteMapping("/{id}")
    public CategoryResponse delete(@PathVariable long id){
    return Converter.categoryConverter(categoryService.delete(id));
}
@PostMapping("/{bookid}")
    public  CategoryResponse saveByBookId(@RequestBody Category category,@PathVariable long id) {
    return  Converter.categoryConverter(categoryService.saveBookById(category, id));
}
}
