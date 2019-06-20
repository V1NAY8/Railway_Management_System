<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
    <!DOCTYPE html>
    <html>

    <head>
        <meta charset="ISO-8859-1">
        <title>WELCOME TO RAILWAY RESERVATION SYSTEM</title>
        <style>
            body {
                background: url(../res/welcome1.jpg);
            }
            
            header {
                padding: 30px;
                text-align: Right;
                font-size: 40px;
                color: red;
            }
            
            nav {
                float: right;
                width: 30%;
                height: 50px;
                /* only for demonstration, should be removed */
                background: none;
                padding: 30px;
                font-size: 25px;
            }
        </style>
    </head>

    <body>
        <header text-align: "center">
            <marquee>Welcome to Indian Railways</marquee>
            <nav>
                <a href=" HomePage.html" title="Home">HOME</a>&nbsp
                <a href=" Login.html" title="Login">LOGIN</a>
            </nav>
        </header>
        <h2> Dear User, <br> Your UserName is
            <%= request.getAttribute("name") %>.</h2>
        <h3> Please remember this username to Login into Railway Reservation System</h3>

    </body>

    </html>