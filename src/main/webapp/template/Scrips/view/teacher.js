$(document).ready(function() {
    $("#search").on("keyup", function() {
        var value = $(this).val().toLowerCase();
        $("#mytable tr").filter(function() {
            $(this).toggle($(this).text().toLowerCase().indexOf(value) > -1)
        });
    });
});
class teacher {
    constructor() {
        this.inItEvent();
        this.getDateNow();
        this.checkTickRow();
    }

    /**
     * Hàm thực hiện bắt các sự kiện trên giao diện
     */
    inItEvent() {
        $(document).on('click', '.add-new', this.openDialogAdd);
        $(document).on('click', 'button.cancel', this.closeDialog);
        $(document).on('click', 'button.edit', this.openDialogEdit);
        $('.table tbody').on('click', 'tr', this.rowTick);
        $(document).on('click', 'button.delete', this.openDialogDelete.bind(this));
        $(document).on('click', 'button.save', this.saveData.bind(this));
        $(document).on('click', 'button.confirm-delete', this.deleteData.bind(this));
        $(document).on('click', 'button.confirm-cancel', this.closeDialogDelete);
        $('#subject').on('change', this.loadData.bind(this));
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
    }

    /**
     * Hàm mở dialog thêm
     */
    openDialogAdd() {
        $('#dialogadd input').val();
        $('input[fieldname="subjectid"]').val($('#subject option:selected').val());
        $('#updatetype').val("post");
        $('#dialogadd').prop('hidden', false);
        $("#dialogadd").dialog({
            title: "Thêm mới sinh viên",
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
    openDialogDelete() {
        $('#dialogdelete').prop('hidden', false);
        $("#dialogdelete").dialog({
            title: "Sửa điểm sinh viên",
            height: 150
        });
    }

    /**
     * Hàm chọn một  hàng sau khi click chuột
     * @param {*} event 
     */
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

    /**
     * Hàm lưu dũ liệu sau khi người dùng thực hiện thêm mới hoặc sửa dữ liệu
     */
    saveData() {
        var me = this;
        var data = {};
        var inputfield = $('.add input');
        $.each(inputfield, function(index, item) {
            var fieldname = $(item).attr('fieldname');
            data[fieldname] = $(item).val();
        });
        var updatetype = $('#updatetype').val();
        if (updatetype === "post") {
            $.ajax({
                type: updatetype,
                url: "adminapi",
                data: JSON.stringify(data),
                async: false,
                contentType: "application/json; charset=utf-8",
                success: function(response) {
                    if (response.message == "success") {
                        $("#dialogadd").dialog('close');
                        me.loadData();
                    } else {
                        alert();
                    }

                }
            });
        } else {
            var studentid = $('.tick td[fieldname="studentid"]').html();
            $.ajax({
                type: updatetype,
                url: "adminapi?studentid=" + studentid,
                data: JSON.stringify(data),
                async: false,
                contentType: "application/json; charset=utf-8",
                success: function(response) {
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
            }
        });
    }

    /**
     * Hàm lấy giá trị ngày hiện tại và hiển thị trên giao diện
     */
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

    /**
     * Hàm lấy dữ liệu danh sách điểm sinh viên với ứng mới giảng viên và môn học được chọn
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
     * Hàm load dữ liệu tương ứng với teacherid và subjectid được lựa chọn trong thẻ select
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