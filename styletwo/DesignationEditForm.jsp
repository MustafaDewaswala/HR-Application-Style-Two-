<tm:Module name='DESIGNATION' />
<jsp:useBean id='designationBean' scope='request' class='com.thinking.machines.hr.beans.DesignationBean' />
<jsp:useBean id='errorBean' scope='request' class='com.thinking.machines.hr.beans.ErrorBean' />
<jsp:include page='/MasterPageTopSection.jsp' />
<script src='/styletwo/js/DesignationEditForm.js'></script>
<!-- right panel starts here   -->
<div class='content-right-panel'>
<h2>Designation (Edit Module)</h2>
<span class='error'>
<jsp:getProperty name='errorBean' property='error' />
</span>
<form method='post' action='/styletwo/EditDesignation.jsp' onsubmit='return validateForm(this)'>
<input type='hidden' id='code' name='code' value='${designationBean.code}'>
Designation  
<input type='text' id='title' name='title' maxlength='35' size='36' value='${designationBean.title}'>
<span id='titleErrorSection' class='error'></span><br>
<button type='submit'>Edit</button>
<button type='Button' onclick='cancelUpdation()'>Cancel</button>
</form>
<form id='cancelUpdationForm' action='/styletwo/Designations.jsp'>
</form>
<jsp:include page='/MasterPageBottomSection.jsp' />