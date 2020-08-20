package com.montran.action;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.struts.action.Action;
import org.apache.struts.action.ActionForm;
import org.apache.struts.action.ActionForward;
import org.apache.struts.action.ActionMapping;

import com.montran.dao.BookIssueDAO;
import com.montran.form.DeleteBookForm;
import com.montran.form.LibraryForm;

public class DeleteBookAction extends Action {
@Override
public ActionForward execute(ActionMapping mapping, ActionForm form, HttpServletRequest request,
		HttpServletResponse response) throws Exception {
	System.out.println("in Delete Book action :: execute");

	DeleteBookForm deleteForm = (DeleteBookForm)form;
	BookIssueDAO dao = new BookIssueDAO();
	System.out.println(deleteForm.getIssueSerialNumber());
	dao.deleteIssueBook(deleteForm.getIssueSerialNumber());
			
	System.out.println("Book deleted successfully");

		return mapping.findForward("success");
		
	}

}