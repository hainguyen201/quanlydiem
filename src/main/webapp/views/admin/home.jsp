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
				<select id="subject">
					<option>--Chọn môn học--</option>
					<c:forEach var="sub" items="${subjectModel}">
						<option value="${sub.getSubjectid()}">${sub.getSubjectname()}</option>
					</c:forEach>
				</select>

			</div>
			<div class="content-right">
				<div class="datenow">
					<input id="datenow" disabled />
				</div>
				<div class="content-title">
					<span>Cập nhật điểm sinh viên</span>

				</div>
				<hr
					style="background-color: black; text-align: left; position: relative; top: 30px;"
					noshade="noshade">
				<input id="search" type="text" placeholder="Search..">
				<div class="toolbar">
					<button ><a href='http://localhost:8080/quanlydiemsinhvien/list-student'>Xem DS</a></button>
					<button class="add-new">Thêm</button>
					<button class="edit" disabled>Sửa</button>
					<button class="delete" disabled>Xóa</button>
				</div>
				<div id='dialogadd' hidden>
					<form class="form-add">

						<div class="add">
							<div class="add-label1">
								<span>Học kỳ</span> <input fieldname="semester" />
							</div>
							<div class="add-label1">
								<span>Mã môn học</span> <input fieldname="subjectid" />
							</div>
						</div>
						<div class="add">
							<div class="add-label1">
								<span>Họ tên</span> <input fieldname="studentname" />
							</div>
							<div class="add-label1">
								<span>MSSV</span> <input fieldname="studentid" />
							</div>

						</div>
						<div class="add">
							<div class="add-label1">
								<span>Mã lớp</span> <input fieldname="classid" />
							</div>

						</div>
						<div class="add">
							<div class="add-label1">
								<span>Điểm QT</span> <input fieldname="grade1" />
							</div>
							<div class="add-label1">
								<span>Điểm cuối kì</span> <input fieldname="grade2" />
							</div>
						</div>
						<div class="add">
							<div class="add-label1">
								<span>Ghi chú</span> <input fieldname="note" />
							</div>
						</div>
					</form>
					<div class="btn-add">
						<button class="save">Lưu</button>
						<button class="cancel">Hủy</button>
					</div>
					<input id="updatetype" type="hidden" value="" />
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
				</div>
				<div id='dialogedit'>
					<form class="form-edit"></form>
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
				<div id="dialogalert" hidden>
					<form>
						<div class="alert-title">
							<span>Sinh viên không tồn tại, bạn có muốn thêm sinh viên
								mới</span>
						</div>
						<div class="btn-confirm">
							<button class="dialogalert-add">Thêm</button>
							<button class="dialegalert-cancel">Hủy</button>
						</div>
					</form>
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

				<div class="main-table table-grade">
					<table class="table table-hover table-bordered table-responsive-sm">
						<thead>
							<tr>
								<th fieldname="semester">Kỳ học</th>
								<th fieldname="subjectname">Môn học</th>
								<th fieldname="classid">Mã lớp</th>
								<th fieldname="studentname">Họ tên</th>
								<th fieldname="studentid">MSSV</th>
								<th fieldname="credit">Số tín</th>
								<th fieldname="grade1">Điểm quá trính</th>
								<th fieldname="grade2">Điểm cuối kì</th>
								<th fieldname="weight">Trọng số</th>
								<th fieldname="note">Ghi chú</th>
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