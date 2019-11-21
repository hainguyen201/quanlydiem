$(document).ready(function() {
    // $("#dialog").dialog({
    //     title: "Dang nhap",
    //     modal: true,
    //     height: 400,
    //     width: 500,
    //     resizable: false,
    // });
    var date = new Date($.now());
    var res = date.getMonth();
    if (res == 12) {
        res = 1;
    } else {
        res++;
    }
    $('#datenow').val(date.getDate() + '/' + res + '/' + date.getFullYear());

});
class login {
    constructor() {
        this.InItEvent();
        this.loaddata();

    }
    InItEvent() {


        $(document).on('click', '.link-login', this.openLoginDialog);
    }
    openLoginDialog() {
        $('.input-login-form input').val("");
        $("#dialog").prop("hidden", false)
        $("#dialog").dialog({
            title: "Dang nhap",
            modal: true,
            height: 350,
            width: 500,
            resizable: false,
        });
    }

    openPageQLDiem() {
        window.location.replace("");
    }

}
var logins = new login();