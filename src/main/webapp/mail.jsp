<%--
  Created by IntelliJ IDEA.
  User: white
  Date: 2017-10-04
  Time: 21:18
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>注册界面</title>
</head>
<body>
   <div>
       <form action="/register.do" method="post">
           <table>
               <caption>邮箱注册界面</caption>
              <tr>
                  <td>邮箱：</td>
                  <td><input type="text" name="email"></td>
              </tr>
               <tr>
                   <td>密码：</td>
                   <td><input type="password" name="password"></td>
               </tr>
               <tr>
                   <td><input type="submit" name="sub_btn" value="提交"></td>
               </tr>
           </table>
       </form>
   </div>
</body>
</html>
