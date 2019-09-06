$(function () {
select()
    //begin
    $("#btn").click(function () {
        selectStudent();
    });//end

    //begin
    function selectStudent() {
        $("#msg").load("studentServlet","opr=select");
    };
    //end

    function select() {

        $.get("studentServlet","opr=selectList",selectList);
            function selectList(data) {
            //console.log(data);
                console.log("aa");
            alert("da");
            $.each(data,function (i,item) {

                //创建tr标签
                var rowTr=document.createElement('tr');
                rowTr.className="tr_node";

                var child="<td>"+item.studentNo+"</td>"
                    +"<td>"+item.studentName+"</td>"
                +"<td>"+item.studentPassword+"</td>"
                +"<td>"+item.studentGedent+"</td>"
                +"<td>"+item.gradeId+"</td>"
                +"<td>"+item.address+"</td>"
                rowTr.innerHTML=child;
                $(".tbody_node").append(rowTr);
            })
        };
    }
})

