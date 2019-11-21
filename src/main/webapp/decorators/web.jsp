<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ include file="/common/taglib.jsp"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta content="text/html; charset=utf-8" http-equiv="Content-Type">
<title><dec:title default="Trang chu" /></title>
<link rel="stylesheet" type="text/css" media="all"
	href="<c:url value='/template/CSS/libraries/bootstrap-4.3.1-dist/css/bootstrap.css'/>">
<link rel="stylesheet" type="text/css" media="all"
	href="<c:url value='/template/CSS/libraries/jquery-ui.css'/>">
<link rel="stylesheet" type="text/css" media="all"
	href="<c:url value='/template/CSS/header.css'/>">
<link rel="stylesheet" type="text/css" media="all"
	href="<c:url value='/template/CSS/content.css'/>">
<link rel="stylesheet" type="text/css" media="all"
	href="<c:url value='/template/CSS/menu.css'/>">
<link rel="stylesheet" type="text/css" media="all"
	href="<c:url value='/template/CSS/rightcontent.css'/>">
<link rel="stylesheet" type="text/css" media="all"
	href="<c:url value='/template/CSS/studentinfo.css'/>">
<link rel="stylesheet" type="text/css" media="all"
	href="<c:url value='/template/CSS/table.css'/>">
</head>
<body>
	<header class="header">
	<div class="logo_uni">
		<a href="#" class="logo_uni_header"></a>
	</div>
	<div class="login">
		<button class="link-login">Đăng xuất</button>
	</div>
	</header>
	<div class="master-content">
		<div id="dialog" hidden>
			<form action="thongtin.html" method="" class="login-form">
				<div class="login-title">
					<span>Login</span>
				</div>
				<div class="input-login-form">
					<div class="label-input">
						<span>Tai khoan</span>
					</div>
					<input name="user" property="login" /><br> <br>
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
				<select id="semester">
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
					<span>Thông tin sinh viên</span>
				</div>
				<hr
					style="background-color: black; text-align: left; position: relative; top: 30px;"
					noshade="noshade">
				<div class="main-studentinfo">
					<div class="info">
						<div class="name">
							<span>Họ tên</span> <input fieldname='studentname' />
						</div>
						<div class="mssv">
							<span>MSSV</span> <input fieldname="studentid" />
						</div>
					</div>
					<div class="info">
						<div class="class">
							<span>Lớp</span> <input fieldname="studentclass" />
						</div>
						<div class="gender">
							<span>Giới tính</span> <input fieldname="gender" />
						</div>
					</div>
					<div class="info">
						<div class="faculty">
							<span>Khoa, viện</span><input fieldname="faculty"/>
						</div>						
						<div class="dob">
							<span>Ngày sinh</span> <input fieldname="dateofbirth" />
						</div>
					</div>
					<div class="info">
						<div class="email">
							<span>Email</span> <input fieldname="email" />
						</div>
						<div class="district">
							<span>Tỉnh,TP</span> <input fieldname="district" />
						</div>
					</div>
				</div>
				<div class="main-table">
					<table class="table table-hover table-bordered table-responsive-sm">
						<thead>
							<tr>
								<th>Kỳ học</th>
								<th>Mã HP</th>
								<th>Tên HP</th>
								<th>TC</th>
								<th>Lớp học</th>
								<th>Điểm quá trình</th>
								<th>Điểm thi</th>
								<th>Kết quả</th>
							</tr>
						</thead>
						<tbody>

						</tbody>
					</table>
				</div>
				<div class="CPA-GPA content-footer">
					<input value="GPA: 4.0       CPA: 4.0" disabled />
				</div>
				<div class="credit content-footer">
					<input value="Số tín chỉ nợ: 0 Số tín chỉ tích lũy: 100"
						disabled />
				</div>
			</div>
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