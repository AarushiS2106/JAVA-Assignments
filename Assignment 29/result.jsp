<!DOCTYPE html>
<html>
<head>
    <title>Registration Result</title>
</head>
<body>
    <%
        String name = request.getParameter("name");
        String email = request.getParameter("email");
        String phone = request.getParameter("phone");
        String password = request.getParameter("password");
    %>
    <h2>Registration Successful</h2>
    <h3>Submitted Information</h3>
    <p>Name: <%= name %></p>
    <p>Email: <%= email %></p>
    <p>Phone Number: <%= phone %></p>
    <p>Password: Received successfully (hidden for security)</p>
    <a href="register.jsp">Back to Registration</a>
</body>
</html>
