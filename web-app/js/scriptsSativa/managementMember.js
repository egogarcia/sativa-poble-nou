var ManagementMember = function () {


    return {

        init: function () {
            $('.deleteMember').click(function() {
                var id = $(this).prop('id');
                $('#deleteMember').modal('show');
                $('#btnDeleteMember').prop('href', "member/delete?memberId="+id);
            });

		    
        }
    }
}();