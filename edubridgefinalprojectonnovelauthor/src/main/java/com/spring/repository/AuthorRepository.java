package com.spring.repository;


import org.springframework.data.jpa.repository.JpaRepository;

import com.spring.entity.Author;



public interface AuthorRepository extends JpaRepository<Author,Integer> {


}
