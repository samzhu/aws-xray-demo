package com.example.demo;

import com.example.demo.domain.model.aggregates.Book;
import com.example.demo.infrastructure.repositories.BookRepository;

import org.springframework.boot.context.event.ApplicationReadyEvent;
import org.springframework.context.event.EventListener;
import org.springframework.stereotype.Component;

import lombok.NonNull;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;

@Slf4j
@Component
@RequiredArgsConstructor
public class ApplicationReady {

    @NonNull
    private final BookRepository bookRepository;

    @EventListener(ApplicationReadyEvent.class)
    public void applicationReady() {
        bookRepository.save(new Book("123456", "Mongo", "001"));
    }
}
