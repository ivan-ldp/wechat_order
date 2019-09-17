// $(document).ready(function () {
//     init();
//     function init() {
//         var url="127.0.0.1:8082/goodsList";
//         var sortId=2;
//         $.getJSON(url,sortId,orucessGoodsDetailList)
//     }
//     function orucessGoodsDetailList(data) {
//     $.each(data,function (i,goodsDetail) {
//         console.log(goodsDetail.toString());
//     })
//     }
// })
$(function () {
    loadFile(null);
    $.getJSON({
        url: "/goods/sort/list",
        success: function (data) {
            console.info(data)
            var sortOp = "<option value='' >全部</option>"
            if (null != data) {
                $.each(data, function (i, sort) {
                    sortOp += "<option value=" + sort.id + ">" +
                        sort.name + "</option>"
                })
            }
            $("#goods_sort").append(sortOp);
        }
    });

    $("#goods_sort").click(function () {
        var content = $(this).val();
        $("tbody").html("");
        loadFile(content);
    });


});

function loadFile(sortId) {
    $.ajax({
        url: "/goods/goodsList",
        data: {sortId: sortId},
        type: "get",
        dataType: "json",
        success: function (data) {
            console.info(data)
            if (null != data) {
                $.each(data, function (i, n) {
                   if (i % 2 != 0) {
                        var s = "<tr class='odd'>" +
                            "<td>" + n.id + "</td>" +
                            "<td>" + n.name + "</td>" +
                            "<td>" + n.sortName + "</td>" +
                            "<td>" + n.address + "</td>" +
                            "<td>" + n.createDate + "</td>" +
                            "<td>" + n.price.toFixed(2) + "</td>" +
                            "<td>" + n.remaining + "</td>" +
                            "<td><a href='/goods/detail/"+n.id+"'>购买</a></td>" +
                            "</tr>"
                   } else {
                        var s = "<tr class='even'>" +
                            "<td>" + n.id + "</td>" +
                            "<td>" + n.name + "</td>" +
                            "<td>" + n.sortName + "</td>" +
                            "<td>" + n.address + "</td>" +
                            "<td>" + n.createDate + "</td>" +
                            "<td>" + n.price.toFixed(2) + "</td>" +
                            "<td>" + n.remaining + "</td>" +
                            "<td><a href='/goods/detail/"+n.id+"'>购买</a></td>" +
                            "</tr>"
                    }

                    $("tbody").append(s);
                })
            }
        }
    })
}