package com.example.demo.interfaces.rest;

import java.util.List;

import com.amazonaws.xray.spring.aop.XRayEnabled;
import com.example.demo.domain.model.aggregates.Book;
import com.example.demo.infrastructure.repositories.BookRepository;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import lombok.NonNull;
import lombok.RequiredArgsConstructor;

@XRayEnabled
@RestController
@RequiredArgsConstructor
public class BookRestController {
    @NonNull
    private final BookRepository bookRepository;

    @GetMapping(path = "/getall")
    public List<Book> find() {
        return bookRepository.findAll();
    }
}
