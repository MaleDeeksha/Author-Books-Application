package com.spring.service;

import java.util.List;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.spring.entity.Author;
import com.spring.repository.AuthorRepository;

@Service
public class AuthorService {
	@Autowired
	public AuthorRepository authorrepository;

	public List<Author> listAll(){
		return authorrepository.findAll();
	}
	public Author addAuthor(Author a) {
		return authorrepository.save(a);
	}
	public Author searchById(int id) {
		return authorrepository.findById(id).get();
	}
	
public void deleteAuthor(int id) {
	 authorrepository.deleteById(id);
} 

public Author updateAuthor(Author author,int authorId)
{
	return authorrepository.save(author);
}
/*public Author searchByName(String authorName) {
	// TODO Auto-generated method stub
	return authorrepository.findByName(authorName).get();

}*/

	
	}
