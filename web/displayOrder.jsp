<%-- 
    Document   : displayOrder
    Created on : Aug 1, 2024, 3:30:26 PM
    Author     : VivoBook
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta charset="UTF-8">
        <title>แสดงผลการสั่งซื้อ</title>
    </head>
    <body>
        <h1>รายละเอียดการสั่งซื้อ</h1>
        <p>ชื่อลูกค้า: ${order.customerName}</p>
        <p>ชื่อชานม: ${order.teaName}</p>
        <p>ท็อปปิ้ง: ${order.topping}</p>
        <p>ความหวาน: ${order.sweetness}</p>
        <p>ราคา: ${order.price}</p>

        <form action="editOrder.jsp" method="get">
            <input type="submit" value="แก้ไข">
        </form>
    </body>
</html>
