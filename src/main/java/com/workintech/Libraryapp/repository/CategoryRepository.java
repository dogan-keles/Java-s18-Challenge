package com.workintech.Libraryapp.repository;

import com.workintech.Libraryapp.entity.Category;
import org.springframework.data.jpa.repository.JpaRepository;

public interface CategoryRepository extends JpaRepository<Category, Long> {
}
