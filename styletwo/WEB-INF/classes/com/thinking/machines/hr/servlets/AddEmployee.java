package com.thinking.machines.hr.servlets;
import com.thinking.machines.hr.dl.*;
import com.thinking.machines.hr.beans.*;
import javax.servlet.*;
import javax.servlet.http.*;
import java.util.*;
import java.text.*;
import java.math.*;
public class AddEmployee extends HttpServlet
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
EmployeeBean employeeBean;
employeeBean=(EmployeeBean)request.getAttribute("employeeBean");
String name=employeeBean.getName();
int designationCode=employeeBean.getDesignationCode();
String designation=employeeBean.getDesignation();
String dateOfBirth=employeeBean.getDateOfBirth();
String gender=employeeBean.getGender();
boolean isIndian=employeeBean.getIsIndian();
String basicSalary=employeeBean.getBasicSalary();
String panNumber=employeeBean.getPANNumber();
String aadharCardNumber=employeeBean.getAadharCardNumber();
EmployeeDTO employee=new EmployeeDTO();
employee.setName(name);
employee.setDesignationCode(designationCode);
employee.setDesignation(designation);
SimpleDateFormat simpleDateFormat=new SimpleDateFormat("yyyy-MM-dd");
employee.setDateOfBirth(simpleDateFormat.parse(dateOfBirth));
employee.setGender(gender);
employee.setIsIndian(isIndian);
BigDecimal bd=new BigDecimal(basicSalary);
employee.setBasicSalary(bd);
employee.setPANNumber(panNumber);
employee.setAadharCardNumber(aadharCardNumber);
EmployeeDAO employeeDAO=new EmployeeDAO();
try
{
employeeDAO.add(employee);
employeeBean.setEmployeeId(employee.getEmployeeId());
MessageBean messageBean=new MessageBean();
messageBean.setHeading("Employee (Add module)");
messageBean.setMessage("Employee added, add more ?");
messageBean.setGenerateButtons(true);
messageBean.setGenerateTwoButtons(true);
messageBean.setButtonOneText("Yes");
messageBean.setButtonTwoText("No");
messageBean.setButtonOneAction("EmployeeAddForm.jsp");
messageBean.setButtonTwoAction("Employees.jsp");
request.setAttribute("messageBean",messageBean);
RequestDispatcher requestDispatcher;
requestDispatcher=request.getRequestDispatcher("/Notification.jsp");
requestDispatcher.forward(request,response);
}catch(DAOException daoException)
{
ErrorBean errorBean;
errorBean=new ErrorBean();
errorBean.setError(daoException.getMessage());
request.setAttribute("errorBean",errorBean);
RequestDispatcher requestDispatcher;
requestDispatcher=request.getRequestDispatcher("/EmployeeAddForm.jsp");
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