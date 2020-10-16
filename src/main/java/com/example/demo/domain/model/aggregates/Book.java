package com.example.demo.domain.model.aggregates;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Entity
@Table(name = "book")
public class Book {
   @Id
   @Column(name = "isbn", nullable = false, length = 60)
   @NotNull
   @Size(max = 60)
   private String isbn;
   @Column(name = "name", length = 100)
   @Size(max = 100)
   private String name;
   @Column(name = "author", length = 100)
   @Size(max = 100)
   private String authorId;
}