<%--
  Created by IntelliJ IDEA.
  User: white
  Date: 2017-10-05
  Time: 13:09
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>添加商品页面</title>
</head>
<body>
<div>
    <form action="/addGood.do" method="post">
        <table>
            <caption>添加商品页面</caption>
            <tr>
                <td>商品名称</td>
                <td><input type="text" name="goods_name"/></td>
            </tr>
            <tr>
                <td>商品价格</td>
                <td><input type="text" name="goods_price"/></td>
            </tr>
            <tr>
                <td>商品库存</td>
                <td><input type="text" name="goods_stock"/></td>
            </tr>
            <tr>
                <td>商品介绍</td>
                <td><input type="text" name="goods_desc"/></td>
            </tr>
            <tr>
                <td></td>
                <td><input type="submit" value="提交"/></td>
            </tr>
        </table>
    </form>
</div>
</body>
</html>






