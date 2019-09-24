$(document).ready(function(){
    loadSort();
});

/*    加载分类方法  */
function loadSort() {
    $.getJSON({
        url: "/goods/sortList",
        success: function (data) {
            console.info(data);
            if(null!=data){
                $.each(data, function (i, n) {
                    var s="<tr>\n" +
                        "<td><input type=\"checkbox\"></td>\n" +
                        "<td>"+n.categoryId+"</td>\n" +
                        "<td>"+n.categoryName+"</td>\n" +
                        "<td>"+n.createTime+"</td>\n" +
                        "<td>"+n.updateTime+"</td>\n" +
                        "<td><a href='/goods/sortList/"+n.categoryId+"'>删除</a>" +
                        "<a href='/goods/modifyGoodsSort/"+n.categoryId+"'>修改</a></td>\n" +
                        "</tr>";
                    $("#result-tab").append(s);
                })
            }
        }
    })
}