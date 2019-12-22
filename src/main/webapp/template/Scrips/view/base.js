class base {
    constructor() {

    }
    getDateNow() {
        var date = new Date($.now());
        var res = date.getMonth();
        if (res == 12) {
            res = 1;
        } else {
            res++;
        }
        $('#datenow').val(date.getDate() + '/' + res + '/' + date.getFullYear());

    }
    saveStudent() {
        var me = this;
        var data = {};
        var inputfield = $('.addstudent input');
        $.each(inputfield, function(index, item) {
            var fieldname = $(item).attr('fieldname');
            data[fieldname] = $(item).val();
        });
        debugger
        var studentid = $('.tick td[fieldname=studentid]').html();
        if ($('#updatetype').val() == "post") {
            $.ajax({
                type: "post",
                url: "adminapi?type=newstudent",
                data: JSON.stringify(data),
                async: false,
                contentType: "application/json; charset=utf-8",
                success: function(response) {
                    debugger
                    if (response == null) {
                        $("#dialogaddstudent").dialog('close');
                        $('.alert-danger').fadeIn();
                        $('.alert-danger').fadeOut(5000);
                    } else if (response.message == "success") {
                        $('.alert-add-success').fadeIn();
                        $('.alert-add-success').fadeOut(5000);
                        $("#dialogaddstudent").dialog('close');
                        me.loadData();
                    } else {
                        $("#dialogaddstudent").dialog('close');
                        $('.alert-danger').fadeIn();
                        $('.alert-danger').fadeOut(5000);
                    }

                }
            });
        } else {
            var studentid = $('.tick td[fieldname=studentid]').html();
            $.ajax({
                type: "put",
                url: "listapi?studentid=" + studentid,
                data: JSON.stringify(data),
                async: false,
                contentType: "application/json; charset=utf-8",
                success: function(response) {
                    debugger
                    if (response == null) {
                        $("#dialogaddstudent").dialog('close');
                        $('.alert-danger').fadeIn();
                        $('.alert-danger').fadeOut(5000);
                    } else if (response.message == "success") {
                        $('.alert-add-success').fadeIn();
                        $('.alert-add-success').fadeOut(5000);
                        $("#dialogaddstudent").dialog('close');
                        me.loadData();
                    } else {
                        $("#dialogaddstudent").dialog('close');
                        $('.alert-danger').fadeIn();
                        $('.alert-danger').fadeOut(5000);
                    }

                }
            });
        }
    }
    rowTick(event) {
        $('button.edit').prop("disable", false);
        $('button.delete').prop("disable", false);
        if (event.ctrlKey) {
            $(this).addClass('tick');
            $('button.delete').removeAttr('disabled');

        } else {
            $('.table tbody tr').removeClass('tick');
            $(this).addClass('tick');
            $('button.delete').removeAttr('disabled');
            $('button.add-new').removeAttr('disabled');
            $('button.edit').removeAttr('disabled');
        }
    }
    openDialogAddStudentFirst() {
        var me = this;
        $('#updatetype').val("post");
        $("#dialogaddstudent").prop('hidden', false);
        $("#dialogaddstudent").dialog({
            title: "Thêm mới thông tin sinh viên",
            modal: true,
            height: 350,
            width: 700,
            resizable: false,
        });
    }
    closeDialogAddStudent() {
        $("#dialogaddstudent").dialog('close');
    }
    openDialogDelete() {
        $('#dialogdelete').prop('hidden', false);
        $("#dialogdelete").dialog({
            title: "Xóa sinh viên",
            height: 150
        });
    }
    closeDialogDelete() {
        $("#dialogdelete").dialog('close');
        event.preventDefault();
    }
    hideinput() {
        $('input[fieldname="studentid"]').prop("disabled", true);
        $('input[fieldname="subjectid"]').prop("disabled", true);
        $('input[fieldname="studentname"]').prop("disabled", true);
    }
    showinputagain() {
        $('input[fieldname="studentid"]').prop("disabled", false);
        $('input[fieldname="subjectid"]').prop("disabled", false);
        $('input[fieldname="studentname"]').prop("disabled", false);
    }

}