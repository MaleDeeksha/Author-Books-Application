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
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.spring.entity.Author;
import com.spring.entity.Books;
import com.spring.service.AuthorService;
import com.spring.service.BooksService;

@RestController
public class BooksController {
	@Autowired
	private BooksService booksService;
	@Autowired
	private AuthorService authorService;
	
	//displays the books list in Book
	@GetMapping("/bookslist")
	public List<Books> getBooks()
	{
		return this.booksService.getAllVBooks();
	}
	
	// adds the books into list in Book
	@PostMapping("/addbooks")
	public String addBooks(@Valid @RequestBody Books books,@RequestParam ("authorid")int authorId) 
	{
		Author a = this.authorService.searchById(authorId);
		books.setAuthor(a);
	
				this.booksService.addBooks(books);
				return "book added has been successfully";
	
	}
	// adds books by id in Book
	@PostMapping("/addbooks1/{authorId}")
	public String addBooks1(@Valid @RequestBody Books books,@PathVariable int authorId) 
	{
		Author a1 = this.authorService.searchById(authorId);
		books.setAuthor(a1);
	
				this.booksService.addBooks(books);
				return "book added has been successfully";
	
	}
	//deletes books from the list in Book
	@DeleteMapping("/delbooks/{bookId}")
	public String deleteBooks(@PathVariable int bookId)
	{
		this.booksService.deleteBooks(bookId);
		boolean flag = true;
		new ResponseEntity<Boolean>(flag, HttpStatus.OK);
	
		return "Book has been deleted";
	}
	
	//its change/modify data in Author 
	/*@PostMapping("/updatebook")
    public ResponseEntity<Books> updateBook(@Valid @RequestBody Books book) {
        Books b = booksService.updateBook(book);
        return new ResponseEntity<>(b, HttpStatus.OK);
    }*/
	// change/modify data in Book
	@PutMapping("/updatebook/{bookId}")
	public Books updateBook(@RequestBody Books b,@PathVariable int bookId)
	{
		return booksService.updateBook(b, bookId);
	}
	
	// displays book details by using id only mentioned id
	@GetMapping("/search/{bookId}")
	public Books searchById(@PathVariable int bookId) {

	return this.booksService.searchById(bookId);
	}
	
	//its displays data by using name
	/*@GetMapping("/search/{bName}")
	public Books searchByName(@PathVariable String bName) {

	return this.booksService.searchByName(bName);
	}*/

		}


