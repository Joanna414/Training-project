package com.montran.form;

import javax.servlet.http.HttpServletRequest;

import org.apache.struts.action.ActionErrors;
import org.apache.struts.action.ActionForm;
import org.apache.struts.action.ActionMapping;
import org.apache.struts.action.ActionMessage;

public class DeleteBookForm extends  ActionForm{



@Override
public ActionErrors validate(ActionMapping mapping, HttpServletRequest request) {

	ActionErrors errors = new ActionErrors();
	
	if(request.getParameter("issueSerialNumber") != null) {
		if(request.getParameter("issueSerialNumber").equals("delete") ) {
			if(getIssueSerialNumber() == 0 || ("".equals(getIssueSerialNumber())))
				errors.add("member.error", new ActionMessage("label.common.date"));
//			if()
		}
	}
	return errors;
}

private int issueSerialNumber;

public int getIssueSerialNumber() {
	return issueSerialNumber;
}

public void setIssueSerialNumber(int issueSerialNumber) {
	this.issueSerialNumber = issueSerialNumber;
}




}
