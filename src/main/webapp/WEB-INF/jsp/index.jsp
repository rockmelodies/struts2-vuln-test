<%@ taglib uri="http://struts.apache.org/tags" prefix="s" %>
<html>
<head>
    <title>Struts2 Vulnerability Test</title>
</head>
<body>
<h1>${message}</h1>
<form action="submit.action" method="post">
    <input type="text" name="userName" placeholder="Enter your name" required />
    <input type="submit" value="Submit" />
</form>
</body>
</html>
