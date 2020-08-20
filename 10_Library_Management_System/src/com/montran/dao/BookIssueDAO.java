package com.montran.dao;

import java.util.Date;
import java.util.List;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.query.Query;

import com.montran.form.LibraryForm;
import com.montran.pojo.BookIssue;
import com.montran.pojo.Books;
import com.montran.pojo.Member;
import com.montran.util.SessionFactoryUtil;

public class BookIssueDAO {
	private Session session;
	private Transaction transaction;
	private SessionFactory factory = SessionFactoryUtil.getFactory();
	private int issueSerialNumber;


	public List<BookIssue> getAllBookIssueDetails() {
		System.out.println("in dao");
		session = factory.openSession();
		Query query = session.createQuery("from books_issue order by issue_serial_number ");
		List<BookIssue> bookIssueList = query.getResultList();
		System.out.println(bookIssueList);
		return bookIssueList;

	}


	public Member getMember(String memberCode) {
		session = factory.openSession();
		Member member = session.get(Member.class, memberCode);
		System.out.println(member);
		session.close();
		return member;
		}
	
	public Books getBook(String bookCode) {
		session = factory.openSession();
		Books book = session.get(Books.class, bookCode);
		System.out.println(book);
		session.close();
		return book;
	}
	public void issueNewBook(BookIssue details) {
		session = SessionFactoryUtil.getFactory().openSession();
		transaction = session.beginTransaction();
		session.save(details);
		transaction.commit();
		session.close();
	}

	public int getMaxBookIssue() {
		session = SessionFactoryUtil.getFactory().openSession();
		Query query = session.createQuery("select max(issueSerialNumber) from books_issue");
		List<Integer> issueList = query.list();
		int maxCount = issueList.get(0);
		System.out.println(maxCount);
		session.close();

		return maxCount + 1;
	}


	public void deleteIssueBook(int issueSerialNumber) {
		session = factory.openSession();
		transaction = session.beginTransaction();
		BookIssue issue = session.get(BookIssue.class, issueSerialNumber);
		session.delete(issue);
		transaction.commit();
		session.close();
	}
	public void updateBook(int issueSerialNumber,Date issueDate,Date dueDate) {
		session = SessionFactoryUtil.getFactory().openSession();
		transaction = session.beginTransaction();
		BookIssue issue=session.get(BookIssue.class, issueSerialNumber);
		issue.setIssueDate(issueDate);
		issue.setDueDate(dueDate);
		session.update(issue);
		transaction.commit();
		session.close();
	}
}