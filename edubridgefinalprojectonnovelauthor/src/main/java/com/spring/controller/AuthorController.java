package com.spring.controller;

import java.util.List;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.spring.entity.Author;
import com.spring.service.AuthorService;
@RestController
public class AuthorController {
	@Autowired
	public AuthorService authorservice;
	// displays the author list in Author
	@GetMapping("/authorlist")
	public List<Author>getAuthor(@RequestBody Author author){
		return this.authorservice.listAll();
	}
	// adds the books into list/table
	@PostMapping("/addauthor")
	public Author addAuthor(@Valid @RequestBody Author author) {
		return this.authorservice.addAuthor(author);
	}
	
	/*@PostMapping("/updateauthor")
    public ResponseEntity<Author> updateAuthor(@Valid @RequestBody Author author) {
        Author a = authorservice.updateAuthor(author);
        return new ResponseEntity<>(a, HttpStatus.OK);
    }*/
	//updating author by id
	@PutMapping("/updateauthor/{authorId}")
	public Author updateAuthor(@RequestBody Author a,@PathVariable int authorId)
	{
		return authorservice.updateAuthor(a, authorId);
	}
	//delete author by id
	@DeleteMapping("/delauthor/{authorId}")
	public String deleteAuthor(@PathVariable int authorId)
	{
		this.authorservice.deleteAuthor(authorId);
		boolean flag = true;
		 new ResponseEntity<Boolean>(flag, HttpStatus.OK);
	
		return "Author has been deleted";
	}
	//search author details by id only mentioned id
	@GetMapping("/search/{id}")
	public Author searchById(@PathVariable int id) {

	return this.authorservice.searchById(id);
	}
	/*@GetMapping("/search/{authorName}")
	public Author searchByName(@PathVariable String authorName) {

	return this.authorservice.searchByName(authorName);
	}*/


	/*@GetMapping("Cart/{id}")
	public ResponseEntity<Party> getPartyById(@PathVariable("partyId") long partyId) {
		return new ResponseEntity<Party>(partyservice.getPartyById(partyId), HttpStatus.OK);
	}*/


}
