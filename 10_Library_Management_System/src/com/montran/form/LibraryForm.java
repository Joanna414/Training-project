package com.montran.form;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.apache.struts.action.ActionErrors;
import org.apache.struts.action.ActionForm;
import org.apache.struts.action.ActionMapping;
import org.apache.struts.action.ActionMessage;

public class LibraryForm extends ActionForm {
	
	@Override
	public ActionErrors validate(ActionMapping mapping, HttpServletRequest request) {
		HttpSession httpSession = request.getSession();
		ActionErrors errors = new ActionErrors();
		if (request.getParameter("member") != null) {
			if (request.getParameter("member").equals("getMember")) {
				if (getMemberCode() == null || ("".equals(getMemberCode()))) {
					errors.add("member.error", new ActionMessage("label.common.memberCode"));
				}
			}

		}

		if (request.getParameter("book") != null) {
			if (request.getParameter("book").equals("getBook")) {
				if (getBookCode() == null || ("".equals(getBookCode()))) {
					errors.add("book.error", new ActionMessage("label.common.bookCode"));
				}

			}

		}

		if (request.getParameter("issue") != null) {
			if (request.getParameter("issue").equals("issueBook")) {
				if (getMemberCode() == null || ("".equals(getMemberCode()))) {
					errors.add("member.error", new ActionMessage("label.common.memberCode"));
				}
				if (getBookCode() == null || ("".equals(getBookCode()))) {
					errors.add("book.error", new ActionMessage("label.common.bookCode"));
				}
			}
		}

		if (request.getParameter("issueDate") != null) {
			if (request.getParameter("issueDate").equals("issueDate")) {
				if (getIssueDate() == null) {
					errors.add("date.error", new ActionMessage("label.common.date"));
				}
			}
		}
		if (request.getParameter("dueDate") != null) {
			if (request.getParameter("dueDate").equals("dueDate")) {
				if (getIssueDate() == null) {
					errors.add("date.error", new ActionMessage("label.common.date"));
				}
			}
		}
		return errors;
	}
	
	private int issueSerialNumber;
	private String memberCode;
	private String memberName;
	private String bookCode;
	private String bookName;
	private String bookAuthor;
	private String issueDate;
	private String dueDate;

	public LibraryForm() {
		// TODO Auto-generated constructor stub
	}

	public LibraryForm(int issueSerialNumber, String memberCode, String memberName, String bookCode, String bookName,
			String bookAuthor, String issueDate, String dueDate) {
		super();
		this.issueSerialNumber = issueSerialNumber;
		this.memberCode = memberCode;
		this.memberName = memberName;
		this.bookCode = bookCode;
		this.bookName = bookName;
		this.bookAuthor = bookAuthor;
		this.issueDate = issueDate;
		this.dueDate = dueDate;
	}

	public int getIssueSerialNumber() {
		return issueSerialNumber;
	}

	public void setIssueSerialNumber(int issueSerialNumber) {
		this.issueSerialNumber = issueSerialNumber;
	}

	public String getMemberCode() {
		return memberCode;
	}

	public void setMemberCode(String memberCode) {
		this.memberCode = memberCode;
	}

	public String getMemberName() {
		return memberName;
	}

	public void setMemberName(String memberName) {
		this.memberName = memberName;
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

	public String getIssueDate() {
		return issueDate;
	}

	public void setIssueDate(String issueDate) {
		this.issueDate = issueDate;
	}

	public String getDueDate() {
		return dueDate;
	}

	public void setDueDate(String dueDate) {
		this.dueDate = dueDate;
	}

	@Override
	public String toString() {
		return "LibraryForm [issueSerialNumber=" + issueSerialNumber + ", memberCode=" + memberCode + ", memberName="
				+ memberName + ", bookCode=" + bookCode + ", bookName=" + bookName + ", bookAuthor=" + bookAuthor
				+ ", issueDate=" + issueDate + ", dueDate=" + dueDate + "]";
	}

}
