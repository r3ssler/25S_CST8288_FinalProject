<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <title>Sign Up</title>
    <link rel="stylesheet" href="../css/signup.css" />
</head>
<body>
<div class="signup-container">
    <div class="signup-box">
        <h2>Sign Up</h2>
        <form action="../user/register" method="post">
            <fieldset>
                <legend>Account Information</legend>

                <label for="username">Username:</label>
                <input type="text" id="username" name="username" required autocomplete="username" />

                <label for="password">Password:</label>
                <input type="password" id="password" name="password" required autocomplete="new-password" />

                <label for="email">Email:</label>
                <input type="email" id="email" name="email" required autocomplete="email" />

                <label for="name">Full Name:</label>
                <input type="text" id="name" name="name" autocomplete="name" />

                <label for="type">User Type:</label>
                <select id="type" name="type" required>
                    <option value="">-- Select Role --</option>
                    <option value="admin">Admin</option>
                    <option value="operator">Operator</option>
                </select>
            </fieldset>

            <div class="form-buttons">
                <button type="submit">Register</button>
                <button type="button" onclick="window.location.href='login.jsp'">Back to Login</button>
            </div>
        </form>
    </div>
</div>
</body>
</html>
