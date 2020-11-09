package com.example.demo.service;

import java.util.List;

import javax.transaction.Transactional;

import com.example.demo.domain.model.aggregates.Book;
import com.example.demo.infrastructure.repositories.BookRepository;
import com.example.demo.interfaces.rest.transform.dto.BookDto;

import org.springframework.stereotype.Service;

import lombok.NonNull;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;

@Slf4j
@Service
@RequiredArgsConstructor
public class BookService {
    @NonNull
    private final BookRepository bookRepository;

    @Transactional
    public Book save(BookDto bookDto){
        Book book = new Book();
        book.setIsbn(bookDto.getIsbn());
        book.setName(bookDto.getName());
        book.setAuthorId(bookDto.getAuthorId());
        book = bookRepository.save(book);
        return book;
    }

    public List<Book> findAll(){
        return bookRepository.findAll();
    }
}


