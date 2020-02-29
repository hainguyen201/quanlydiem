<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
    <%@ include file="/common/taglib.jsp"%>
        <!DOCTYPE html>
        <html>

        <head>
            <meta charset="UTF-8">
            <title>Sinh viên</title>
        </head>

        <body>
            <header class="header">
                <div class="logo_uni">
                    <a href="#" class="logo_uni_header"></a>
                </div>
                <div class="login">
                    <button class="link-login"><a href="/quanlydiemsinhvien/thoat?action=logout&usertype=student">Đăng xuất</a></button>
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
                            <input type="radio" name="user-type" id="teacher" /><label for="teacher">Giao vien</label> <input type="radio" name="user-type" id="student" /><label for="student">Hoc
						sinh</label>
                        </div>
                        <button style="margin-left: 40px;" class="btn-login" type="submit">Dang
					nhap</button>

                    </form>
                </div>
                <div class="content">
                    <div class="menu">
                        <select id="semester">
				</select>
                    </div>
                    <div class="content-right">
                        <div class="datenow">
                            <input id="datenow" disabled />
                        </div>
                        <div class="content-title">
                            <span>Thông tin sinh viên</span>
                        </div>
                        <hr style="background-color: black; text-align: left; position: relative; top: 30px;" noshade="noshade">
                        <div class="main-studentinfo">
                            <div class="info">
                                <div class="name">
                                    <span>Họ tên</span> <input fieldname='studentname' value="${studentModel.studentname}" />
                                </div>
                                <div class="mssv">
                                    <span>MSSV</span> <input fieldname="studentid" value="${studentModel.studentid }" />
                                </div>
                            </div>
                            <div class="info">
                                <div class="class">
                                    <span>Lớp</span> <input fieldname="studentclass" value="${studentModel.studentclass}" />
                                </div>
                                <div class="gender">
                                    <span>Giới tính</span> <input fieldname="gender" value="${studentModel.gender}" />
                                </div>
                            </div>
                            <div class="info">
                                <div class="faculty">
                                    <span>Khoa, viện</span><input style="position: relative; left: 5px" fieldname="faculty" value="${studentModel.faculty}" />
                                </div>
                                <div class="dob">
                                    <span>Ngày sinh</span> <input fieldname="dateofbirth" value="${studentModel.dateofbirth}" />
                                </div>
                            </div>
                            <div class="info">
                                <div class="email">
                                    <span>Email</span> <input fieldname="email" value="${studentModel.email}" />
                                </div>
                                <div class="district">
                                    <span>Tỉnh,TP</span> <input fieldname="district" value="${studentModel.district}" />
                                </div>
                            </div>
                            <div class="info">
                                <div class="phone">
                                    <span>SĐT</span> <input fieldname="phone" value="${studentModel.phone}" />
                                </div>
                            </div>
                        </div>
                        <input id="search" type="text" placeholder="Search.." style="top: 52px">
                        <div class="main-table">
                            <table class="table table-hover table-bordered table-responsive-sm">
                                <thead>
                                    <tr>
                                        <th fieldname="semester">Kỳ học</th>
                                        <th fieldname="subjectid">Mã HP</th>
                                        <th fieldname="subjectname">Tên HP</th>
                                        <th fieldname="credit">TC</th>
                                        <th fieldname="classid">Lớp học</th>
                                        <th fieldname="grade1">Điểm quá trình</th>
                                        <th fieldname="grade2">Điểm thi</th>
                                        <th fieldname="result">Kết quả</th>
                                    </tr>
                                </thead>
                                <tbody id="mytable">
                                </tbody>
                            </table>
                        </div>
                        <div class="total">
                            <div class="CPA">
                                <span>CPA: </span>
                            </div>
                            <div class="GPA">
                                <span>GPA: </span>
                            </div>
                        </div>
                        <!-- <div class="CPA-GPA content-footer">
					<input value="GPA: 4.0       CPA: 4.0" disabled />
				</div>
				<div class="credit content-footer">
					<input value="Số tín chỉ nợ: 0 Số tín chỉ tích lũy: 100"
						disabled />
				</div> -->
                    </div>
                </div>

            </div>
            <%-- 	<script
		src="<c:url value='/template/Scrips/libraries/jquery-3.4.1.js'/>"></script>
	<script
		src="<c:url value='/template/Scrips/libraries/jquery-1.12.4.js'/>"></script>
	<script src="<c:url value='/template/Scrips/libraries/jquery-ui.js'/>"></script>
	<script src="<c:url value='/template/Scrips/libraries/common.js'/>"></script>
	<script src="<c:url value='/template/Scrips/view/student.js'/>"></script> --%>
                <script type="text/javascript">
                    $('.info input').prop("disabled", true);
                    var date = new Date($.now());
                    var res = date.getMonth();
                    if (res == 12) {
                        res = 1;
                    } else {
                        res++;
                    }
                    $('#datenow').val(date.getDate() + '/' + res + '/' + date.getFullYear());
                    /* var data = [];
                    data['studentid'] = 20173089;
                    $.ajax({
                        url: "student?studentid=" + 20173089,
                        type: 'post',
                        contentType: "application/json",
                        data: JSON.stringify(),
                        async: false,
                        dataType: 'json',
                        success: function(response) {
                            data = response;
                            debugger
                        }
                    }); */
                </script>

        </body>

        </html>