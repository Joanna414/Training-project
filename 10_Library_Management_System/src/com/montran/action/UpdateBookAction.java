package com.montran.action;


import java.sql.Date;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.struts.action.Action;
import org.apache.struts.action.ActionForm;
import org.apache.struts.action.ActionForward;
import org.apache.struts.action.ActionMapping;

import com.montran.dao.BookIssueDAO;
import com.montran.form.LibraryForm;
import com.montran.pojo.BookIssue;

public class UpdateBookAction extends Action {

	@Override
	public ActionForward execute(ActionMapping mapping, ActionForm form, HttpServletRequest request,
			HttpServletResponse response) throws Exception {
		System.out.println("in Update Book action :: execute");
		LibraryForm update = (LibraryForm) form;
		BookIssueDAO dao = new BookIssueDAO();
		BookIssue issue = new BookIssue();
		dao.updateBook(update.getIssueSerialNumber(), Date.valueOf(update.getIssueDate()),Date.valueOf(update.getDueDate()));

		return mapping.findForward("success");
		}
	
	}
	

		

