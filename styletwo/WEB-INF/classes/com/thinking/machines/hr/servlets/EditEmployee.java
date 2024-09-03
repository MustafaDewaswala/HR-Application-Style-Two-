package com.thinking.machines.hr.servlets;
import com.thinking.machines.hr.dl.*;
import com.thinking.machines.hr.beans.*;
import javax.servlet.*;
import javax.servlet.http.*;
import java.io.*;
import java.sql.*;
import java.util.*;
import java.text.*;
public class EditEmployee extends HttpServlet
{
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
String employeeId=request.getParameter("employeeId");
EmployeeDAO employeeDAO=new EmployeeDAO();
try
{
EmployeeDTO employee=employeeDAO.getByEmployeeId(employeeId);
EmployeeBean employeeBean=new EmployeeBean();
employeeBean.setEmployeeId(employeeId);
employeeBean.setName(employee.getName());
employeeBean.setDesignationCode(employee.getDesignationCode());
employeeBean.setDesignation(employee.getDesignation());
employeeBean.setGender(employee.getGender());
employeeBean.setIsIndian(employee.getIsIndian());
employeeBean.setBasicSalary(employee.getBasicSalary().toPlainString());
SimpleDateFormat simpleDateFormat=new SimpleDateFormat("yyyy-MM-dd");
String dob=simpleDateFormat.format(employee.getDateOfBirth());
employeeBean.setDateOfBirth(dob);
employeeBean.setPANNumber(employee.getPANNumber());
employeeBean.setAadharCardNumber(employee.getAadharCardNumber());
request.setAttribute("employeeBean",employeeBean);
RequestDispatcher requestDispatcher;
requestDispatcher=request.getRequestDispatcher("EmployeeEditForm.jsp");
requestDispatcher.forward(request,response);
}catch(DAOException daoException)
{
ErrorBean errorBean;
errorBean=new ErrorBean();
errorBean.setError(daoException.getMessage());
request.setAttribute("errorBean",errorBean);
RequestDispatcher requestDispatcher;
requestDispatcher=request.getRequestDispatcher("EmployeeEditForm.jsp");
requestDispatcher.forward(request,response);
}
}catch(Exception exception)
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
System.out.println(exception.getMessage()); // remove after testing and setup 500 (internal error page)
}
}
public void doGet(HttpServletRequest request,HttpServletResponse response)
{
doPost(request,response);
}
}