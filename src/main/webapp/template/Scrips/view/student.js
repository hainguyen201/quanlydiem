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
    getSemeter() {
        var date = new Date($.now());
        var month = date.getMonth();

        if (month >= 8 || month <= 2) {
            month = 1;
        } else {
            month = 2;
        }
        var y = date.getFullYear();
        var s = y.toString() + month.toString();
        return s;
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
        var cpa = 0.0;
        var gpa = 0.0;
        var credit = 0;
        var creditgpa = 0;
        $.each(data2, function(idex, item) {
            var rowHTML = $('<tr></tr>');
            credit = credit + parseInt(item['credit']);
            var grade = 0.0;
            $.each(fieldtables, function(fieldindex, fielditem) {
                var fieldname = fielditem.getAttribute('fieldname');
                if (fieldname === "result") {
                    var fieldvalue = item['grade1'] * (1 - item['weight']) + item['grade2'] * item['weight'];

                    if (fieldvalue >= 8.5) {
                        grade = 4;
                    } else if (fieldvalue >= 8) {
                        grade = 3.5;
                    } else if (fieldvalue >= 7) {
                        grade = 3;
                    } else if (fieldvalue >= 6.5) {
                        grade = 2.5;
                    } else if (fieldvalue >= 6) {
                        grade = 2;
                    } else if (fieldvalue >= 5.5) {
                        grade = 1.5;
                    } else if (fieldvalue >= 4) {
                        grade = 1;
                    } else {
                        grade = 0;
                    }
                    debugger
                    grade = grade * item['credit'];
                    cpa += grade;
                    debugger
                    if (item['semester'].equals(getSemeter())) {
                        gpa += grade * item['credit'];
                        creditgpa += parseInt(item['credit']);
                    }

                } else {
                    var fieldvalue = item[fieldname];
                }
                rowHTML.append('<td fieldName="{1}">{0}</td>'.format(fieldvalue, fieldname));
            });
            $('.table tbody').append(rowHTML);
        });
        cpa = cpa / credit;
        gpa = gpa / creditgpa;
        $(".CPA span").html("CPA: " + Math.round(cpa * 100) / 100);
        $(".GPA span").html("GPA: " + Math.round(gpa * 100) / 100);


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