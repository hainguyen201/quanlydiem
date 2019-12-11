$(document).ready(function() {

});
class teacher {
    constructor() {
        this.inItEvent();
        this.getDateNow();
        this.loadData();
    }
    inItEvent() {
        $(document).on('click', '.add-new', this.openDialogAdd);
        $(document).on('click', 'button.cancel', this.closeDialog)
        $(document).on('click', 'btn.edit', this.openDialogEdit);
        $(document).on('click', 'btn.add-new', this.openDialogDelete);
        $('.table tbody').on('click', 'tr', this.rowTick);
        $(document).on('click', 'button.delete', function() { $('.tick').remove() });
        $(document).on('click', 'button.save', this.saveData);


    }
    closeDialog() {
        $("#dialogadd").dialog('close');
    }
    openDialogAdd() {
        $('#dialogadd input').val();
        $('#dialogadd').prop('hidden', false);
        $("#dialogadd").dialog({
            title: "Thêm mới sinh viên",
            modal: true,
            height: 350,
            width: 700,
            resizable: false,
        });
    }
    rowTick(event) {
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
    saveData() {

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
    getData() {
        var teacherid = $('#teacherid').val();
        var subjectid = $('#subjectid').val();
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
    loadData() {
        var data = this.getData();
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
}
var teachers = new teacher();