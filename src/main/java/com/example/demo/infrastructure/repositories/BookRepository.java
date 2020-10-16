package com.example.demo.infrastructure.repositories;

import java.util.List;

import com.example.demo.domain.model.aggregates.Book;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

@Repository
public interface BookRepository extends JpaRepository<Book, String> {

    List<Book> findByAuthorId(String authorId);

    Page<Book> findByAuthorId(@Param("authorId") String authorId, Pageable pageable);

    List<Book> findByAuthorId(@Param("authorId") String authorId, Sort sort);
}