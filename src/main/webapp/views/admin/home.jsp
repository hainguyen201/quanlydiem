<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Trang Admin</title>
<link rel="stylesheet" type="text/css" media="all"
	href="<c:url value='/template/CSS/teacher_contentright.css'/>">
<link rel="stylesheet" type="text/css" media="all"
	href="<c:url value='/template/CSS/dialog.css'/>">
</head>
<body>
	<header class="header">
		<div class="logo_uni">
			<a href="#" class="logo_uni_header"></a>
		</div>
		<div class="login">
			<button class="link-login">
				<a href="/quanlydiemsinhvien/thoat?action=logout&usertype=teacher">Đăng
					xuất</a>
			</button>
		</div>
		<!-- <div class="login-form">
                <form action="" method="">
                    <span>Tai khoan</span>
                    <input/>
                    <span>Mat khau</span>
                    <input/>
                    <button>Dang nhap</button>
                </form>
            </div> -->
	</header>

	<div class="master-content">
		<!-- <div id="dialog" hidden>
            <form action="" method="" class="login-form">
                <div class="input-login-form">
                    <div class="label-input"><span>Tai khoan</span></div>
                    <input /><br><br>
                    <div class="label-input"><span>Mat khau</span></div>
                    <input type="password" /><br>
                </div>
                <div class="login-type">
                    <input type="radio" name="user-type" /><span>Giao vien</span><br>
                    <input type="radio" name="user-type" /><span>Phu huynh, Hoc sinh</span><br>
                    <br><br>
                </div>
                <button style="margin-left: 40px;" class="btn-login">Dang nhap</button>
            </form>
        </div> -->
		<div id="dialog" hidden>
			<form action="thongtin.html" method="" class="login-form">
				<div class="login-title">
					<span>Login</span>
				</div>
				<div class="input-login-form">
					<div class="label-input">
						<span>Tai khoan</span>
					</div>
					<input name="user" property="login" /><br>
					<br>
					<div class="label-input">
						<span>Mat khau</span>
					</div>
					<input name="password" type="password" property="login" /><br>
				</div>
				<div class="login-type">
					<input type="radio" name="user-type" id="teacher" /><label
						for="teacher">Giao vien</label> <input type="radio"
						name="user-type" id="student" /><label for="student">Hoc
						sinh</label>
				</div>
				<button style="margin-left: 40px;" class="btn-login" type="submit">Dang
					nhap</button>

			</form>
		</div>
		<div class="content">
			<div class="menu">
				<select id="subject">
					<option value="it3080">Cấu trúc dữ liệu</option>
					<option>Thuật toán ứng dụng</option>
					<option>Các môn khác</option>
					<option>Các môn khác</option>
					<option>4</option>
				</select> <select id="semester">
					<option>Học kì</option>
					<option>1</option>
					<option>2</option>
					<option>3</option>
					<option>4</option>
				</select>

			</div>
			<div class="content-right">
				<div class="datenow">
					<input id="datenow" disabled />
				</div>
				<div class="content-title">
					<span>Cập nhật thông tin sinh viên</span>

				</div>
				<hr
					style="background-color: black; text-align: left; position: relative; top: 30px;"
					noshade="noshade">
				<div class="toolbar">
					<button class="add-new">Thêm</button>
					<button class="edit">Sửa</button>
					<button class="delete">Xóa</button>
				</div>
				<div id='dialogadd' hidden>
					<form class="form-add">
						<div class="add">
							<div class="add-label1">
								<span>Học kỳ</span> <input />
							</div>
							<div class="add-label1">
								<span>Môn học</span> <input />
							</div>
						</div>
						<div class="add">
							<div class="add-label1">
								<span>Họ tên</span> <input />
							</div>
							<div class="add-label1">
								<span>MSSV</span> <input />
							</div>

						</div>
						<div class="add">
							<div class="add-label1">
								<span>Số tín</span> <input />
							</div>
							<div class="add-label1">
								<span>Hệ số</span> <input />
							</div>

						</div>
						<div class="add">
							<div class="add-label1">
								<span>Điểm QT</span> <input />
							</div>
							<div class="add-label1">
								<span>Điểm cuối kì</span> <input />
							</div>
						</div>
						<div class="add">
							<div class="add-label1">
								<span>Ghi chú</span> <input />
							</div>
						</div>
					</form>
					<div class="btn-add">
						<button class="save">Lưu</button>
						<button class="cancel">Hủy</button>
					</div>
				</div>
				<div id='dialogedit'>
					<form class="form-edit"></form>
				</div>
				<div id='dialogdelete'>
					<form class="form-delete"></form>
				</div>
				<!-- <div class="student-info">
                    <div class="student-name">
                        <span>Họ và tên</span>
                        <input value="Nguyễn Văn Hải" disabled/>
                    </div>
                    <div class="student-mssv">
                        <span>MSSV</span>
                        <input value="20173089" disabled/>
                    </div>

                </div> -->

				<div class="main-table">
					<table class="table table-hover table-bordered table-responsive-sm">
						<thead>
							<tr>
								<th>Kỳ học</th>
								<th>Môn học</th>
								<th>Họ tên</th>
								<th>MSSV</th>
								<th>Số tín</th>
								<th>Hệ số</th>
								<th>Điểm quá trính</th>
								<th>Điểm cuối kì</th>
								<th>Điểm chữ</th>
								<th>Ghi chú</th>
							</tr>
						</thead>
						<tbody>
						</tbody>
					</table>
				</div>
				<!-- <div class="CPA-GPA content-footer">
                    <input value="GPA: 4.0       CPA: 4.0" disabled />
                </div>
                <div class="credit content-footer">
                    <input value="Số tín chỉ nợ: 0 Số tín chỉ tích lũy: 100" disabled />
                </div>
                <div class="content-right-footer">
                    <span>Chú ý: Chỉ giáo viên mới có quyền thay đổi thông tin!</span>
                </div> -->

			</div>
		</div>

		<script
			src="<c:url value='/template/Scrips/libraries/jquery-3.4.1.js'/>"></script>
		<script
			src="<c:url value='/template/Scrips/libraries/jquery-1.12.4.js'/>"></script>
		<script src="<c:url value='/template/Scrips/libraries/jquery-ui.js'/>"></script>
		<script src="<c:url value='/template/Scrips/libraries/common.js'/>"></script>
		<script src="<c:url value='/template/Scrips/view/login.js'/>"></script>
		<script src="<c:url value='/template/Scrips/view/student.js'/>"></script>
</body>
</html>