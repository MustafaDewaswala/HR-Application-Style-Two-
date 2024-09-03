<%@taglib uri='/WEB-INF/mytags/tmtags.tld' prefix='tm' %>
<tm:Module name='EMPLOYEE' />
<jsp:useBean id='employeeBean' scope='request' class='com.thinking.machines.hr.beans.EmployeeBean' />
<jsp:useBean id='errorBean' scope='request' class='com.thinking.machines.hr.beans.ErrorBean' />
<script src='/styletwo/js/EmployeeDeleteForm.js'></script>
<jsp:include page='/MasterPageTopSection.jsp' />
<!-- right panel starts here   -->
<div class='content-right-panel'>
<h2>Employee (Delete Module)</h2>
<form method='post' action='/styletwo/DeleteEmployee.jsp' onsubmit='return validateForm(this)'>
<tm:FormId/>
<input type='hidden' id='employeeId' name='employeeId' value='${employeeBean.employeeId}'>
Name : 
<b>${employeeBean.name}</b><br>
Designation : 
<b>${employeeBean.designation}</b><br>
Date of birth : 
<b>${employeeBean.dateOfBirth}</b><br>
Gender : 
<tm:If condition='${employeeBean.isMale()==true}'> 
<b>Male</b><br>
</tm:If>
<tm:If condition='${employeeBean.isFemale()==true}'> 
<b>Female</b><br>
</tm:If>
Nationality :
<tm:If condition='${employeeBean.getIsIndian()==true}'> 
<b>Indian</b><br>
</tm:If>
<tm:If condition='${employeeBean.getIsIndian()==false}'> 
<b>Not an Indian</b><br>
</tm:If>
Basic Salary : 
<b>${employeeBean.basicSalary}</b><br>
PAN number : 
<b>${employeeBean.panNumber}</b><br>
Aadhar card number : 
<b>${employeeBean.aadharCardNumber}</b><br><br><br>
Are you sure you want to delete this employee ?<br><br><br>
<button type='submit'>Yes</button>
<button type='Button' onclick='cancelDeletion()'>No</button>
</form>
<form id='cancelDeletionForm' action='/styletwo/Employees.jsp'>
</form>
<jsp:include page='/MasterPageBottomSection.jsp' />