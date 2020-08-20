package com.montran.pojo;


import java.util.Date;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToOne;

@Entity(name="books_issue") 
public class BookIssue {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "issue_serial_number")
	 private int issueSerialNumber;
	
	@Column(name = "issue_date")
	 private Date issueDate;
	
	@Column(name = "due_date")
	 private Date dueDate;
	
	@OneToOne
	@JoinColumn(name = "book_code")
	 private Books book;
	
	@OneToOne
	@JoinColumn(name = "member_code")
	 private Member member;
	
	public BookIssue() {
		// TODO Auto-generated constructor stub
	}

	public BookIssue(int issueSerialNumber, Date issueDate, Date dueDate, Books book, Member member) {
		super();
		this.issueSerialNumber = issueSerialNumber;
		this.issueDate = issueDate;
		this.dueDate = dueDate;
		this.book = book;
		this.member = member;
	}

	public int getIssueSerialNumber() {
		return issueSerialNumber;
	}

	public void setIssueSerialNumber(int issueSerialNumber) {
		this.issueSerialNumber = issueSerialNumber;
	}

	public Date getIssueDate() {
		return issueDate;
	}

	public void setIssueDate(Date issueDate) {
		this.issueDate = issueDate;
	}

	public Date getDueDate() {
		return dueDate;
	}

	public void setDueDate(Date dueDate) {
		this.dueDate = dueDate;
	}

	public Books getBook() {
		return book;
	}

	public void setBook(Books book) {
		this.book = book;
	}

	public Member getMember() {
		return member;
	}

	public void setMember(Member member) {
		this.member = member;
	}

	@Override
	public String toString() {
		return "BookIssue [issueSerialNumber=" + issueSerialNumber + ", issueDate=" + issueDate + ", dueDate=" + dueDate
				+ ", book=" + book + ", member=" + member + "]";
	}
	
	
	
}
