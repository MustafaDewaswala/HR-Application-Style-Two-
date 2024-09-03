package com.thinking.machines.hr.servlets;
import com.thinking.machines.hr.dl.*;
import com.thinking.machines.hr.beans.*;
import javax.servlet.*;
import javax.servlet.http.*;
import java.text.*;
import java.math.*;
import java.io.*;
import java.util.*;
public class UpdateEmployee extends HttpServlet
{
public void doGet(HttpServletRequest request,HttpServletResponse response)
{
doPost(request,response);
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
EmployeeBean employeeBean=(EmployeeBean)request.getAttribute("employeeBean");
String employeeId=employeeBean.getEmployeeId();
String name=employeeBean.getName();
String gender=employeeBean.getGender();
String dateOfBirth=employeeBean.getDateOfBirth();
String designation=employeeBean.getDesignation();
int designationCode=employeeBean.getDesignationCode();
String basicSalary=employeeBean.getBasicSalary();
Boolean isIndian=employeeBean.getIsIndian();
String panNumber=employeeBean.getPANNumber();
String aadharCardNumber=employeeBean.getAadharCardNumber();
EmployeeDTO employee=new EmployeeDTO();
employee.setEmployeeId(employeeId);
employee.setName(name);
employee.setGender(gender);
employee.setDesignationCode(designationCode);
employee.setDesignation(designation);
SimpleDateFormat simpleDateFormat=new SimpleDateFormat("yyyy-MM-dd");
employee.setDateOfBirth(simpleDateFormat.parse(dateOfBirth));
BigDecimal sal=new BigDecimal(basicSalary);
employee.setBasicSalary(sal);
employee.setIsIndian(isIndian);
employee.setPANNumber(panNumber);
employee.setAadharCardNumber(aadharCardNumber);
EmployeeDAO employeeDAO=new EmployeeDAO();
try
{
employeeDAO.update(employee);
MessageBean messageBean=new MessageBean();
messageBean.setHeading("Employee (Edit module)");
messageBean.setMessage("Employee updated");
messageBean.setGenerateButtons(true);
messageBean.setButtonOneText("Ok");
messageBean.setButtonOneAction("Employees.jsp");
request.setAttribute("messageBean",messageBean);
RequestDispatcher requestDispatcher;
requestDispatcher=request.getRequestDispatcher("Notification.jsp");
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