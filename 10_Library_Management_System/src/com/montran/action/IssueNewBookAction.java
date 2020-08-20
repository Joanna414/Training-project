package com.montran.action;

import java.time.LocalDate;
import java.time.ZoneId;
import java.util.Date;
import java.util.Random;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.apache.struts.action.Action;
import org.apache.struts.action.ActionErrors;
import org.apache.struts.action.ActionForm;
import org.apache.struts.action.ActionForward;
import org.apache.struts.action.ActionMapping;
import org.apache.struts.action.ActionMessage;

import com.montran.dao.BookIssueDAO;
import com.montran.form.LibraryForm;
import com.montran.pojo.BookIssue;
import com.montran.pojo.Books;
import com.montran.pojo.Member;

public class IssueNewBookAction extends Action {

	@Override
	public ActionForward execute(ActionMapping mapping, ActionForm form, HttpServletRequest request,
			HttpServletResponse response) throws Exception {

		LibraryForm detailsForm = (LibraryForm) form;
		BookIssueDAO dao = new BookIssueDAO();
		ActionErrors errors = new ActionErrors();

		Member member = null;
		Books book = null;
		BookIssue details = null;
		detailsForm.setIssueSerialNumber(dao.getMaxBookIssue());

		System.out.println("in Issue new Book action :: execute");

		if (request.getParameter("member") != null) {
			if (request.getParameter("member").equals("getMember")) {
				System.out.println("getMember Button is Clicked");
				System.out.println(detailsForm.getMemberCode());
				member = dao.getMember(detailsForm.getMemberCode());
				detailsForm.setMemberName(member.getMemberName());
				return mapping.findForward("book");
//			} else {
//				if (detailsForm.getMemberCode() == null || ("".equals(detailsForm.getMemberCode()))) {
//					errors.add("member.error", new ActionMessage("label.common.memberCode"));
//				}
			}
		}

		if (request.getParameter("book") != null) {
			if (request.getParameter("book").equals("getBook")) {
				System.out.println("getBook Button is Clicked");
				System.out.println(detailsForm.getBookCode());
				book = dao.getBook(detailsForm.getBookCode());
				detailsForm.setBookAuthor(book.getBookAuthor());
				detailsForm.setBookName(book.getBookName());

//				if (detailsForm.getBookCode() == null || ("".equals(detailsForm.getBookCode()))) {
//					errors.add("book.error", new ActionMessage("label.common.bookCode"));
//				}

				LocalDate issueDate = LocalDate.now();
				LocalDate dueDate = LocalDate.now();

				member = dao.getMember(detailsForm.getMemberCode());
				detailsForm.setMemberName(member.getMemberName());

				if (member.getMemberType().equals("Student")) {
					dueDate = dueDate.plusDays(10);
					System.out.println(detailsForm);
				}
				if (member.getMemberType().equals("Faculty")) {
					dueDate = dueDate.plusDays(90);
					System.out.println(detailsForm);
				}

				detailsForm.setIssueDate(issueDate.toString());
				detailsForm.setDueDate(dueDate.toString());

				HttpSession httpSession = request.getSession();

				httpSession.setAttribute("member", member);
				httpSession.setAttribute("book", book);
				httpSession.setAttribute("issueDate", issueDate);
				httpSession.setAttribute("dueDate", dueDate);
				return mapping.findForward("member");
			}
		}

		if (request.getParameter("issue") != null) {
			if (request.getParameter("issue").equals("issueBook")) {
				System.out.println("Issue Book Button Click");
				HttpSession httpSession = request.getSession();
				LocalDate issueDate = null;
				LocalDate dueDate = null;

				if (httpSession.getAttribute("book") != null)
					book = (Books) httpSession.getAttribute("book");
//				else{
//					errors.add("book.error", new ActionMessage("label.common.book"));
//				}
				if (httpSession.getAttribute("member") != null)
					member = (Member) httpSession.getAttribute("member");
//				else{
//					errors.add("member.error", new ActionMessage("label.common.member"));
//				}
				if (httpSession.getAttribute("issueDate") != null)
					issueDate = (LocalDate) httpSession.getAttribute("issueDate");
//				else{
//					errors.add("date.error", new ActionMessage("label.common.date"));
//				}
				if (httpSession.getAttribute("dueDate") != null)
					dueDate = (LocalDate) httpSession.getAttribute("dueDate");
//				else{
//					errors.add("date.error", new ActionMessage("label.common.date"));
//				}
				Date issueD = Date.from(issueDate.atStartOfDay(ZoneId.systemDefault()).toInstant());
				Date dueD = Date.from(dueDate.atStartOfDay(ZoneId.systemDefault()).toInstant());

				details = new BookIssue(detailsForm.getIssueSerialNumber(), issueD, dueD, book, member);
				dao.issueNewBook(details);
				System.out.println("Book Issued Successfully !!");
			}
		}
		return mapping.findForward("success");

	}
}
