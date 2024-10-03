<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
    <meta charset="UTF-8">
    <title>แก้ไขคำสั่งซื้อ</title>
</head>
<body>
    <h1>แก้ไขคำสั่งซื้อ</h1>
    <form action="OrderServlet" method="post">
        <input type="hidden" name="action" value="update">
        
        <label for="customerName">ชื่อลูกค้า:</label>
        <input type="text" id="customerName" name="customerName" value="${order.customerName}" required><br><br>

        <label>ชื่อชานม:</label><br>
        <label>
            <div style="display: inline-block; text-align: center; margin: 10px;">
            <img src="${pageContext.request.contextPath}/nm/c1.jpg" alt="ชานมไข่มุก" style="width: 150px; height: 150px;">
            <br>
            <label>
                <input type="checkbox" name="teaName" value="ชานมไข่มุก"> ชานมไข่มุก
            </label>
        </div>
            
        <div style="display: inline-block; text-align: center; margin: 10px;">
            <img src="${pageContext.request.contextPath}/nm/c2.jpg" alt="ชาไท" style="width: 150px; height: 150px;">
            <br>
            <label>
                <input type="checkbox" name="teaName" value="ชาไท"> ชาไท
            </label>
        </div>
            
        <div style="display: inline-block; text-align: center; margin: 10px;">
            <img src="${pageContext.request.contextPath}/nm/c3.jpg" alt="ชาเขียวนม" style="width: 150px; height: 150px;">
            <br>
            <label>
                <input type="checkbox" name="teaName" value="ชาเขียวนม"> ชาเขียวนม
            </label>
        </div>
        
        <div style="display: inline-block; text-align: center; margin: 10px;">
            <img src="${pageContext.request.contextPath}/nm/c4.jpg" alt="ชานมโกโก้" style="width: 150px; height: 150px;">
            <br>
            <label>
                <input type="checkbox" name="teaName" value="ชานมโกโก้"> ชานมโกโก้
            </label>
        </div>
        
        <div style="display: inline-block; text-align: center; margin: 10px;">
            <img src="${pageContext.request.contextPath}/nm/c5.jpg" alt="ชานมสตอเบอรี่" style="width: 150px; height: 150px;">
            <br>
            <label>
                <input type="checkbox" name="teaName" value="ชานมสตอเบอรี่"> ชานมสตอเบอรี่
            </label>
        </div><br>

        <label>ท็อปปิ้ง:</label><br>
        <div style="display: inline-block; text-align: center; margin: 10px;">
            <img src="${pageContext.request.contextPath}/nm/k1.jpg" alt="ไข่มุก" style="width: 150px; height: 100px;">
            <br>
            <label>
                <input type="checkbox" name="topping" value="ไข่มุก"> ไข่มุก
            </label>
        </div>
        <div style="display: inline-block; text-align: center; margin: 10px;">
            <img src="${pageContext.request.contextPath}/nm/k2.jpg" alt="วุ้น" style="width: 150px; height: 100px;">
            <br>
            <label>
                <input type="checkbox" name="topping" value="วุ้น"> วุ้น
            </label>
        </div>
            <div style="display: inline-block; text-align: center; margin: 10px;">
            <img src="${pageContext.request.contextPath}/nm/k3.jpg" alt="พุดดิ้ง" style="width: 150px; height: 100px;">
            <br>
            <label>
                <input type="checkbox" name="topping" value="พุดดิ้ง"> พุดดิ้ง
            </label>
        </div><br>
        <br><br>

        <label>ความหวาน:</label><br>
        <input type="radio" id="sweet100" name="sweetness" value="100%" <c:if test="${order.sweetness == '100%'}"></c:if>>
        <label for="sweet100">100%</label><br>
        <input type="radio" id="sweet50" name="sweetness" value="50%" <c:if test="${order.sweetness == '50%'}"></c:if>>
        <label for="sweet50">50%</label><br>
        <input type="radio" id="sweet25" name="sweetness" value="25%" <c:if test="${order.sweetness == '25%'}"></c:if>>
        <label for="sweet25">25%</label><br><br>

        <label for="price">ราคา:</label>
        <input type="text" id="price" name="price" value="${order.price}" required><br><br>

        <input type="submit" value="บันทึกการแก้ไข">
    </form>
</body>
</html>
