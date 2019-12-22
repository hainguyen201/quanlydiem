<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ include file="/common/taglib.jsp"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html>
<html>

<head>
<meta charset="UTF-8">
</head>

<body>
	<div class="alert alert-success alert-add-success" role="alert">
		<strong>Chúc mừng !</strong> Bạn đã thêm thành công
	</div>
	<div class="alert alert-success alert-edit-success" role="alert">
		<strong>Chúc mừng !</strong> Bạn đã sửa thành công
	</div>
	<div class="alert alert-success alert-delete-success" role="alert">
		<strong>Chúc mừng !</strong> Bạn đã xóa thành công
	</div>
	<div class="alert alert-danger" role="alert">Lỗi không thêm được sinh viên!</div>	
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
	</header>

	<div class="master-content">
		
		<div class="content">
			<div class="menu">
			</div>
			<div class="content-right">
				<div class="datenow">
					<input id="datenow" disabled />
				</div>
				<div class="content-title">
					<span>Danh sách sinh viên</span>

				</div>
				<hr
					style="background-color: black; text-align: left; position: relative; top: 30px;"
					noshade="noshade">
				<input id="search" type="text" placeholder="Search..">
				<div class="toolbar">

					<button ><a href="http://localhost:8080/quanlydiemsinhvien/admin-home">Trở lại</a></button>
					<button class="add-student">Thêm</button>
					<button class="edit" disabled>Sửa</button>
					<button class="delete" disabled>Xóa</button>
				</div>
				<div id='dialogaddstudent' hidden>
					<form class="form-add">
						<div class="addstudent">
							<div class="add-label1">
								<span>Họ tên</span> <input fieldname="studentname" />
							</div>
							<div class="add-label1">
								<span>MSSV</span> <input fieldname="studentid" />
							</div>
						</div>
						<div class="addstudent">
							<div class="add-label1">
								<span>Lớp</span> <input fieldname="studentclass" />
							</div>
							<div class="add-label1">
								<span>Giới tính</span> <input fieldname="gender" />
							</div>
						</div>
						<div class="addstudent">
							<div class="add-label1">
								<span>Khoa, viện</span> <input fieldname="faculty" />
							</div>
							<div class="add-label1">
								<span>Ngày sinh</span> <input fieldname="dob" />
							</div>
						</div>
						<div class="addstudent">
							<div class="add-label1">
								<span>Email</span> <input fieldname="email" />
							</div>
							<div class="add-label1">
								<span>Địa chỉ</span> <input fieldname="district" />
							</div>
						</div>
					</form>
					<div class="btn-add">
						<button class="savestudent">Lưu</button>
						<button class="cancelstudent">Hủy</button>
					</div>
					<input id="updatetype" type="hidden" value="" />
				</div>
				<div id='dialogdelete' hidden>
					<form class="form-delete">
						<div class="delete-title">
							<span>Bạn có chắc muôn xóa ?</span>
						</div>
						<div class="btn-confirm">
							<button class="confirm-delete">Xóa</button>
							<button class="confirm-cancel">Hủy</button>
						</div>
					</form>
				</div>
				<div class="main-table table-grade">
					<table class="table table-hover table-bordered table-responsive-sm">
						<thead>
							<tr>
								<th fieldname="studentname">Họ tên</th>
								<th fieldname="studentid">MSSV</th>
								<th fieldname="studentclass">Lớp</th>
								<th fieldname="gender">Giới tính</th>
								<th fieldname="faculty">Khoa, viện</th>
								<th fieldname="dateofbirth">Ngày sinh</th>
								<th fieldname="email">Email</th>
								<th fieldname="district">Địa chỉ</th>
							</tr>
						</thead>
						<tbody id="mytable">
						</tbody>
					</table>
				</div>
				<input type="hidden" id="teacherid"
					value="${teacherModel.getTeacherid()}" /> <input type="hidden"
					id="subjectid" value="${teacherModel.getSubjectid()}" />
			</div>
		</div>
</body>

</html>