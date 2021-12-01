<html>
<head>
    <title> jsp</title>
</head>
<body>
<form action="/welcome", method= "post">
<p><font color="red">${error}</font></p>
Enter your name <input type= "text" name="name"/>
password <input type="password" name="password"/> <input type="submit" value="login">
</form>
</body>
</html>