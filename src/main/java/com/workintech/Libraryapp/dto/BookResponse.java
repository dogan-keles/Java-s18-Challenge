package com.workintech.Libraryapp.dto;

public record BookResponse(String bookName , AuthorResponse authorResponse,CategoryResponse categoryResponse) {
}
