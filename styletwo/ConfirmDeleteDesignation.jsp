<%@taglib uri='/WEB-INF/mytags/tmtags.tld' prefix='tm' %>
<tm:Module name='DESIGNATION' />
<jsp:useBean id='designationBean' scope='request' class='com.thinking.machines.hr.beans.DesignationBean' />
<jsp:useBean id='errorBean' scope='request' class='com.thinking.machines.hr.beans.ErrorBean' />
<script src='/styletwo/js/DesignationDeleteForm.js'></script>
<jsp:include page='/MasterPageTopSection.jsp' />
<!-- right panel starts here   -->
<div class='content-right-panel'>
<h2>Designation (Delete Module)</h2>
<span class='error'>
<jsp:getProperty name='errorBean' property='error' />
</span>
<form method='post' action='/styletwo/DeleteDesignation.jsp' onsubmit='return validateForm(this)'>
<tm:FormId/>
<input type='hidden' id='code' name='code' value='${designationBean.code}'>
Designation : <b>${designationBean.title}</b><br><br>
Are you sure you want to delete this designation ?<br><br><br>
<button type='submit'>Yes</button>
<button type='Button' onclick='cancelDeletion()'>No</button>
</form>
<form id='cancelDeletionForm' action='/styletwo/Designations.jsp'>
</form>
<jsp:include page='/MasterPageBottomSection.jsp' />