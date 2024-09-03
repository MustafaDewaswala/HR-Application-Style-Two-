package com.thinking.machines.hr.servlets;
import com.thinking.machines.hr.dl.*;
import com.thinking.machines.hr.beans.*;
import javax.servlet.*;
import javax.servlet.http.*;
import java.io.*;
import java.sql.*;
import java.util.*;
import java.math.*;
import java.text.*;
public class ConfirmDeleteEmployee extends HttpServlet
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
String stringEmployeeId=request.getParameter("employeeId");
if(stringEmployeeId==null)
{
RequestDispatcher requestDispatcher;
requestDispatcher=request.getRequestDispatcher("/Employees.jsp");
requestDispatcher.forward(request,response);
return;
}
EmployeeDAO employeeDAO=new EmployeeDAO();
try
{
EmployeeDTO employee=employeeDAO.getByEmployeeId(stringEmployeeId);
EmployeeBean employeeBean=new EmployeeBean();
employeeBean.setEmployeeId(stringEmployeeId);
employeeBean.setName(employee.getName());
employeeBean.setDesignation(employee.getDesignation());
employeeBean.setDesignationCode(employee.getDesignationCode());
SimpleDateFormat simpleDateFormat=new SimpleDateFormat("dd-MM-yyyy");
String dateOfBirth=simpleDateFormat.format(employee.getDateOfBirth());
employeeBean.setDateOfBirth(dateOfBirth);
employeeBean.setGender(employee.getGender());
employeeBean.setIsIndian(employee.getIsIndian());
employeeBean.setBasicSalary(employee.getBasicSalary().toPlainString());
employeeBean.setPANNumber(employee.getPANNumber());
employeeBean.setAadharCardNumber(employee.getAadharCardNumber());
request.setAttribute("employeeBean",employeeBean);
RequestDispatcher requestDispatcher;
requestDispatcher=request.getRequestDispatcher("ConfirmDeleteEmployee.jsp");
requestDispatcher.forward(request,response);
return;
}catch(DAOException daoException)
{
ErrorBean errorBean;
errorBean=new ErrorBean();
errorBean.setError(daoException.getMessage());
request.setAttribute("errorBean",errorBean);
RequestDispatcher requestDispatcher;
requestDispatcher=request.getRequestDispatcher("ConfirmDeleteEmployee.jsp");
requestDispatcher.forward(request,response);
return;
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