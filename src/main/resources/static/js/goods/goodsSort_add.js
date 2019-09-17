$(function () {
    $.getJSON({
        url: "/goods/sortList",
        success: function (data) {
            // console.info(data)
            var sortOp = "<option value='' >全部</option>"
            if (null != data) {
                $.each(data, function (i, sort) {
                    sortOp += "<option value=" + sort.categoryId + ">" +
                        sort.categoryName + "</option>"
                })
            }
            $("#sort").append(sortOp);
        }
    })
});