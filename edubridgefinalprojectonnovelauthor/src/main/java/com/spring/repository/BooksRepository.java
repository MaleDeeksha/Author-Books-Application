package com.spring.repository;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;

import com.spring.entity.Books;



public interface BooksRepository extends JpaRepository<Books,Integer> {



}
