$(document).ready(function() {
    $('.info input').prop("disabled", true);
    $("#search").on("keyup", function() {
        var value = $(this).val().toLowerCase();
        $("#mytable tr").filter(function() {
            $(this).toggle($(this).text().toLowerCase().indexOf(value) > -1)
        });
    });
});
class student {
    constructor() {

        this.loadData();
        this.inItEvent();
        this.getDateNow();

    }
    inItEvent() {

    }

    /**
     * Hàm lấy thông tin về điểm các môn học của sinh viên
     */
    getStudentGrade() {
        var data = [];
        var id = $('input[fieldname="studentid"]').val();
        $.ajax({
            url: "student?studentid=" + id,
            type: 'post',
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
     * Hàm lấy thông tin điểm sinh viên và đưa vào trang web
     */
    loadData() {
        var me = this;
        var data2 = this.getStudentGrade();
        var fieldtables = $('.table th[fieldname]');
        var fields = $('.main-studentinfo input[fieldname]');
        // // $('input[fieldname="studentid"').val(data[1]['studentid']);
        // $.each(fields, function(idex, item) {
        //     var fieldsName = item.getAttribute('fieldname');
        //     $('input[fieldname="' + fieldsName + '"]').val(data[0][fieldsName]);
        // });

        $('.main-table tbody').empty();
        $.each(data2, function(idex, item) {
            var rowHTML = $('<tr></tr>');

            $.each(fieldtables, function(fieldindex, fielditem) {
                var fieldname = fielditem.getAttribute('fieldname');
                if (fieldname === "result") {
                    var fieldvalue = (item['grade1'] + item['grade2']) / 2;
                } else {
                    var fieldvalue = item[fieldname];
                }
                rowHTML.append('<td fieldName="{1}">{0}</td>'.format(fieldvalue, fieldname));
            });
            $('.table tbody').append(rowHTML);
        });
    }

    /**
     * Hàm thực hiện lấy ngày tháng năm và hiển thị trên giao diện
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

}
var students = new student();