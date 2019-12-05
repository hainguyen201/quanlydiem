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
}
var students = new student();