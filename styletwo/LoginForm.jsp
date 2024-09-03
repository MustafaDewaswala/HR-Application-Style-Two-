<jsp:useBean id='errorBean' scope='request' class='com.thinking.machines.hr.beans.ErrorBean' />
<!DOCTYPE HTML>
<html lang='en'>
<head>
<title>HR Application</title>
<link rel='stylesheet' type='text/css' href='/styletwo/css/styles.css'>
</head>
<body>
<!-- Main container starts here   -->
<div class='main-container'>
<!-- header starts here   -->
<div class='header'>
<img src='/styletwo/images/logo.png' class='logo'>
<div class='brand-name'>Thinking Machines</div>
</div><!-- header ends here   -->
<!-- content-section starts here   -->
<div class='content'>
<!-- login form section starts here   -->
<div class='loginForm'>
<form action='/styletwo/Login.jsp' method='post'>
<table border='0'>
<tr>
<td colspan='2' align='center'>
<span class='error'>
${errorBean.error}
</span>
</td>
</tr>
<tr>
<td>Username</td>
<td><input type='text' id='username' name='username' maxlength='15'></td>
</tr>
<tr>
<td>Password</td>
<td><input type='password' id='password' name='password' maxlength='15'></td>
</tr>
<tr>
<td colspan='2' align='center'>
<button type='submit'>Login</button>
</td>
</tr>
</table>
</form>
</div><!-- login form section ends here   -->
</div><!-- content-section ends here   -->
<!-- footer starts here   -->
<div class='footer'>
&copy; Thinking Machines 2023
</div>
<!-- footer ends here   -->
</div>
<!-- Main container ends here   -->
</body>
</html>