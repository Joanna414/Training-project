package com.montran.action;

import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.apache.struts.action.Action;
import org.apache.struts.action.ActionForm;
import org.apache.struts.action.ActionForward;
import org.apache.struts.action.ActionMapping;

import com.montran.dao.BookIssueDAO;
import com.montran.pojo.BookIssue;

public class BookIssueDetailsAction extends Action {

	@Override
	public ActionForward execute(ActionMapping mapping, ActionForm form, HttpServletRequest request,
			HttpServletResponse response) throws Exception {
		System.out.println("in Book issue details action :: execute");
		BookIssueDAO dao = new BookIssueDAO();
		List<BookIssue> issueDetails = dao.getAllBookIssueDetails();
		System.out.println(issueDetails);
		
		HttpSession httpSession = request.getSession();
		httpSession.setAttribute("bookIssueDetails", issueDetails);
		
		return mapping.findForward("success");

	}
}