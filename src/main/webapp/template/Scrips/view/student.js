$(document).ready(function() {

});
class student {
    constructor() {

        this.loadData();
        this.inItEvent();


    }
    inItEvent() {

    }
    getData() {
        var data = [];
        $.ajax({
            url: "student",
            type: 'GET',
            async: false,
            dataType: 'json',
            success: function(response) {
                data = response;
            }
        });
        return data;
    }
    getStudentGrade() {
        var data = [];
        $.ajax({
            url: "student",
            type: 'GET',
            contentType: "application/json; charset=utf-8",
            data: JSON.stringify({ state: "Studentgrade" }),
            async: false,
            dataType: 'json',
            success: function(response) {
                data = response;
            }
        });
        return data;
    }
    loadData() {
        var me = this;
        var data = this.getStudentGrade();
        debugger
        var fields = $('.main-studentinfo input[fieldname]');
        // $('input[fieldname="studentid"').val(data[1]['studentid']);
        $.each(fields, function(idex, item) {
            var fieldsName = item.getAttribute('fieldname');
            $('input[fieldname="' + fieldsName + '"]').val(data[1][fieldsName]);
        });
        $('.main-table tbody').empty();

    }
}
var students = new student();