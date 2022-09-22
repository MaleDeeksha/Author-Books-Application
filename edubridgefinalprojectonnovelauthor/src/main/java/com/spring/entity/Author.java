package com.spring.entity;

import java.util.Date;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import javax.validation.constraints.NotNull;

import org.springframework.format.annotation.DateTimeFormat;


@Entity
@Table(name="Author")
public class Author {
@Id
@GeneratedValue(strategy = GenerationType.AUTO)

private int authorId;
@Column(name="author_name",length=20)
@NotNull
private String authorName;

@Column(name="experience",length=40)
@NotNull
private int experience;

@Column(name="about_author",length=50)
@NotNull
private String aboutAuthor;
 
/*@Column(name="date")
@DateTimeFormat(pattern="yyyy/mm/dd")
@NotNull
private Date date;*/
@OneToMany(cascade = CascadeType.ALL)
private List<Books>book;
public int getAuthorId() {
	return authorId;
}
public void setAuthorId(int authorId) {
	this.authorId = authorId;
}
public String getAuthorName() {
	return authorName;
}
public void setAuthorName(String authorName) {
	this.authorName = authorName;
}
public List<Books> getBook() {
	return book;
}
public void setBook(List<Books> book) {
	this.book = book;
}
public int getExperience() {
	return experience;
}
public void setExperience(int experience) {
	this.experience = experience;
}
public String getAboutAuthor() {
	return aboutAuthor;
}
public void setAboutAuthor(String aboutAuthor) {
	this.aboutAuthor = aboutAuthor;
}
/*public Date getDate() {
	return date;
}
public void setDate(Date date) {
	this.date = date;
}*/


}



