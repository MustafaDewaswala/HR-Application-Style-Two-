<%@taglib uri='/WEB-INF/mytags/tmtags.tld' prefix='tm' %>
<tm:Module name='EMPLOYEE' />
<jsp:useBean id='employeeBean' scope='request' class='com.thinking.machines.hr.beans.EmployeeBean' />
<jsp:useBean id='errorBean' scope='request' class='com.thinking.machines.hr.beans.ErrorBean' />
<jsp:include page='/MasterPageTopSection.jsp' />
<script src='/styletwo/js/EmployeeAddForm.js'></script>
<!-- right panel starts here   -->
<div class='content-right-panel'>
<h2>Employees (ADD Module)</h2>
<span class='error'>
<jsp:getProperty name='errorBean' property='error' />
</span>
<form method='post' action='/styletwo/AddEmployee.jsp' onsubmit='return validateForm(this)'>
<tm:FormId/>
<table>
<tr>
<td>Name</td>
<td><input type='text' id='name' name='name' maxlength='50' size='51' value='${employeeBean.name}'>
<span id='nameErrorSection' style='color:red'></span></td>
</tr>
<tr>
<td>Designation</td>
<td><select id='designationCode' name='designationCode'>
<option value='-1'>&lt; Select Designation &gt;</option>
<tm:EntityList populatorClass='com.thinking.machines.hr.bl.DesignationBL' populatorMethod='getAll' name='dsgnBn'>
<option value='${dsgnBn.code}'>${dsgnBn.title}</option>
</tm:EntityList>
</select>
<span id='designationCodeErrorSection' style='color:red'></span></td>
</tr>
<tr>
<td>Date of Birth</td>
<td><input type='date' id='dateOfBirth' name='dateOfBirth' value='1970-01-01'>
<span id='dateOfBirthErrorSection' style='color:red'></span></td>
</tr>
<tr>
<td>Gender</td>
<td><input type='radio' id='male' name='gender' value='M'> Male
<input type='radio' id='female' name='gender' value='F'> Female
<span id='genderErrorSection' style='color:red'></span></td>
</tr>
<tr>
<td>Indian ?</td>
<td><input type='checkbox' id='isIndian' name='isIndian' value='Y'></td>
</tr>
<tr>
<td>Basic salary</td>
<td><input type='text' style='text-align:right' id='basicSalary' name='basicSalary' maxlength='12' size='13' value='${employeeBean.basicSalary}'>
<span id='basicSalaryErrorSection' style='color:red'></span></td>
</tr>
<tr>
<td>PAN number</td>
<td><input type='text' id='panNumber' name='panNumber' maxlength='15' size='16' value='${employeeBean.panNumber}'>
<span id='panNumberErrorSection' style='color:red'></span></td>
</tr>
<tr>
<td>Aadhar card number</td>
<td><input type='text' id='aadharCardNumber' name='aadharCardNumber' maxlength='15' size='16' value='${employeeBean.aadharCardNumber}'>
<span id='aadharCardNumberErrorSection' style='color:red'></span></td>
</tr>
<tr>
<td colspan='2'><button type='submit'>ADD</button>
<button type='Button' onclick='cancelAddition()'>CANCEL</button></td>
</tr>
</table>
</form>
<form id='cancelAdditionForm' action='/styletwo/Employees.jsp'>
</form>
<jsp:include page='/MasterPageBottomSection.jsp' />