package com.thinking.machines.hr.tags;
import javax.servlet.jsp.tagext.*;
import javax.servlet.jsp.*;
import javax.servlet.http.*;
public class FormResubmittedTagHandler extends TagSupport
{
public FormResubmittedTagHandler()
{
this.reset();
}
private void reset()
{
// do nothing
}
public int doStartTag()
{
HttpServletRequest request=(HttpServletRequest)pageContext.getRequest();
String formId=request.getParameter("formId");
if(formId==null)
{
return super.EVAL_BODY_INCLUDE;
}
String formIdInSession=(String)pageContext.getAttribute(formId,PageContext.SESSION_SCOPE);
if(formIdInSession==null)
{
return super.EVAL_BODY_INCLUDE;
}
pageContext.removeAttribute(formId,PageContext.SESSION_SCOPE);
if(formId.equals(formIdInSession))
{
return super.SKIP_BODY;
}
return super.EVAL_BODY_INCLUDE;
}
public int doEndTag()
{
return super.EVAL_PAGE;
}
}