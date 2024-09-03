package com.thinking.machines.hr.servlets;
import com.thinking.machines.hr.dl.*;
import com.thinking.machines.hr.beans.*;
import javax.servlet.*;
import javax.servlet.http.*;
public class DeleteDesignation extends HttpServlet
{
public void doGet(HttpServletRequest request,HttpServletResponse response)
{
try
{
RequestDispatcher requestDispatcher;
requestDispatcher=request.getRequestDispatcher("/Designations.jsp");
requestDispatcher.forward(request,response);
return;
}catch(Exception e)
{
// do nothing
}
}
public void doPost(HttpServletRequest request,HttpServletResponse response)
{
try
{
HttpSession ss=request.getSession();
if(ss.getAttribute("username")==null)
{
RequestDispatcher requestDispatcher;
requestDispatcher=request.getRequestDispatcher("/LoginForm.jsp");
requestDispatcher.forward(request,response);
return;
}
DesignationBean designationBean=(DesignationBean)request.getAttribute("designationBean");
int code=designationBean.getCode();
DesignationDAO designationDAO=new DesignationDAO();
if(code<=0 || designationDAO.designationCodeExists(code)==false)
{
RequestDispatcher requestDispatcher;
requestDispatcher=request.getRequestDispatcher("/Designations.jsp");
requestDispatcher.forward(request,response);
return;
}
try
{
designationDAO.delete(code);
MessageBean messageBean=new MessageBean();
messageBean.setHeading("Designation (Delete module)");
messageBean.setMessage("Designation deleted");
messageBean.setGenerateButtons(true);
messageBean.setButtonOneText("Ok");
messageBean.setButtonOneAction("Designations.jsp");
request.setAttribute("messageBean",messageBean);
RequestDispatcher requestDispatcher;
requestDispatcher=request.getRequestDispatcher("Notification.jsp");
requestDispatcher.forward(request,response);
}catch(DAOException daoException)
{
if(designationDAO.designationCodeExists(code)==true)
{
MessageBean messageBean=new MessageBean();
messageBean.setHeading("Notification");
messageBean.setMessage("Unable to delete designation<br><b>Cannot delete designation as it has been alloted to an employee</b><br>");
messageBean.setGenerateButtons(true);
messageBean.setButtonOneText("Ok");
messageBean.setButtonOneAction("Designations.jsp");
request.setAttribute("messageBean",messageBean);
RequestDispatcher requestDispatcher;
requestDispatcher=request.getRequestDispatcher("Notification.jsp");
requestDispatcher.forward(request,response);
}
ErrorBean errorBean;
errorBean=new ErrorBean();
errorBean.setError(daoException.getMessage());
request.setAttribute("errorBean",errorBean);
RequestDispatcher requestDispatcher;
requestDispatcher=request.getRequestDispatcher("ConfirmDeleteDesignation.jsp");
requestDispatcher.forward(request,response);
}
}catch(Exception e)
{
RequestDispatcher requestDispatcher;
requestDispatcher=request.getRequestDispatcher("ErrorPage.jsp");
try
{
requestDispatcher.forward(request,response);
}catch(Exception e2)
{
// do nothing
}
}
}
}