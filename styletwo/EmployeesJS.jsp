<%@taglib uri='/WEB-INF/mytags/tmtags.tld' prefix='tm' %>
<script>
var employee;
<tm:EntityList populatorClass='com.thinking.machines.hr.bl.EmployeeBL' populatorMethod='getAll' name='empBean'>
employee=new Employee();
employee.employeeId="${empBean.employeeId}";
employee.name="${empBean.name}";
employee.designationCode=${empBean.designationCode};
employee.designation="${empBean.designation}";
employee.dateOfBirth="${empBean.dateOfBirth}";
employee.gender="${empBean.gender}";
employee.isIndian=${empBean.isIndian};
employee.basicSalary=${empBean.basicSalary};
employee.panNumber="${empBean.getPANNumber()}";
employee.aadharCardNumber="${empBean.aadharCardNumber}";
employees[${serialNumber}-1]=employee;
</tm:EntityList>
</script>