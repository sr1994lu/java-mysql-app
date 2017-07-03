<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ page import="my.beans.db.MyDBAccess11" %>
<%
    MyDBAccess11 mda = (MyDBAccess11) request.getAttribute("myVal");
    String[][] strDBVal = mda.getResult();
%>
<html>
<head>
    <title>Title</title>
    <style>
        table {
            text-align: left;
        }

        th {
            background-color: #fff8f4;
            padding: 4px;
        }
    </style>
</head>
<body>
    <ul>
        <li><a href="/BeansDBServlet01">BeansDBServlet01</a></li>
        <li><a href="/BeansDBServlet11">BeansDBServlet11</a></li>
        <li><a href="/BeansDBServlet12">BeansDBServlet12</a></li>
        <li><a href="/BeansDBServlet13">BeansDBServlet13</a></li>
        <li><a href="/BeansDBServlet14">BeansDBServlet14</a></li>
        <li><a href="/BeansServlet31">BeansServlet31</a></li>
    </ul>
    <table border="1">
        <tr>
            <th>GAKUSEKI</th>
            <th>KURASU</th>
            <th>SHUSSEKI</th>
            <th>SHIMEI</th>
            <th>NENREI</th>
        </tr>
        <%
            if (strDBVal != null) {
                int rowCount = 0;
                while (rowCount < strDBVal.length) {
                    out.println("<tr>");
                    for (int i = 0; i < 5; i += 1) {
                        out.println("<td>" + strDBVal[rowCount][i] + "</td>");
                    }
                    out.println("</tr>");
                    rowCount += 1;
                }
            }
        %>
    </table>
</body>
</html>
