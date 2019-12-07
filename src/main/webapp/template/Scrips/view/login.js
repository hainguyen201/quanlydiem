$(document).ready(function() {

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
        this.getdatenow();
        this.InItEvent();
        this.checktype();
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
    checktype() {
        $('.login-type').change(function() {
            var s = $("input[name='type']:checked").val();
            $('input#usertype').val(s);
        });
    }
    getdatenow() {
        var date = new Date($.now());
        var res = date.getMonth();
        if (res == 12) {
            res = 1;
        } else {
            res++;
        }
        $('#datenow').val(date.getDate() + '/' + res + '/' + date.getFullYear());

    }

}
var logins = new login();