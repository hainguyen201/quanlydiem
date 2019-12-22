$(document).ready(function() {
    $("#search").on("keyup", function() {
        var value = $(this).val().toLowerCase();
        $("#mytable tr").filter(function() {
            $(this).toggle($(this).text().toLowerCase().indexOf(value) > -1)
        });
    });


});
class list extends base {
    constructor() {
        super();
        this.inItEvent();
        this.loadData();
        this.getDateNow();
    }
    inItEvent() {
        $('.table tbody').on('click', 'tr', this.rowTick);
        $(document).on('click', 'button.add-student', this.openDialogAddStudentFirst.bind(this));
        $(document).on('click', 'button.savestudent', this.saveStudent.bind(this));
        $(document).on('click', 'button.cancelstudent', this.closeDialogAddStudent);
        $(document).on('click', 'button.edit', this.openDialogEdit.bind(this));
        $(document).on('click', 'button.delete', this.openDialogDelete.bind(this));
        $(document).on('click', 'button.confirm-delete', this.deleteData.bind(this));
    }

    openDialogEdit() {
        var me = this;
        $('#dialogaddstudent').prop('hidden', false);
        $('#updatetype').val("put");
        $("#dialogaddstudent").dialog({
            title: "Sửa thông tin sinh viên",
            modal: true,
            height: 350,
            width: 700,
            resizable: false,
        });
        var inputform = $('#dialogaddstudent input[fieldname]');
        $.each(inputform, function(index, item) {
            var fielditem = $(item).attr("fieldname");
            if (fielditem == "dob") {
                $(item).val($('.tick td[fieldname="dateofbirth"]').html());
            } else {

                $(item).val($('.tick td[fieldname=' + fielditem + ']').html());
            }
        });

    }
    closeDialogAddStudent() {
        $("#dialogaddstudent").dialog('close');
    }
    getData() {
        var data = [];
        $.ajax({
            type: "get",
            url: "listapi",
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
    loadData() {
        var data = this.getData();
        $('.table tbody').empty();
        var fieldtables = $('.table th[fieldname]');
        $.each(data, function(idex, item) {
            var rowHTML = $('<tr></tr>');
            $.each(fieldtables, function(fieldindex, fielditem) {
                var fieldname = fielditem.getAttribute('fieldname');
                var fieldvalue = item[fieldname];
                rowHTML.append('<td fieldName="{1}">{0}</td>'.format(fieldvalue, fieldname));
            });
            $('.table tbody').append(rowHTML);
        });
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

    deleteData() {
        var me = this;
        var id = $('.tick td[fieldname="studentid"]').html();
        $.ajax({
            type: "delete",
            url: "listapi?studentid=" + id,
            async: false,
            contentType: "application/json; charset=utf-8",
            success: function(response) {
                $('.tick').closest("tr").remove();
                me.closeDialogDelete();
                $('.alert-delete-success').fadeIn();
                $('.alert-delete-success').fadeOut(5000);
            }
        });
        event.preventDefault();
    }
}
var l = new list();