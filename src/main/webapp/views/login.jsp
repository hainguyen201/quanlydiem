<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>

<head>
    <meta charset="utf-8">

    <link rel="stylesheet" href="<c:url value='/template/CSS/libraries/jquery-ui.css'/>">
    <link rel="stylesheet" href="<c:url value='/template/CSS/header.css'/>">
    
    
</head>

<body>
    <header class="header">
        <div class="logo_uni">
            <a href="#" class="logo_uni_header"></a>
        </div>
        <div class="login">
            <button class="link-login">Dang nhap</button>
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
            <form action="/quanlydiemsinhvien/dang-nhap?action=login" method="post" class="login-form">
                <div class="login-title"><span>Login</span></div>
                <div class="input-login-form">
                    <div class="label-input"><span>Tai khoan</span></div>
                    <input name="username" property="login" /><br><br>
                    <div class="label-input"><span>Mat khau</span></div>
                    <input name="password" type="password" property="login" /><br>
                    <input name="usertype" type="hidden" value="teacher"/>
                </div>
                <div class="login-type">
                    <input type="radio" name="usertype" id="teacher" value="teacher"/><label for="teacher">Giao vien</label>
                    <input type="radio" name="usertype" id="student" value="student"/><label for="student">Hoc sinh</label>
                </div>
                <button style="margin-left: 40px;" class="btn-login">Dang nhap</button>
            </form>
        </div>
    </div>
    <script src="/quanlydiemsinhvien/template/Scrips/libraries/jquery-3.4.1.js"></script>
    <script src="/quanlydiemsinhvien/template/Scrips/libraries/jquery-1.12.4.js"></script>
    <script src="/quanlydiemsinhvien/template/Scrips/libraries/jquery-ui.js"></script>
    <script src="/quanlydiemsinhvien/template/Scrips/view/login.js"></script>
    <script src="/quanlydiemsinhvien/template/Scrips/view/test.js"></script>
    <%-- <script type="text/javascript" src='<c:url value="/template/Scrips/libraries/jquery-3.4.1.js"/>'></script>
    <script type="text/javascript" src='<c:url value="/template/Scrips/libraries/jquery-1.12.4.js"/>'></script>
    <script type="text/javascript" src='<c:url value="/template/Scrips/libraries/jquery-ui.js"/>'></script>
    <script type="text/javascript" src='<c:url value="/template/Scrips/view/login.js"/>'></script>
    <script type="text/javascript" src='<c:url value="/template/Scrips/view/test.js"/>'></script> --%>
</body>

</html>