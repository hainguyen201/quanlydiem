$(document).ready(function() {
	$('.info input').prop("disabled", true);
});
class student {
    constructor() {

        /*this.loadData();*/
        this.inItEvent();
        this.getDateNow();

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
        data['studentid']=20173089;
        $.ajax({
            url: "student",
            type: 'get',
            contentType: "application/json",
            data: JSON.stringify(data),
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
        var data = this.getData();
   
        var fields = $('.main-studentinfo input[fieldname]');
        // $('input[fieldname="studentid"').val(data[1]['studentid']);
        $.each(fields, function(idex, item) {
            var fieldsName = item.getAttribute('fieldname');
            $('input[fieldname="' + fieldsName + '"]').val(data[0][fieldsName]);
        });
        $('.main-table tbody').empty();

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

}
var students = new student();