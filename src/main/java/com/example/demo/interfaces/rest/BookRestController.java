package com.example.demo.interfaces.rest;

import java.util.List;

import com.amazonaws.xray.spring.aop.XRayEnabled;
import com.example.demo.domain.model.aggregates.Book;
import com.example.demo.interfaces.rest.transform.dto.BookDto;
import com.example.demo.service.BookService;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import lombok.NonNull;
import lombok.RequiredArgsConstructor;

@XRayEnabled
@RestController
@RequestMapping(path = "/books")
@RequiredArgsConstructor
public class BookRestController {
    @NonNull
    private final BookService bookService;

    @GetMapping(path = "/findAll")
    public List<Book> findAll() {
        return bookService.findAll();
    }

    @PostMapping(path = "/")
    public Book post(@RequestBody BookDto bookDto) {
        return bookService.save(bookDto);
    }
}
