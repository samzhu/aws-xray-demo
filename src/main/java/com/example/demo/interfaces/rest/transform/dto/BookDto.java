package com.example.demo.interfaces.rest.transform.dto;

import lombok.Data;

@Data
public class BookDto {
    private String isbn;
    private String name;
    private String authorId;
}