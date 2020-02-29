$(document).ready(function() {
    $("#search").on("keyup", function() {
        var value = $(this).val().toLowerCase();
        $("#mytable tr").filter(function() {
            $(this).toggle($(this).text().toLowerCase().indexOf(value) > -1)
        });
    });


});
class teacher extends base {
    constructor() {
        super();
        this.inItEvent();
        this.getDateNow();
        this.checkTickRow();
    }

    /**
     * Hàm thực hiện bắt các sự kiện trên giao diện
     */
    inItEvent() {
        $(document).on('click', '.add-new', this.openDialogAdd.bind(this));
        $(document).on('click', 'button.cancel', this.closeDialog);
        $(document).on('click', 'button.edit', this.openDialogEdit.bind(this));
        $('.table-grade .table tbody').on('click', 'tr', this.rowTick);
        $(document).on('click', 'button.delete', this.openDialogDelete.bind(this));
        $(document).on('click', 'button.save', this.saveData.bind(this));
        $(document).on('click', 'button.confirm-delete', this.deleteData.bind(this));
        $(document).on('click', 'button.confirm-cancel', this.closeDialogDelete);
        $('#subject').on('change', this.loadData.bind(this));
        $(document).on('click', 'button.dialogalert-add', this.openDialogAddStudent.bind(this));
        $(document).on('click', 'button.savestudent', this.saveStudent.bind(this));
        $(document).on('click', 'button.cancelstudent', this.closeDialogAddStudent);
        $(document).on('click', 'button.dialegalert-cancel', this.closeDialogAlertAdd);
        $(document).on('click', 'button.add-student', this.openDialogAddStudentFirst.bind(this));
        $(document).on('click', 'button.btn-addsubject', this.openDialogAddSubject.bind(this));

    }
    openDialogAddSubject() {

    }

    /**
     * Hàm đóng dialog thêm và sửa
     */
    closeDialog() {
        $("#dialogadd").dialog('close');
    }

    /**
     * Hàm đóng dialog xóa
     */
    closeDialogDelete() {
        $("#dialogdelete").dialog('close');
        event.preventDefault();
    }


    closeDialogAlertAdd() {
        $("#dialogalert").dialog('close');
    }

    /**
     * Hàm mở dialog thêm
     */
    openDialogAdd() {
        var me = this;
        me.showinputagain();
        $('#dialogadd input').val();
        $('input[fieldname="subjectid"]').val($('#subject option:selected').val());
        $('#updatetype').val("post");
        $('#dialogadd').prop('hidden', false);
        $("#dialogadd").dialog({
            title: "Thêm mới điểm sinh viên",
            modal: true,
            height: 350,
            width: 700,
            resizable: false,
        });
        var date = new Date($.now());
        var month = date.getMonth();

        if (month >= 8 || month <= 2) {
            month = 1;
        } else {
            month = 2;
        }
        var y = date.getFullYear();
        var s = y.toString() + month.toString();
        $('input[fieldname="semester"]').val(s);
    }
    openDialogAddStudent(event) {
        var me = this;
        me.showinputagain();
        $('#updatetype').val("post");
        $('#dialogalert').prop('hidden', true);
        $('#dialogalert').dialog('close');
        $("#dialogaddstudent").prop('hidden', false);
        $("#dialogaddstudent").dialog({
            title: "Thêm mới thông tin sinh viên",
            modal: true,
            height: 350,
            width: 700,
            resizable: false,
        });
        $('.addstudent input[fieldname="studentname"]').val($('.add input[fieldname="studentname"]').val());
        $('.addstudent input[fieldname="studentid"]').val($('.add input[fieldname="studentid"]').val());
        event.preventDefault();
    }

    openDialogAddStudentFirst() {
        var me = this;
        me.showinputagain();
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

    /**
     * Hàm mở dialog sửa
     */
    openDialogEdit() {
        var me = this;
        me.hideinput();
        $('#dialogadd').prop('hidden', false);
        $('#updatetype').val("put");
        $("#dialogadd").dialog({
            title: "Sửa điểm sinh viên",
            modal: true,
            height: 350,
            width: 700,
            resizable: false,
        });
        var inputform = $('input[fieldname]');
        $.each(inputform, function(index, item) {
            var fielditem = $(item).attr("fieldname");
            $(item).val($('.tick td[fieldname=' + fielditem + ']').html());
        });
        $('input[fieldname="subjectid"]').val($('#subject option:selected').val());
    }

    /**
     * Hàm mở dialog xóa
     */


    openDialogAlert() {
        $('#dialogalert').prop('hidden', false);
        $("#dialogalert").dialog({
            title: "Thông báo",
            height: 170
        });
    }

    /**
     * Hàm mở dialog thêm môn học cho giảng viên
     */


    /**
     * Hàm lưu dũ liệu sau khi người dùng thực hiện thêm mới hoặc sửa dữ
     * liệu
     */
    saveData() {
        var me = this;
        var data = {};
        var inputfield = $('.add input');
        $.each(inputfield, function(index, item) {
            var fieldname = $(item).attr('fieldname');
            data[fieldname] = $(item).val();
        });
        var subjectid = $('#subject option:selected').val();
        var updatetype = $('#updatetype').val();
        if (updatetype === "post") {
            $.ajax({
                type: updatetype,
                url: "adminapi",
                data: JSON.stringify(data),
                async: false,
                contentType: "application/json; charset=utf-8",
                success: function(response) {
                    if (response == null) {

                        $("#dialogadd").dialog('close');
                        me.openDialogAlert();
                    } else if (response.message == "success") {
                        $('.alert-add-success').fadeIn();
                        $('.alert-add-success').fadeOut(2000);
                        $("#dialogadd").dialog('close');
                        me.loadData();
                    } else {
                        $('#dialogadd').dialog('close');
                        $('.alert-danger').fadeIn();
                        $('.alert-danger').fadeOut(2000);
                    }
                }
            });
        } else {
            var studentid = $('.tick td[fieldname="studentid"]').html();
            $.ajax({
                type: updatetype,
                url: "adminapi?studentid=" + studentid + "&subjectid=" + subjectid,
                data: JSON.stringify(data),
                async: false,
                contentType: "application/json; charset=utf-8",
                success: function(response) {
                    $('.alert-edit-success').fadeIn();
                    $('.alert-edit-success').fadeOut(2000);
                    $("#dialogadd").dialog('close');
                    me.loadData();
                }
            });
        }
    }

    /**
     * Hàm xóa dữ liệu khi ấn nút xóa
     */
    deleteData() {
            var me = this;
            var id = $('.tick td[fieldname="studentid"]').html();
            $.ajax({
                type: "delete",
                url: "adminapi?studentid=" + id,
                async: false,
                contentType: "application/json; charset=utf-8",
                success: function(response) {
                    $('.tick').closest("tr").remove();
                    me.closeDialogDelete();
                    $('.alert-delete-success').fadeIn();
                    $('.alert-delete-success').fadeOut(2000);
                }
            });
            event.preventDefault();
        }
        /**
         * Hàm lấy dữ liệu danh sách điểm sinh viên với ứng mới giảng viên và môn
         * học được chọn
         */
    getData() {
        var teacherid = $('#teacherid').val();
        var subjectid = $('#subject option:selected').val();
        var data = [];
        $.ajax({
            type: "get",
            url: "adminapi?teacherid=" + teacherid + "&subjectid=" + subjectid,
            contentType: "application/json",
            data: JSON.stringify(),
            async: false,
            dataType: 'json',
            success: function(response) {
                data = response;
            }
        });
        return data;
    }

    /**
     * Hàm load dữ liệu tương ứng với teacherid và subjectid được lựa chọn trong
     * thẻ select
     */
    loadData() {
        $('button.edit').prop("disable", true);
        $('button.delete').prop("disable", true);
        var me = this;
        var data = me.getData();
        $('.table tbody').empty();
        var fieldtables = $('.table th[fieldname]');
        $.each(data, function(idex, item) {
            var rowHTML = $('<tr></tr>');

            $.each(fieldtables, function(fieldindex, fielditem) {
                var fieldname = fielditem.getAttribute('fieldname');
                if (fieldname === "result") {
                    var fieldvalue = item['grade1'] + item['grade2'];
                } else {
                    var fieldvalue = item[fieldname];
                }
                rowHTML.append('<td fieldName="{1}">{0}</td>'.format(fieldvalue, fieldname));
            });
            $('.table tbody').append(rowHTML);
        });
    }

    checkTickRow() {
        var tickCount = $('.tick').length;
    }
}
var teachers = new teacher();