package com.workintech.Libraryapp.exceptions;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDateTime;
@Data
@AllArgsConstructor
public class LibraryErrorResponse {
    private long status;
    private String message;
    private LocalDateTime dateTime;
}
