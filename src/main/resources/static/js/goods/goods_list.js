$(function () {
    loadFile(null,0,0,1);
   status();
   sortList();

    $("#button").click(function () {
        var goodName = $("#goodsName").val();
        var sort=$("#goods_sort").val();
        var status=$("#goods_status").val();
        $("tbody").html(" ");
        loadFile(goodName,status,sort,1);
    });


});
/*    用来加载商品分类*/
function sortList() {
    $.getJSON({
        url: "/goods/sortList",
        success: function (data) {
            // console.info(data)
            var sortOp = "<option value='0' >全部</option>"
            if (null != data) {
                $.each(data, function (i, sort) {
                    sortOp += "<option value=" + sort.categoryId + ">" +
                        sort.categoryName + "</option>"
                })
            }
            $("#goods_sort").append(sortOp);
        }
    });
}

/*加载 是否上下架状态*/
function status() {
    $.getJSON({
        url: "/goods/statusList",
        success: function (data) {
            //  console.info(data)
            var sortOp = "<option value='0' >全部</option>"
            if (null != data) {
                $.each(data, function (i, sort) {
                    sortOp += "<option value=" + sort.valueId + ">" +
                        sort.valueName + "</option>"
                })
            }
            $("#goods_status").append(sortOp);
        }
    });

}

/*    加载商品方法  */
//goodsName,status,categoryId,pageIndex,pageSize
function loadFile(goodsName,status,categoryId,pageIndex) {
    $.ajax({
        url: "/goods/goodsList",
        data:{"goodsName":goodsName,
               "status"   :status,
             "categoryId" :categoryId,
             "pageIndex"  :pageIndex
                  },
        type: "POST",
        dataType: "json",
        success: function (data) {
         console.info(data);
            if (null != data) {
                $.each(data, function (i, n) {
                        var s = "<tr>" +
                            "<td>" + n.goodsId + "</td>" +
                            "<td>" + n.goodsName + "</td>" +
                            "<td>" + n.picUrl + "</td>" +
                            "<td>" + n.description + "</td>" +
                            "<td>" + n.xiaoLiang + "</td>" +
                            "<td>" + n.remains + "</td>" +
                            "<td>" + n.status + "</td>" +
                            "<td>" + n.price.toFixed(2) + "</td>" +
                            "<td>" + n.createTime + "</td>" +
                            "<td>" + n.updateTime + "</td>" +
                            "<td><a href='/goods/delGoods/"+n.goodsId+"'>删除</a>" +
                            "<a href='/goods/modifyGoods/"+n.goodsId+"'>修改</a></td>" +
                            "</tr>"
                    $("tbody").append(s);
                })
            }
        }
    })
}
