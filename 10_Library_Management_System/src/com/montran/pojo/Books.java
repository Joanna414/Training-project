package com.montran.pojo;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;

@Entity(name = "books_master")
public class Books {
	@Id
	@Column(name = "book_code")
	 private String bookCode;
	
	@Column(name = "book_title") 
	private String bookName;
	
	@Column(name = "book_author") 
	private String bookAuthor;
	
	@Column(name = "book_status") 
	private String bookStatus;
	
	public Books() {
		// TODO Auto-generated constructor stub
	}

	public Books(String bookCode, String bookName, String bookAuthor, String bookStatus) {
		super();
		this.bookCode = bookCode;
		this.bookName = bookName;
		this.bookAuthor = bookAuthor;
		this.bookStatus = bookStatus;
	}

	public String getBookCode() {
		return bookCode;
	}

	public void setBookCode(String bookCode) {
		this.bookCode = bookCode;
	}

	public String getBookName() {
		return bookName;
	}

	public void setBookName(String bookName) {
		this.bookName = bookName;
	}

	public String getBookAuthor() {
		return bookAuthor;
	}

	public void setBookAuthor(String bookAuthor) {
		this.bookAuthor = bookAuthor;
	}

	public String getBookStatus() {
		return bookStatus;
	}

	public void setBookStatus(String bookStatus) {
		this.bookStatus = bookStatus;
	}

	@Override
	public String toString() {
		return "Books [bookCode=" + bookCode + ", bookName=" + bookName + ", bookAuthor=" + bookAuthor + ", bookStatus="
				+ bookStatus + "]";
	}
	
	 
}
