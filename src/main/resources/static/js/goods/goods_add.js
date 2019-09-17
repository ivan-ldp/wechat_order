$(function () {
    sortList();
    status();

});


/*    用来加载商品分类*/
function sortList() {
    $.getJSON({
        url: "/goods/sortList",
        success: function (data) {
           console.info(data)
            var sortOp = "<option value='' >全部</option>"
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
            var sortOp = "<option value='' >全部</option>"
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