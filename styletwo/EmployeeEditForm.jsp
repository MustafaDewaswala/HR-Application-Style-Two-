<%@taglib uri='/WEB-INF/mytags/tmtags.tld' prefix='tm' %>
<tm:Module name='EMPLOYEE' />
<jsp:useBean id='employeeBean' scope='request' class='com.thinking.machines.hr.beans.EmployeeBean' />
<jsp:useBean id='errorBean' scope='request' class='com.thinking.machines.hr.beans.ErrorBean' />
<jsp:include page='/MasterPageTopSection.jsp' />
<script src='/styletwo/js/EmployeeEditForm.js'></script>
<!-- right panel starts here   -->
<div class='content-right-panel'>
<h2>Employee (Edit Module)</h2>
<form method='post' action='/styletwo/EditEmployee.jsp' onsubmit='return validateForm(this)'>
<tm:FormId/>
<input type='hidden' name='employeeId' id='employeeId' value='${employeeBean.employeeId}'>
<table>
<tr>
<td>Name</td>
<td><input type='text' id='name' name='name' maxlength='50' size='51' value='${employeeBean.name}'>
<span id='nameErrorSection' style='color:red'></span></td>
</tr>
<tr>
<td>Designation</td>
<td><select id='designationCode' name='designationCode'>
<option selected value='${employeeBean.designationCode}'>${employeeBean.designation}</option>
<tm:EntityList populatorClass='com.thinking.machines.hr.bl.DesignationBL' populatorMethod='getAll' name='dsgnBn'>
<option value='${dsgnBn.code}'>${dsgnBn.title}</option>
</tm:EntityList>
</select>
<span id='designationCodeErrorSection' style='color:red'></span>
</td>
</tr>
<tr>
<td>Date of Birth</td>
<td><input type='date' id='dateOfBirth' name='dateOfBirth' value='${employeeBean.dateOfBirth}'>
<span id='dateOfBirthErrorSection' style='color:red'></span></td>
</tr>
<tr>
<td>Gender</td>
<td>
<tm:If condition='${employeeBean.isMale()==true}'>
<input checked type='radio' id='male' name='gender' value='M'> Male
<input type='radio' id='female' name='gender' value='F'> Female
</tm:If>
<tm:If condition='${employeeBean.isFemale()==true}'>
<input type='radio' id='male' name='gender' value='M'> Male
<input checked type='radio' id='female' name='gender' value='F'> Female
</tm:If>
<span id='genderErrorSection' style='color:red'></span></td>
</tr>
<tr>
<td>Indian ?</td>
<td>
<tm:If condition='${employeeBean.getIsIndian()==true}'>
<input checked type='checkbox' id='isIndian' name='isIndian' value='true'></td>
</tm:If>
<tm:If condition='${employeeBean.getIsIndian()==false}'>
<input type='checkbox' id='isIndian' name='isIndian' value='true'></td>
</tm:If>
</tr>
<tr>
<td>Basic salary</td>
<td><input type='text' style='text-align:right' id='basicSalary' name='basicSalary' maxlength='12' size='13' value='${employeeBean.basicSalary}'>
<span id='basicSalaryErrorSection' style='color:red'></span></td>
</tr>
<tr>
<td>PAN Number</td>
<td><input type='text' id='panNumber' name='panNumber' maxlength='15' size='16' value='${employeeBean.panNumber}'>
<span id='panNumberErrorSection' style='color:red'></span>
</td>
</tr>
<tr>
<td>Aadhar card Number</td>
<td><input type='text' id='aadharCardNumber' name='aadharCardNumber' maxlength='15' size='16' value='${employeeBean.aadharCardNumber}'>
<span id='aadharCardNumberErrorSection' style='color:red'></span>
</td>
</tr>
<tr>
<td colspan='2'><button type='submit'>Update</button>
<button type='Button' onclick='cancelUpdation()'>Cancel</button></td>
</tr>
</table>
</form>
<form id='cancelUpdationForm' action='/styletwo/Employees.jsp'>
</form>
<jsp:include page='/MasterPageBottomSection.jsp' />
