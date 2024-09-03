package com.thinking.machines.hr.servlets;
import com.thinking.machines.hr.dl.*;
import com.thinking.machines.hr.beans.*;
import com.thinking.machines.hr.bl.*;
import javax.servlet.*;
import javax.servlet.http.*;
import java.util.*;
import java.io.*;
public class EmployeesJS extends HttpServlet
{


public void doPost(HttpServletRequest request,HttpServletResponse response)
{
doGet(request,response);
}

public void doGet(HttpServletRequest request,HttpServletResponse response)
{
try
{
PrintWriter pw=response.getWriter();
response.setContentType("text/javascript");

/* The following is a very bad 
   idea, hence commented
*/

//File file=new File("c:\\tomcat9\\webapps\\styletwo\\WEB-INF\\js\\Employees.js");


ServletContext servletContext=getServletContext();
File file=new File(servletContext.getRealPath("")+File.separator+"WEB-INF"+File.separator+"js"+File.separator+"Employees.js");
RandomAccessFile randomAccessFile=new RandomAccessFile(file,"r");
while(randomAccessFile.getFilePointer()<randomAccessFile.length())
{
pw.println(randomAccessFile.readLine());
}
randomAccessFile.close();
pw.println("var employee;\n");
int i=0;
List<EmployeeBean> employees=new EmployeeBL().getAll();
for(EmployeeBean employeeBean:employees)
{
pw.print("employee=new Employee();\n");
pw.print("employee.employeeId=\""+employeeBean.getEmployeeId()+"\";\n");
pw.print("employee.name=\""+employeeBean.getName()+"\";\n");
pw.print("employee.designationCode="+employeeBean.getDesignationCode()+";\n");
pw.print("employee.designation=\""+employeeBean.getDesignation()+"\";\n");
pw.print("employee.dateOfBirth=\""+employeeBean.getDateOfBirth()+"\";\n");
pw.print("employee.gender=\""+employeeBean.getGender()+"\";\n");
pw.print("employee.isIndian="+employeeBean.getIsIndian()+";\n");
pw.print("employee.basicSalary="+employeeBean.getBasicSalary()+";\n");
pw.print("employee.panNumber=\""+employeeBean.getPANNumber()+"\";\n");
pw.print("employee.aadharCardNumber=\""+employeeBean.getAadharCardNumber()+"\";\n");
pw.print("employees["+i+"]=employee;\n");
i++;
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