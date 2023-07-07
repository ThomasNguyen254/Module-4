<%--
  Created by IntelliJ IDEA.
  User: thomasnguyen
  Date: 06/07/2023
  Time: 09:40
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Title</title>
</head>
<body>
<div style="text-align: center">
    <h2>TỜ KHAI Y TẾ</h2>
    <h3>ĐÂY LÀ THÔNG TIN QUAN TRỌNG,THÔNG TIN CỦA ANH/CHỊ SẼ GIÚP CƠ QUAN Y TẾ LIÊN LẠC KHI CẦN THIẾT ĐỀ PHÒNG DỊCH
        TRUYỀN NHIỄM </h3>
    <h4 style="color: red">Khuyến cáo:Khai báo thông tin sai vi phạm pháp luật Việt Nam và có thể xử lý hình sự</h4>
</div>
<form>
    <label for="name">Họ tên (Ghi chữ in hoa)</label><br>
    <input type="text" id="name" name="name" required>
    <div>
        <label for="birthYear">Năm sinh</label><br>
        <input type="text" id="birthYear" name="birthYear" required>
        <label for="gender">Giới tính:</label>
        <select id="gender" name="gender" required>
            <option value="male">Male</option>
            <option value="female">Female</option>
        </select>
        <label for="gender">Quốc tịch:</label>
        <select id="passportNumber" name="passportNumber" required>
            <option value="VietNam">Việt Nam</option>
            <option value="Canada">Canada</option>
            <option value="German">German</option>
            <option value="Japan">Japan</option>
        </select>
    </div>
    <h4>Số hộ chiếu hoặc số CMND hoặc giấy thông hành hợp khác(*)</h4>
    <input type="text" size="50"><br>
    <h4><label>Thông tin đi lại</label></h4>
    <input type="radio" id="travelInfo1" name="travelInfo" value="airplane" required>
    <label for="travelInfo1">Tàu bay</label>
    <input type="radio" id="travelInfo2" name="travelInfo" value="ship" required>
    <label for="travelInfo2">Tàu thuyền</label>
    <input type="radio" id="travelInfo3" name="travelInfo" value="car" required>
    <label for="travelInfo3">Ô tô</label>
    <input type="radio" id="travelInfo4" name="travelInfo" value="other" required>
    <label for="travelInfo4">Khác(Ghi rõ)</label>
    <div>
        <label for="vehicleNumber">Số hiệu phương tiện</label><br>
        <input type="text" id="vehicleNumber" name="vehicleNumber" placeholder="VD:VN123" required>
        <label for="numberSeat">Số ghế</label><br>
        <input type="text" id="numberSeat" name="numberSeat" required>
    </div>
    <h4><label>Ngày khởi hành</label></h4>
    <select id="departureDate" name="departureDate" required>
        <option value="">-- Select Departure Date --</option>


        <!-- Generate options for dates from 1 to 30 -->
    </select>

    <label for="returnDate">Return Date:</label>
    <select id="returnDate" name="returnDate" required>
        <option value="">-- Select Return Date --</option>
    </select>


</form>

<script>
    for (let i = 1; i < 31; i++) {
        let op = document.createElement("option");
        op.append(i.toString());
        'departureDate'.appendChild(op);
    }

</script>
</body>
</html>
