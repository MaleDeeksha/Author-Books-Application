package com.spring.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.spring.entity.Author;
import com.spring.entity.Books;
import com.spring.repository.BooksRepository;
@Service
public class BooksService {
	@Autowired
	private BooksRepository booksRepository;
	
	public List<Books> getAllVBooks()
	{
		return booksRepository.findAll();
	}
	
	public Books addBooks(Books books)
	{
		return booksRepository.save(books);
	}
	
	
	/*public Books searchByName(String bName)
	{
		return  booksRepository.findByName(bName).get();
	}*/
	
	public void deleteBooks(int bookId) {
	
			booksRepository.deleteById(bookId);			
		}

	public Books updateBook(Books books,int bookId)
	{
		return booksRepository.save(books);
	}
	public Books searchById(int bookId)
	{
		return  booksRepository.findById(bookId).get();
	}

		// TODO Auto-generated method stub
		
	
	
	

}
