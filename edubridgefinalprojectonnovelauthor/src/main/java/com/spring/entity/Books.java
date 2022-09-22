package com.spring.entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;
import javax.validation.constraints.NotNull;

@Entity
@Table(name="books")
 
public class Books {
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	 private int bookId;

	 @Column(name="book_name",length=50)
	 @NotNull
     private String bName;
	 
	 @Column(name="price")
	 @NotNull
     private double price;
	 
	 @Column(name="content_status",length=50)
	 @NotNull
	 private String contentStatus;
	 //@OneToMany(fetch = FetchType.EAGER, mappedBy = "book", cascade = CascadeType.ALL)
	  //private List<Author> story  ;
	@ManyToOne
	@JoinColumn(name = "authorId")
	private Author author;
	 
	public Author getAuthor() {
		return author;
	}

	public void setAuthor(Author author) {
		this.author = author;
	}

	public int getBookId() {
		return bookId;
	}

	public void setBookId(int bookId) {
		this.bookId = bookId;
	}

	public String getbName() {
		return bName;
	}

	public void setbName(String bName) {
		this.bName = bName;
	}

	public double getPrice() {
		return price;
	}

	public void setPrice(double price) {
		this.price = price;
	}

	public String getContentStatus() {
		return contentStatus;
	}

	public void setContentStatus(String contentStatus) {
		this.contentStatus = contentStatus;
	}

		// TODO Auto-generated method stub
		
	



}
