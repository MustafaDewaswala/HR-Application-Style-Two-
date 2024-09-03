<%@taglib uri='/WEB-INF/mytags/tmtags.tld' prefix='tm' %>
<tm:Module name='DESIGNATION' />
<!DOCTYPE HTML>
<html lang='en'>
<head>
<meta charset='utf-8'>
<title>HR Application</title>
</head>
<body>
<table>
<thead>
<tr>
<th>S.No.</th>
<th>Designation</th>
</tr>
</thead>
<tbody>
<tm:EntityList populatorClass='com.thinking.machines.hr.bl.DesignationBL' populatorMethod='getAll' name='dsgnBn'>
<tr>
<td>${serialNumber}</td>
<td>${dsgnBn.title}</td>
</tr>
</tm:EntityList>
</tbody>
</table>
<br>
<br>
<br>
Select Designation
<select name='designationCode'>
<option value=-1>&lt;Select&gt;</option>
<tm:Designations>
<option value='${designationBean.code}'>${designationBean.title}(${designationBean.code})</option>
</tm:Designations>
</body>
</html>